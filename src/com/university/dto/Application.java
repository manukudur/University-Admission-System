package com.university.dto;

import java.util.Date;

public class Application {
	private long applicationId;
	private String fullName;
	private Date dob;
	private String HighestQualification;
	private double marksObtained;
	private String emailId;
	private String scheduledProgramId;
	private String status = "Pending";
	private Date DateOfInterview = null;
	
	public long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getHighestQualification() {
		return HighestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		HighestQualification = highestQualification;
	}
	public double getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(double marksObtained) {
		this.marksObtained = marksObtained;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getScheduledProgramId() {
		return scheduledProgramId;
	}
	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateOfInterview() {
		return DateOfInterview;
	}
	public void setDateOfInterview(Date dateOfInterview) {
		DateOfInterview = dateOfInterview;
	}
	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", fullName=" + fullName + ", dob=" + dob
				+ ", HighestQualification=" + HighestQualification + ", marksObtained=" + marksObtained + ", emailId="
				+ emailId + ", scheduledProgramId=" + scheduledProgramId + ", status=" + status + ", DateOfInterview="
				+ DateOfInterview + "]";
	}
	
		
}
