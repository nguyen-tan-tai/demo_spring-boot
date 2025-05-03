package com.example.demo.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commons.json.Jsonizable;
import com.example.demo.models.entities.User;
import com.example.demo.models.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class GetUserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    public GetUserResponse get() {
        User u = userRepository.findByEmail("tantantai@gmail.com");
        return new GetUserResponse(u);
    }

    public static class GetUserResponse implements Jsonizable {
        private User user;

        public GetUserResponse(User user) {
            this.user = user;
        }

        @JsonProperty(value = "id", index = 1)
        public Long getId() {
            return this.user.getId();
        }

        @JsonProperty(value = "name", index = 2)
        public String getName() {
            return this.user.getName();
        }

        @JsonProperty(value = "email", index = 3)
        public String getEmail() {
            return this.user.getEmail();
        }
    }
}
