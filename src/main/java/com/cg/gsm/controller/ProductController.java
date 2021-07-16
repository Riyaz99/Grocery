package com.cg.gsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gsm.dto.ProductDto;
import com.cg.gsm.dto.SuccessMessageDto;
import com.cg.gsm.entities.ProductEntity;
import com.cg.gsm.exception.CartNotFoundException;
import com.cg.gsm.exception.DatabaseException;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.ProductCodeExistsException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.ValidateProductException;
import com.cg.gsm.service.ProductServiceInt;
import com.cg.gsm.util.ProductConstants;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductServiceInt productService;

	@PostMapping("/addproduct")
	public SuccessMessageDto add(@RequestBody ProductDto productDto) throws DuplicateRecordException, DatabaseException,
			ValidateProductException, CartNotFoundException, ProductCodeExistsException {
		ProductEntity product = productService.addProduct(productDto);
		return new SuccessMessageDto(ProductConstants.PRODUCT_ADDED + product.getId());
	}

	@PutMapping("/updateproduct")
	public SuccessMessageDto update(@RequestBody ProductDto productDto)
			throws DuplicateRecordException, RecordNotFoundException, ValidateProductException {
		ProductEntity product = productService.updateProduct(productDto);
		return new SuccessMessageDto(ProductConstants.PRODUCT_UPDATED + product.getId());
	}
	
//	@PutMapping("/updateproduct/{id}")
//	public SuccessMessageDto update(@PathVariable("id") Long productId, @RequestBody ProductDto productDto)
//			throws DuplicateRecordException, RecordNotFoundException, ValidateProductException {
//		productDto.setId(productId);
//		ProductEntity product = productService.updateProduct(productDto);
//		return new SuccessMessageDto(ProductConstants.PRODUCT_UPDATED + product.getId());
//	}

	@GetMapping("/getproduct/{id}")
	public ProductEntity findByPK(@PathVariable("id") Long productId) throws RecordNotFoundException {
		return productService.findByPk(productId);
	}

	@GetMapping("/getallproducts")
	public List<ProductEntity> getAll() {
		return productService.getAll();
	}
}
