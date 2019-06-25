package com.university.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.university.dto.Application;
import com.university.dto.Program;
import com.university.dto.ScheduledProgram;
import com.university.dto.User;
import com.university.utils.DBUtils;

public class UniversityDAOImpl implements UniversityDAO {

	@Override
	public User login(String username, String password, String role) {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
//			FileReader fr = new FileReader(DBUtils.PROPERTY_FILE_PATH);
//			Properties prop = new Properties();
//			prop.load(fr);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("select * from users where username = ? and password = ? and role = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, role);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getString("role"));
				user = u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	@Override
	public boolean addProgram(Program prog) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean state = false;
		int count = 0;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("insert into programs_offered values (?,?,?,?,?,?)");
			pstmt.setString(1, prog.getProgramName());
			pstmt.setString(2, prog.getDescription());
			pstmt.setString(3, prog.getApplicantEligibility());
			pstmt.setInt(4, prog.getDurationInMonths());
			pstmt.setString(5, prog.getDegreeCertificateOffered());
			pstmt.setString(6, prog.getImgUrl());
			count = pstmt.executeUpdate();
			if (count >= 0) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public boolean updateProgram(Program prog) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean state = false;
		int result = 0;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("update programs_offered set description = ?, applicant_eligibility = ?, duration_in_months = ?, degree_certificate_offered = ?, img_url = ? where program_name = ?");
			pstmt.setString(1, prog.getDescription());
			pstmt.setString(2, prog.getApplicantEligibility());
			pstmt.setInt(3, prog.getDurationInMonths());
			pstmt.setString(4, prog.getDegreeCertificateOffered());
			pstmt.setString(5, prog.getImgUrl());
			pstmt.setString(6, prog.getProgramName());
			result = pstmt.executeUpdate();
			if (result >= 0) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}
	
