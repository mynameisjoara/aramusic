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
	    <h2>글 삭제하기</h2>
	    <form id="frm" name="frm" method="post" action="/FreeboardDeleteOk">
	    	<c:set var="dto" value="${dto }"> </c:set>
	    		<input type="hidden" value="${dto.getWritepwd() }" id="writepwd" name="writepwd" >
	    		<input type="hidden" value="${dto.getIdx() }" id="idx" name="idx" >
	    	<table class="board_detail">
	    		<tr>
	    			<td>비밀번호를 입력하세요</td>
	    			<td><input type="password" id="checkpwd" name="checkpwd" required="required"/></td>	
	    		</tr>
	    	</table>
	    	<div align="center">
	    	<input type="submit" id="submit" value="삭제하기" class="btn">
	    	<input type="button" value="전체목록" onclick="location.href='/FreeboardList'" class="btn">
	    	</div>
	    </form>
    </div>
</body>
</html>