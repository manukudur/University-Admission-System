package com.university.service;

import java.util.List;

import com.university.dao.UniversityDAO;
import com.university.dao.UniversityDAOImpl;
import com.university.dto.ScheduledProgram;

public class SchPrograms {
	UniversityDAO u = new UniversityDAOImpl();
	
	public List<ScheduledProgram> getNames() {
		return u.listAllScheduledPrograms();
	}
	public boolean createScheduledProgram(ScheduledProgram schPro) {
		return u.createScheduledProgram(schPro);
	}
	public List<ScheduledProgram> getAllSchPros() {
		return u.listAllScheduledPrograms();
	}
	public boolean updateSchPros(ScheduledProgram schPro) {
		return u.updateScheduledProgram(schPro);
	}
	public boolean deleteSchPros(String schProId) {
		return u.deleteScheduledProgram(schProId);
	}
}
