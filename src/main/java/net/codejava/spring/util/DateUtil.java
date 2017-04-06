package net.codejava.spring.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) {
//		DateUtil dateUtil = new DateUtil();
//		
//		String loginTime = "09:45";
//		String logoutTime ="19:32";
//		String lunchDuration="00:45";
//		String totalHours = dateUtil.getTotalWorkedHours(loginTime, logoutTime, lunchDuration);
//		System.out.println("totalHours: "+totalHours);
//		double totalHoursDecimal = dateUtil.getTotalWorkedDecimalHours(loginTime, logoutTime, lunchDuration);
//		System.out.println("totalHoursDecimal: "+totalHoursDecimal);
//		double manDays = dateUtil.getManDays(totalHoursDecimal);
//		System.out.println("manDays: "+manDays);
//		java.sql.Date loginDate = dateUtil.parseDateForSql("06-04-2017");
//		System.out.println("loginDate : "+loginDate);
	}

	public double getManDays(double totalDecimalHours) {
		double manDays = (double) (totalDecimalHours/8.0);
		return getRoundedResult(manDays);
	}

	public String getTotalWorkedHours(String loginTime,String logoutTime, String lunchDuration) {
		int t1 = getTotalMinutes(loginTime);
	    int t2 = getTotalMinutes(logoutTime);
	    int t3 = getTotalMinutes(lunchDuration);
	    int total = t2 - t1 - t3;
		return getResult(total);
	}
	
	public double getTotalWorkedDecimalHours(String loginTime,String logoutTime, String lunchDuration) {
		String totalHours = getTotalWorkedHours(loginTime, logoutTime, lunchDuration);
		int totalMinutes = getTotalMinutes(totalHours);
		return getRoundedResult(((double)totalMinutes/60));
	}
	
	public int getTotalMinutes(String time) {
	    String[] t = time.split(":");
	    return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
	}
	
	private String getResult(int total) {
	    int minutes = total % 60;
	    int hours = ((total - minutes) / 60) % 24;
	    return String.format("%02d:%02d", hours, minutes);
	}
	private double getRoundedResult(double inputValue){
		double roundedValue = (double) Math.round(inputValue * 100) / 100;
		return roundedValue;
	}
	
	public java.sql.Date parseDateForSql(String inputDate){
		DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.sql.Date outputSqlDate = null;
		Date parsedJavaDate = null;
		try {
			parsedJavaDate = sdf.parse(inputDate);
			outputSqlDate = new java.sql.Date(parsedJavaDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return outputSqlDate;
	}
	
	public java.sql.Date convertDateForSql(Date javaDate){
        java.sql.Date outputSqlDate = null;
		try {
			outputSqlDate = new java.sql.Date(javaDate.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
        return outputSqlDate;
	}
}
