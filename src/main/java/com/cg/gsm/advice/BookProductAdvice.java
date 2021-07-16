package com.cg.gsm.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.gsm.dto.ErrorMessageDto;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.UserNotFoundException;
import com.cg.gsm.exception.ValidateBookProductException;

@RestControllerAdvice
public class BookProductAdvice {

	@ExceptionHandler(DatabaseException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleDatabaseException(DatabaseException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleUserNotFoundException(UserNotFoundException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());
	}

	@ExceptionHandler(ValidateBookProductException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleValidateBookProductException(ValidateBookProductException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}

}
