package com.university.dao;

import java.util.Date;
import java.util.List;

import com.university.dto.Application;
import com.university.dto.Program;
import com.university.dto.ScheduledProgram;
import com.university.dto.User;

public interface UniversityDAO {
	public User login(String username, String password, String role);
	public boolean addProgram(Program prog);
	public boolean updateProgram(Program prog);
	public boolean deleteProgram(String programName);
	public List<Program> listAllPrograms();
	public boolean createScheduledProgram(ScheduledProgram schPro);
	public boolean updateScheduledProgram(ScheduledProgram schPro);
	public boolean deleteScheduledProgram(String schProId);
	public List<ScheduledProgram> listAllScheduledPrograms();
	public boolean applyApplication(Application app);
	public boolean deleteApplication(long id);
	public boolean updateApplication(Application app);
	public List<Application> listAllApplications();
	public long getApplicationId(String email);
	public boolean getApplicationStatus(long id, String dob);
	public Application getApplication(long id);
	public boolean checkApplication(String email, String dob);	
}
