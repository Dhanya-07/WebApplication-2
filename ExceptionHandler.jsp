<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exception Occured</title>
</head>
<body>
<% if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}
%>
<form action="Login.jsp" method="post">
<p>You have Entered Invalid Values,<br>
<ol>
<li> Makesure you have not violated datatypes of any fields</li>
<li>Makesure you have entered your credentials appropriately</li>
<li>Makesure you have not duplicated any IDs</li>
<br>
</ol>
click on HomePage to return 
<button>HomePage</button>
</form>
</body>
</html>
