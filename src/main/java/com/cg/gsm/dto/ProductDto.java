package com.cg.gsm.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String code;
	private String name;
	private Double price;
	private String description;
	private String category;
	private Integer quantity;

	public ProductDto() {
		super();
	}

	public ProductDto(String code, String name, Double price, String description, String category, Integer quantity) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.quantity = quantity;
	}

	public ProductDto(long id, String code, String name, Double price, String description, String category,
			Integer quantity) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
