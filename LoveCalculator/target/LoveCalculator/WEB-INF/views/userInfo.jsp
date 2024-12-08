<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.erorr {
	color: red;
}
</style>
<title>userInfo</title>
</head>
<body bgcolor="pink">
	<div align="center">
		<h1>Love Calculator</h1>
		<form:form action="Validateuserinfo" modelAttribute="userdto">
			<p>
				<label for="yname">Your Name :</label>
				<form:input id="yname" path="YourName" />
				<form:errors path="YourName" cssClass="erorr" />
			</p>
			<p>
				<label for="cname">Your CrushName :</label>
				<form:input id="cname" path="CrushName" />
				<form:errors path="CrushName" cssClass="erorr" />
			</p>
			<p>
				<label for="condtion"></label>
				<form:checkbox id="condtion" path="Condition" />
				This Prediction Only for a Fun
				<form:errors path="Condition" cssClass="erorr" />
			</p>
			<input type="submit">

		</form:form>
	</div>
</body>
</html>