package com.cg.gsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gsm.dto.BookProductDto;
import com.cg.gsm.dto.SuccessMessageDto;
import com.cg.gsm.entities.BookProductEntity;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.UserNotFoundException;
import com.cg.gsm.exception.ValidateBookProductException;
import com.cg.gsm.service.BookProductServiceInt;
import com.cg.gsm.util.BookProductConstants;

@RestController
@RequestMapping("/bookproduct")
public class BookProductController {

	@Autowired
	BookProductServiceInt bookProductService;

	@PostMapping("/addbookproduct")
	public SuccessMessageDto addBookProduct(@RequestBody BookProductDto bookProductDto)
			throws DuplicateRecordException, DatabaseException, UserNotFoundException, ValidateBookProductException {
		BookProductEntity bookProduct = bookProductService.addBookProduct(bookProductDto);
		return new SuccessMessageDto(BookProductConstants.BOOKPRODUCT_ADDED + bookProduct.getProductId());
	}

	@PutMapping("/updatebookproduct/{id}")
	public SuccessMessageDto update(@PathVariable("id") Long productId, @RequestBody BookProductDto bookProductDto)
			throws RecordNotFoundException, ValidateBookProductException {
		bookProductDto.setProductId(productId);
		BookProductEntity bookProduct = bookProductService.updateBookProduct(bookProductDto);
		return new SuccessMessageDto(BookProductConstants.BOOKPRODUCT_UPDATED + bookProduct.getProductId());
	}

	@GetMapping("/getbookproduct/{id}")
	public BookProductEntity findByPK(@PathVariable("id") Long productId) throws RecordNotFoundException {
		return bookProductService.findByPk(productId);
	}

}
