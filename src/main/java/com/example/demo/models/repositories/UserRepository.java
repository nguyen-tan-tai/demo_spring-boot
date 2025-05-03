package com.example.demo.models.repositories;

import com.example.demo.models.entities.User;

public interface UserRepository extends BaseRepository<User, Long> {
    User findByEmail(String email);
}
