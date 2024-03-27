package com.alameendev.interviewpanel.model;

import java.io.Serializable;

public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String adminName;
	private long adminId;
	private String adminEmailId;
	private String adminPassword;
	private String adminPhoneNo;

	private Admin() {
	}

	private Admin(Builder builder) {
		this.adminName = builder.name;
		this.adminEmailId = builder.email;
		this.adminId = builder.id;
		this.adminPhoneNo = builder.phoneNo;
		this.adminPassword = builder.password;
	}

	public String getName() {
		return adminName;
	}

	public void setName(String name) {
		this.adminName = name;
	}

	public long getId() {
		return adminId;
	}

	public void setId(long id) {
		this.adminId = id;
	}

	public void setEmailId(String email) {
		this.adminEmailId = email;
	}

	public String getEmailId() {
		return adminEmailId;
	}

	public String getPassword() {
		return adminPassword;
	}

	public void setPassword(String password) {
		this.adminPassword = password;
	}

	public String getPhoneNo() {
		return adminPhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.adminPhoneNo = phoneNo;
	}

	public static class Builder {
		private String name;
		private String email;
		private long id;
		private String password;
		private String phoneNo;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder phoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
			return this;
		}

		public Admin build() {
			return new Admin(this);
		}
	}

	@Override
	public String toString() {
		return "Admin [name=" + adminName + ", id=" + adminId + ", password=" + adminPassword + ", phoneNo="
				+ adminPhoneNo + "]";
	}

}
