package com.alameendev.fooddeliveryapp.dishes;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.alameendev.fooddeliveryapp.model.Dish;
import com.alameendev.fooddeliveryapp.model.Hotel;

public class DishView {

	private DishModel dishModel;

	public DishView() {
		this.dishModel = new DishModel(this);
	}

	public void showAddDish() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter the hotel id:");
			long hotelId = scanner.nextLong();
			scanner.nextLine();
			System.out.print("Enter the dish name:");
			String name = scanner.nextLine();
			System.out.print("Enter the price:");
			int price = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter the Dish type(V for veg,N for Non-veg):");
			char dishType = scanner.next().charAt(0);
			dishModel.addDish(hotelId, name, price, dishType);
		} catch (InputMismatchException e) {
			System.out.println("Enter a number input!");
		}
	}

	public void showDishes() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the hotelId:");
		long hotelId = scanner.nextLong();
		List<Dish> dishList = dishModel.getDishListForRestaurent(hotelId);
		showDishesTable(dishList);
	}

	public void showDishesTable(List<Dish> dishList) {
		if (dishList.size() == 0) {
			showAlert("Currently there are no dishes in hotel . Add some dishes!\n");
		} else {
			System.out.printf("%n%-5s|%-15s|%-15s|%-15s%n", "Id", "Dish Name", "Dish Type", "Price");
			for (Dish dish : dishList) {
				System.out.printf("%n%-5d|%-15s|%-15s|%-15s%n", dish.getDishId(), dish.getName(), dish.getType(),
						dish.getPrice());
			}
		}
	}

	public void showHotelTable(List<Hotel> hotelList) {
		if (hotelList.size() == 0) {
			showAlert("Currently there are no hotels in your control . Add some Hotels!\n");
		} else {
			System.out.printf("%n%-5s|%-15s|%-15s|%-15s|%-15s%n", "Id", "Hotel Name", "Dish Type", "Address",
					"Phone No");
			for (Hotel hotel : hotelList) {
				System.out.printf("%n%-5d|%-15s|%-15s|%-15s|%-15s%n", hotel.getHotelId(), hotel.getName(),
						hotel.getDishType(), hotel.getAddress(), hotel.getPhoneNo());
			}
		}
	}

	public void showAlert(String alert) {
		System.out.print(alert);
	}
}
