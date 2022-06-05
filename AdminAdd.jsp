<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>	Admin Add Page</title>
</head>
<body>
<% if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}
%>
<%
Class.forName("org.postgresql.Driver");int n=0;String s="";
String url="jdbc:postgresql://localhost:5432/FormApp";
String r="postgres";
String pass="Dh@ny@07";
Connection con=DriverManager.getConnection(url,r,pass); 
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select admin_id from temp");
if(rs.next())
{
	n=rs.getInt(1);	
}
s=n+"";
System.out.println("s val:"+s);
Connection cond=DriverManager.getConnection(url,r,pass); 
Statement std=cond.createStatement();
std.executeUpdate("Delete from temp");
%>
	<form action="AdminAddServlet" method="post">
	    <p>Your User ID:</p>
		<input type="number" name="id" value=<%=s%>><br>
		<p>Enter the new Poll ID:</p>
		<input type="number" name="idp"><br>
		<p>Enter the new Poll Name:</p>
		<input type="text" name="col"><br>
		<input type="submit" name="submit" value="submit">
	</form>
</body>
</html>
