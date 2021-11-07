<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Astral by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Astral by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/room.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>

</head>
<body class="is-preload">

	<!-- Wrapper-->
	<div id="wrapper">

		<!-- Nav -->
		<nav id="nav">
			<a href="main.do" class="icon solid fa-home"><span>Home</span></a> <a
				href="myroom.do" class="icon solid fa-folder active"><span>Work</span></a>
			<a href="" class="icon solid fa-envelope"><span>Contact</span></a> <a
				href="mform.jsp" class="icon brands fa-twitter"><span>Twitter</span></a>
		</nav>

		<!-- Main -->
		<div id="main">
			<article id="work" class="panel">
				<header>
					<h2>Room Setting</h2>
				</header>
				<section>
					<div class="row">
						<c:forEach var="v" items="${rdatas}">
							<div class="col-6 col-6-medium col-12-small">
								<div style="position: relative">
									<div style="position: absolute; margin-top: 10%;">
										<form action="rform.do" method="post" class="on"
											name="roomform" id="room${v.rpk}"
											style="width: 90%; margin-left: 5%; z-index: 1; position: relative">

											<input type="hidden" name="rpk" value="${v.rpk}" readonly>
											<input type="hidden" name="roomname" value="${v.roomname}"
												readonly> <span
												style="border-bottom: outset; font-weight: 500;">No.${v.rpk}
												title : ${v.roomname}</span> <input type="password" name="password"
												placeholder="Password" style="margin-top: 10px"> <input
												type="submit" style="display: none">
										</form>
									</div>

									<c:if test="${v.filepath == null}">
										<a class="image fit" href="javascript:void(0);"
											onclick="sroom(${v.rpk})"><img id="img${v.rpk}"
											src="images/pic01.jpg" alt=""> </a>
									</c:if>
									<c:if test="${v.filepath != null}">
										<a class="image fit" href="javascript:void(0);"
											onclick="sroom(${v.rpk})"><img id="img${v.rpk}"
											src="images/${v.filepath}" alt=""> </a>
									</c:if>

								</div>
							</div>
						</c:forEach>

						<%-- ${v.email} ${v.roomname}${v.password} ${v.rdatetime} --%>
					</div>

					<div class="row">
						<c:if test="${paging.startPage != 1 }">
							<a
								href="myroom.do?page=${(page-1)-(page-1)%paging.perPageSet - paging.perPageSet + 1}">이전</a>

							<!-- 이전페이지 -->
						</c:if>
						<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
							var="p">
							<c:if test="${paging.curPage == p}">
								<a href="myroom.do?page=${p}" style="font-weight: bold">${p}</a>
							</c:if>
							<c:if test="${paging.curPage != p}">
								<a href="myroom.do?page=${p}">${p}</a>
							</c:if>
						</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a
								href="myroom.do?page=${(page-1)-(page-1)%paging.perPageSet + paging.perPageSet + 1}">다음</a>
							<!-- 다음페이지 -->
						</c:if>
					</div>

					<div class="row" style="margin-top: 50px">
						<div class="col-2 col-3-medium col-4-small">
							<Button type="button" onclick="location.href='rform.jsp'">방
								생성</Button>
						</div>
						<div class="col-2 col-3-medium col-4-small" style="align: right">
							<Button type="button" onclick="location.href='logout.do'">로그
								아웃</Button>
						</div>
					</div>
				</section>
			</article>


		</div>

		<!-- Footer -->
		<div id="footer">
			<ul class="copyright">
				<li>&copy; Untitled.</li>
				<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
			</ul>
		</div>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/room.js"></script>

</body>
</html>