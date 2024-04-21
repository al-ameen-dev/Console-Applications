package com.alameendev.fooddeliveryapp.hotel;

import java.util.List;

import com.alameendev.fooddeliveryapp.db.FoodDB;
import com.alameendev.fooddeliveryapp.model.Hotel;

public class HotelModel {
	private HotelView hotelView;
	private FoodDB db;
	
	public HotelModel(HotelView hotelView) {
		this.hotelView = hotelView;
		db = FoodDB.getInstance();
	}

	public List<Hotel> getHotelsForAdmin() {
		return db.getHotelList(db.getCurrentUser());
	}

	public void addHotels(String name, char type, String phoneNo, String address) {
		db.addHotel(name,type,phoneNo,address);
	}

	public List<Hotel> getAllHotels() {
		return db.getHotelList();
	}
}
