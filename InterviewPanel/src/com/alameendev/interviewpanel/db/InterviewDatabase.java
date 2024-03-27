package com.alameendev.interviewpanel.db;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.alameendev.interviewpanel.model.Receptionist;
import com.alameendev.interviewpanel.model.UniqueId;
import com.alameendev.interviewpanel.serializer.JsonSerializer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.alameendev.interviewpanel.model.Admin;
import com.alameendev.interviewpanel.model.Candidate;
import com.alameendev.interviewpanel.model.Hr;

public class InterviewDatabase {

	private static InterviewDatabase interviewDatabase;

	private Admin admin;
	private UniqueId uniqueId;
	private long currentHr;
	private long currentReceptionist;
	private boolean isStarted = false;

	private List<Receptionist> receptionistList = new LinkedList<>();
	private List<Hr> hrList = new LinkedList<>();
	private Map<Long, Queue<Candidate>> hrQueue = new HashMap<>();
	private Map<Long, Boolean> interviewStatus = new HashMap<>();
	private List<Candidate> completedCandidates = new LinkedList<>();

	private final String UNIQUE_ID_FILE_NAME = "uniqueid.json";
	private final String ADMIN_FILE_NAME = "admin.json";
	private final String RECEPTIONIST_FILE_NAME = "receptionist.json";
	private final String HR_FILE_NAME = "hr.json";
	private final String HR_QUEUE_FILE_NAME = "hrqueue.json";
	private final String COMPLETED_CANDIDATE_FILE_NAME = "completedcandidates.json";
	private final String INTERVIEW_STATUS = "interviewstatus.json";

	private InterviewDatabase() {
		if (JsonSerializer.serialize().retrieveFromJsonSingleObj(UNIQUE_ID_FILE_NAME, UniqueId.class) != null) {
			uniqueId = JsonSerializer.serialize().retrieveFromJsonSingleObj(UNIQUE_ID_FILE_NAME, UniqueId.class);
		} else {
			uniqueId = UniqueId.id();
		}
	}

	public static InterviewDatabase getInstance() {
		if (interviewDatabase == null) {
			interviewDatabase = new InterviewDatabase();
		}
		return interviewDatabase;
	}

	// A helper method to retrive the data that stored in file by a DB_LABELS enum.
	public void initDb(DB_LABELS label) {
		switch (label) {
		case ADMIN:
			if (retrieveAdmin() != null) {
				this.admin = retrieveAdmin();
			}
			break;
		case HR:
			if (retrieveHr() != null) {
				this.hrList = retrieveHr();
			}
			break;
		case RECEPTIONIST:
			if (retrieveReceptionist() != null) {
				this.receptionistList = retrieveReceptionist();
			}
			break;
		case HRQUEUE:
			if (retrieveHrQueue() != null) {
				this.hrQueue = retrieveHrQueue();
			}
			break;
		case INTERVIEWSTATUS:
			if (retrieveInterviewStatus() != null) {
				this.interviewStatus = retrieveInterviewStatus();
			}
		case COMPLETEDCANDIDATES:
			if (retrieveCompletedCandidates() != null) {
				this.completedCandidates = retrieveCompletedCandidates();
			}
			break;
		default:
			break;
		}

	}

	// Helper function used to serialize the UniqueId object and write it to the
	// disk.
	public void saveUniqueId() {
		JsonSerializer.serialize().saveToJson(uniqueId, UNIQUE_ID_FILE_NAME);
	}

	// Helper function used to serialize the Library object and write it to the
	// disk.
	public void saveReceptionist() {
		JsonSerializer.serialize().saveToJson(receptionistList, RECEPTIONIST_FILE_NAME);
	}

	// Helper function used to serialize the Admin object and write it to the disk.
	public void saveAdmin() {
		JsonSerializer.serialize().saveToJson(admin, ADMIN_FILE_NAME);
	}

	// Helper function used to serialize the Book object and write it to the disk.
	public void saveHrQueue() {
		JsonSerializer.serialize().saveToJson(hrQueue, HR_QUEUE_FILE_NAME);
	}

	// Helper function used to serialize the IssuedBooks object and write it to the
	// disk.
	public void saveCompletedList() {
		JsonSerializer.serialize().saveToJson(completedCandidates, COMPLETED_CANDIDATE_FILE_NAME);
	}

	public void saveInterviewStatus() {
		JsonSerializer.serialize().saveToJson(interviewStatus, INTERVIEW_STATUS);
	}

	// Helper function used to serialize the Customer object and write it to the
	// disk.
	public void saveHr() {
		JsonSerializer.serialize().saveToJson(hrList, HR_FILE_NAME);
	}

	// Helper function to retrieve the UniqueId object json from the file.
	public UniqueId retrieveUniqueId() {
		return JsonSerializer.serialize().retrieveFromJsonSingleObj(UNIQUE_ID_FILE_NAME, UniqueId.class);
	}

