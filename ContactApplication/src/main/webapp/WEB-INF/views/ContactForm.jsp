<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Page</title>
<s:url var="url_css" value="/resourceURl/CSS/style.css"/>
<link href="${url_css }" rel="stylesheet" type="text/css">
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
			<!-- body -->
			<td height="350px">
				<c:if test="${err!=null }">
					<p class="error">${err }</p>
				</c:if>
				<c:if test="${success!=null }">
					<p class="success">${succ }</p>
				</c:if>
				<s:url var="url_save" value="/saveContact"/>
				<f:form action="${url_save }" modelAttribute="contact">
					<table border="1">
						<tr>
							<td>Name:</td>
							<td><f:input path="contactName"/></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><f:input path="contactEmail"/></td>
						</tr>
						<tr>
							<td>Phone:</td>
							<td><f:input path="contactPhone"/></td>
						</tr>
						<tr>
							<td>Address:</td>
							<td><f:textarea path="contactAddress"/></td>
						</tr>
						<tr>
							<td>Remark:</td>
							<td><f:textarea path="contactRemark"/></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<button>Add</button>
							</td>
						</tr>
					</table>
					
				</f:form>
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