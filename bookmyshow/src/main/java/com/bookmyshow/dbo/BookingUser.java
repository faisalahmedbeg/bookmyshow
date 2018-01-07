package com.bookmyshow.dbo;

public class BookingUser {
	private String userName;
	private String fullName;
	private String password;
	private int age;
	private int phoneNumber;

	public BookingUser(String userName, String fullName, String password, int age, int phoneNumber) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public static boolean compareUserDetails(BookingUser u1, BookingUser u2) {
		if ((u1.userName.equals(u2.userName)) && (u1.password.equals(u2.password)))
			return true;
		else
			return false;
	}

	public String getUserName() {
		return userName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

}
