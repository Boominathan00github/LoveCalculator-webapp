<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored = "false" %>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getEmail</title>
</head>
<body>
Hi ${name.yourName}
<form:form action="validateemail"   modelAttribute="email">
Enter Email to Send  <form:input path="email"/>
<form:errors  path="email"/>
<input type="submit" value="Send">
</form:form>
</body>
</html>