package com.cg.gsm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity /*extends BaseEntity*/ {

	@Column(name = "name")
	private String name;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prodcode;
	public long getProdcode() {
		return prodcode;
	}

	public void setProdcode(long prodcode) {
		this.prodcode = prodcode;
	}

	private String code;
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToOne(mappedBy = "product",cascade=CascadeType.ALL)
	private BaseEntity base2;

	public ProductEntity(String name, String code, String price, String description, String quantity, byte[] image) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.image = image;
	}

	public BaseEntity getBase2() {
		return base2;
	}

	public void setBase2(BaseEntity base2) {
		this.base2 = base2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "price")
	private String price;
	@Column(name = "desciption")
	private String description;
	@Column(name = "quantity")
	private String quantity;

	@Column(name = "image")
	private byte[] image;

	/*
	 * @Override public String getKey() { return String.valueOf(id); }
	 * 
	 * @Override public String getValue() { return name; }
	 */

}
