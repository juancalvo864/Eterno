package com.javasoft.eterno.service;

import com.javasoft.eterno.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    ResponseEntity<String> signUp(Map<String,String> requestMap);

    ResponseEntity<String> login(Map<String,String> requestMap);
}
