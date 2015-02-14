<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%><%@taglib prefix="sj"
	uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cloud Printer HMRITM</title>
</head>
<body>
	<s:if test="#session.loginId!=null">
		Successfully Logged In...Welcome <s:property value="#session.emailId" />
		<br>
		<br>
		<sj:menu id="menuWithItems"
			cssStyle="background-color:#ebebeb;height:auto;width:200px;">
			<sj:menuItem title="Create Files" href="upload.jsp"
				cssStyle="background-color:#ebebeb;" />
			<sj:menuItem title="Open Files" cssStyle="background-color:#ebebeb;">
				<sj:menu id="subMenuPlugins"
					cssErrorStyle="background-color:#ebebeb;">
					<sj:menuItem title="Text" href="showfiles" />
				</sj:menu>
			</sj:menuItem>
			<sj:menuItem title="Upload Files"
				cssStyle="background-color:#ebebeb;">
				<sj:menu id="" cssStyle="width:auto;background-color:#ebebeb;">
					<sj:menuItem title="Text" href="uploadtextfile.jsp" />
					<sj:menuItem title="Image" href="fileuploadformat.jsp" />
					<sj:menuItem title="Pdf" href="uploadpdf.jsp" />
				</sj:menu>
			</sj:menuItem>
			<sj:menuItem title="Print Files" cssStyle="background-color:#ebebeb;">
				<sj:menu cssStyle="width:auto;background-color:#ebebeb;">
					<sj:menuItem title="Text" href="showfilesforprint" />
					<sj:menuItem title="Image" href="showimagefiles" />
					<sj:menuItem title="Pdf" href="showpdffiles" />
				</sj:menu>
			</sj:menuItem>
		</sj:menu>
	</s:if>
	<s:else>
		<jsp:forward page="notInSession.jsp" />
	</s:else>

	<a href="logout">Logout</a>
</body>
</html>