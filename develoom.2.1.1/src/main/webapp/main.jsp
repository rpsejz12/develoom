<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<table border="1">
		<c:forEach var="v" items="${rdatas}">
			<tr>
				<td>${v.rpk}</td>
				<td>${v.email}</td>
				<td>${v.roomname}</td>
				<td>${v.password}</td>
				<td>${v.rdatetime}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2"><Button type="button"
					onclick="location.href='rinsert.jsp'">방 생성</Button></td>
		</tr>
	</table>


<%-- 	<a href="main.do?page=1">처음으로</a>
	<c:if test="${paging.startPage != 1 }">
		<a href="main.do?page=${(page-1)-(page-1)%paging.perPageSet - paging.perPageSet + 1}">&lt;</a>
	</c:if>
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
		<c:if test="${paging.curPage == p}">
			<a href="main.do?page=${p}" style ="font-weight:bolder;">${p}</a>
		</c:if>
		<c:if test="${paging.curPage != p}">
			<a href="main.do?page=${p}">${p}</a>
		</c:if>
	</c:forEach>
	<c:if test="${paging.endPage != paging.lastPage}">
		<a href="main.do?page=${(page-1)-(page-1)%paging.perPageSet + paging.perPageSet + 1}">&gt;</a>
	</c:if>
	<a href="main.do?page=${paging.lastPage}">마지막으로</a> --%>
</body>







</html>