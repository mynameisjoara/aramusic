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
        <table class="board_list">
            <tr>
                <th>글 번호</th><th>주제</th><th>글 제목</th><th>작성자</th><th>작성일자</th><th>조회수</th>
            </tr>
            <c:set var="list" value="${list}"/>
            <c:if test="${!empty list}">
                <c:forEach items="${list}" var="freeboardDto">
                    <tr>
                        <td><c:out value="${freeboardDto.getFreeNum()}"/></td>
                        <td><c:out value="${freeboardDto.getFreeSubject()}"/></td>
                        <td><a href="/freeCont?freeNum=${freeboardDto.getFreeNum()}&page=${page}"> <c:out value="${freeboardDto.getFreeTitle()}"/><c:if test="${freeboardDto.getFreeReplyCnt() >0}">
                            (${freeboardDto.getFreeReplyCnt()})
                            </c:if> </a></td>
                        <td><c:out value="${freeboardDto.getMemId()}"/></td>
                        <td><c:out value="${freeboardDto.getFreeCreatedDate()}"/></td>
                        <td><c:out value="${freeboardDto.getFreeHit()}"/></td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty list}">
                <tr>
                    <td colspan="6" align="center">
                        <h3>게시글이 없습니다.</h3>
                    </td>
                </tr>
            </c:if>

        </table>
</body>
</html>