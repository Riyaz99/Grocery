package com.cg.gsm.dto;

import java.util.Date;

public class BookProductDto {

	private long productId;
	private String productName;
	private Integer quantity;
	private Double amount;
	private Date date;

	private long userEntityId;

	public BookProductDto() {
		super();
	}

	public BookProductDto(long productId, String productName, Integer quantity, Double amount, Date date,
			long userEntityId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.amount = amount;
		this.date = date;
		this.userEntityId = userEntityId;
	}

	public BookProductDto(String productName, Integer quantity, Double amount, Date date, long userEntityId) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.amount = amount;
		this.date = date;
		this.userEntityId = userEntityId;
	}

	public long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public long getUserEntityId() {
		return userEntityId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setUserEntityId(long userEntityId) {
		this.userEntityId = userEntityId;
	}

}
