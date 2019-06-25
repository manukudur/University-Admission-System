package com.university.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.dto.Program;
import com.university.service.ProgramService;

@WebServlet("/UdateProg")
public class UdateProgramServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Program p = new Program();
		p.setProgramName(request.getParameter("proName"));
		p.setDescription(request.getParameter("desc"));
		p.setApplicantEligibility(request.getParameter("appEle"));
		p.setDurationInMonths(Integer.parseInt(request.getParameter("durInMon")));
		p.setDegreeCertificateOffered(request.getParameter("degCert"));
		p.setImgUrl(request.getParameter("imgUrl"));
		ProgramService ps = new ProgramService();
		if (ps.updateProgram(p)) {
			request.getRequestDispatcher("update_program.jsp").forward(request, response);			
		}
	}

}
