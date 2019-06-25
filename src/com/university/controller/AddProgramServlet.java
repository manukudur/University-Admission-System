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

@WebServlet("/addPro")
public class AddProgramServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Program p = new Program();
		p.setProgramName(req.getParameter("pname"));
		p.setDescription(req.getParameter("pdesc"));
		p.setApplicantEligibility(req.getParameter("appele"));
		p.setDurationInMonths(Integer.parseInt(req.getParameter("dinmonth")));
		p.setDegreeCertificateOffered(req.getParameter("dco"));
		p.setImgUrl(req.getParameter("imgurl"));
		ProgramService ps = new ProgramService();
		boolean state = ps.addProgram(p);
		if (state) {
			out.println("<div class=\"alert alert-success\" role=\"alert\">\r\n" + 
					" Program Added Successfully\r\n" + 
					"</div>");
			req.getRequestDispatcher("list_all_programs.jsp").include(req, resp);;
		}else {
			out.println("<div class=\"alert alert-danger\" role=\"alert\">\r\n" + 
					"  Program already exists\r\n" + 
					"</div>");
			req.getRequestDispatcher("add_program.jsp").include(req, resp);;
		}
	}

}
