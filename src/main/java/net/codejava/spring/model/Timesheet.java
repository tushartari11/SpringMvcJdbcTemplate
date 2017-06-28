package net.codejava.spring.model;

public class Timesheet {

	
	private int id;
	private String loginDate;
	private String loginDay;
	private String loginTime;
	private String logoutTime;
	private String lunchDuration;
	private String totalHours;
	private double totalHoursDecimal;
	private double manDays;
	private String createdDate;
	private String modifiedDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getLunchDuration() {
		return lunchDuration;
	}
	public void setLunchDuration(String lunchDuration) {
		this.lunchDuration = lunchDuration;
	}
	public String getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}
	public double getTotalHoursDecimal() {
		return totalHoursDecimal;
	}
	public void setTotalHoursDecimal(double totalHoursDecimal) {
		this.totalHoursDecimal = totalHoursDecimal;
	}
	public double getManDays() {
		return manDays;
	}
	public void setManDays(double manDays) {
		this.manDays = manDays;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	

	public String getLoginDay() {
		return loginDay;
	}
	public void setLoginDay(String loginDay) {
		this.loginDay = loginDay;
	}
	
	@Override
	public String toString() {
		return "Timesheet [id=" + id + ", loginDate=" + loginDate + ", loginDay=" + loginDay + ", loginTime="
				+ loginTime + ", logoutTime=" + logoutTime + ", lunchDuration=" + lunchDuration + ", totalHours="
				+ totalHours + ", totalHoursDecimal=" + totalHoursDecimal + ", manDays=" + manDays + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
