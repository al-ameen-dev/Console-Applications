package com.alameendev.fooddeliveryapp.login;

import java.util.List;

import com.alameendev.fooddeliveryapp.db.FoodDB;
import com.alameendev.fooddeliveryapp.homepage.HomePageView;
import com.alameendev.fooddeliveryapp.model.User;

public class LoginModel {
	private LoginView loginView;
	private HomePageView homePageView;
	private FoodDB db;

	public LoginModel(LoginView loginView) {
		this.loginView = loginView;
		this.homePageView = new HomePageView();
		this.db = FoodDB.getInstance();
	}

	public void validateUser(String userName, String password) {
		List<User> userList = FoodDB.getInstance().getUserList();
		for (User user : userList) {
			if (userName.equals(user.getName())) {
				if (password.equals(user.getPassword())) {
					db.setCurrentUser(user);
					homePageView.showUserMenu(user);
				} else {
					loginView.showAlert("User name or Password is incorrect!\n");
				}
			}
		}
	}

	public void createUser(String userName, String password, String address, String phoneNo, char role) {
			db.createUser(userName, password, address, phoneNo, role);
			loginView.showAlert("User created successfully!");
			loginView.init();
	}

	public boolean isUser(String userName) {
		if(db.getUser(userName)) {
			return true;
		}
		return false;
	}

}
