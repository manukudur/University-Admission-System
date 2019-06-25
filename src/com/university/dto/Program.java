package com.university.dto;

public class Program {
	
	private String programName;
	private String description;
	private String applicantEligibility;
	private int durationInMonths;
	private String degreeCertificateOffered;
	private String imgUrl;
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApplicantEligibility() {
		return applicantEligibility;
	}
	public void setApplicantEligibility(String applicantEligibility) {
		this.applicantEligibility = applicantEligibility;
	}
	public int getDurationInMonths() {
		return durationInMonths;
	}
	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
	public String getDegreeCertificateOffered() {
		return degreeCertificateOffered;
	}
	public void setDegreeCertificateOffered(String degreeCertificateOffered) {
		this.degreeCertificateOffered = degreeCertificateOffered;
	}
	
	@Override
	public String toString() {
		return "Programs [programName=" + programName + ", description=" + description + ", applicantEligibility="
				+ applicantEligibility + ", durationInMonths=" + durationInMonths + ", degreeCertificateOffered="
				+ degreeCertificateOffered + "]";
	}
}
