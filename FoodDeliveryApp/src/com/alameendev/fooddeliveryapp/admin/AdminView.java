package com.alameendev.fooddeliveryapp.admin;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.alameendev.fooddeliveryapp.dishes.DishView;
import com.alameendev.fooddeliveryapp.hotel.HotelView;
import com.alameendev.fooddeliveryapp.login.LoginView;

public class AdminView {
	
	private AdminModel adminModel;
	private HotelView hotelView;
	private DishView dishView;
	
	
	public AdminView() {
		this.adminModel = new AdminModel(this);
		this.hotelView = new HotelView();
		this.dishView = new DishView();
	}

	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		exit: while(true) {
			try {
				System.out.println("1.Add Hotels 2.Show Hotels 3. Add dishes to hotel 4.Show dishes 10.Logout");
				int choice = scanner.nextInt();
				
				switch (choice) {
				case 1:
					hotelView.showAddHotelsMenu();
					break;
				case 2:
					hotelView.showHotels();
					break;
				case 3:
					dishView.showAddDish();
					break;
				case 4:
					dishView.showDishes();
					break;
				case 10:
					break exit;
				default:
					break;
				}
			}catch (InputMismatchException e) {
				System.out.println("Enter a number input!\n");
			}
			
		}
		
	}
}
