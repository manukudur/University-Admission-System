package com.university.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.university.dto.User;
import com.university.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = new UserService().userLogin(req.getParameter("username"), req.getParameter("password"), req.getParameter("role"));
		if(u != null) {
			//Login Successful
			HttpSession session = req.getSession();
			if (u.getRole().equals("admin")) {
				session.setAttribute("admin", u);
				resp.sendRedirect("./admin");	
			}else if (u.getRole().equals("member")) {
				session.setAttribute("member", u);
				resp.sendRedirect("./member");
			}
		}else {
			//Login Failed
			resp.sendRedirect("./login.html");
		}
	}
}
