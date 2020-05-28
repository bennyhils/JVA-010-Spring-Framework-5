<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Validation Demo</title>

    <style>

        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>

</head>
<body style="padding: 100px 100px 100px 100px; font-size: 24px;">

<h1>Fill this form</h1>

<form:form modelAttribute="user">
    <form:errors path="*" cssClass="errorblock" element="div"/>
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><form:input path="age"/></td>
            <td><form:errors path="age" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="password"/></td>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Login"/>
            </td>
        </tr>

    </table>

</form:form>

</body>
</html>