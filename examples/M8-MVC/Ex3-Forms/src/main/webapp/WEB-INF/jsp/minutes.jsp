<%@ page import="com.luxoft.jva010.mvc.model.Goal" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Minutes</title>
</head>

<body style="padding-left: 100px">

<a href="/">Demo list</a>

<h1>Our goal for the day is: ${goal.minutes}m</h1>
<%
    Goal goal = (Goal) session.getAttribute("goal");
    Integer minutes = (Integer) request.getAttribute("minutes");

    if (minutes >= goal.getMinutes())
    {
%>
<h1 style="color: green">CONGRATULATIONS!!! YOUR GOAL REACHED!!!</h1>
<%
    }
%>

<h1>Your current work time is: ${minutes}m</h1>
<div style="font-size: 24px">
    <form:form modelAttribute="work">
        Enter work time in minutes: <form:input cssStyle="font-size: 24px" path="minutes"/>&nbsp;&nbsp;
        <input type="submit" value="Enter Work"/>
    </form:form>
</div>
</body>
</html>