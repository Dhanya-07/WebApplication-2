<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Credentials</title>
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
  
</style>
</head>
<body>
  <h3><b><p align="center">User Credentials</p></b></h3>
  <form id="regForm" action="LoginServlet" method="post">
  <div><b>User Id</b>
    <p><input type="number" placeholder="userId" name="userid"></p>
  </div>
  <div><b>User Name</b>
    <p><input type= "text"placeholder="Name" name="name"></p>
  </div>
    <div><b>Password</b>
    <p><input type="password" placeholder="Password" name="password"></p>
  </div>
  <input type="submit" value="Validate">
</form>
</body>
</html>
