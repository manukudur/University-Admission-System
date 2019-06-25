package com.university.service;

import com.university.dao.UniversityDAO;
import com.university.dao.UniversityDAOImpl;
import com.university.dto.User;

public class UserService {
	public User userLogin(String username, String password, String role) {
		UniversityDAO dao = new UniversityDAOImpl();
		return dao.login(username, password, role);
	}
}
