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

import com.cg.gsm.dto.CartDto;
import com.cg.gsm.dto.SuccessMessageDto;
import com.cg.gsm.entities.CartEntity;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.exception.RecordNotFoundException;
import com.cg.gsm.exception.UserNotFoundException;
import com.cg.gsm.service.CartServiceInt;
import com.cg.gsm.util.CartConstants;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartServiceInt cartService;

	@PostMapping("/addcart")
	public SuccessMessageDto addCart(@RequestBody CartDto cartDto)
			throws DuplicateRecordException, UserNotFoundException {
		CartEntity cart = cartService.addCart(cartDto);
		return new SuccessMessageDto(CartConstants.CART_ADDED + cart.getCartId());
	}

	@GetMapping("/getcart/{id}")
	public CartEntity get(@PathVariable("id") Long cartId) throws RecordNotFoundException {
		return cartService.findByPk(cartId);
	}
	
	@PutMapping("/addtocart")
	public SuccessMessageDto addToCart(@RequestBody CartDto cartDto)
			throws RecordNotFoundException, UserNotFoundException {
		CartEntity cart = cartService.addToCart(cartDto);
		return new SuccessMessageDto(CartConstants.CART_ADDED + cart.getCartId());
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getcartbyuser/{id}")
	public List<CartEntity> getCart(@PathVariable("id") Long userId) throws RecordNotFoundException {
		System.out.println("abc");
		return cartService.viewCartItems(userId);
	}

}
