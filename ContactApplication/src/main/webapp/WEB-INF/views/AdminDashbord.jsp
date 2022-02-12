<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="/ContactApplication/resourceURl/CSS/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px">
			 <!-- Header -->
			 	<jsp:include page="layouts/Header.jsp"/>
			 </td>
		</tr>
		<tr>
			<td height="25px"><!-- menu -->
				<jsp:include page="layouts/menu.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="350px"> <!-- body -->
				Admin Page
			</td>
		</tr>
		<tr>
			<td height="25px"><!-- footer -->
				<jsp:include page="layouts/Footer.jsp"/>
			 </td>
		</tr>
	</table>
</body>
</html>