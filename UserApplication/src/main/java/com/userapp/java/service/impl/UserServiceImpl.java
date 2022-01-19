package com.userapp.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userapp.java.dto.UserRequestDto;
import com.userapp.java.dto.UserResponseDto;
import com.userapp.java.entity.User;
import com.userapp.java.exception.UserNotFoundException;
import com.userapp.java.repository.UserRepository;
import com.userapp.java.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUserDetails(UserRequestDto userRequestDto) {
		
		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		userRepository.save(user);
		
	}

	@Override
	public List<UserResponseDto> getAllUsers() {
		
		List<UserResponseDto> userResponse = new ArrayList<UserResponseDto>();
		Iterator<User> it = userRepository.findAll().iterator();

		while (it.hasNext()) {
			UserResponseDto userResponseDto = new UserResponseDto();
			BeanUtils.copyProperties(it.next(), userResponseDto);
			userResponse.add(userResponseDto);
		}
		return userResponse;
	}

	@Override
	public UserResponseDto getUsersById(Integer userId) {
		
		User user = new User();
		UserResponseDto userResponseDto = new UserResponseDto();
		Optional<User> optionalUser = userRepository.findById(userId);
		
		if(optionalUser.isPresent()) 			
			user = optionalUser.get();
			BeanUtils.copyProperties(user, userResponseDto);
		return userResponseDto;
	}

	@Override
	public void updateUserDetails(UserRequestDto userRequestDto, Integer userId) {
		
		User user = userRepository.findById(userId).get();
		BeanUtils.copyProperties(userRequestDto, user);
		userRepository.save(user);		
	}

	@Override
	public void deleteUserDetails(Integer userId) {
		
		User user = userRepository.findById(userId).get();
		if(user==null) 
			throw new UserNotFoundException("No customer with the id: "+userId);
		user = new User();
		user.setUserId(userId); 
		userRepository.delete(user);			
	}

}
