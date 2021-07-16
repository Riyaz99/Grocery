package com.cg.gsm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.dto.CartDto;
import com.cg.gsm.entities.CartEntity;
import com.cg.gsm.entities.ProductEntity;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.UserNotFoundException;
import com.cg.gsm.repository.CartDAOInt;
import com.cg.gsm.repository.ProductDAOInt;
import com.cg.gsm.repository.UserDAOInt;
import com.cg.gsm.util.CartConstants;

@Service
public class CartServiceImpl implements CartServiceInt {

	@Autowired
	CartDAOInt cartRepository;

	@Autowired
	UserDAOInt userRepository;

	@Autowired
	ProductDAOInt productRepository;

	@Override
	public CartEntity addCart(CartDto cartDto) throws DuplicateRecordException, UserNotFoundException {

		Optional<CartEntity> optCart = cartRepository.findById(cartDto.getCartId());
		Optional<UserEntity> optUser = userRepository.findById(cartDto.getUserEntityId());

		if (!optUser.isPresent())
			throw new UserNotFoundException(CartConstants.USER_NOT_FOUND);

		if (!optCart.isPresent()) {

			CartEntity cart = new CartEntity();
			cart.setUserEntity(optUser.get());

			return cartRepository.save(cart);

		} else
			throw new DuplicateRecordException(CartConstants.CART_EXISTS);
	}

	@Override
	public CartEntity findByPk(Long cartId) throws RecordNotFoundException {

		Optional<CartEntity> optCart = cartRepository.findById(cartId);

		if (optCart.isPresent()) {

			return optCart.get();

		} else
			throw new RecordNotFoundException(CartConstants.CART_NOT_FOUND);
	}

	@Override
	public CartEntity addToCart(CartDto cartDto) throws RecordNotFoundException, UserNotFoundException {
		Optional<UserEntity> optUser = userRepository.findById(cartDto.getUserEntityId());

		if (!optUser.isPresent())
			throw new UserNotFoundException(CartConstants.USER_NOT_FOUND);
		Optional<ProductEntity> optProduct = productRepository.findById(cartDto.getProductId());
		System.out.println(cartRepository.findById(cartDto.getCartId()));
		CartEntity cart = new CartEntity();
		cart.setQuantity(cartDto.getQuantity());
		cart.setProductEntity(optProduct.get());
		cart.setUserEntity(optUser.get());
		return cartRepository.save(cart);
	}

	@Override
	public List<CartEntity> viewCartItems(Long userId) {
		return cartRepository.viewCart(userId);
	}

}
