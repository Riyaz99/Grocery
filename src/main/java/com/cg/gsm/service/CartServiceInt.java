package com.cg.gsm.service;

import java.util.List;

import com.cg.gsm.dto.CartDto;
import com.cg.gsm.entities.CartEntity;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.UserNotFoundException;

public interface CartServiceInt {

	public CartEntity addCart(CartDto cartDto) throws DuplicateRecordException, UserNotFoundException;
	
	public CartEntity findByPk(Long cartId) throws RecordNotFoundException;
	
	public CartEntity addToCart(CartDto cartDto) throws RecordNotFoundException, UserNotFoundException;
	
	public List<CartEntity> viewCartItems(Long userId);
}
