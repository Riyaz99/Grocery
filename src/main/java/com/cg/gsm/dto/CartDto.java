package com.cg.gsm.dto;

public class CartDto {

	private long cartId;

	private long userEntityId;

	private long productId;

	private long quantity;

	public CartDto() {
		super();
	}

	public CartDto(long userEntityId, long productId, long quantity) {
		super();
		this.userEntityId = userEntityId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public CartDto(long cartId, long userEntityId, long productId, long quantity) {
		super();
		this.cartId = cartId;
		this.userEntityId = userEntityId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public long getCartId() {
		return cartId;
	}

	public long getUserEntityId() {
		return userEntityId;
	}

	public long getProductId() {
		return productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public void setUserEntityId(long userEntityId) {
		this.userEntityId = userEntityId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
