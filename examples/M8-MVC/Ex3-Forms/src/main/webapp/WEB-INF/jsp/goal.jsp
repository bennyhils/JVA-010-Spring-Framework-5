<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Goal</title>
</head>
<body style="padding-left: 100px">

<a href="/">Demo list</a>

<h1>Setup Your Goal</h1>

<div style="font-size: 24px">
    <form:form modelAttribute="goal">

        Minutes to work: <form:input cssStyle="font-size: 24px" path="minutes"/>
        &nbsp;&nbsp;
        <input style="font-size: 24px;" type="submit" value="Set Your Goal"/>

    </form:form>
</div>
</body>
</html>