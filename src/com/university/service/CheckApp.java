package com.university.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckApp")
public class CheckApp extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (new ApplyApplication().appState(Long.parseLong(request.getParameter("appId")), request.getParameter("dob"))) {
			request.setAttribute("app", new ApplyApplication().applicationStatus(Long.parseLong(request.getParameter("appId")), request.getParameter("dob")));
			request.getRequestDispatcher("your_status.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("something_went_wrong.jsp").forward(request, response);			
		}
	}
}
