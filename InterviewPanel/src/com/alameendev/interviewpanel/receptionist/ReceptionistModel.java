package com.alameendev.interviewpanel.receptionist;

import java.util.List;

import com.alameendev.interviewpanel.db.DB_LABELS;
import com.alameendev.interviewpanel.db.InterviewDatabase;
import com.alameendev.interviewpanel.model.Candidate;
import com.alameendev.interviewpanel.model.Hr;
import com.alameendev.interviewpanel.model.Receptionist;

class ReceptionistModel {

	private ReceptionistView receptionistview;
	private InterviewDatabase db;

	public ReceptionistModel(ReceptionistView receptionistView) {
		db = InterviewDatabase.getInstance();
		this.receptionistview = receptionistView;
		if (db.retrieveHr() != null) {
			db.initDb(DB_LABELS.HR);
		}
		if (db.retrieveHrQueue() != null) {
			db.initDb(DB_LABELS.HRQUEUE);
		}
	}

	public void updateReceptionist(String name, String password, String phoneNo, String email, String address) {
		Receptionist receptionist = db.getReceptionist();
		receptionist.setAddress(address);
		receptionist.setPassword(password);
		receptionist.setName(name);
		receptionist.setEmailId(email);
		receptionist.setPhoneNo(phoneNo);
	}

	public Receptionist getReceptionstionistDetails() {
		return db.getReceptionist();
	}

	public void addCandidate(long hrId, String name, String email, String phoneNo, String address,
			String qualification) {
		Candidate candidate = new Candidate.Builder().id(db.uniqueId().getCandidateId()).name(name).email(email)
				.phoneNo(phoneNo).address(address).qualification(qualification).build();
		if (!db.addCandidateToTheQueue(candidate, hrId)) {
			receptionistview.showAlert("Candidate with email id '" + email + "' already exist!");
			return;
		}
		db.uniqueId().incrementCandidateId();
		db.saveUniqueId();
		db.saveHrQueue();
		receptionistview.showAlert("Candidate added successfull!");
	}

	public List<Hr> getHr() {
		return db.getHr();
	}

}
