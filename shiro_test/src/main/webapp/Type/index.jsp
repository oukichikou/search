<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="index" method="post">
<select name="txt">
<c:set var="all" value="true" scope="request"></c:set>
<c:set var="optionlist" value="${statuslist}" scope="request"></c:set>
<c:set var="current" value="${status}" scope="request"></c:set>
<c:import url="../select_model/select.jsp"></c:import>
</select>
<input type="submit">
</form>
<c:forEach items="${list.list}" var="row">
${row.name}<br>
</c:forEach>

</body>
</html>