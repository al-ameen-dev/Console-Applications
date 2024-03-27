package com.alameendev.interviewpanel.receptionist;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.alameendev.interviewpanel.login.LoginView;
import com.alameendev.interviewpanel.model.Hr;
import com.alameendev.interviewpanel.model.Receptionist;
import com.alameendev.interviewpanel.validationutils.Validation;

public class ReceptionistView {
	
	private ReceptionistModel receptionistModel;
	
	public ReceptionistView() {
		this.receptionistModel = new ReceptionistModel(this);
	}
	
	public void updateReceptionistDetails() {
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
		receptionistModel.updateReceptionist(name,password,phoneNo,email,address);
	}
	
	public void addCandidateToQueue() {
		Scanner scanner = new Scanner(System.in);
		long hrId = 0;
		System.out.print("Enter the HR id:");
		try {
			hrId = scanner.nextInt();
		}catch(InputMismatchException e) {
			showAlert("Enter a number input!");
			return;
		}
		scanner.nextLine();
		System.out.print("Enter the candidate name:");
		String name = scanner.nextLine();
		if(!Validation.validate().name(name)) {
			showAlert("Please enter a valid name!");
			return;
		}
		System.out.print("Enter the email:");
		String email = scanner.next();
		if(!Validation.validate().email(email)) {
			showAlert("Enter a valid email format!");
			return;
		}
		System.out.print("Enter the phone no:");
		String phoneNo = scanner.next();
		if(!Validation.validate().phone(phoneNo)) {
			showAlert("Enter a valid phone no!");
			return;
		}
		scanner.nextLine();
		System.out.print("Enter the address:");
		String address = scanner.nextLine();
		if(address.length()<4) {
			showAlert("Enter a address greater than 4 characters!");
			return;
		}
		System.out.print("Enter the qualification:");
		String qualification = scanner.next();
		if(qualification.length()<1) {
			showAlert("Enter a valid qualification!");
			return;
		}
		receptionistModel.addCandidate(hrId,name,email,phoneNo,address,qualification);
	}
	
	public void showReceptionistDetails() {
		Receptionist receptionist = receptionistModel.getReceptionstionistDetails();
		System.out.printf("Name: %-5s | Email: %-5s | Phone No: %-5s | Address: %-5s",receptionist.getName(),
				receptionist.getEmailId(),receptionist.getPhoneNo(),receptionist.getAddress());
	}
	
	public void showAlert(String alert) {
		System.out.println(alert);
	}

	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		exit: while(true) {
			System.out.printf("%nReceptionist Menu : 1 %-10s| 2 %-10s| 3 %-10s| 4 %-10s| 5 %-10s| 6 %-10s%n","Add Candidates",
					"Show HR's","Update Receptionist Details","Show Receptionist Details","Go Back","Logout");
			System.out.print("Enter the choice:");
			try {
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					addCandidateToQueue();
					break;
				case 2:
					showHrList();
					break;
				case 3:
					updateReceptionistDetails();
					break;
				case 4:
					showReceptionistDetails();
					break;
				case 5:
					break exit;
				case 6:
					LoginView.getInstance().init();
					return;
				default:
					System.out.println("Invalid choice selected!");
				}
			}catch(InputMismatchException e) {
				showAlert("Enter a number input!");
				scanner.next();
			}
			
		}
	}

	public void showHrList() {
		showHrTable(receptionistModel.getHr());
	}
	public void showHrTable(List<Hr> hrList) {
		if (hrList.size() == 0) {
			showAlert("Currently there is no candidates to show!.\n");
		} else {
			System.out.printf("%n%-15s|%-15s|%-15s|%-15s%n", "HR Id", "Hr Name", "Email Id",
					"Phone No");
			for (Hr hr : hrList) {
				System.out.printf("%n%-15d|%-15s|%-15s|%-15s%n", hr.getHrId(), hr.getHrName(),
						hr.getHrEmailId(), hr.getPhoneNo());
			}
		}
	}
}
