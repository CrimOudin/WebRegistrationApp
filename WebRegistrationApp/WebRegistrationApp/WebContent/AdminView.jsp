<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.webregistrationapp.UserInfo"%>
<%@ page import="com.webregistrationapp.Controller"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin View</title>
<%
	List<UserInfo> allUserInfo = Controller.getDatabaseInfo();
%>
<style>
table, th, td {
    border: 1px solid black;
}
table th:nth-child(even) {
    background-color: #ffebcd;
}
table th:nth-child(odd) {
    background-color: #7fffd4;
}
</style>
</head>
<body bgcolor="#f0f0f0">
	<h1 align="center" name="PageTitle">Admin View: Registered Users</h1>
	<br>
	<table style="width: 100%">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Address 1</th>
			<th>Address 2</th>
			<th>City</th>
			<th>State</th>
			<th>Zip Code</th>
			<th>Country</th>
			<th>Date</th>
		</tr>
		<%
			for (int i = 0; i < allUserInfo.size(); i++) {
		%>
		<tr>
			<th><%=allUserInfo.get(i).getFirstName()%></th>
			<th><%=allUserInfo.get(i).getLastName()%></th>
			<th><%=allUserInfo.get(i).getAddress1()%></th>
			<th><%=allUserInfo.get(i).getAddress2()%></th>
			<th><%=allUserInfo.get(i).getCity()%></th>
			<th><%=allUserInfo.get(i).getState()%></th>
			<th><%=allUserInfo.get(i).getZip()%></th>
			<th><%=allUserInfo.get(i).getCountry()%></th>
			<th><%=allUserInfo.get(i).getDate()%></th>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>