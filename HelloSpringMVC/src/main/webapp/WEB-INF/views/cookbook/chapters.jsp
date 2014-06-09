<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정 쉐프의 요리책</title>
</head>
<body>

	<h1>정 쉐프의 요리책</h1>
	<h3>저자 : ${cookbook.writer}</h3>
	<ul>
		<c:forEach var="chapter" items="${cookbook.chapters}">
			<li>${chapter}<a href="/hellomvc/cookbook/chapters/${chapter}">[바로가기]</a></li>
		</c:forEach>
	</ul>

</body>
</html>