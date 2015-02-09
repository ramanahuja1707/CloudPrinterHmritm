<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Cloud Printer HMRITM</title>
</head>
<body>
	<center>
		<h1>Cloud Printer HMRITM</h1>
		<s:form action="login" method="post">
			<table>

				<tr>
					<td><s:textfield label="Login Id" key="loginId" /></td>
				</tr>
				<tr>

					<td><s:textfield label="Password" key="password" /></td>
				</tr>
				<tr>

					<td><s:textfield label="Email Id" key="mailId" /></td>
				</tr>
				<tr>
					<td><s:textfield type="submit" value="Login" /></td>
				</tr>
			</table>
			<s:property value="loginError" />
			<s:property value="registrationStatus" />
			<s:property value="logoutStatus" />
			<br>

		</s:form>
		<br>
		<a href="forgotLoginId.jsp">Forgot Login Id ?</a><br> <a
			href="forgotPassword.jsp">Forgot Password ?</a><br> <br> <a
			href="registerUser.jsp"><input type="button" value="Register"></a>
	</center>
</body>
</html>
