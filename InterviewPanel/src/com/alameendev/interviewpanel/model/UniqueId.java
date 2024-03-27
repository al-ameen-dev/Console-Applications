package com.alameendev.interviewpanel.model;

import java.io.Serializable;

public class UniqueId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long adminId;
	private long candidateId;
	private long hrId;
	private long receptionistId;

	private static UniqueId uniqueId;

	public static UniqueId id() {
		if (uniqueId == null) {
			uniqueId = new UniqueId();
		}
		return uniqueId;
	}

	private UniqueId() {
		adminId = 1;
		candidateId = 1;
		hrId = 1;
		receptionistId = 1;
	}

	public void reset() {
		adminId = 1;
		candidateId = 1;
		hrId = 1;
		receptionistId = 1;
	}

	public long getAdminId() {
		return adminId;
	}
	
	public void incrementAdminId() {
		adminId++;
	}

	public long getCandidateId() {
		return candidateId;
	}
	
	public void incrementCandidateId() {
		candidateId++;
	}

	public long getHrId() {
		return hrId;
	}

	public void incrementHrId() {
		hrId++;
	}
	public long getReceptionistId() {
		return receptionistId;
	}
	
	public void incrementReceptionistid() {
		receptionistId++;
	}

}
