package com.university.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.dto.Application;
import com.university.service.ApplyApplication;

@WebServlet("/application")
public class ApplicationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Application a = new Application();
		a.setFullName(req.getParameter("fullName"));
		Date d;
		java.sql.Date sqlDate = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dob"));
			sqlDate = new java.sql.Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		a.setDob(sqlDate);
		a.setHighestQualification(req.getParameter("highestQualification"));
		a.setMarksObtained(Double.parseDouble(req.getParameter("marksObtained")));
		a.setEmailId(req.getParameter("emailId"));
		a.setScheduledProgramId(req.getParameter("program"));
		ApplyApplication app = new ApplyApplication();
		boolean state = app.addAppication(a);
		long appId = 0;
		if (state == true) {
			appId = app.generatedId(a.getEmailId());
			req.getRequestDispatcher("app_id.jsp").include(req, resp);
		}else {
			req.getRequestDispatcher("already_reg.jsp").include(req, resp);
		}
	}
}
