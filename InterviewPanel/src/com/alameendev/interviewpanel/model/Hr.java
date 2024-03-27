package com.alameendev.interviewpanel.model;

import java.io.Serializable;

public class Hr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long hrId;
	private String hrName;
	private String hrPassword;
	private String hrEmailId;
	private String phoneNo;

	private Hr() {
	}

	private Hr(Builder builder) {
		this.hrId = builder.id;
		this.hrName = builder.name;
		this.hrPassword = builder.password;
		this.hrEmailId = builder.email;
		this.phoneNo = builder.phoneNo;
	}

	public long getHrId() {
		return hrId;
	}

	public void setHrId(long hrId) {
		this.hrId = hrId;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getHrPassword() {
		return hrPassword;
	}

	public void setHrPassword(String hrPassword) {
		this.hrPassword = hrPassword;
	}

	public String getHrEmailId() {
		return hrEmailId;
	}

	public void setHrEmailId(String hrEmailId) {
		this.hrEmailId = hrEmailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public static class Builder {
		private long id;
		private String name;
		private String email;
		private String password;
		private String phoneNo;

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
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

		public Hr build() {
			return new Hr(this);
		}
	}

	@Override
	public String toString() {
		return "Hr [hrId=" + hrId + ", hrName=" + hrName + ", hrEmailId=" + hrEmailId + ", phoneNo=" + phoneNo + "]";
	}

}
