<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirect to Homepage</title>
</head>
<body>
<% if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}
%>
<p>Process Successful</p>
<p>Click on button to redirect to Homepage</p>
<form action="guestHomePage.jsp" method="post">
<input type="submit" value="HomePage">
</form>
</body>
</html>
