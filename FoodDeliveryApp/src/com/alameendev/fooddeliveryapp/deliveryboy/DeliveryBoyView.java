package com.alameendev.fooddeliveryapp.deliveryboy;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.alameendev.fooddeliveryapp.cart.CartView;
import com.alameendev.fooddeliveryapp.db.FoodDB;
import com.alameendev.fooddeliveryapp.model.Cart;
import com.alameendev.fooddeliveryapp.model.Dish;
import com.alameendev.fooddeliveryapp.model.Hotel;
import com.alameendev.fooddeliveryapp.model.User;


public class DeliveryBoyView {

	private DeliveryBoyModel deliveryBoyModel;
	private FoodDB db;
	
	public DeliveryBoyView() {
		this.deliveryBoyModel = new DeliveryBoyModel(this);
		db = FoodDB.getInstance();
	}
	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		
		exit:while(true) {
			try {
				System.out.print("1.Show Orders 2.Take Order 10.Logout.\n");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					showOrders();
					break;
				case 2:
					
					break;
		
				case 10:
					break exit;

				default:
					break;
				}
				
			}catch(InputMismatchException e) {
				
			}
		}
	}
	
	private void showOrders() {
		List<Cart> cartList = db.cartList();
		for(Cart cart:cartList) {
			User user = db.getUser(cart.getUserId());
			System.out.printf("%n%-10s |%-10s |%-10s","Customer Name","Phone No","Address");
			System.out.printf("%n%-10s |%-10s |%-10s%n", user.getName(),user.getPhoneNo(),user.getAddress());
			System.out.printf("%n%-10s |%-15s |%-15s |%-15s |%-15s |%-15s%n", "Dish Id","Dish Name","Dish Price","Hotel Name","Hotel Address","Hotel contact");
			for(Dish dish:cart.getOrderList()) {
				Hotel hotel = db.getHotel(dish.getHotelId());
				System.out.printf("%n%-10d |%-15s |%-15d |%-15s |%-15s |%-15s%n", dish.getDishId(),dish.getName(),dish.getPrice(),hotel.getName(),hotel.getAddress(),hotel.getPhoneNo());
			}
		}
		
	}
	public void showAlert(String alert) {
		System.out.print(alert);
	}

}
