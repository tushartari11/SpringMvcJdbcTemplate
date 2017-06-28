<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TimeSheet Details</title>
<link rel="stylesheet" type="text/css" href="resources/static/css/tablesort.css">
<link rel="stylesheet" type="text/css" href="resources/static/css/styles.css">
</head>
<body>
	<div align="center">
		<h1>Timesheet Details</h1>
		
		<div class="box effect5">
		<table>
		<tr>
			<td style="background-color: transparent;">
				<a href="newTimesheet"><img src="resources/static/images/1491937292_Add.png"/></a>
			</td>
		</tr>
		<tr>
			<td>
				<table class="table-sort table-sort-search" style="height: 500px;overflow-y: scroll;">
					<thead>
						<tr>
							<th>No</th>
							<th class="table-sort">Date</th>
							<th>In Time</th>
							<th>Out Time</th>
							<th class="table-sort">Lunch</th>
							<th class="table-sort">Total Hours</th>
							<th class="table-sort">Days</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="timesheetDetail" items="${listTimesheetDetails}"
							varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${timesheetDetail.loginDate}</td>
								<td>${timesheetDetail.loginTime}</td>
								<td>${timesheetDetail.logoutTime}</td>
								<td>${timesheetDetail.lunchDuration}</td>
								<td>${timesheetDetail.totalHoursDecimal}</td>
								<td>${timesheetDetail.manDays}</td>
								<td><a href="editTimeSheet?id=${timesheetDetail.id}"><img src="resources/static/images/1491937363_Edit.png"></img></a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="deleteTimesheet?id=${timesheetDetail.id}"><img src="resources/static/images/1491937418_Cancel.png"></a></td>
		
							</tr>
						</c:forEach>
					</tbody>
				</table>
		 	</td>
		</tr>
		</table>
	   </div>
	</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script> 
<script type="text/javascript" src="resources/static/js/tablesort.js"></script> 
<script type="text/javascript">
$(function () {
$('table.table-sort').tablesort();
});
</script>
</html>
