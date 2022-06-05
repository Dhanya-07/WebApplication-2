<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View poll %</title>
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
	 String u="view";
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


Connection con=DriverManager.getConnection(url,r,pass); 
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select count(distinct admin_id) from Votes");
if(rs.next())
	n=rs.getInt(1);
//m
Connection conm=DriverManager.getConnection(url,r,pass); 
Statement stm=conm.createStatement();
ResultSet rsm=stm.executeQuery("select count(*) from Votes");
if(rsm.next())
	m=rsm.getInt(1);

Connection con1=DriverManager.getConnection(url,r,pass); 
Statement st1=con1.createStatement();
ResultSet rs1=st1.executeQuery("select  selected from Votes");
Connection con2=DriverManager.getConnection(url,r,pass); 
Statement st2=con2.createStatement();
ResultSet rs2=st2.executeQuery("select  selected from Votes");
String a1[]=new String[m];int i=0,j=0;
String a2[]=new String[m];%>
<b><p>Percentage of Secured Votes</p></b>

<ul><b><center><h2>List</h2></center></b>

<%while(rs1.next())
{
	a1[i++]=rs1.getString(1);
}
while(rs2.next())
{
	a2[j++]=rs2.getString(1);
}
	for(i=0;i<m;i++)
	{
		for(j=0;j<m;j++)
		{
			if( (a1[i].equals(a2[j]))&&(a1[i]!=null))
					{c++;
				//System.out.println(c*100)
				d=(c*100)/n;
				
					}
		}
		c=0;
		%>
	<li><center><%=a1[i]%> <b>is with <%=d%> % </b>of votes<br></center></li>i>
	<br>
	<%} %>
	</ul>	
	<button onclick="history.back()">HomePage</button>
</body>
</html>
