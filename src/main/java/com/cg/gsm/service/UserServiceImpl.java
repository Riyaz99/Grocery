package com.cg.gsm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.dto.UserDto;
import com.cg.gsm.entities.Login;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.EmailIdExistsException;
import com.cg.gsm.exception.MobileNoExistsException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.ValidateUserException;
import com.cg.gsm.repository.ILoginRepository;
import com.cg.gsm.repository.UserDAOInt;
import com.cg.gsm.util.UserConstants;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	UserDAOInt userRepository;
	
	@Autowired
	ILoginRepository loginRepository;

	@Override
	public UserEntity addUser(UserDto userDto)
			throws DuplicateRecordException, DatabaseException, ValidateUserException, EmailIdExistsException,
			MobileNoExistsException {

		Optional<UserEntity> optUser = userRepository.findById(userDto.getUserId());

		if (!optUser.isPresent()) {
			
			List<UserEntity> userList = userRepository.findAll();
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getEmailId().equals(userDto.getEmailId()))
					throw new EmailIdExistsException(UserConstants.EMAIL_ID_EXISTS);
				if (userList.get(i).getMobileNo().equals(userDto.getMobileNo()))
					throw new MobileNoExistsException(UserConstants.MOBILE_NO_EXISTS);
			}

			validateUser(userDto);

			UserEntity user = new UserEntity();
			user.setUserId(userDto.getUserId());
			user.setPassword(userDto.getPassword());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setMobileNo(userDto.getMobileNo());
			user.setEmailId(userDto.getEmailId());
			user.setCountry(userDto.getCountry());
			user.setState(userDto.getState());
			user.setDistrict(userDto.getDistrict());
			user.setPincode(userDto.getPincode());
			user.setAddress(userDto.getAddress());
			user.setUserId(userDto.getUserId());
			user.setRole(userDto.getRole());
			Login login = new Login();
			login.setPassword(userDto.getPassword());
			login.setUserName(userDto.getEmailId());
			login.setRole(userDto.getRole());

			UserEntity new_user = userRepository.save(user);
			login.setUserId((int) new_user.getUserId());
			loginRepository.save(login);
			return new_user;

		} else {
			throw new DuplicateRecordException(UserConstants.USER_EXISTS);
		}
	}

	@Override
	public UserEntity updateUser(UserDto userDto)
			throws DuplicateRecordException, RecordNotFoundException, ValidateUserException {

		Optional<UserEntity> optUser = userRepository.findById(userDto.getUserId());

		if (optUser.isPresent()) {

			validateUser(userDto);

			UserEntity user = optUser.get();
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setMobileNo(userDto.getMobileNo());
			user.setEmailId(userDto.getEmailId());
			user.setPassword(userDto.getPassword());
			user.setCountry(userDto.getCountry());
			user.setState(userDto.getState());
			user.setDistrict(userDto.getDistrict());
			user.setPincode(userDto.getPincode());
			user.setAddress(userDto.getAddress());
			user.setUserId(userDto.getUserId());
			user.setRole(userDto.getRole());

			return userRepository.save(user);

		} else
			throw new RecordNotFoundException(UserConstants.USER_NOT_FOUND);
	}

	@Override
	public UserEntity findByPK(Long userId) throws RecordNotFoundException {

		Optional<UserEntity> optUser = userRepository.findById(userId);

		if (optUser.isPresent()) {

			return optUser.get();

		} else
			throw new RecordNotFoundException(UserConstants.USER_NOT_FOUND);
	}

	@Override
	public boolean validateUser(UserDto userDto) throws ValidateUserException {

		if (!userDto.getFirstName().matches(UserConstants.FIRSTNAME_PATTERN))
			throw new ValidateUserException(UserConstants.FIRSTNAME_NOT_FOUND);

		if (!userDto.getLastName().matches(UserConstants.LASTNAME_PATTERN))
			throw new ValidateUserException(UserConstants.LASTNAME_NOT_FOUND);

		if (!userDto.getMobileNo().matches(UserConstants.MOBILE_NO_PATTERN))
			throw new ValidateUserException(UserConstants.MOBILE_NO_CANNOT_BE_EMPTY);

		if (!userDto.getEmailId().matches(UserConstants.EMAIL_PATTERN))
			throw new ValidateUserException(UserConstants.EMAIL_CANNOT_BE_EMPTY);

		if (!userDto.getPassword().matches(UserConstants.PASSWORD_PATTERN))
			throw new ValidateUserException(UserConstants.PASSWORD_CANNOT_BE_EMPTY);

		if (!userDto.getCountry().matches(UserConstants.COUNTRY_PATTERN))
			throw new ValidateUserException(UserConstants.COUNTRY_CANNOT_BE_EMPTY);

		if (!userDto.getState().matches(UserConstants.STATE_PATTERN))
			throw new ValidateUserException(UserConstants.STATE_PATTERN);

		if (!userDto.getDistrict().matches(UserConstants.DISTRICT_PATTERN))
			throw new ValidateUserException(UserConstants.DISTRICT_CANNOT_BE_EMPTY);

		if (!userDto.getPincode().matches(UserConstants.PINCODE_PATTERN))
			throw new ValidateUserException(UserConstants.PINCODE_CANNOT_BE_EMPTY);

		return true;
	}

	@Override
	public List<UserEntity> getAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findByEmailId(String email) {
		return userRepository.findByEmailId(email);
	}

}
