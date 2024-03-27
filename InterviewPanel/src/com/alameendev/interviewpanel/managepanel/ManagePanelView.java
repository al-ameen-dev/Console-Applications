package com.alameendev.interviewpanel.managepanel;

public class ManagePanelView {

	private ManagePanelModel managePanelModel;

	public ManagePanelView() {
		this.managePanelModel = new ManagePanelModel(this);
	}

//	public void startInterview() {
//		managePanelModel.startInterview();
//	}
//
//	public void endInterview() {
//		managePanelModel.removeCompletedCandidate();
//	}
//	
//	public void showInterviewStatus() {
//		managePanelModel.interviewStatus();
//	}

	public void showAlert(String alert) {
		System.out.println(alert);
	}

}
