package com.alameendev.interviewpanel.admin;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.alameendev.interviewpanel.db.InterviewDatabase;
import com.alameendev.interviewpanel.login.LoginView;
import com.alameendev.interviewpanel.model.Admin;
import com.alameendev.interviewpanel.validationutils.Validation;

public class AdminView {

	private AdminModel adminModel;

	public AdminView() {
		this.adminModel = new AdminModel(this);
	}

	public void showMenu() {

		Scanner scanner = new Scanner(System.in);
		exit: while (true) {
			System.out.printf("%nAdmin Menu : 1 %-10s| 2 %-10s| 3 %-10s| 4 %-10s| 5 %-10s| 6 %-10s| 7 %-10s| 9 %-10s%n", "Add HR",
					"Add Receptionist", "Update Admin Info","Remove HR","Remove Receptionist", "Show Admin Info","Logout", "Exit");
			try {
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					addHr();
					break;
				case 2:
					addReceptionist();
					break;
				case 3:
					updateAdminInfo();
					break;
				case 4:
					removeHr();
					break;
				case 5:
					removeReceptionist();
					break;
				case 6:
					showAdminInfo();
					break;
				case 7:
					// loginView.init();
					LoginView.getInstance().init();
					return;
				case 9:
					break exit;
				default:
					System.out.println("Invalid choice selected!");
				}
			} catch (InputMismatchException e) {
				showAlert("Enter a number input!");
				scanner.next();
			}
		}
	}

	private void removeHr() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Hr ID:");
		long id = scanner.nextInt();
		adminModel.removeHr(id);
		showAlert("HR removed successfully!");		
	}
	
	private void removeReceptionist() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Receptionist ID:");
		long id = scanner.nextInt();
		adminModel.removeReceptionist(id);
		showAlert("Receptionist removed successfully!");		
	}

	private void showAdminInfo() {
		Admin admin = adminModel.getAdmin();
		System.out.println("Admin Name:"+admin.getName()+"\n"+"Admin Password:"+admin.getPassword()+"\n"+
		"Admin Email:"+admin.getEmailId()+"\n"+"Admin Phone No:"+admin.getPhoneNo());
	}

	private void updateAdminInfo() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the name:");
		String name = scanner.nextLine();
		System.out.print("Enter the password:");
		String password = scanner.next();
		System.out.print("Enter the phone no:");
		String phoneNo = scanner.next();
		System.out.print("Enter the email:");
		String email = scanner.next();
		scanner.nextLine();
		System.out.print("Enter the address:");
		String address = scanner.nextLine();
		adminModel.updateAdmin(name,password,phoneNo,email);
		
	}

	private void addHr() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the hr email:");
		String name = scanner.nextLine();
		if (!Validation.validate().email(name)) {
			showAlert("Enter a valid name!");
			return;
		}
		System.out.print("Enter the default password for hr:");
		String password = scanner.next();
		if (password.length() < 6) {
			showAlert("Enter a valid password!");
			return;
		}
		adminModel.addHr(name, password);
	}
	 
	private void addReceptionist() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the receptionist email id:");
		String name = scanner.nextLine();
		if (!Validation.validate().email(name)) {
			showAlert("Enter a valid name!");
			return;
		}
		System.out.print("Enter the default password for receptionist:");
		String password = scanner.next();
		if (password.length() < 6) {
			showAlert("Enter a valid password!");
			return;
		}
		adminModel.addReceptionist(name, password);
	}

	public void showAlert(String alert) {
		System.err.println(alert);
	}
}
