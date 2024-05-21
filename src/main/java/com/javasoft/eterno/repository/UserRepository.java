package com.javasoft.eterno.repository;

import com.javasoft.eterno.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(@Param(("email"))String email);
}
