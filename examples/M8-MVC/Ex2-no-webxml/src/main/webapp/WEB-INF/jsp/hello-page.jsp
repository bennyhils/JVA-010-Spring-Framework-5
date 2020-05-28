<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%


%>
<h1>${greeting}</h1>

<%
    Boolean isAgeProcessed = (Boolean) session.getAttribute("isAgeProcessed");

    if (isAgeProcessed != null && isAgeProcessed)
    {
%>
        We have got your age. Thank you!<br><br>
<%
    }

%>


<form action="/processAge">
    <table>
        <tr>
            <td><input type="hidden" name="test" value="hidden field"/></td>
            <td>Enter your age: <input name="age" value=""/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Send to the server"/>
            </td>
        </tr>
    </table>
</form>


</body>
</html>