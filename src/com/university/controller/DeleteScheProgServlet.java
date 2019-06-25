package com.university.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.service.SchPrograms;

@WebServlet("/DeleteScheProg")
public class DeleteScheProgServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("proId");
		PrintWriter out = response.getWriter();
		SchPrograms ps = new SchPrograms();
		if (ps.deleteSchPros(s)) {
			request.getRequestDispatcher("DeleteScheduleProgram.jsp").forward(request, response);			
		} else {
			out.println("<div class=\"alert alert-danger\" role=\"alert\">\r\n" + 
					"  "+s+" ID is in Use, You can't Delete!\r\n" + 
					"</div>");
			request.getRequestDispatcher("DeleteScheduleProgram.jsp").include(request, response);
		}
	}

}
