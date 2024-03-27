package com.alameendev.interviewpanel.hr;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.alameendev.interviewpanel.db.InterviewDatabase;
import com.alameendev.interviewpanel.login.LoginView;
import com.alameendev.interviewpanel.model.Candidate;

public class HrView {

	private HrModel hrModel;

	public HrView() {
		this.hrModel = new HrModel(this);
	}

	public void showMenu() {

		Scanner scanner = new Scanner(System.in);
		exit: while (true) {
			System.out.printf("%nMenu : 1 %-10s| 2 %-10s| 3 %-10s| 4 %-10s| 6 %-10s| 9 %-10s%n",
					"Show Candidates", "Start Interview", "Interview next candidate", "Show Status", "Logout", "Exit");
			try {
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					getAllCandidates();
					break;
				case 2:
					startInterview();
					break;
				case 3:
					interviewNextCandidate();
					break;
				case 4:
					showInterviewStatus();
					break;
				case 6:
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

	public void startInterview() {
		hrModel.initiateInterview();
	}

	private void getAllCandidates() {
		showCandidateTable(hrModel.getQueue());
	}

	private void interviewNextCandidate() {
		hrModel.removeCompletedCandidate();
	}

	private void showInterviewStatus() {
		hrModel.interviewStatus();
	}

	public void showCandidateTable(Queue<Candidate> candidateList) {
		if (candidateList.size() == 0) {
			showAlert("Currently there is no candidates to show!.\n");
		} else {
			System.out.printf("%n%-15s|%-15s|%-15s|%-15s|%-15s|%-15s%n", "Candidate Id", "Candidate Name", "Email Id",
					"Phone", "Address", "Qualification");
			for (Candidate candidate : candidateList) {
				System.out.printf("%n%-15d|%-15s|%-15s|%-15s|%-15s|%-15b%n", candidate.getId(), candidate.getName(),
						candidate.getEmail(), candidate.getPhoneNo(), candidate.getAddress(),
						candidate.getQualification());
			}
		}
	}

	public void showAlert(String alert) {
		System.err.println(alert);

	}
}
