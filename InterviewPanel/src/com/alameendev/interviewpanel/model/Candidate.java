package com.alameendev.interviewpanel.model;

import java.io.Serializable;

public class Candidate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long candidateId;
	private String candidateName;
	private String candidateEmail;
	private String candidatePhoneNo;
	private String candidateAddress;
	private String candidateQualification;
	
	private Candidate() {
	}
	
	private Candidate(Builder builder) {
		this.candidateName = builder.name;
		this.candidateId = builder.id;
		this.candidateEmail = builder.email;
		this.candidateAddress = builder.address;
		this.candidatePhoneNo = builder.phoneNo;
		this.candidateQualification = builder.qualification;
	}

	public long getId() {
		return candidateId;
	}

	public void setId(int id) {
		this.candidateId = id;
	}

	public String getName() {
		return candidateName;
	}

	public void setName(String name) {
		this.candidateName = name;
	}

	public String getEmail() {
		return candidateEmail;
	}

	public void setEmail(String email) {
		this.candidateEmail = email;
	}

	public String getPhoneNo() {
		return candidatePhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.candidatePhoneNo = phoneNo;
	}

	public String getAddress() {
		return candidateAddress;
	}

	public void setAddress(String address) {
		this.candidateAddress = address;
	}

	public String getQualification() {
		return candidateQualification;
	}

	public void setQualification(String qualification) {
		this.candidateQualification = qualification;
	}
	
	public static class Builder{
		private String name;
		private long id;
		private String qualification;
		private String phoneNo;
		private String email;
		private String address;
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder qualification(String qualification) {
			this.qualification = qualification;
			return this;
		}
		
		public Builder phoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
			return this;
		}
		
		public Builder id(long id) {
			this.id = id;
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
		
		public Candidate build() {
			return new Candidate(this);
		}
	}
	
	@Override
	public String toString() {
		return "Candidate ["+ candidateId+" - "+candidateName+" - "+candidateQualification+" ]";
	}

}
