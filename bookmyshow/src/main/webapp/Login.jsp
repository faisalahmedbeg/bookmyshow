<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg1 = (String)request.getAttribute("login_message");
String msg2 = (String)request.getAttribute("reg_message");
if (msg1!= null) 
out.println(msg1);
%>
<form action="AuthenticateUser" method="post">
<br><h1>Enter Login Details</h1>
<br>User Name: <input type="text" name="username" />
<br>Password: <input type="password" name="password" />
<br><input type="submit" value="Sign In" />
</form>
<br><br>
<% 
if (msg2!= null) 
out.println(msg2);
%>
<form action="RegisterUser" method="post">
<br><h1>Enter Registration Details</h1>
<br>Full Name: <input type="text" name="reg_fullname" />
<br>User Name: <input type="text" name="reg_username" />
<br>Password: <input type="password" name="reg_password" />
<br>RePassword: <input type="password" name="reg_repassword" />
<br>Age: <input type="text" name="reg_age" />
<br>Phone Number: <input type="text" name="reg_phonenumber" />
<br><input type="submit" value="Sign Up" />
</form>
</body>
</html>