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
	    <h2>글 수정하기</h2>
	    <form id="frm" name="frm" method="post" action="/FreeboardEditOk">
	    	<c:set var="dto" value="${dto }"> </c:set>
	    		<input type="hidden" value="${dto.getWritepwd() }" id="writepwd" name="writepwd" >
	    		<input type="hidden" value="${dto.getIdx() }" id="idx" name="idx" >
	    	<table class="board_detail">
	    		<tr>
	    			<td>제목</td>
	    			<td><input type="text" id="title" name="title" required="required" value="${dto.getTitle() }"/></td>
	    		</tr>
	    		<tr>
	    			<td colspan="2">
	    			<textarea rows="8" cols="30" id="contents" name="contents" style="resize: none"  required="required">${dto.getContents() }</textarea> </td>
	    		</tr>
	    		<tr>
	    			<td>비밀번호</td>
	    			<td><input type="password" id="checkpwd" name="checkpwd" required="required"/></td>	
	    		</tr>
	    	</table>
	    	<input type="submit" id="submit" value="작성하기" class="btn">
	    	<input type="button" value="전체목록" onclick="location.href='/FreeboardList'" class="btn">
	    </form>
    </div>
</body>
</html>