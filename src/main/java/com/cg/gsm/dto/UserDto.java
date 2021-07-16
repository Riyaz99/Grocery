package com.cg.gsm.dto;

public class UserDto {

	private long userId;
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String emailId;
	private String country;
	private String state;
	private String district;
	private String pincode;
	private String address;
	private String role;

	public UserDto() {
		super();
	}

	public UserDto(String password, String firstName, String lastName, String mobileNo, String emailId, String country,
			String state, String district, String pincode, String address, String role) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.country = country;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.address = address;
		this.role = role;
	}

	public UserDto(long userId, String password, String firstName, String lastName, String mobileNo, String emailId,
			String country, String state, String district, String pincode, String address, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.country = country;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.address = address;
		this.role = role;
	}

	public long getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getDistrict() {
		return district;
	}

	public String getPincode() {
		return pincode;
	}

	public String getAddress() {
		return address;
	}

	public String getRole() {
		return role;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRoleId(String role) {
		this.role = role;
	}

}
