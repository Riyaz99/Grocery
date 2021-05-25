package com.cg.gsm.entities;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "base")
public abstract class BaseEntity implements DropdownList {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@Column(name = "createdBy")
	protected String createdBy;

	@Column(name = "modifiedBy")
	protected String modifiedBy;

	@Column(name = "createdDateTime")
	protected Timestamp createdDateTime;

	@Column(name = "modifiedDateTime")
	protected Timestamp modifiedDateTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserEntity user;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BookProductEntity bookproduct;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProductEntity product;

	public BookProductEntity getBookproduct() {
		return bookproduct;
	}

	public void setBookproduct(BookProductEntity bp2) {
		this.bookproduct = bp2;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity p) {
		this.product = p;
	}

	public long getId() {
		return id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Timestamp getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Timestamp modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	/*
	 * @Override public String getKey() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * @Override public String getValue() { // TODO Auto-generated method stub
	 * return null; }
	 */

}