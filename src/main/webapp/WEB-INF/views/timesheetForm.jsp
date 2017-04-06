<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Time sheet Details</h1>
		<form:form action="saveTimesheet" method="post"
			modelAttribute="timesheet">
			<table>
				<form:hidden path="id" />
				<tr>
					<td>Date:</td>
					<td><form:input path="loginDate" id="loginDateTimepicker" /></td>
				</tr>
				<tr>
					<td>Login Time:</td>
					<td><form:input path="loginTime" id="loginTimepicker" /></td>
				</tr>
				<tr>
					<td>Logout Time:</td>
					<td><form:input path="logoutTime" id="logoutTimepicker"/></td>
				</tr>
				<tr>
					<td>Lunch Duration:</td>
					<td><form:input path="lunchDuration" id="lunchDurationTimepicker"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>

<!-- this should go after your </body> -->
<link rel="stylesheet" type="text/css"
	href="resources/static/css/jquery.datetimepicker.css"></link>
<script src="resources/static/js/jquery.js"></script>
<script src="resources/static/build/jquery.datetimepicker.full.min.js"></script>
<script>
	$(function() {
		$('#loginDateTimepicker').datetimepicker({
			  format:'d-m-Y',
			  timepicker:false
			});
	});
	$('#loginTimepicker').datetimepicker({
		datepicker : false,
		format : 'H:i'
	});
	$('#logoutTimepicker').datetimepicker({
		datepicker : false,
		format : 'H:i'
	});
	$('#lunchDurationTimepicker').datetimepicker({
		datepicker : false,
		format : 'H:i',
		allowTimes:['00:15', '00:30', '00:45','01:00'
			,'01:15','01:30','01:45','01:00']
	});
</script>
</html>