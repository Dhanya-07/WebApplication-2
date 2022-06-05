<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Insertion</title>
</head>
<body>
<%
Class.forName("org.postgresql.Driver");
String url="jdbc:postgresql://localhost:5432/FormApp";
String r="postgres";
String pass="Dh@ny@07";
Connection con=DriverManager.getConnection(url,r,pass); 
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Poll_details");
%>
<% if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}
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
      <td><%=rs.getInt(1) %></td>
      <td><%=rs.getInt(2) %></td>
      <td><%=rs.getInt(3) %></td>
      <td><%=rs.getString(4) %></td>
      <td><%=rs.getInt(5) %></td>
      </tr>
      <%} %>
      </table>
<form id="regForm" action="AdminAddQueServlet_1" method="post">	
  <div class="tab"><b> Enter the Question Details</b>
    <br>
    <p>Confirm the Poll ID</p>
    <input type="number" id="id" name="id" ><br>
    <p>Enter the Question</p>
     <input type="text" id="que" name="a" ><br>
   <p>Enter the option 1</p>
	<input type="text" id="op1" name="b" ><br>
    <p>Enter the option 2</p>
	
	<input type="text" id="op2" name="c" ><br>
    
    <p>Enter the option 3</p>
    <input type="text" id="op3"  name="d" ><br>
    <input type="submit" value="submit">
    
</div></form>
</body>
</html>
