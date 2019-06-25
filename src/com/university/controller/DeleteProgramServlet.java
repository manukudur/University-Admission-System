package com.university.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.dto.Program;
import com.university.service.ProgramService;

@WebServlet("/DeletePro")
public class DeleteProgramServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProgramService ps = new ProgramService();
		PrintWriter out = response.getWriter();
		String s = request.getParameter("proName");
		if (ps.deleteProgram(s)) {
			request.getRequestDispatcher("delete_program.jsp").forward(request, response);			
		} else {
			out.println("<div class=\"alert alert-danger\" role=\"alert\">\r\n" + 
					" "+s+" is in Use, You can't Delete!\r\n" + 
					"</div>");
			request.getRequestDispatcher("delete_program.jsp").include(request, response);
		}
	}

}
