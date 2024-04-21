package com.alameendev.fooddeliveryapp.homepage;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.alameendev.fooddeliveryapp.admin.AdminView;
import com.alameendev.fooddeliveryapp.customer.CustomerModel;
import com.alameendev.fooddeliveryapp.customer.CustomerView;
import com.alameendev.fooddeliveryapp.deliveryboy.DeliveryBoyView;
import com.alameendev.fooddeliveryapp.model.User;

public class HomePageView {

	CustomerView customerView;
	DeliveryBoyView deliveryBoyView;
	AdminView adminView;

	public HomePageView() {
		this.customerView = new CustomerView();
		this.deliveryBoyView = new DeliveryBoyView();
		this.adminView = new AdminView();
	}

	public void showUserMenu(User user) {
		switch (user.getRole()) {
		case ADMIN:adminView.showMenu();
			break;
		case USER:
			customerView.showMenu();
			break;
		case DELILVERY_BOY:
			deliveryBoyView.showMenu();
			break;
		default:
			System.out.println("Enter a valid option!");
		}

	}
}
