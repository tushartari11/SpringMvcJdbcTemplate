<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TimeSheet Details</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Timesheet Details</h1>
	        
	        <table border="1">
	        	<th>No</th>
	        	<th>Date</th>
	        	<th>In Time</th>
	        	<th>Out Time</th>
	        	<th>Lunch</th>
	        	<th>Total Hours</th>
	        	<th>Days</th>
	        	<th>Action</th>
	        	
				<c:forEach var="timesheetDetail" items="${listTimesheetDetails}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${timesheetDetail.loginDate}</td>
					<td>${timesheetDetail.loginTime}</td>
					<td>${timesheetDetail.logoutTime}</td>
					<td>${timesheetDetail.lunchDuration}</td>
					<td>${timesheetDetail.totalHoursDecimal}</td>
					<td>${timesheetDetail.manDays}</td>
					<td>
						<a href="editTimeSheet?id=${timesheetDetail.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteTimesheet?id=${timesheetDetail.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    	
    	<h3><a href="newTimesheet">New Timesheet</a></h3>
    </body>
</html>
