package com.ur.service;

import com.ur.entity.UserEntity;

public interface UserService {
	
	void registerUser(UserEntity user);

    boolean authenticate(String username, String password);

    UserEntity getUserByUsername(String username);

	boolean isUserExists(String username);

	boolean isPhoneNumberExists(String phoneNumber);

	boolean isEmailExists(String email);

}
