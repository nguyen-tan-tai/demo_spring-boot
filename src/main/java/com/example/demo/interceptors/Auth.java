package com.example.demo.interceptors;

import com.example.demo.commons.role.ROLE;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auth {

    public ROLE[] requiredRoles() default {};
}
