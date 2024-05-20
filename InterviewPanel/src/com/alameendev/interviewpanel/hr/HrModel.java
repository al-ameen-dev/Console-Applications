package com.alameendev.interviewpanel.hr;

import java.util.Queue;

import com.alameendev.interviewpanel.db.DB_LABELS;
import com.alameendev.interviewpanel.db.InterviewDatabase;
import com.alameendev.interviewpanel.model.Candidate;

class HrModel {

	private HrView hrView;
	private InterviewDatabase db;

	HrModel(HrView hrView) {
		db = InterviewDatabase.getInstance();
		this.hrView = hrView;
		if(db.retrieveHrQueue() != null) {
			db.initDb(DB_LABELS.HRQUEUE);
		}
		if(db.retrieveInterviewStatus() != null) {
			db.initDb(DB_LABELS.INTERVIEWSTATUS);
		}
	}

	public void initiateInterview() {
		if (!db.getInterviewStatusForHr()) {
			if (db.hrQueue().size() != 0) {
				hrView.showAlert("Interview Started");
				db.setStatusOfInterview(true,db.getCurrentHrId());
				hrView.showAlert("The first candidate Id was '"
						+ db.hrQueue().peek().getId() + "'   " + "Name:"
						+ db.hrQueue().peek().getName());
			} else {
				hrView.showAlert("Cant start the interview because no one is in the waiting list!");

			}
		} else {
			hrView.showAlert("Interview is Already Started!");
		}
	}

	public void removeCompletedCandidate() {
		if (db.hrQueue().size() == 0) {
			hrView.showAlert("Nobody in waiting list!");
			return;
		}
		if(!db.getInterviewStatusForHr()) {
			hrView.showAlert("Interview not started yet");
			return;
		}
		Candidate candidate = db.removeCompletedCandidateFromTheHrQueue();
		db.saveHrQueue();
		db.addCandidateToTheCompletedQueue(candidate);
		Candidate nextCandidate = db.getNextCandidateFromTheHrQueue();
		hrView.showAlert("The candiate with ID '" + candidate.getId() + "' '" + candidate.getName()
				+ "' has completed the interview");
		if (nextCandidate != null) {
			hrView.showAlert(
					"Next candidate going in is id '" + nextCandidate.getId() + "' '" + nextCandidate.getName());
		} else {
			db.setStatusOfInterview(false,db.getCurrentHrId());
		}

	}

	public void interviewStatus() {
		if (db.hrQueue().size() != 0 && db.getInterviewStatusForHr()) {
			boolean first = true;

			for (Candidate cnd : InterviewDatabase.getInstance().hrQueue()) {
				if (first) {
					String str = String.format("Id : %-3d - Name : %-3s - email : %-3ss (ongoing interview)%n", cnd.getId(),
							cnd.getName(), cnd.getEmail());
					hrView.showAlert(str);
					first = false;
				} else {
					String str = String.format("Id : %-3d - Name : %-3s - email : %-3s (waiting for interview)%n",cnd.getId(),
							cnd.getName(), cnd.getEmail());
					hrView.showAlert(str);
				}
			}
		} else {
			hrView.showAlert("Interview Not Started yet");
		}
	}

	public boolean getInterviewStatus() {
		return db.getInterviewStatusForHr();
	}

	public Queue<Candidate> getQueue() {
		return db.hrQueue();
	}

}
