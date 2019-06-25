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

@WebServlet("/getapplicationid")
public class GetApplicationId extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {new ApplyApplication().generatedId(req.getParameter("emailId"));
			req.getRequestDispatcher("app_id.jsp").include(req, resp);
	}
}
