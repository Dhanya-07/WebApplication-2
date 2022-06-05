

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>

<html>
<head>
	<title>Questions Insertion</title>
	
	<style>
		body
		{
			background-color: silver;
		}
		#regForm {
			background-color: white;}
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
Statement st=con.createStatement();int n=0,i=1,j=100;String s="";
ResultSet rs=st.executeQuery("select poll_id from Poll_details");
while(rs.next())
{
	n=rs.getInt(1);
}
s=n+"";

%>
<form id="regForm" action="AdminAddQueServlet" method="post">

	
  <div class="tab"><b> Enter the Question Details</b>
    <br>
    <p>Your specified Poll ID</p>
    <input type="number" id="id" oninput="this.className = ''" name="id" value=<%=s%>><br>
    <p>Enter the Question</p>
     <input type="text" id="que" oninput="this.className = ''" name="a" ><br>
   <p>Enter the option 1</p>
	<input type="text" id="op1"  oninput="this.className = ''" name="b" ><br>
    <p>Enter the option 2</p>
	
	<input type="text" id="op2" oninput="this.className = ''" name="c" ><br>
    
    <p>Enter the option 3</p>
    <input type="text" id="op1" oninput="this.className = ''" name="d" ><br>
    <p>Your specified Poll ID</p>
   
    <input type="number" id="id" oninput="this.className = ''" name="id" value=<%=s%> ><br>
    <p>Enter the Question</p>
     <input type="text" id="que" oninput="this.className = ''" name="a1" ><br>
 <p>Enter the option 1</p>
	<input type="text" id="op1"  oninput="this.className = ''" name="b1" ><br>
    
	 <p>Enter the option 2</p>
	<input type="text" id="op2" oninput="this.className = ''" name="c1" ><br>
     <p>Enter the option 3</p>
    
    <input type="text" id="op1" oninput="this.className = ''" name="d1" ><br>
    <p>Your specified Poll ID</p>
    <input type="number" id="id" oninput="this.className = ''" name="id" value=<%=s%>><br>
    <p>Enter the Question</p>
     <input type="text" id="que" oninput="this.className = ''" name="a2" ><br>
 <p>Enter the option 1</p>
	<input type="text" id="op1"  oninput="this.className = ''" name="b2" ><br>
    
	 <p>Enter the option 2</p>
	<input type="text" id="op2" oninput="this.className = ''" name="c2" ><br>
    
     <p>Enter the option 3</p>
    <input type="text" id="op1" oninput="this.className = ''" name="d2" ><br>
    <p>Your specified Poll ID</p>
    <input type="number" id="id" oninput="this.className = ''" name="id" value=<%=s%>><br>
    <p>Enter the Question</p>
     <input type="text" id="que" oninput="this.className = ''" name="a3" ><br>
 <p>Enter the option 1</p>
	<input type="text" id="op1"  oninput="this.className = ''" name="b3" ><br>
    
	 <p>Enter the option 2</p>
	<input type="text" id="op2" oninput="this.className = ''" name="c3" ><br>
    
     <p>Enter the option 3</p>
    <input type="text" id="op1" oninput="this.className = ''" name="d3" ><br>
    <p>Your specified Poll ID</p>
    <input type="number" id="id" oninput="this.className = ''" name="id" value=<%=s%>><br>
    <p>Enter the Question</p>
     <input type="text" id="que" oninput="this.className = ''" name="a4" ><br>
 <p>Enter the option 1</p>
	<input type="text" id="op1"  oninput="this.className = ''" name="b4" ><br>
     <p>Enter the option 2</p>
	
	<input type="text" id="op2" oninput="this.className = ''" name="c4" ><br>
    
     <p>Enter the option 3</p>
    <input type="text" id="op1" oninput="this.className = ''" name="d4" ><br>
    <p>Your specified Poll ID</p>
    <input type="number" id="id" oninput="this.className = ''" name="id" value=<%=s%>><br>
    <p>Enter the Question</p>
     <input type="text" id="que" oninput="this.className = ''" name="a5" ><br>
 <p>Enter the option 1</p>
	<input type="text" id="op1"  oninput="this.className = ''" name="b5" ><br>
     <p>Enter the option 2</p>
	<input type="text" id="op2" oninput="this.className = ''" name="c5" ><br>
     <p>Enter the option 3</p>
    <input type="text" id="op1" oninput="this.className = ''" name="d5" ><br>
   <input type="submit" value="Add" ><br>
	</div>
</form>
</body>
</html>
