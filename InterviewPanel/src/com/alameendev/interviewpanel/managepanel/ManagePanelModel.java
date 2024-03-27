package com.alameendev.interviewpanel.managepanel;

import com.alameendev.interviewpanel.db.InterviewDatabase;
import com.alameendev.interviewpanel.model.Candidate;

public class ManagePanelModel {

	private ManagePanelView managePanelView;

	ManagePanelModel(ManagePanelView managePanelView) {
		this.managePanelView = managePanelView;
	}

//	public void startInterview() {
//		if (!InterviewDatabase.getInstance().getStatusOfInterview()) {
//			if (InterviewDatabase.getInstance().getInterviewQueue().size() != 0) {
//				managePanelView.showAlert("Interview Started");
//				InterviewDatabase.getInstance().setStatusOfInterview(true);
//				managePanelView.showAlert("The first candidate Id was '"
//						+ InterviewDatabase.getInstance().getInterviewQueue().peek().getId() + "' " + "Name:"
//						+ InterviewDatabase.getInstance().getInterviewQueue().peek().getName());
//			} else {
//				managePanelView.showAlert("Cant start the interview because no one is in the waiting list!");
//			}
//		} else {
//			managePanelView.showAlert("Interview is Already Started!");
//		}
//	}

//	public void interviewStatus() {
//		if (InterviewDatabase.getInstance().getInterviewQueue().size() != 0 && InterviewDatabase.getInstance().getStatusOfInterview()) {
//			boolean first = true;
//
//			for (Candidate cnd : InterviewDatabase.getInstance().getInterviewQueue()) {
//				if (first) {
//					System.out.printf("Id : %-3d - Name : %-3s - email : %-3ss (ongoing interview)%n", cnd.getId(), cnd.getName(),cnd.getEmail());
//					first = false;
//				} else {
//					System.out.printf("Id : %-3d - Name : %-3s - email : %-3s (waiting for interview)%n", cnd.getId(), cnd.getName(),cnd.getEmail());
//				}
//			}
//		}else {
//			managePanelView.showAlert("Interview Not Started yet");
//		}
//	}
//
//	public void removeCompletedCandidate() {
//		if (InterviewDatabase.getInstance().getInterviewQueue().size() == 0) {
//			managePanelView.showAlert("Nobody in waiting list!");
//			return;
//		}
//		Candidate candidate = InterviewDatabase.getInstance().removeCompletedCandidateFromTheQueue();
//		Candidate nextCandidate = InterviewDatabase.getInstance().getNextCandidateFromTheQueue();
//		managePanelView.showAlert("The candiate with ID '" + candidate.getId() + "' '" + candidate.getName()
//				+ "' has completed the interview");
//		if (nextCandidate != null) {
//			managePanelView.showAlert(
//					"Next candidate going in is id '" + nextCandidate.getId() + "' '" + nextCandidate.getName());
//		}else {
//			InterviewDatabase.getInstance().setStatusOfInterview(false);
//		}
//
//	}
}
