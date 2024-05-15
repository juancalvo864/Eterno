package com.javasoft.eterno.service;

import com.javasoft.eterno.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    void save(User user);
}
