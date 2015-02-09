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
	<s:form method="post" action="forgotloginid">
		<s:textfield key="emailId" label="Enter Email-Id" />
		<s:submit value="Get Login Id" />
	</s:form>
	<br>
	<s:property value="forgotLoginIdStatus" />
	<br>
	<a href="login.jsp">Go Back To Login Page</a>
</body>
</html>