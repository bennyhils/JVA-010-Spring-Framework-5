<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Person Form</title>
</head>
<body style="padding-left: 100px;">
<a href="/" >Demo list</a>
<h1>Edit Person</h1>

<form:form modelAttribute="personBean" method="POST" action="/persons/edit/${personBean.id}">
     <table>
    <tr>
        <td><form:label path="id">Id:</form:label></td>
           
        <td><form:input path="id" disabled="true"/></td>
          
    </tr>
    <tr>
        <td><form:label path="name">Name:</form:label></td>
           
        <td><form:input path="name"/></td>
          
    </tr>
    <tr>
        <td><form:label path="money">Money</form:label></td>
           
        <td><form:input path="money"/></td>
          
    </tr>
    </table>
    <br>
     <input type="submit" value="Save" />&nbsp;&nbsp;
    <a href="/persons/all">Back</a>
</form:form>

</body>
</html>