package com.alameendev.fooddeliveryapp.cart;

import com.alameendev.fooddeliveryapp.db.FoodDB;
import com.alameendev.fooddeliveryapp.model.Cart;

public class CartModel {

	private CartView cartView;
	private FoodDB db;
	
	public CartModel(CartView cartView) {
		this.cartView = cartView;
		db = FoodDB.getInstance();
	}

	public Cart getCart() {
		return db.getCartForUser();
	}
	public boolean addToCart(long dishId) {
		boolean result =  db.addDishToCart(dishId);
		return result;
	}
}
