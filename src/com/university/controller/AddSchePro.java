package com.university.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.dto.ScheduledProgram;
import com.university.service.SchPrograms;

@WebServlet("/AddSchePro")
public class AddSchePro extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		ScheduledProgram sp = new ScheduledProgram();
		sp.setScheduledProgramId(req.getParameter("scheduledProgramId"));
		sp.setProgramName(req.getParameter("pname"));
		sp.setLocation(req.getParameter("location"));
		java.sql.Date sqlDate1 = null;
		java.sql.Date sqlDate2 = null;
		try {
			java.util.Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("sdate"));
			java.util.Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("edate"));
			sqlDate1 = new java.sql.Date(d1.getTime());
			sqlDate2 = new java.sql.Date(d2.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sp.setStartDate(sqlDate1);
		sp.setEndDate(sqlDate2);
		sp.setSessionsPerWeek(Integer.parseInt(req.getParameter("spw")));
		SchPrograms app = new SchPrograms();
		boolean state = app.createScheduledProgram(sp);
		if (state) {
			out.println("<div class=\"alert alert-success\" role=\"alert\">\r\n" + 
					"  Scheduled Program Added Successfully\r\n" + 
					"</div>");
			req.getRequestDispatcher("ListAllScheduleProgram.jsp").include(req, resp);
		}else {
			out.println("<div class=\"alert alert-danger\" role=\"alert\">\r\n" + 
					"  Enter Unique Scheduled Program ID\r\n" + 
					"</div>");
			req.getRequestDispatcher("ScheduleProgram.jsp").include(req, resp);
		}
	}

}
