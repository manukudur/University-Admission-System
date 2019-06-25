package com.university.service;

import java.util.List;

import com.university.dao.UniversityDAOImpl;
import com.university.dto.Program;

public class ProgramService {
	public boolean addProgram(Program prog) {
		return new UniversityDAOImpl().addProgram(prog);
	}
	public List<Program> getPrograms() {
		return new UniversityDAOImpl().listAllPrograms();
	}
	public boolean updateProgram(Program prog) {
		return new UniversityDAOImpl().updateProgram(prog);
	}
	public boolean deleteProgram(String programName) {
		return new UniversityDAOImpl().deleteProgram(programName);
	}
	public List<Program> listAllPrograms() {
		return new UniversityDAOImpl().listAllPrograms();
	}
}
