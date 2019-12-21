<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
	<div align="center">
	
	<table border="1" width="800" cellspacing="0">
		<tr>
			<th>글번호</th> <th>글제목</th>
		</tr>
		
		<c:set var="list" value="${list }"></c:set>
		<c:if test="${!empty list }">
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.getIdx() }</td>
					<td>${dto.getTitle() }</td>
				</tr>
			</c:forEach>
		</c:if>

			
		<c:if test="${empty list }">
			<tr>
				<td colspan="2" align="center">
					<h3>검색된 레코드가 없습니다.!!!</h3>
					<h3>test.!!!</h3>
					<h3>aaaaa.!!!</h3>
				</td>
			</tr>
		</c:if>	
		
	</table>
	<br>
</body>
</html>