package com.cg.gsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gsm.dto.SuccessMessageDto;
import com.cg.gsm.dto.UserDto;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.EmailIdExistsException;
import com.cg.gsm.exception.MobileNoExistsException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.ValidateUserException;
import com.cg.gsm.service.UserServiceInt;
import com.cg.gsm.util.UserConstants;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceInt userService;

	@PostMapping("/adduser")
	public SuccessMessageDto addUser(@RequestBody UserDto userDto)
			throws DuplicateRecordException, DatabaseException, ValidateUserException, EmailIdExistsException,
			MobileNoExistsException {
		UserEntity user = userService.addUser(userDto);
		return new SuccessMessageDto(UserConstants.USER_ADDED + user.getUserId());
	}

	@PutMapping("/updateuser/{id}")
	public SuccessMessageDto updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto)
			throws DuplicateRecordException, RecordNotFoundException, ValidateUserException {
		userDto.setUserId(userId);
		UserEntity user = userService.updateUser(userDto);
		return new SuccessMessageDto(UserConstants.USER_UPDATED + user.getUserId());
	}

	@GetMapping("/getuser/{id}")
	public UserEntity findByPK(@PathVariable("id") Long userId) throws RecordNotFoundException {
		return userService.findByPK(userId);
	}

	@GetMapping("/getallusers")
	public List<UserEntity> getAll() {
		return userService.getAll();
	}
	
//	@GetMapping("/getuserbyemail")
//	public UserEntity findByEmailId() {
//		return userService.findByEmailId(null)
//	}
}
