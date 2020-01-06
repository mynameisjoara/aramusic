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
	<div class="container">
		<table class="board_detail">
	
			<c:set var="dto" value="${dto }"> </c:set>
			<c:if test="${!empty dto }">
	
				<tr>
					<th>글번호</th>
					<td><c:out value="${dto.getIdx()}"/></td>
					<th>조회수</th>
					<td><c:out value="${dto.getHit()}"/></td>	
					<th>작성자</th>
					<td><c:out value="${dto.getCreator() }"/></td>						
				</tr>
				<tr>			
					<th>제목</th>
					<td colspan="5"><c:out value="${dto.getTitle() }"/></td>
				</tr>
				<tr>		
					<th>내용</th>
					<td colspan="5"><c:out value="${dto.getContents() }"/></td>	
				</tr>
				<tr>									
					<c:if test="${!empty dto.getUpdatedDatetime()}">
					<th>작성일/수정일</th>
					<td colspan="5">${dto.getCreatedDatetime() }/${dto.getUpdatedDatetime() }</td>
					</c:if>
					<c:if test="${empty dto.getUpdatedDatetime()}">
					<th>작성일</th>
					<td colspan="5">${dto.getCreatedDatetime() }</td>
					</c:if>
				</tr>
			</c:if>

		</table>
			<br>
			<div align="center">
				<td align="center">
                <input type="button" value="수정" class="btn" onclick="location.href='/FreeboardEdit?idx=${dto.getIdx()}'">
                <!-- 미완성 -->    <input type="button" value="삭제" class="btn" onclick="location.href='/FreeboardDelete?idx=${dto.getIdx()}'">
					<input type="button" value="전체목록" class="btn" onclick="location.href='/FreeboardList'">
				</td>
			</div>
		</div>
</body>
</html>