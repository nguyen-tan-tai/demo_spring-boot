package com.example.demo.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

class JsonUtilsTest {
    static class Employee {
        public Employee() {
        }

        public Employee(String name, String email, int age) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        @JsonProperty(value = "name", index = 1)
        private String name;

        @JsonProperty(value = "age", index = 3)
        private Integer age;

        @JsonProperty(value = "mail", index = 2)
        private String email;
    }

    @Test
    public void dump() {
        assertThat(JsonUtils.dump(null)).isEqualTo("null");
        assertThat(JsonUtils.dump("")).isEqualTo("\"\"");
        assertThat(JsonUtils.dump(1)).isEqualTo("1");
        assertThat(JsonUtils.dump(true)).isEqualTo("true");
        assertThat(JsonUtils.dump(new int[] { 1, 99 })).isEqualTo("[1,99]");
        assertThat(JsonUtils.dump(Arrays.asList("hoge", "fuga"))).isEqualTo("[\"hoge\",\"fuga\"]");
        assertThat(JsonUtils.dump(Collections.singletonMap("hoge", "fuga"))).isEqualTo("{\"hoge\":\"fuga\"}");
        assertThat(JsonUtils.dump(new Employee("John", "john@email.com", 40)))
                .isEqualTo("{\"name\":\"John\",\"mail\":\"john@email.com\",\"age\":40}");
        assertThat(JsonUtils.dump(Arrays.asList(
                new Employee("John", "john@email.com", 40),
                new Employee("Doe", "doe@email.com", 50))))
                .isEqualTo("[{\"name\":\"John\",\"mail\":\"john@email.com\",\"age\":40},{\"name\":\"Doe\",\"mail\":\"doe@email.com\",\"age\":50}]");
    }

    @Test
    public void testParseJsonClazz() {
        @SuppressWarnings("unchecked")
        Map<String, String> map = JsonUtils.parse("{\"hoge\":\"fuga\"}", Map.class);
        assertThat(map).hasSize(1);
        assertThat(map.containsKey("hoge"));
        assertThat(map.get("hoge")).isEqualTo("fuga");

        Employee john = JsonUtils.parse("{\"name\":\"John\",\"mail\":\"john@email.com\",\"age\":40}", Employee.class);
        assertThat(john.name).isEqualTo("John");
        assertThat(john.email).isEqualTo("john@email.com");
        assertThat(john.age).isEqualTo(40);
    }

    @Test
    public void testParseJsonTypeReference() {
        Employee john = JsonUtils.parse("{\"name\":\"John\",\"mail\":\"john@email.com\",\"age\":40}", Employee.class);
        assertThat(john.name).isEqualTo("John");
        assertThat(john.email).isEqualTo("john@email.com");
        assertThat(john.age).isEqualTo(40);

        List<Employee> employees = JsonUtils.parse("["
                + "{\"name\":\"John\",\"mail\":\"john@email.com\",\"age\":40},"
                + "{\"name\":\"Doe\",\"mail\":\"doe@email.com\",\"age\":50}"
                + "]", new TypeReference<List<Employee>>() {
                });
        assertThat(employees).hasSize(2);
        assertThat(employees.get(0).name).isEqualTo("John");
        assertThat(employees.get(0).email).isEqualTo("john@email.com");
        assertThat(employees.get(0).age).isEqualTo(40);
        assertThat(employees.get(1).name).isEqualTo("Doe");
        assertThat(employees.get(1).email).isEqualTo("doe@email.com");
        assertThat(employees.get(1).age).isEqualTo(50);
    }
}
