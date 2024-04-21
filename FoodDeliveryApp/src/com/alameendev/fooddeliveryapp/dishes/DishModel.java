package com.alameendev.fooddeliveryapp.dishes;

import java.util.List;

import com.alameendev.fooddeliveryapp.db.FoodDB;
import com.alameendev.fooddeliveryapp.model.Dish;

public class DishModel {
	private DishView dishView;
	private FoodDB db;
	
	public DishModel(DishView dishView) {
		this.dishView = dishView;
		db = FoodDB.getInstance();
	}

	public void addDish(long hotelId, String name, int price, char dishType) {
		db.createDish(hotelId,name,price,dishType);
		dishView.showAlert("Dish added successfully!\n");
	}

	public List<Dish> getDishListForRestaurent(long hotelId) {
		return db.getDishList(hotelId);
	}
}
