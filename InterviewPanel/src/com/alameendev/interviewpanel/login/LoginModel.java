package com.alameendev.interviewpanel.login;

import java.util.List;

import com.alameendev.interviewpanel.admin.AdminView;
import com.alameendev.interviewpanel.db.DB_LABELS;
import com.alameendev.interviewpanel.db.InterviewDatabase;
import com.alameendev.interviewpanel.hr.HrView;
import com.alameendev.interviewpanel.model.Hr;
import com.alameendev.interviewpanel.model.Admin;
import com.alameendev.interviewpanel.model.Receptionist;
import com.alameendev.interviewpanel.receptionist.ReceptionistView;

class LoginModel {

	private LoginView loginView;
	private AdminView adminView;
	private HrView hrView;
	private ReceptionistView receptionistView;
	private InterviewDatabase db;

	LoginModel(LoginView loginView) {
		this.loginView = loginView;
		hrView = new HrView();
		adminView = new AdminView();
		receptionistView = new ReceptionistView();
		db = InterviewDatabase.getInstance();
		if(db.retrieveAdmin() != null) {
			db.initDb(DB_LABELS.ADMIN);
		}else {
			Admin admin = new Admin.Builder().id(db.uniqueId().getAdminId()).name("zsgs")
					.phoneNo("Please update the phone no!").password("admin").email("Please update the email!")
					.phoneNo("Please Update the phone no!").build();
			db.uniqueId().incrementAdminId();
			db.createAdmin(admin);
		}
		if(db.retrieveHr() != null) {
			db.initDb(DB_LABELS.HR);
		}
		if(db.retrieveReceptionist() != null) {
			db.initDb(DB_LABELS.RECEPTIONIST);
		}
	}

	public void validateAdmin(String email, String password) {
		Admin admin = db.getAdmin();
		if (admin.getName().equals(email)) {
			if (admin.getPassword().equals(password)) {
				adminView.showMenu();
			} else {
				loginView.showAlert("Invalid Password!");
				LoginView.getInstance().init();
			}
		} else{
			loginView.showAlert("Invalid Username!");
			LoginView.getInstance().init();
		}
	}
	
	public void validateHr(String email,String password) {
		List<Hr> hrList = db.getHr();
		for(Hr hr:hrList) {
			if(hr.getHrEmailId().equals(email)) {
				if(hr.getHrPassword().equals(password)) {
					db.setCurrentHr(hr.getHrId());
					hrView.showMenu();
				}else {
					loginView.showAlert("Password is Invalid!");
				}
			}else if(hr.getHrPassword().equals(password)){
				loginView.showAlert("Email is invalid!");
			}
		}
		loginView.showAlert("Invalid Credentials!");
	}
	
	public void validateReceptionist(String email,String password) {
		List<Receptionist> receptionistList = db.getReceptionistList();
		for(Receptionist rc:receptionistList) {
			if(rc.getEmailId().equals(email)) {
				if(rc.getPassword().equals(password)) {
					db.setCurrentReceptionist(rc.getId());
					receptionistView.showMenu();
					return;
				}else {
					loginView.showAlert("Password is Invalid!");
				}
			}else if(rc.getPassword().equals(password)){
				loginView.showAlert("Email is invalid!");
			}
		}
		loginView.showAlert("Invalid Credentials!");
	}

}
