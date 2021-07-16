package com.cg.gsm.service;

import java.util.List;

import com.cg.gsm.dto.UserDto;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.EmailIdExistsException;
import com.cg.gsm.exception.MobileNoExistsException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.ValidateUserException;

public interface UserServiceInt {

	public UserEntity addUser(UserDto userDto)
			throws DuplicateRecordException, DatabaseException, ValidateUserException, EmailIdExistsException,
			MobileNoExistsException;

	public UserEntity updateUser(UserDto userDto)
			throws DuplicateRecordException, RecordNotFoundException, ValidateUserException;

	public boolean validateUser(UserDto userDto) throws ValidateUserException;

	public UserEntity findByPK(Long userId) throws RecordNotFoundException;

	public List<UserEntity> getAll();
	
	public UserEntity findByEmailId(String email);

}
