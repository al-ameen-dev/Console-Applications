package com.alameendev.interviewpanel;

import com.alameendev.interviewpanel.login.LoginView;

public class InterviewPanel {
	
	private static InterviewPanel interviewPanel;
	
	private String appName = "Interview Panel";
	
	private String appVersion = "0.0.1";
	
	private InterviewPanel() {
		
	}
	
	public static InterviewPanel getInstance() {
		if(interviewPanel == null) {
			return new InterviewPanel();
		}
		return interviewPanel;
	}
	
	private void create() {
		LoginView loginView = new LoginView();
		loginView.init();
	}
	
	public String getAppname() {
		return appName;
	}
	
	public String getAppVersion() {
		return appVersion;
	}
	
	public static void main(String[] args) {
		InterviewPanel.getInstance().create();
	}
}
