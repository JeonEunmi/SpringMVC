<%@ page language="java" contentType="text/html; charset=UTF-8"  
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%-- jstl-1.2.jar 파일 필요 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>쌍용교육센터</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>

	$(document).ready(function() {
		
	});

</script>

</head>
<body>

	<div class="container">
	
		<img src="${pageContext.request.contextPath}/resources/img/sist_logo.png">
		
		<!-- <h1>Hello, SpringMVC World!</h1> -->
		
		<c:forEach var="m" items="${list}">
		<ul>
			<li>${m.name_} / ${m.phone}</li>
		</ul>
		</c:forEach>
		
	</div>

</body>
</html>