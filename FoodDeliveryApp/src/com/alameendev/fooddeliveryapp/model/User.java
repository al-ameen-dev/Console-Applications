package com.alameendev.fooddeliveryapp.model;

import com.alameendev.fooddeliveryapp.model.FOOD_ENUMS.UserType;

public class User {

	private User(Builder builder) {
		this.userId = builder.userId;
		this.name = builder.name;
		this.password = builder.password;
		this.address = builder.address;
		this.phoneNo = builder.phoneNo;
		this.role = builder.role;
	}

	private long userId;
	private String name;
	private String password;
	private String phoneNo;
	private String address;
	private UserType role;

	public static class Builder {
		private long userId;
		private String name;
		private String password;
		private String phoneNo;
		private String address;
		private UserType role;

		public Builder userId(long userId) {
			this.userId = userId;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder phoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder role(UserType role) {
			this.role = role;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", role=" + role + "]";
	}

}
