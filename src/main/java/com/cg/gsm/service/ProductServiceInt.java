package com.cg.gsm.service;

import java.util.List;

import com.cg.gsm.dto.ProductDto;
import com.cg.gsm.entities.ProductEntity;
import com.cg.gsm.exception.CartNotFoundException;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.ProductCodeExistsException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.ValidateProductException;

public interface ProductServiceInt {

	public ProductEntity addProduct(ProductDto productDto)
			throws DuplicateRecordException, DatabaseException, ValidateProductException,
			CartNotFoundException, ProductCodeExistsException;

	public ProductEntity updateProduct(ProductDto productDto)
			throws DuplicateRecordException, RecordNotFoundException, ValidateProductException;
	
	public boolean validateProduct(ProductDto productDto) throws ValidateProductException;

	public ProductEntity findByPk(Long productId) throws RecordNotFoundException;
	
	public List<ProductEntity> getAll();

}
