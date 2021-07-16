package com.cg.gsm.util;

public class UserConstants {

	public static final String MORE_THAN_ONE_ROW = "More than one row with the given identifier was found";

	public static final String USER_EXISTS = "User already exists";

	public static final String BASE_NOT_FOUND = "No base found";

	public static final String USER_NOT_FOUND = "No user found";

	public static final String USER_ADDED = "Record added successfully and Generated ID is ";

	public static final String USER_UPDATED = "Record updated successfully for the ID ";

	public static final String FIRSTNAME_PATTERN = "([a-z A-Z]+)";

	public static final String FIRSTNAME_NOT_FOUND = "Firstname cannot be empty should contain alphabets only";

	public static final String LASTNAME_PATTERN = "([a-z A-Z]+)";

	public static final String LASTNAME_NOT_FOUND = "Lastname cannot be empty should contain alphabets only";

	public static final String MOBILE_NO_PATTERN = "([6-9]{1}[0-9]{9})";

	public static final String MOBILE_NO_CANNOT_BE_EMPTY = "Mobile number cannot be empty and should start with 6-9 having 10 digits";

	public static final String EMAIL_PATTERN = "([a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+)";

	public static final String EMAIL_CANNOT_BE_EMPTY = "Email cannot be empty and should follow valid pattern example:hello@xyz.com";

	public static final String PASSWORD_PATTERN = "([a-zA-Z0-9]+[@#$%]+[a-zA-Z0-9]*|[@#$%]+[a-zA-Z0-9]+)";

	public static final String PASSWORD_CANNOT_BE_EMPTY = "Password should contain atleast one special characters like @,#,$,%";
	
	public static final String COUNTRY_PATTERN = "([a-z A-Z]+)";

	public static final String COUNTRY_CANNOT_BE_EMPTY = "Country cannot be empty can only contain alphabets";

	public static final String STATE_PATTERN = "([a-z A-Z]+)";

	public static final String STATE_CANNOT_BE_EMPTY = "State cannot be empty can only contain aplhabets";

	public static final String DISTRICT_PATTERN = "([a-z A-Z]+)";

	public static final String DISTRICT_CANNOT_BE_EMPTY = "District cannot be empty can only contain alphabets";

	public static final String PINCODE_PATTERN = "([1-9][0-9]{5})";

	public static final String PINCODE_CANNOT_BE_EMPTY = "Pincode cannot be empty can only contain numerics with 6 digits";
	
	public static final String EMAIL_ID_EXISTS = "Email id already exists";
	
	public static final String MOBILE_NO_EXISTS = "Mobile number already exists";

}
