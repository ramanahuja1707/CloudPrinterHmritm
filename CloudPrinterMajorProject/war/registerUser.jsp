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
	<center>
		<s:form action="registeruser" method="post">
			<s:textfield key="userInformation.userName" label="User Name" />
			<s:textfield key="userInformation.loginId" label="Login Id" />
			<s:textfield key="userInformation.age" label="Age" />
			<s:radio list="{'Male','Female'}" key="userInformation.gender"
				label="Gender" />
			<s:textfield key="userInformation.userDesignation"
				label="User Designation" />
			<s:textfield key="userInformation.userWorkLocation"
				label="Work Location" />
			<s:textfield key="userInformation.emailId" label="Email-Id" />
			<s:textfield key="userInformation.alternateEmail"
				label="Alternate Email-Id" />
			<s:textfield key="userInformation.contactNumber" label="Mobile No." />
			<s:submit value="Register" />
		</s:form>
		<s:property value="registrationStatus" />
		<s:property value="registrationError" />
		
		<a href="login.jsp">Go Back To Login Page</a>
	</center>
</body>
</html>