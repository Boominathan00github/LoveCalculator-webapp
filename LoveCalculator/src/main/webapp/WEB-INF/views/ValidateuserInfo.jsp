<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>appResult</title>
</head>
<body>
 Hi! ${userdto.yourName}<br>
Love Result :${appresult}
<br>
<a href="<c:url value ="email"/>">Result send to Email </a>
 <!-- <a href="email">Result send to Email </a> -->
</body>
</html>