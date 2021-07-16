package com.cg.gsm.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.gsm.dto.ErrorMessageDto;
import com.cg.gsm.exception.EmailIdExistsException;
import com.cg.gsm.exception.MobileNoExistsException;
import com.cg.gsm.exception.ValidateUserException;

@RestControllerAdvice
public class UserAdvice {
	
	@ExceptionHandler(ValidateUserException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleValidateUserException(ValidateUserException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(EmailIdExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleEmailIdExistsException(EmailIdExistsException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}
	
	@ExceptionHandler(MobileNoExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleMobileNoExistsException(MobileNoExistsException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}
}
