package com.cg.gsm.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	private long quantity;

	@ManyToOne(cascade = CascadeType.MERGE)
	private UserEntity userEntity;

	@ManyToOne(cascade = CascadeType.MERGE)
	private ProductEntity productEntity;

	public long getCartId() {
		return cartId;
	}

	public long getQuantity() {
		return quantity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}


}
