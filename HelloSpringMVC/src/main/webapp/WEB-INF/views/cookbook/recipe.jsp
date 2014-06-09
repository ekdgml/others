<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${recipe.recipeName}만들기</title>
</head>
<body>

	<h2>${recipe.recipeName}의 재료</h2>
	<ul>
		<c:forEach var="ingredient" items="${recipe.ingredients()}">
			<li>${ingredient}</li>
		</c:forEach>
	</ul><br/>
	=============================================================<br/>
	<h2>${recipe.recipeName}만들기</h2>
	<ul>
		<c:forEach var="recipe" items="${recipe.recipe()}">
			<li>${recipe}</li>
		</c:forEach>
	</ul>

</body>
</html>