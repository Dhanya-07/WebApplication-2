<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Poll delete Page</title>
<style>
    table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>
</head>
<body>
<% if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}
%>
<%
Class.forName("org.postgresql.Driver");
String url="jdbc:postgresql://localhost:5432/FormApp";
String r="postgres";
String pass="Dh@ny@07";
Connection con=DriverManager.getConnection(url,r,pass); 
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Poll_details");
%>
<table>
    <tr>
    <th>Serial No</th>
      <th>User_ID</th>
      <th>Poll_ID</th>
      <th>Poll_Name</th>
      <th>No of Questions</th>
    </tr>
    <% while(rs.next()){ %>
    <tr>
      <td><%=rs.getString(1) %></td>
      <td><%=rs.getString(2) %></td>
      <td><%=rs.getString(3) %></td>
      <td><%=rs.getString(4) %></td>
      <td><%=rs.getString(5) %></td>
    </tr>
    <%} %>
    </table>
    <form action="AdminEditServlet" method="post">
    <p>Enter the Poll ID to be edited</p>
    <input type="number" placeholder="Poll ID" name="editid"><br>
    <p>Enter the Poll Name to be edited</p>
    <input type="text" placeholder="New Poll Name" name="editname"><br>
    <input type="submit" value="Edit">
    <br>
    <br>
    </form>
</body>
</html>
