package com.alameendev.fooddeliveryapp.model;

import java.io.Serializable;

import com.alameendev.fooddeliveryapp.model.FOOD_ENUMS.DishType;

public class Dish implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long dishId;
	private String name;
	private int price;
	private long userId;
	private long hotelId;
	private DishType dishType;

	private Dish(Builder builder) {
		this.dishId = builder.dishId;
		this.name = builder.name;
		this.price = builder.price;
		this.userId = builder.userId;
		this.hotelId = builder.hotelId;
		this.dishType = builder.type;
	}

	public static class Builder {
		private long dishId;
		private String name;
		private int price;
		private long userId;
		private long hotelId;
		private DishType type;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder dishId(long id) {
			this.dishId = id;
			return this;
		}

		public Builder price(int price) {
			this.price = price;
			return this;
		}

		public Builder userId(long userId) {
			this.userId = userId;
			return this;
		}

		public Builder hotelId(long hotelId) {
			this.hotelId = hotelId;
			return this;
		}

		public Builder dishType(DishType type) {
			this.type = type;
			return this;
		}

		public Dish build() {
			return new Dish(this);
		}

	}

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public DishType getType() {
		return dishType;
	}

	public void setType(DishType type) {
		this.dishType = type;
	}

}
