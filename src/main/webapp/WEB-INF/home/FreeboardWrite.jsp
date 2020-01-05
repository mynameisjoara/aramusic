<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    <h2>글 작성하기</h2>
	    <form id="frm" name="frm" method="post" action="/FreeboardWriteOk">
	    	<table class="board_detail">
	    		<tr>
	    			<td>제목</td>
	    			<td><input type="text" id="title" name="title" required="required"/></td>
	    		</tr>
	    		<tr>
	    			<td colspan="2">
	    			<textarea rows="8" cols="30" id="contents" name="contents" style="resize: none"  required="required"></textarea> </td>
	    		</tr>
	    	</table>
	    	<input type="submit" id="submit" value="작성하기" class="btn">
	    </form>
    </div>
</body>
</html>