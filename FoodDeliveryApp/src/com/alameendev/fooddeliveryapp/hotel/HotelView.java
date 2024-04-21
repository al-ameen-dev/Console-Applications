package com.alameendev.fooddeliveryapp.hotel;
import java.util.List;
import java.util.Scanner;

import com.alameendev.fooddeliveryapp.model.Hotel;

public class HotelView {
	
	private HotelModel hotelModel;
	
	public HotelView() {
		this.hotelModel = new HotelModel(this);
	}
	
	public void showHotels() {
		List<Hotel> hotels = hotelModel.getHotelsForAdmin();
		showHotelTable(hotels);
	}
	
	public void showAllHotels() {
		List<Hotel> hotels = hotelModel.getAllHotels();
		showHotelTable(hotels);
	}

	public void showAddHotelsMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the hotel name:");
		String name = scanner.nextLine();
		System.out.print("Enter the Dishtype 'V' for veg. 'N' for non-veg:");
		char type = scanner.next().charAt(0);
		System.out.print("Enter the phone number:");
		String phoneNo = scanner.next();
		scanner.nextLine();
		System.out.print("Enter the address:");
		String address = scanner.nextLine();
		hotelModel.addHotels(name,type,phoneNo,address);
	}
	
	public void showHotelTable(List<Hotel> hotelList) {
		if (hotelList.size() == 0) {
			showAlert("Currently there are no hotels in your control . Add some Hotels!\n");
		} else {
			System.out.printf("%n%-5s|%-15s|%-15s|%-15s|%-15s%n", "Id", "Hotel Name", "Dish Type",
					"Address", "Phone No");
			for (Hotel hotel : hotelList) {
				System.out.printf("%n%-5d|%-15s|%-15s|%-15s|%-15s%n", hotel.getHotelId(), hotel.getName(),
						hotel.getDishType(),hotel.getAddress(),hotel.getPhoneNo());
			}
		}
	}
	
	public void showAlert(String alert) {
		System.out.print(alert);
	}

}
