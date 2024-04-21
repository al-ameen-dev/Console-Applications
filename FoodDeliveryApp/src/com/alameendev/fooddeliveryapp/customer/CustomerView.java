package com.alameendev.fooddeliveryapp.customer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.alameendev.fooddeliveryapp.cart.CartView;
import com.alameendev.fooddeliveryapp.dishes.DishView;
import com.alameendev.fooddeliveryapp.hotel.HotelView;

public class CustomerView {
	
	private CustomerModel customerModel;
	private HotelView hotelView;
	private DishView dishView;
	private CartView cartView;
	
	public CustomerView() {
		this.customerModel = new CustomerModel(this);
		this.hotelView = new HotelView();
		this.dishView = new DishView();
		this.cartView = new CartView();
	}

	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		exit: while (true) {
			try {
				System.out.println("1.Show Hotels 2.Show Dishes 3.Order Food 4.Show Cart 9.My Profile 10.Logout ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:hotelView.showAllHotels();break;
				case 2:dishView.showDishes();break;
				case 3:cartView.showAddToCart();break;
				case 4:cartView.showCart();break;
				case 10:
					break exit;
					
				default:System.out.println("Enter a valid option!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter a number input!");
			}

		}		
	}
}
