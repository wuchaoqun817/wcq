<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
webapp
<input type="text">
<input type="button" value="搜索">
<table>
<c:forEach items="${products}" var="product">
	<tr>
	<td>${product.proName}</td>
	<td>${product.proType}</td>
	<td>${product.info}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>