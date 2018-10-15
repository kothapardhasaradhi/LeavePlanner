<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
</head>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link rel="stylesheet" href="css/custome.css">

<style>
table {
	border-collapse: collapse;
	width: 80%;
	margin-top: 30px;
	margin-left: auto;
	margin-right: auto;
}

.orange {
	background-color: orange;
}

#edit.selected tr {
	background-color: orange;
	color: orange;
}

tr:hover td {
	background-color: lightgreen;
}



body {
	font-family: 'EB Garamond';
	font-size: 18px;
}

th,td {
	padding: 8px;
	text-align: left;
}

td {
	background-color: white;
}

td:input[type="button"] {
	background-color: white;
}

th {
	background-color: #5bc0de;
	color: white;
	border-color: black;
	text-align: justify;
}

tr:hover {
	background-color: lwhite;
}

#td1 {
	background-color: #5bc0de;
	text-align: center;
}

tr:nth-child(even) input {
	background-color: #f2f2f2;
}

tr:nth-child(even) td {
	background-color: #f2f2f2;
}

</style></head>
<body>
<jsp:include page="header1.jsp"/>
	<table border="black">
		<tr>
			<th>EMPLOYEE ID</th>
			<th>EMPLOYEE  Name</th>
			<th>FROM DATE</th>
			<th>T0 DATE</th>
			<th>LEAVE TYPE</th> 
			<th>BACKUP RESOURCE</th>
		</tr>
		<tr>
			<td><html:property value="empid" /></td>
			<td><html:property value="empname" /></td>
			<td><html:property value="fromdate" /></td>
			<td><html:property value="todate" /></td>
			<td><html:property value="leavetype" /></td>
			<td><html:property value="backupres"/>
			</td>
	<!-- <td>  <html:property value="backupres" /> </td> -->
		</tr>
	</table>
	<jsp:include page="footer.jsp"/>
</body>
</html>