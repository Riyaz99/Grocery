package com.cg.gsm.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.gsm.dto.ErrorMessageDto;
import com.cg.gsm.exception.ProductCodeExistsException;
import com.cg.gsm.exception.ValidateProductException;

@RestControllerAdvice
public class ProductAdvice {

	@ExceptionHandler(ValidateProductException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleDatabaseException(ValidateProductException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}

	@ExceptionHandler(ProductCodeExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleProductCodeExistsException(ProductCodeExistsException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}

}
