package com.university.dto;

import java.util.Date;

public class ScheduledProgram {
	
	private String scheduledProgramId;
	private String programName;
	private String location;
	private Date startDate;
	private Date endDate;
	private int sessionsPerWeek;

	public String getScheduledProgramId() {
		return scheduledProgramId;
	}
	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getSessionsPerWeek() {
		return sessionsPerWeek;
	}
	public void setSessionsPerWeek(int sessionsPerWeek) {
		this.sessionsPerWeek = sessionsPerWeek;
	}
	@Override
	public String toString() {
		return "ScheduledProgram [scheduledProgramId=" + scheduledProgramId + ", programName=" + programName
				+ ", location=" + location + ", startDate=" + startDate + ", endDate=" + endDate + ", sessionsPerWeek="
				+ sessionsPerWeek + "]";
	}
}
