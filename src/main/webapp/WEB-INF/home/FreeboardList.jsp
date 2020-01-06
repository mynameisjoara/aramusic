<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../resources/css/board.css" rel="stylesheet" media="screen">
<title>게시판</title>
</head>
<body>
<jsp:include page="titlebutton.jsp"></jsp:include>
	<div class="container" >
	
	<table class="board_list">
		<tr>
			<th align="center">글번호</th> <th>글제목</th> <th>조회수</th> <th>작성자</th> <th>작성시간</th>
		</tr>
		
		<c:set var="list" value="${list }"></c:set>
		<c:if test="${!empty list }">
			<c:forEach items="${list }" var="dto">
				<tr>
<!-- 				화면에 출력하는 값들은 모두 문자열로 바꾸어 주기 위해 c:out태그를 사용. -->
                    <td><c:out value="${dto.getIdx()}"/></td>			
					<td><a href="/FreeboardCont?idx=${dto.getIdx()}"> <c:out value="${dto.getTitle()}"/></a></td>	
                    <td><c:out value="${dto.getHit()}"/></td>			
                    <td><c:out value="${dto.getCreator()}"/></td>			
                    <td><c:out value="${dto.getCreatedDatetime()}"/></td>			
				</tr>
			</c:forEach>
		</c:if>

			
		<c:if test="${empty list }">
			<tr>
				<td colspan="5" align="center">
					<h3>게시글이 없습니다!</h3>
				</td>
			</tr>
		</c:if>	
	</table>
		<div align="right"> 
	    <a href="/FreeboardWrite" class="btn">글 쓰기</a>
		</div>
	<br>
</body>
</html>