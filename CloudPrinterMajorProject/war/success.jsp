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
	<s:if test="#session.loginId!=null">
		Successfully Logged In...Welcome <s:property value="#session.emailId" />
		<br>
	</s:if>
	<s:else>
		<jsp:forward page="notInSession.jsp" />
	</s:else>
	<a href="logout">Logout</a>
</body>
</html>