	// Helper function to retrieve the Admin object json from the file.
	public Admin retrieveAdmin() {
		return JsonSerializer.serialize().retrieveFromJsonSingleObj(ADMIN_FILE_NAME, Admin.class);
	}

	// Helper function to retrieve the Library object json from the file.
	public List<Hr> retrieveHr() {
		return JsonSerializer.serialize().retrieveFromJson(HR_FILE_NAME, new TypeReference<List<Hr>>() {
		});
	}

	public Map<Long, Boolean> retrieveInterviewStatus() {
		return JsonSerializer.serialize().retrieveFromJson(INTERVIEW_STATUS, new TypeReference<Map<Long, Boolean>>() {
		});
	}

	public List<Receptionist> retrieveReceptionist() {
		return JsonSerializer.serialize().retrieveFromJson(RECEPTIONIST_FILE_NAME,
				new TypeReference<List<Receptionist>>() {
				});
	}

	private List<Candidate> retrieveCompletedCandidates() {
		return JsonSerializer.serialize().retrieveFromJson(COMPLETED_CANDIDATE_FILE_NAME,
				new TypeReference<List<Candidate>>() {
				});
	}

	// Helper function to retrieve the Book object json form the file.
	public Map<Long, Queue<Candidate>> retrieveHrQueue() {
		return JsonSerializer.serialize().retrieveFromJson(HR_QUEUE_FILE_NAME,
				new TypeReference<Map<Long, Queue<Candidate>>>() {
				});
	}

	public UniqueId uniqueId() {
		return uniqueId;
	}

	// Returns the current id of the HR.
	public long getCurrentHrId() {
		return currentHr;
	}

	public void setCurrentHr(long currentHr) {
		this.currentHr = currentHr;
	}

	public void setCurrentReceptionist(long currentReceptionist) {
		this.currentReceptionist = currentReceptionist;
	}

	public long getCurrentReceptionist() {
		return currentReceptionist;
	}

	public Receptionist getReceptionist() {
		for (Receptionist receptionist : receptionistList) {
			if (receptionist.getId() == currentReceptionist) {
				return receptionist;
			}
		}
		return null;
	}

	// Returns the Queue for the current HR.
	public Queue<Candidate> hrQueue() {
		return hrQueue.get(currentHr);
	}

	// Returns the Interview Status for the current HR.
	public boolean getInterviewStatusForHr() {
		return interviewStatus.get(currentHr);
	}

	// Returns the Status of the interview for the current HR.
	public void setStatusOfInterview(boolean status, long hrId) {
		if (!interviewStatus.containsKey(hrId)) {
			interviewStatus.put(hrId, status);
		} else {
			interviewStatus.put(hrId, status);
		}
		saveInterviewStatus();
	}

	// Returns the first candidate from the current HR Queue also removes fromt the
	// Queue.
	public Candidate removeCompletedCandidateFromTheHrQueue() {
		return hrQueue.get(currentHr).poll();
	}

	// Returns the second candidate from the Current Hr Queue.
	public Candidate getNextCandidateFromTheHrQueue() {
		return hrQueue.get(currentHr).peek();
	}

	// ----------------------------------------//
//	public boolean getStatusOfInterview() {
//		return isStarted;
//	}
//
//	public void setStatusOfInterview(boolean status) {
//		isStarted = status;
//	}

	public Admin getAdmin() {
		return admin;
	}

	public List<Receptionist> getReceptionistList() {
		return receptionistList;
	}

	public void addHr(Hr hr) {
		hrList.add(hr);
		saveHr();

	}

	public void addReceptionist(Receptionist receptionist) {
		receptionistList.add(receptionist);
		saveReceptionist();
	}

	public void createAdmin(Admin admin) {
		if (this.admin == null) {
			this.admin = admin;
		}
		saveAdmin();
	}

	public boolean addCandidateToTheQueue(Candidate candidate, long hrId) {
		if (!hrQueue.containsKey(hrId)) {
			hrQueue.put(hrId, new LinkedList<>());
		}

		boolean isPresent = false;
		for (Candidate cnd : hrQueue.get(hrId)) {
			if (cnd.getEmail().equals(candidate.getEmail())) {
				isPresent = true;
			}
		}
		if (isPresent) {
			return isPresent;
		} else {
			return hrQueue.get(hrId).add(candidate);
		}
	}
	
	public void addCandidateToTheCompletedQueue(Candidate candidate) {
		completedCandidates.add(candidate);
		saveCompletedList();
	}

	public List<Hr> getHr() {
		return hrList;
	}

	public void removeHr(long id) {
		hrQueue.remove(id);
		hrList.removeIf(hr->hr.getHrId() == id);
		saveHr();
		saveHrQueue();
	}
	
	public void removeReceptionist(long id) {
		receptionistList.removeIf(recep ->recep.getId()==id);
		saveReceptionist();
	}

}
