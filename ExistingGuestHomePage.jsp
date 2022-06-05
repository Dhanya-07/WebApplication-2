<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Existing Guest HomePage</title>
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
<p>You have already casted your Vote<br>Your responses:<br></p>
<%
int n=0;
Class.forName("org.postgresql.Driver");
String url="jdbc:postgresql://localhost:5432/FormApp";
String r="postgres";
String pass="Dh@ny@07";
Connection con=DriverManager.getConnection(url,r,pass); 
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Poll_details");
///user
Connection conn=DriverManager.getConnection(url,r,pass); 
Statement stn=conn.createStatement();
ResultSet rsn=stn.executeQuery("select admin_id from temp");
if(rsn.next())
{
	n=rsn.getInt(1);
}
System.out.println("n in existing: "+n);
if(n!=0)
{
Connection con1=DriverManager.getConnection(url,r,pass); 
Statement st1=con1.createStatement();
ResultSet rs1=st1.executeQuery("select * from Votes where admin_id='"+n+"'");

%>
<table>
<tr>
<th>User Id</th>
<th>Question No</th>
<th>Your Nominations</th>
</tr>
    
    <%while(rs1.next()){ %>
    <tr>
      <td><%=rs1.getString(1) %></td>
      <td><%=rs1.getString(2) %></td>
      <td><%=rs1.getString(3) %></td>
     </tr>
      <%} }
      else
      {%>
      <p>Your updation is successful</p><%}%>
</table>
<p>You can edit your vote here:!</p>
<table>
    <tr>
    <th>Serial No</th>
      <th>User_ID</th>
      <th>Poll_ID</th>
      <th>Poll_Name</th>
      <th>No of Questions</th>
      <th>Operations</th>
    </tr>
    <% while(rs.next()){ %>
    <tr>
      <td><%=rs.getString(1) %></td>
      <td><%=rs.getString(2) %></td>
      <td><%=rs.getString(3) %></td>
      <td><%=rs.getString(4) %></td>
      <td><%=rs.getString(5) %></td>
      <td>
      <form action="ExistingGuestJSP.jsp" method="post">
      <input type="submit" name="<%=rs.getInt(3)%>" value="Edit">
  </td>
    </tr>
    <%} %>
    </form>
    <form action="ViewExit" method="post">
    <button type="submit" name="oper" " value="view">View Poll Votes(%)</button>
    <button type="submit" name="oper"  value="exit">Exit Application</button>
    <button type="submit" name="oper"  value="logout">Logout</button>
    </form>
    <br>
    <br>
  </table>
</body>
</html>

