package com.alameendev.fooddeliveryapp.login;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.alameendev.fooddeliveryapp.FoodDelivery;

public class LoginView {
	private LoginModel loginModel;

	public LoginView() {
		this.loginModel = new LoginModel(this);
	}

	public void init() {
		FoodDelivery foodDelivery = FoodDelivery.getInstance();
		String welcomeString = foodDelivery.getAppname()+"--------\nv--------"+foodDelivery.getAppVersion();
		String welcomeMessage = String.format("%n%s%n", welcomeString);
		showAlert(welcomeMessage);
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("1.Login 2.Sign Up\n");
				System.out.println("Enter the choice:");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:login();break;
				case 2:signup();break;
				}
			} catch (InputMismatchException e) {
				showAlert("Enter a number input!");
			}
		}

	}
	
	public void signup() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the Details!:\n");
		System.out.print("Enter the user name:");
		String userName = scanner.nextLine();
		if(!loginModel.isUser(userName)) {
			showAlert("User name is already taken!\n");
			return;
		}
		System.out.print("Enter the password:");
		String password = scanner.next();
		scanner.nextLine();
		System.out.print("Enter the address:");
		String address = scanner.nextLine();
		System.out.print("Enter the phone No:");
		String phoneNo = scanner.next();
		System.out.print("Choose the role:\n");
		System.out.print("H.Hotel Admin U.User D.Delivery Boy :");
		char role = Character.toUpperCase(scanner.next().charAt(0));
		if(role == 'D' || role == 'H' || role == 'U') {
			loginModel.createUser(userName,password,address,phoneNo,role);
		}else {
			showAlert("Enter a valid role!\n");
		}
	}
	
	public void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nPlease Login:\n");
		System.out.print("Enter the user name:");
		String userName = scanner.nextLine();
		System.out.print("Enter the password:");
		String password = scanner.next();
		loginModel.validateUser(userName,password);
	}		

	public void logout() {
		showAlert("Loged out Successfully");
		init();
	}

	public void showAlert(String alertText) {
		System.out.print(alertText);
	}
}
