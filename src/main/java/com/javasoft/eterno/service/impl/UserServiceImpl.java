package com.javasoft.eterno.service.impl;

import com.javasoft.eterno.entity.User;
import com.javasoft.eterno.repository.UserRepository;
import com.javasoft.eterno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void save(User user){
        this.userRepository.save(user);
    }
}
