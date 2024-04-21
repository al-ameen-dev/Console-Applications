package com.alameendev.fooddeliveryapp.model;

import java.io.Serializable;

public class UniqueId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public long uniqueUserId;
	public long uniqueHotelId;
	public long uniqueDishId;
	public long uniqueCartid;
	
	
	private static UniqueId uniqueId;
	
	public static UniqueId id() {
		if(uniqueId == null) {
			uniqueId = new UniqueId();
		}
		return uniqueId;
	}
	
	private UniqueId() {
		reset();
	}
	
	public void reset() {
		uniqueCartid = 1;
		uniqueDishId = 1;
		uniqueHotelId = 1;
		uniqueUserId = 1;
	}
	
	public void incrementUserId() {
		uniqueUserId++;
	}
	
	public long getUserId() {
		return uniqueUserId;
	}
	
	public void incrementCartId() {
		uniqueCartid++;
	}
	
	public long getCartId() {
		return uniqueCartid;
	}
	
	public void incrementDishId() {
		uniqueDishId++;
	}
	
	public long getDishId() {
		return uniqueDishId;
	}
	
	public void incrementHotelId() {
		uniqueHotelId++;
	}
	
	public long getHotelId() {
		return uniqueHotelId;
	}
}
