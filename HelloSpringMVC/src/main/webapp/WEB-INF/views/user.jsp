<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

사용자 ID : ${userInfo.userId} <br/>
사용자명 : ${userInfo.name} <br/>
사용자이메일 : ${userInfo.email} <br/>

===========================================<br/>
<c:forEach var = "address" items="${userInfo.addresses}">
주소 : [${address.zipCode}] ${address.address} <br/>
</c:forEach>
</body>
</html>