<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Page</title>
<s:url var="url_css" value="/resourceURl/CSS/style.css" />
<link href="${url_css }" rel="stylesheet" type="text/css">
</head>
<body>
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px">
				<!-- Header --> <jsp:include page="layouts/Header.jsp" />
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- menu --> <jsp:include page="layouts/menu.jsp" />
			</td>
		</tr>
		<tr>
			<td height="350px">
				<h3>Contact List</h3>
				
				<c:if test="${param.msg eq 'del' }">
					<p class="success">Record Deleted Successfully</p>
				</c:if>
				<form action="<s:url value="/user/searchContact"/>">
					<input type="text" name="search" value="${param.search }" placeholder="Enter search string">
					<button>Search</button>
				</form>
				</br>
				<table border="1">
					<thead>
						<th>SR</th>
						<th>Name</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Address</th>
						<th>Remark</th>
						<th>Action</th>
						<th hidden>contactId</th>
					</thead>
					<tbody>
						<c:if test="${empty contactList}">
							<tr>
								<td colspan="8"><center>No Records Available</center></td>
							</tr>
						</c:if>
						<c:if test="${contactList !=null }">
							<c:forEach var="con" items="${contactList }" varStatus="st">
								<tr>
									<td>${st.count }</td>
									<td>${con.contactName }</td>
									<td>${con.contactPhone }</td>
									<td>${con.contactEmail }</td>
									<td>${con.contactAddress }</td>
									<td>${con.contactRemark}</td>
									 	<s:url var="url_edit" value="/user/edit">
									 		<s:param name="contactId" value="${con.contactId}"/>
									 	</s:url>
									 	<s:url var="url_del" value="/user/delete">
									 		<s:param name="contactId" value="${con.contactId}"/>
									 	</s:url>
									<td><a href="${url_edit }">Edit</a> | <a href="${url_del }">Delete</a></td>
									<td hidden>${con.contactId}</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- footer --> <jsp:include page="layouts/Footer.jsp" />
			</td>
		</tr>
	</table>
</body>
</html>