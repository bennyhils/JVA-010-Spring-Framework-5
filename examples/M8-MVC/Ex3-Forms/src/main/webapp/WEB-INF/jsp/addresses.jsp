<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Addresses Demo</title>
</head>
<body style="padding-left: 100px">
<a href="/" >Demo list</a>
<h1>Addresses Demo</h1>

<table cellpadding="10px" cellspacing="0px">
	<tr style="background-color: cornflowerblue">
		<th>#id</th>
		<th>City</th>
		<th>Street</th>
	</tr>
	<c:forEach items="${addresses}" var="address">
		<tr>
			<td><c:out value="${address.id}"></c:out></td>
			<td><c:out value="${address.city}"></c:out></td>
			<td><c:out value="${address.street}"></c:out></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>