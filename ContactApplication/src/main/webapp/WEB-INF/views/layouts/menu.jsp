<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.userId==null }">
	<!-- User is not logged in : Guest Menu -->
	<a href="#">Home</a> | <a href="#">Login</a> | <a href="${pageContext.request.contextPath }/userRegister">Register</a> | <a href="#">About</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.userRole==1 }">
	<!-- Admin Menu -->
	<a href="${pageContext.request.contextPath }/admin/dashbord">Home</a> | <a href="#">User List</a> | <a href="#">About</a> | <a href="#">Logout</a> 
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.userRole==2 }">
	<!-- User Menu -->
	<a href="${pageContext.request.contextPath }/user/dashbord">Home</a> | <a href="${pageContext.request.contextPath }/user/contactForm">Add Contact</a> | <a href="${pageContext.request.contextPath }/user/contactList">Contact List</a> | <a href="#">About</a> | <a href="#">Logout</a>
</c:if>
