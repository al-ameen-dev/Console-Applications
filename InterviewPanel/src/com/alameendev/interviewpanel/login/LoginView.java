package com.alameendev.interviewpanel.login;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.alameendev.interviewpanel.InterviewPanel;
import com.alameendev.interviewpanel.validationutils.Validation;

public class LoginView {

	private static LoginView loginView;
	private LoginModel loginModel;

	public LoginView() {
		loginModel = new LoginModel(this);
	}

	public static LoginView getInstance() {
		if (loginView == null) {
			loginView = new LoginView();
		}
		return loginView;
	}

	public void init() {
		System.out.println("----" + InterviewPanel.getInstance().getAppname() + "---\nversion "
				+ InterviewPanel.getInstance().getAppVersion());
		Scanner scanner = new Scanner(System.in);
		exit: while(true){
			System.out.printf("%n Login: 1 %-10s| 2 %-10s| 3 %-10s| 4 %-10s%n","Admin Login","HR Login","Receptionist Login","Exit");
			System.out.print("Enter the choice:");
			try {
				int choice = scanner.nextInt();
				switch(choice){
				case 1:
					adminLogin();
					break;
				case 2:
					hrLogin();
					break;
				case 3:
					receptionistLogin();
					break;
				case 4:
					break exit;
				default:
					showAlert("Enter a valid option!");
				}
			}catch(InputMismatchException e) {
				showAlert("Enter a number input!");
				scanner.next();
			}
		}
		
	}

	public void adminLogin() {
		System.out.println("\nPlease Login To Proceed.");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the user name:");
		String name = scanner.next();
//		if (!Validation.validate().email(name)) {
//			showAlert("Enter a valid user name!");
//			return;
//		}
		System.out.print("Enter the password:");
		String password = scanner.next();
//		if (password.length() < 6) {
//			showAlert("Enter valid password!");
//			return;
//		}
		loginModel.validateAdmin(name, password);
	}

	public void hrLogin() {
		System.out.println("\nPlease Login To Proceed.");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the email Id:");
		String emailId = scanner.next();
		if (!Validation.validate().email(emailId)) {
			showAlert("Enter a valid email id!");
			return;
		}
		System.out.print("Enter the password:");
		String password = scanner.next();
		if (password.length() < 6) {
			showAlert("Enter valid password!");
			return;
		}
		loginModel.validateHr(emailId, password);
	}

	public void receptionistLogin() {
		System.out.println("\nPlease Login To Proceed.");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the email:");
		String emailId = scanner.next();
		if (!Validation.validate().email(emailId)) {
			showAlert("Enter a valid user email id!");
			return;
		}
		System.out.print("Enter the password:");
		String password = scanner.next();
		if (password.length() < 6) {
			showAlert("Enter valid password!");
			return;
		}
		loginModel.validateReceptionist(emailId, password);
	}

//	public void onLoginSuccess() {
//		System.out.flush();
//		System.out.println("\nLogin successful....\n\n ----Welcome to " + InterviewPanel.getInstance().getAppname()
//				+ " -v " + InterviewPanel.getInstance().getAppVersion());
//		homePageView.init();
//	}

	public void showAlert(String alert) {
		System.err.println(alert);
	}
}
