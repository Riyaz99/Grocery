package com.cg.gsm.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookproduct")
public class BookProductEntity /*extends BaseEntity*/ {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	public BookProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	  @OneToOne(mappedBy="bookproduct",cascade=CascadeType.ALL) 
	  private UserEntity users;
	  
	  @OneToOne(mappedBy="bookproduct",cascade=CascadeType.ALL)
	  private BaseEntity base;
	 
	
	
	  public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	public BaseEntity getBase() {
		return base;
	}

	public void setBase(BaseEntity base) {
		this.base = base;
	}


	@Column(name = "productName")
	private String productName;
	@Column(name = "name")
	private String name;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "mobileNo")
	private String mobileNo;
	@Column(name = "country")
	private String country;
	@Column(name = "state")
	private String state;
	@Column(name = "district")
	private String district;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "address")
	private String address;
	@Column(name = "userId")
	private long userId;
	@Column(name = "quantity")
	private String quantity;
	@Column(name = "amount")
	private String anmount;
	@Column(name = "date")
	private Date date;
	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAnmount() {
		return anmount;
	}

	public void setAnmount(String anmount) {
		this.anmount = anmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

/*	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
