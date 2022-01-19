package com.userapp.java.service;

import java.util.List;

import com.userapp.java.dto.UserRequestDto;
import com.userapp.java.dto.UserResponseDto;

public interface UserService {

	void saveUserDetails(UserRequestDto userRequestDto);

	List<UserResponseDto> getAllUsers();

	UserResponseDto getUsersById(Integer userId);

	void updateUserDetails(UserRequestDto userRequestDto, Integer userId);

	void deleteUserDetails(Integer userId);	

}
