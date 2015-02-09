<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cloud Printer HMRITM</title>
</head>
<body>
	<s:form action="forgotpassword" method="post">
		<s:textfield label="Enter Email Id" key="emailId" />
		<s:textfield label="Enter Login Id" key="loginId" />
		<s:submit value="Get Password" />
	</s:form>
	<br>
	<br>
	<s:property value="forgotPasswordStatus"/><br>
	<a href="login.jsp">Go Back To Login Page</a>
</body>
</html>