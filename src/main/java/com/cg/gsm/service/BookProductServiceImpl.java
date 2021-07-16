package com.cg.gsm.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.dto.BookProductDto;
import com.cg.gsm.entities.BookProductEntity;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.UserNotFoundException;
import com.cg.gsm.exception.ValidateBookProductException;
import com.cg.gsm.repository.BookProductDAOInt;
import com.cg.gsm.repository.UserDAOInt;
import com.cg.gsm.util.BookProductConstants;

@Service
public class BookProductServiceImpl implements BookProductServiceInt {

	@Autowired
	BookProductDAOInt bookProductRepository;

	@Autowired
	UserDAOInt userRepository;

	/*
	 * 
	 * @Param bookProductDto represents BookProductDto instance to be passed
	 * 
	 * @Return returns BookProductEntity instance type
	 * 
	 * @Throws DuplicateRecordException raises if id is found in BookProductEntity
	 * 
	 * Description this method adds the BookProductEntity instance if id is not
	 * found
	 * 
	 */

	@Override
	public BookProductEntity addBookProduct(BookProductDto bookProductDto)
			throws DuplicateRecordException, DatabaseException, UserNotFoundException, ValidateBookProductException {

		Optional<BookProductEntity> optBookProduct = bookProductRepository.findById(bookProductDto.getProductId());
		Optional<UserEntity> optUser = userRepository.findById(bookProductDto.getUserEntityId());

		if (!optUser.isPresent())
			throw new UserNotFoundException(BookProductConstants.USER_NOT_FOUND);

		if (!optBookProduct.isPresent()) {

			validateBookProduct(bookProductDto);

			BookProductEntity bookProduct = new BookProductEntity();

			Date date = new Date();

			bookProduct.setProductName(bookProductDto.getProductName());
			bookProduct.setQuantity(bookProductDto.getQuantity());
			bookProduct.setAmount(bookProductDto.getAmount());
			bookProduct.setDate(new Timestamp(date.getTime()));
			bookProduct.setUserEntity(optUser.get());

			return bookProductRepository.save(bookProduct);

		} else {
			throw new DuplicateRecordException(BookProductConstants.BOOKPRODUCT_EXISTS);
		}
	}

	/*
	 * 
	 * @Param bookProductDto represents BookProductDto instance to be passed
	 * 
	 * @Return returns BookProductEntity instance type
	 * 
	 * @Throws RecordNotFoundException raises if id is not found in
	 * BookProductEntity
	 * 
	 * Description this method updates the BookProductEntity instance if id is found
	 * 
	 */

	@Override
	public BookProductEntity updateBookProduct(BookProductDto bookProductDto)
			throws RecordNotFoundException, ValidateBookProductException {

		Optional<BookProductEntity> optBookProduct = bookProductRepository.findById(bookProductDto.getProductId());

		if (optBookProduct.isPresent()) {

			validateBookProduct(bookProductDto);

			BookProductEntity bookProduct = optBookProduct.get();
			bookProduct.setProductName(bookProductDto.getProductName());
			bookProduct.setQuantity(bookProductDto.getQuantity());
			bookProduct.setAmount(bookProductDto.getAmount());

			return bookProductRepository.save(bookProduct);

		} else
			throw new RecordNotFoundException(BookProductConstants.BOOKPRODUCT_NOT_FOUND);
	}

	@Override
	public boolean validateBookProduct(BookProductDto bookProductDto) throws ValidateBookProductException {

		if (!bookProductDto.getProductName().matches(BookProductConstants.PRODUCT_NAME_PATTERN))
			throw new ValidateBookProductException(BookProductConstants.PRODUCT_NAME_CANNOT_BE_EMPTY);

		return true;
	}

	@Override
	public BookProductEntity findByPk(Long productId) throws RecordNotFoundException {
		Optional<BookProductEntity> optBookProduct = bookProductRepository.findById(productId);
		if (optBookProduct.isPresent()) {

			return optBookProduct.get();

		} else
			throw new RecordNotFoundException(BookProductConstants.BOOKPRODUCT_NOT_FOUND);
	}

}
