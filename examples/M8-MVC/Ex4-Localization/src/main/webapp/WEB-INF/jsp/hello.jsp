<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Localization Demo</title>
</head>
<body style="padding: 100px 100px 100px 100px; font-size: 24px;">

    Choose language: <a href="?language=en">English</a> | <a href="?language=de">German</a>

    <h1><spring:message code="greeting"/></h1>

</body>
</html>