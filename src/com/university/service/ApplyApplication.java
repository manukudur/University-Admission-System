package com.university.service;

import java.util.List;

import com.university.dao.UniversityDAO;
import com.university.dao.UniversityDAOImpl;
import com.university.dto.Application;

public class ApplyApplication {
	UniversityDAO u = new UniversityDAOImpl();
	
	public boolean addAppication(Application app) {
		return u.applyApplication(app);
	}
	public long generatedId(String email) {
		return u.getApplicationId(email);
	}
	public boolean generatedId(String email, String dob) {
		return u.checkApplication(email, dob);
	}
	public boolean appState(long id, String dob) {
		return u.getApplicationStatus(id, dob);
	}
	public Application applicationStatus(long id, String dob) {
		if (u.getApplicationStatus(id, dob)) {
			return u.getApplication(id);
		}
		return null;
	}
	public List<Application> appList() {
		return u.listAllApplications();
	}
}
