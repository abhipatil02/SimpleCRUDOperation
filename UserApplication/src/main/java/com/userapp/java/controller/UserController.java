package com.userapp.java.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userapp.java.dto.UserRequestDto;
import com.userapp.java.dto.UserResponseDto;
import com.userapp.java.service.UserService;

@RestController
@Validated
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/users")
	public ResponseEntity<String> saveUserDetails(@Valid @RequestBody UserRequestDto userRequestDto) {
		
		userService.saveUserDetails(userRequestDto);		
		return new ResponseEntity<String>("User Saved Successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getUsers")
	public ResponseEntity<List<UserResponseDto>> getAllUsers(){
		
		return new ResponseEntity<List<UserResponseDto>>(userService.getAllUsers(),HttpStatus.ACCEPTED);
	}	
	
	@GetMapping("/getUsers/{userId}")
	public UserResponseDto getUsersById(@NotNull(message = "userId cannot be null") @PathVariable Integer userId) {
		
		return userService.getUsersById(userId);
	}
	
	@PutMapping(value = "/updateUsers/{userId}")
	public ResponseEntity<String> updateUserDetails(@RequestBody UserRequestDto userRequestDto,
			@NotNull(message = "userId cannot be null") @PathVariable Integer userId) {
		
		userService.updateUserDetails(userRequestDto, userId);
		return new ResponseEntity<String>("User Updated Successfully", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/deleteUsers/{userId}")
	public ResponseEntity<String> deleteUserDetails(@NotNull(message = "userId cannot be null") @PathVariable Integer userId){
		
		userService.deleteUserDetails(userId);
		return new ResponseEntity<String>("User Deleted Successfully",HttpStatus.ACCEPTED);
	}

}
