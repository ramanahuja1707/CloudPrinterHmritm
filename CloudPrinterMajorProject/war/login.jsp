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
		<form action="login" method="post">
			<table>

				<tr>
					<td>Login Id:<input type="text" name="loginId" /></td>
				</tr>
				<tr>

					<td>Password:<input type="password" name="password" /></td>
				</tr>
				<tr>

					<td>Mail Id:<input type="text" name="mailId" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
			<s:property value="loginError" />
			<s:property value="registrationStatus" />
			<br>

		</form>
		<br> <a href="registerUser.jsp"><input type="button"
			value="Register"></a>
	</center>
</body>
</html>
