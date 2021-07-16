package com.cg.gsm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.dto.ProductDto;
import com.cg.gsm.entities.ProductEntity;
import com.cg.gsm.exception.CartNotFoundException;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.ProductCodeExistsException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.ValidateProductException;
import com.cg.gsm.repository.CartDAOInt;
import com.cg.gsm.repository.ProductDAOInt;
import com.cg.gsm.util.ProductConstants;

@Service
public class ProductServiceImpl implements ProductServiceInt {

	@Autowired
	ProductDAOInt productRepository;

	@Autowired
	CartDAOInt cartRepository;

	@Override
	public ProductEntity addProduct(ProductDto productDto)
			throws DuplicateRecordException, DatabaseException, ValidateProductException, CartNotFoundException,
			ProductCodeExistsException {

		Optional<ProductEntity> optProduct = productRepository.findById(productDto.getId());

		if (!optProduct.isPresent()) {

			validateProduct(productDto);
			
			List<ProductEntity> productList = productRepository.findAll();
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getCode().equals(productDto.getCode()))
					throw new ProductCodeExistsException(ProductConstants.PRODUCT_CODE_EXISTS);
			}

			ProductEntity product = new ProductEntity();
			product.setCode(productDto.getCode());
			product.setDescription(productDto.getDescription());
			product.setName(productDto.getName());
			product.setPrice(productDto.getPrice());
			product.setCategory(productDto.getCategory());
			product.setQuantity(productDto.getQuantity());

			return productRepository.save(product);
		} else {
			throw new DuplicateRecordException(ProductConstants.PRODUCT_EXISTS);
		}
	}

	@Override
	public ProductEntity updateProduct(ProductDto productDto)
			throws DuplicateRecordException, RecordNotFoundException, ValidateProductException {

		Optional<ProductEntity> optProduct = productRepository.findById(productDto.getId());

		if (optProduct.isPresent()) {

			validateProduct(productDto);

			ProductEntity product = optProduct.get();
			product.setDescription(productDto.getDescription());
			product.setName(productDto.getName());
			product.setPrice(productDto.getPrice());
			product.setCategory(productDto.getCategory());
			product.setQuantity(productDto.getQuantity());

			return productRepository.save(product);

		} else
			throw new RecordNotFoundException(ProductConstants.PRODUCT_NOT_FOUND);

	}

	@Override
	public boolean validateProduct(ProductDto productDto) throws ValidateProductException {

		if (!productDto.getName().matches(ProductConstants.PRODUCT_NAME_PATTERN))
			throw new ValidateProductException(ProductConstants.PRODUCT_NAME_CANNOT_BE_EMPTY);
		
		if(!productDto.getCode().matches(ProductConstants.PRODUCT_CODE_PATTERN))
			throw new ValidateProductException(ProductConstants.PRODUCT_CODE_CANNOT_BE_EMPTY);

		return true;
	}

	@Override
	public ProductEntity findByPk(Long productId) throws RecordNotFoundException {

		Optional<ProductEntity> optProduct = productRepository.findById(productId);
		if (optProduct.isPresent()) {

			return optProduct.get();

		} else
			throw new RecordNotFoundException(ProductConstants.PRODUCT_NOT_FOUND);
	}

	@Override
	public List<ProductEntity> getAll() {
		return productRepository.findAll();
	}

}