	@Override
	public boolean deleteProgram(String programName) {
		boolean state = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("delete from programs_offered where program_name = ?");
			pstmt.setString(1, programName);
			int count = pstmt.executeUpdate();
			if (count >= 1) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public List<Program> listAllPrograms() {
		Connection con = null;
		CallableStatement cal = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean state = false;
		List<Program> list = new ArrayList<Program>();
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			cal = con.prepareCall("call getAllProgramsName()");
			state = cal.execute();
			if (state) {
				rs = cal.getResultSet();
				while (rs.next()) {
					Program p = new Program();
					p.setProgramName(rs.getString(1));
					p.setDescription(rs.getString(2));
					p.setApplicantEligibility(rs.getString(3));
					p.setDurationInMonths(rs.getInt(4));
					p.setDegreeCertificateOffered(rs.getString(5));
					p.setImgUrl(rs.getString(6));
					list.add(p);
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public boolean createScheduledProgram(ScheduledProgram schPro) {
		boolean state = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("insert into programs_scheduled values (?,?,?,?,?,?)");
			pstmt.setString(1, schPro.getScheduledProgramId());
			pstmt.setString(2, schPro.getProgramName());
			pstmt.setString(3, schPro.getLocation());
			pstmt.setDate(4, (java.sql.Date) schPro.getStartDate());
			pstmt.setDate(5, (java.sql.Date) schPro.getEndDate());
			pstmt.setInt(6, schPro.getSessionsPerWeek());
			count = pstmt.executeUpdate();
			if (count >= 0) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public boolean updateScheduledProgram(ScheduledProgram schPro) {
		boolean state = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("update programs_scheduled set program_name = ?, location = ?, start_date = ?, end_date = ?, sessions_per_week = ? where scheduled_program_id  = ?");
			pstmt.setString(1, schPro.getProgramName());
			pstmt.setString(2, schPro.getLocation());
			pstmt.setDate(3, (java.sql.Date) schPro.getStartDate());
			pstmt.setDate(4, (java.sql.Date) schPro.getEndDate());
			pstmt.setInt(5, schPro.getSessionsPerWeek());
			pstmt.setString(6, schPro.getScheduledProgramId());
			count = pstmt.executeUpdate();
			if (count >= 0) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}
	
	@Override
	public boolean deleteScheduledProgram(String schProId) {
		boolean state = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("delete from programs_scheduled where scheduled_program_id  = ?");
			pstmt.setString(1, schProId);
			count = pstmt.executeUpdate();
			if (count >= 0) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public List<ScheduledProgram> listAllScheduledPrograms() {
		Connection con = null;
		CallableStatement cal = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean state = false;
		List<ScheduledProgram> list = new ArrayList<ScheduledProgram>();
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			cal = con.prepareCall("call getAllScheduledPrograms()");
			state = cal.execute();
			if (state) {
				rs = cal.getResultSet();
				while (rs.next()) {
					ScheduledProgram sp = new ScheduledProgram();
					sp.setScheduledProgramId(rs.getString(1));
					sp.setProgramName(rs.getString(2));
					sp.setLocation(rs.getString(3));
					sp.setStartDate(rs.getDate(4));
					sp.setEndDate(rs.getDate(5));
					sp.setSessionsPerWeek(rs.getInt(6));
					list.add(sp);
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public boolean applyApplication(Application app) {
		boolean state = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("insert into `application` (`full_name`,`date_of_birth`,`highest_qualification`,`marks_obtained`,`email_id`,`scheduled_program_id`,`status`,`date_of_interview`) values (?,?,?,?,?,?,?,?)");
			pstmt.setString(1, app.getFullName());
			pstmt.setDate(2, (java.sql.Date) app.getDob());
			pstmt.setString(3, app.getHighestQualification());
			pstmt.setDouble(4, app.getMarksObtained());
			pstmt.setString(5, app.getEmailId());
			pstmt.setString(6, app.getScheduledProgramId());
			pstmt.setString(7, app.getStatus());
			pstmt.setDate(8, (java.sql.Date)app.getDateOfInterview());
			count = pstmt.executeUpdate();
			if (count >= 0) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public boolean deleteApplication(long id) {
		boolean state = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("delete from application where application_id = ?");
			pstmt.setLong(1, id);
			count = pstmt.executeUpdate();
			if (count >= 0) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public boolean updateApplication(Application app) {
		boolean state = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("update application set full_name = ?, date_of_birth = ?, highest_qualification = ?,"
					+ " marks_obtained = ?, email_id = ?, scheduled_program_id = ?, status = ?, date_of_interview = ? where application_id = ?");
			pstmt.setString(1, app.getFullName());
			pstmt.setDate(2, (Date) app.getDob());
			pstmt.setString(3, app.getHighestQualification());
			pstmt.setDouble(4, app.getMarksObtained());
			pstmt.setString(5, app.getEmailId());
			pstmt.setString(6, app.getScheduledProgramId());
			pstmt.setString(7, app.getStatus());
			pstmt.setDate(8, (Date) app.getDateOfInterview());
			pstmt.setLong(9, app.getApplicationId());
			count = pstmt.executeUpdate();
			if (count >= 0) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public List<Application> listAllApplications() {
		Connection con = null;
		CallableStatement cal = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean state = false;
		List<Application> list = new ArrayList<Application>();
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			cal = con.prepareCall("call getAllApplications()");
			state = cal.execute();
			if (state) {
				rs = cal.getResultSet();
				while (rs.next()) {
					Application app = new Application();
					app.setApplicationId(rs.getLong(1));
					app.setFullName(rs.getString(2));
					app.setDob(rs.getDate(3));
					app.setHighestQualification(rs.getString(4));
					app.setMarksObtained(rs.getDouble(5));
					app.setEmailId(rs.getString(6));
					app.setScheduledProgramId(rs.getString(7));
					app.setStatus(rs.getString(8));
					app.setDateOfInterview(rs.getDate(9));
					list.add(app);
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public long getApplicationId(String email) {
		long appId = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("select application_id from application where email_id = ?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				appId = rs.getLong("application_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return appId;
	}

	@Override
	public boolean getApplicationStatus(long id, String dob) {
		boolean state = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("select * from application where application_id = ? and date_of_birth = ?");
			pstmt.setLong(1, id);
			java.util.Date d;
			java.sql.Date sqlDate = null;
			try {
				d = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
				sqlDate = new java.sql.Date(d.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			pstmt.setDate(2, sqlDate);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				state = true;
			} else {
				state = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

	@Override
	public Application getApplication(long id) {
		Application app = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("select * from application where application_id = ?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Application a = new Application();
				a.setApplicationId(rs.getLong("application_id"));
				a.setFullName(rs.getString("full_name"));
				a.setDob(rs.getDate("date_of_birth"));
				a.setHighestQualification(rs.getString("highest_qualification"));
				a.setMarksObtained(rs.getDouble("marks_obtained"));
				a.setEmailId(rs.getString("email_id"));
				a.setScheduledProgramId(rs.getString("scheduled_program_id"));
				a.setDateOfInterview(rs.getDate("date_of_interview"));
				a.setStatus(rs.getString("status"));
				app = a;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return app;
	}

	@Override
	public boolean checkApplication(String email, String dob) {
		boolean state = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DBUtils.DRIVERCLASS);
			con = DriverManager.getConnection(DBUtils.DBURL, DBUtils.USER, DBUtils.PASSWORD);
			pstmt = con.prepareStatement("select * from application where email_id = ? and date_of_birth = ?");
			pstmt.setString(1, email);
			java.util.Date d;
			java.sql.Date sqlDate = null;
			try {
				d = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
				sqlDate = new java.sql.Date(d.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			pstmt.setDate(2, sqlDate);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				state = true;
			} else {
				state = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}
}
