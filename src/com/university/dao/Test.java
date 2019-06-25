package com.university.dao;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.university.dto.Application;
import com.university.dto.Program;
import com.university.dto.ScheduledProgram;
import com.university.service.ApplyApplication;
import com.university.service.ProgramService;

public class Test {
	public static void main(String[] args) {
		UniversityDAO u = new UniversityDAOImpl();
//		System.out.println(u.login("admin", "admin123", "admin"));
		
//		System.out.println(u.updateProgram(new Program("aseddsdf", "qqqqqqqqqq", "dsfsdf", 333, "sdfsdf")));
		
//		List list = u.listAllPrograms();
//		for (Object object : list) {
//			System.out.println((Program)object);
//		}
		
//		System.out.println(u.deleteProgram("Civil"));
		
//		Application app = new Application();
//		app.setFullName("Manoj");
//		Date d;
//		try {
//			d = new SimpleDateFormat("MM-dd-yyyy").parse("03-16-1995");
//			java.sql.Date sqlDate = new java.sql.Date(d.getTime());
//			app.setDob(sqlDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		ApplyApplication a = new ApplyApplication();
//		System.out.println( a.addAppication(app) );
		
//		boolean s = u.createScheduledProgram(new ScheduledProgram(132, "Electrical", "bang", new java.sql.Date(2019, 5, 16), new java.sql.Date(2019, 6, 16), 3));
//		System.out.println(s);
		
//		boolean s = u.updateScheduledProgram(new ScheduledProgram("132", "Electrical", "Bengaluru", new java.sql.Date(2019, 5, 16), new java.sql.Date(2019, 6, 16), 3));
//		System.out.println(s);
		
//		System.out.println(u.deleteScheduledProgram("132"));
		
//		System.out.println(u.deleteApplication(1));
		
//		System.out.println(u.updateApplication(new Application(2, "Kumar", null, null, 66, "manu@gmail.com", "ee12", null, null)));
		
//		for (Iterator iterator = u.listAllApplications().iterator(); iterator.hasNext();) {
//			Application type = (Application) iterator.next();
//			System.out.println(type);
//		}
		
		System.out.println(new ApplyApplication().applicationStatus(1, "1995-3-16"));
//		System.out.println(u.getApplicationStatus(11,"1995-03-16"));
		
		ProgramService p = new ProgramService();
		List<Program> pro = p.getPrograms();
		for (Program program : pro) {
			
		}
	}
}
