<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<html>
<head>
	<title>Guest Vote Page</title>
	
	<style>
		body
		{
			background-color: silver;
		}
		#regForm {
			background-color: white;
  
  border-style: solid;
  margin: 100px auto;
  font-family: Raleway;
  padding: 40px;
  width: 70%;
  min-width: 300px;
}
* {
  box-sizing: border-box;
}
		.tab {
  display: none;
}
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: blue;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 0.5;
}
#prevBtn
{
	background-color: grey;

}
#nextBtn
{
	background-color: lightgreen;

}
input.invalid
{
  background-color: pink;
  
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
String s="";
while(rs.next())
{
	s=rs.getInt(3)+"";
	System.out.println(s);
	if(	!(request.getParameter(s)==null))
	{
		System.out.println("pf: "+s);
		break;
		
	}
	
	
}

int n=Integer.parseInt(s);int c=0,i=0,m=0;
System.out.println("JSP: "+n);
//check
Connection conc=DriverManager.getConnection(url,r,pass); 
Statement stc=conc.createStatement();
ResultSet rsc=stc.executeQuery("select q_no from Poll_ques where poll_id='"+n+"'");
if(rsc.next())
	c=rsc.getInt(1);
System.out.println("JSP:c "+c);
//admin id and q_no : check
Connection conc1=DriverManager.getConnection(url,r,pass); 
Statement stc1=conc1.createStatement();
//temp
Connection cont=DriverManager.getConnection(url,r,pass); 
Statement stt=cont.createStatement();
ResultSet rst=stt.executeQuery("select admin_id from temp");
if(rst.next())
 i=rst.getInt(1);
System.out.println("JSP:i "+i);
ResultSet rsc1=stc1.executeQuery("select count(*) from Votes where admin_id='"+i+"'and q_no='"+c+"'");
if(rsc1.next())
	 m=rsc1.getInt(1);
System.out.println("JSP:m "+m);
if(m>0)
{
	PrintWriter l=response.getWriter();
	l.println("Already visited the page for voting");
  //  m=0;i=0;n=0;
	//response.sendRedirect("guestHomePage.jsp");
}

	
else
{
Connection con1=DriverManager.getConnection(url,r,pass); 
Statement st1=con1.createStatement();
ResultSet rs1=st1.executeQuery("select * from Poll_ques where poll_id='"+n+"'");
%>
<form id="regForm" action="GuestVoteServlet" method="post">
  <%while(rs1.next())
	{%>
	
  <div class="tab"><b> <%=rs1.getString(3) %></b>
    <br>
    <input type="radio" oninput="this.className = ''" name="<%=rs1.getString(3)%>"   value="<%=rs1.getString(4)%>"><%=rs1.getString(4) %> <br>

	<input  type="radio" name="<%=rs1.getString(3)%>" oninput="this.className = ''"  value="<%=rs1.getString(5)%>"><%=rs1.getString(5) %><br>

	<input   type="radio" name="<%=rs1.getString(3)%>"oninput="this.className = ''"  value="<%=rs1.getString(6)%>"><%=rs1.getString(6) %><br>
	</div>
	
  <%} %>
  
   <%if(!rs.next()) {%>
   <p>Make Wise Choice</p>
   
  <%} %>
 
	<div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div>
  </div>
      <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
     <span class="step"></span>
      <span class="step"></span>
      <span class="step"></span>
       <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
       <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
       <span class="step"></span>
        <span class="step"></span>
  </div>
</form>
  <script>
var currentTab = 0; 
showTab(currentTab); 

function showTab(n) {
  // This function will display the specified tab 
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  fixStepIndicator(n)
}

function nextPrev(n) {
  
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  showTab(currentTab);
}

function validateForm() {
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  for (i = 0; i < y.length; i++) {
    if (y[i].value == "  ") {
      y[i].className += " invalid";
      valid = false;
    }
  }
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  x[n].className += " active";
}
</script>
<%} %>
</body>
</html>
