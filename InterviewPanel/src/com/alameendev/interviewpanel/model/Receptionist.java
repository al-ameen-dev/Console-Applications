package com.alameendev.interviewpanel.model;

import java.io.Serializable;

import com.alameendev.interviewpanel.model.Admin.Builder;

public class Receptionist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String receptionistName;
	private String receptionistPassword;
	private long receptionistId;
	private String receptionistPhoneNo;
	private String receptionistEmailid;
	private String receptoinistAddress;

	private Receptionist() {
	}
	
	private Receptionist(Builder builder) {
		this.receptionistName = builder.name;
		this.receptionistEmailid = builder.email;
		this.receptionistId = builder.id;
		this.receptionistPassword = builder.password;
		this.receptionistPhoneNo = builder.phoneNo;
		this.receptoinistAddress =  builder.address;
		
	}

	public String getName() {
		return receptionistName;
	}

	public void setName(String name) {
		this.receptionistName = name;
	}

	public String getPassword() {
		return receptionistPassword;
	}

	public void setPassword(String password) {
		this.receptionistPassword = password;
	}

	public long getId() {
		return receptionistId;
	}

	public void setId(long id) {
		this.receptionistId = id;
	}

	public String getPhoneNo() {
		return receptionistPhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.receptionistPhoneNo = phoneNo;
	}

	public String getEmailId() {
		return receptionistEmailid;
	}

	public void setEmailId(String emailId) {
		this.receptionistEmailid = emailId;
	}

	public String getAddress() {
		return receptoinistAddress;
	}

	public void setAddress(String address) {
		this.receptoinistAddress = address;
	}
	
	public static class Builder{
		private String name;
		private String password;
		private long id;
		private String phoneNo;
		private String email;
		private String address;
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder id(long id) {
			this.id = id;
			return this;
		}
		
		public Builder phoneNo(String phoneNO) {
			this.phoneNo = phoneNO;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		public Receptionist build() {
			return new Receptionist(this);
		}
	}

	@Override
	public String toString() {
		return "Receptionist { " + receptionistId + " - " + receptionistName + " - " + " - " + receptionistPhoneNo + " - " + receptionistEmailid + " - " + receptoinistAddress + " }";
	}

}
