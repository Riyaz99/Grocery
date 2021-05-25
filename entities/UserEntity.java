package com.cg.gsm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity /*extends BaseEntity*/ {

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	
	@OneToOne(cascade=CascadeType.ALL)
	private BookProductEntity bookproduct;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private BaseEntity base;
	
	public BaseEntity getBase() {
		return base;
	}

	public void setBase(BaseEntity base) {
		this.base = base;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "loginid")
	private String loginId;

	@Column(name = "password")
	private String password;
	@Column(name = "mobileNo")
	private String mobileNo;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "roleId")
	private long roleId;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	  public UserEntity(String firstName, String lastName, BookProductEntity bookproduct, long id, String loginId,
			String password, String mobileNo, String emailId, long roleId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bookproduct = bookproduct;
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.roleId = roleId;
	}

	public BookProductEntity getBookproduct() { return bookproduct; }
	  
	  public void setBookproduct(BookProductEntity bookproduct) { this.bookproduct
	  = bookproduct; }
	 

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


/*	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}
*/
}