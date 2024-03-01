package com.ur.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ur.entity.UserEntity;
import com.ur.repository.UserRepository;
import com.ur.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public boolean authenticate(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public boolean isUserExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean isPhoneNumberExists(String phoneNumber) {
        return userRepository.existsByPhoneNumber(phoneNumber);
    }

    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
     
}
