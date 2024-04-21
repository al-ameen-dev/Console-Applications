package com.alameendev.fooddeliveryapp.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long cartId;
	private long userId;
	private List<Dish> orderList;
	
	public Cart(long cartId,long userId) {
		this.cartId = cartId;
		this.userId = userId;
		this.orderList = new LinkedList<>();
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<Dish> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Dish> orderList) {
		this.orderList = orderList;
	}
	
	public void addToCart(Dish dish) {
		this.orderList.add(dish);
	}
	
}
