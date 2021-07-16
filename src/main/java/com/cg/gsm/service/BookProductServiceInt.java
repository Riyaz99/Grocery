package com.cg.gsm.service;

import com.cg.gsm.dto.BookProductDto;
import com.cg.gsm.entities.BookProductEntity;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.UserNotFoundException;
import com.cg.gsm.exception.ValidateBookProductException;

public interface BookProductServiceInt {

	public BookProductEntity addBookProduct(BookProductDto bookProductDto)
			throws DuplicateRecordException, DatabaseException, UserNotFoundException, ValidateBookProductException;

	public BookProductEntity updateBookProduct(BookProductDto bookProductDto)
			throws RecordNotFoundException, ValidateBookProductException;

	public BookProductEntity findByPk(Long productId) throws RecordNotFoundException;

	public boolean validateBookProduct(BookProductDto bookProductDto) throws ValidateBookProductException;

}
