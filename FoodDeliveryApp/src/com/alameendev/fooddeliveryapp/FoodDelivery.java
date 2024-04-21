package com.alameendev.fooddeliveryapp;

import com.alameendev.fooddeliveryapp.login.LoginView;

public class FoodDelivery {
	private static FoodDelivery foodDelivery;
	
	private String appName = "Food Devlivery Like Swiggy System!";
	
	private String appVersion= "0.0.1";
	
	private FoodDelivery() {
		
	}
	
	public static FoodDelivery getInstance() {
		if(foodDelivery == null) {
			foodDelivery = new FoodDelivery();
		}
		return foodDelivery;
	}
	
	public void create() {
		LoginView loginView = new LoginView();
		loginView.init();
	}
	
	public String getAppname() {
		return appName;
	}
	
	public String getAppVersion() {
		return appVersion;
	}
	
	public static void main(String[] args) {
		FoodDelivery.getInstance().create();
	}
}
