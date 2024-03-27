package com.alameendev.interviewpanel.admin;

import com.alameendev.interviewpanel.db.InterviewDatabase;
import com.alameendev.interviewpanel.model.Admin;
import com.alameendev.interviewpanel.model.Hr;
import com.alameendev.interviewpanel.model.Receptionist;

public class AdminModel {

	private AdminView adminView;
	private InterviewDatabase db;

	AdminModel(AdminView adminView) {
		this.adminView = adminView;
	}

	public void addHr(String email, String password) {
		db = InterviewDatabase.getInstance();
		Hr hr = new Hr.Builder().id(db.uniqueId().getHrId()).email(email).password(password)
				.name("Please update the name!").phoneNo("Please update the phone no!").build();
		db.setStatusOfInterview(false,hr.getHrId());
		db.uniqueId().incrementHrId();
		db.saveUniqueId();
		db.addHr(hr);
		
		adminView.showAlert("HR added successfully!");
	}

	public void addReceptionist(String name, String password) {
		db = InterviewDatabase.getInstance();
		Receptionist receptionist = new Receptionist.Builder().id(db.uniqueId().getReceptionistId()).name("Please update the name!").email(name).password(password).build();
		db.uniqueId().incrementReceptionistid();
		db.saveUniqueId();
		db.addReceptionist(receptionist);
		adminView.showAlert("Receptionist added successfully!");
	}

	public void updateAdmin(String name, String password, String phoneNo, String email) {
		Admin admin = InterviewDatabase.getInstance().getAdmin();
		admin.setEmailId(email);
		admin.setPassword(password);
		admin.setName(name);
		admin.setPhoneNo(phoneNo);
		adminView.showAlert("Admin details updated successfully!");
	}

	public Admin getAdmin() {
		return InterviewDatabase.getInstance().getAdmin();
	}

	public void removeHr(long id) {
		db.removeHr(id);
	}
	
	public void removeReceptionist(long id) {
		db.removeReceptionist(id);
	}
}
