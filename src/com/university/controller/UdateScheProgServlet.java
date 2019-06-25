package com.university.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.dto.ScheduledProgram;
import com.university.service.SchPrograms;

@WebServlet("/UdateScheProg")
public class UdateScheProgServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScheduledProgram p = new ScheduledProgram();
		p.setScheduledProgramId(request.getParameter("proId"));
		p.setProgramName(request.getParameter("proName"));
		p.setLocation(request.getParameter("loc"));
		java.sql.Date sqlDate1 = null;
		java.sql.Date sqlDate2 = null;
		try {
			java.util.Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("sdate"));
			java.util.Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("edate"));
			sqlDate1 = new java.sql.Date(d1.getTime());
			sqlDate2 = new java.sql.Date(d2.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		p.setStartDate(sqlDate1);
		p.setEndDate(sqlDate2);
		p.setSessionsPerWeek(Integer.parseInt(request.getParameter("spw")));
		SchPrograms ps = new SchPrograms();
		if (ps.updateSchPros(p)) {
			request.getRequestDispatcher("UdateScheduleProgram.jsp").forward(request, response);			
		}
	}

}
