<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Delete Question</title>
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
ResultSet rs=st.executeQuery("select  q_no,que,op1,op2,op3 from Poll_ques");
%>
<table>
    <tr>
    <th>Question No</th>
      <th>Question</th>
      <th>option1</th>
      <th>option2</th>
      <th>option3</th>
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
    <form action="AdminEditServlet_1" method="post">
    <p>Enter the Question Number to be edited</p>
    <input type="number" placeholder="Question No" name="editid"><br>
    <p>Enter the Question and option which has to be changed</p>
    <input type="text" placeholder="Question Name" name="editname"><br>
    <input type="text" placeholder="Option 1" name="editop1"><br>
    <input type="text" placeholder="Option 2" name="editop2"><br>
    <input type="text" placeholder="Option 3" name="editop3"><br>
    <input type="submit" value="Edit">
    <br>
    <br>
    </form>
</body>
</html>

