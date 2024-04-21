package com.alameendev.fooddeliveryapp.model;

import java.io.Serializable;

import com.alameendev.fooddeliveryapp.model.FOOD_ENUMS.DishType;

public class Hotel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long hotelId;
	private long adminId;
	private DishType dishType;
	private String name;
	private String phoneNo;
	private String address;

	private Hotel(Builder builder) {
		this.adminId = builder.adminId;
		this.hotelId = builder.hotelId;
		this.dishType = builder.type;
		this.address = builder.address;
		this.phoneNo = builder.phoneNo;
		this.name = builder.name;
	}

	public static class Builder {
		private long hotelId;
		private DishType type;
		private long adminId;
		private String name;
		private String phoneNo;
		private String address;

		public Builder adminId(long id) {
			this.adminId = id;
			return this;
		}
		public Builder hotelId(long id) {
			this.hotelId = id;
			return this;
		}

		public Builder dishType(DishType type) {
			this.type = type;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder phoneNo(String no) {
			this.phoneNo = no;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Hotel build() {
			return new Hotel(this);
		}
	}

	public long getHotelId() {
		return hotelId;
	}
	
	public long getAdmin() {
		return this.adminId;
	}
	
	public void setAdminId(long id) {
		this.adminId = id;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public DishType getDishType() {
		return dishType;
	}

	public void setDishType(DishType dishType) {
		this.dishType = dishType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", adminId=" + adminId + ", dishType=" + dishType + ", name=" + name
				+ ", phoneNo=" + phoneNo + ", address=" + address + "]";
	}
	
	
}
