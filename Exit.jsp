<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exit Page</title>
</head>
<body>
<%
int n=0,c=0,m=0;double d=0.0;
Class.forName("org.postgresql.Driver");
String url="jdbc:postgresql://localhost:5432/FormApp";
String r="postgres";
String pass="Dh@ny@07";
if(session.getAttribute("username")==null)
{
	String u="exit";
	 System.out.println("view jsp: "+u);
	Connection conu=DriverManager.getConnection(url,r,pass); 
	Statement stu=conu.createStatement();
	
	////stu.executeUpdate(z);
	//String servletPath=request. getServletPath(); 
	//out. println(servletPath);
	String z="insert into url values('"+u+"')";
	stu.executeUpdate(z);
	System.out.println("servletPath "+u);
	response.sendRedirect("Login_1.jsp");
}
%>
<h1><center><b><p>Thank you for using the Application</p></b></center></h1>
</body>
</html>
