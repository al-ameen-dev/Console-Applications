package com.alameendev.fooddeliveryapp.cart;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.alameendev.fooddeliveryapp.model.Cart;
import com.alameendev.fooddeliveryapp.model.Dish;

public class CartView {

	private CartModel cartModel;

	public CartView() {
		this.cartModel = new CartModel(this);
	}

	public void showAddToCart() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter the dish id:");
			long dishId = scanner.nextLong();
			if (cartModel.addToCart(dishId)) {
				showAlert("Dish successfully added to the cart!\n");
			} else {
				showAlert("The dish with id '" + dishId + "' not exists!");
			}
		} catch (InputMismatchException e) {
			System.out.println("enter a number input!");
		}
	}

	public void showCart() {
		Cart cart = cartModel.getCart();
		showDishesTable(cart.getOrderList());
	}

	public void showDishesTable(List<Dish> dishList) {
		int total = 0;
		if (dishList.size() == 0) {
			showAlert("there are no dishes. Add some dishes!\n");
		} else {
			System.out.printf("%n%-5s|%-15s|%-15s|%-15s%n", "Id", "Dish Name", "Dish Type", "Price");
			for (Dish dish : dishList) {
				System.out.printf("%n%-5d|%-15s|%-15s|%-15s%n", dish.getDishId(), dish.getName(), dish.getType(),
						dish.getPrice());
				total += dish.getPrice();
			}
			showAlert("The total price:"+total+"\n");
		}
	}

	public void showAlert(String alert) {
		System.out.print(alert);
	}

	public static void showOrders() {
		// TODO Auto-generated method stub
		
	}

}
