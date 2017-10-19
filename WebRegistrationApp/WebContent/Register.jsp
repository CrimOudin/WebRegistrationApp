<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	Object errorFocus = request.getParameter("errorFocus");
	Object fName = request.getParameter("first_name");
	if (fName == null)
		fName = "";
	Object lName = request.getParameter("last_name");
	if (lName == null)
		lName = "";
	Object address1 = request.getParameter("address1");
	if (address1 == null)
		address1 = "";
	Object address2 = request.getParameter("address2");
	if (address2 == null)
		address2 = "";
	Object city = request.getParameter("city");
	if (city == null)
		city = "";
	Object state = request.getParameter("state");
	if (state == null)
		state = "";
	Object zip = request.getParameter("zip");
	if (zip == null)
		zip = "";
	Object country = request.getParameter("country");
	if (country == null)
		country = "";
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd 'at' hh:mm:ss a zzz");
	
%>
<title>Register</title>
</head>
<body align="center" bgcolor="#f0f0f0">
	<h1 align="center" name="PageTitle">Register</h1>
	<br>
	<div
		style="width: 100%; margin-left: auto; margin-right: auto; align: center;">
		<form>
			First Name:<br> <input type="text" name="first_name" size="60"
				maxlength="45" style="text-align: center;" required
				value="<%=fName%>"><br> Last Name:<br> <input
				type="text" name="last_name" size="60" maxlength="45"
				style="text-align: center;" required value="<%=lName%>"><br>
			Address 1:<br> <input type="text" name="address1" size="100"
				maxlength="100" style="text-align: center;" required
				value="<%=address1%>"><br> Address 2:<br> <input
				type="text" name="address2" size="100" maxlength="100"
				style="text-align: center;" value="<%=address2%>"><br>
			City:<br> <input type="text" name="city" size="80"
				maxlength="60" style="text-align: center;" required
				value="<%=city%>"><br> State:<br> <input
				type="text" name="state" size="5" maxlength="2"
				style="text-align: center;" required value="<%=state%>"><br>
			Zip Code:<br> <input type="text" name="zip" size="30"
				maxlength="10" style="text-align: center;" required value="<%=zip%>"><br>
			Country:<br> <input type="text" name="country" size="75"
				maxlength="55" style="text-align: center;" required
				value="<%=country%>"><br> Date(YYYY/MM/DD):<br>
			<%=ft.format(date)%><br> <br> <input type="submit"
				name="submit" onClick="ShowHide()"> <br>
			<br>
			
		</form>
	</div>
</body>
</html>
