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
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper-->
	<div id="wrapper">

		<!-- Nav -->
		<nav id="nav">
			<a href="#home" class="icon solid fa-home"><span>Home</span></a> <a
				href="#work" class="icon solid fa-folder"><span>Work</span></a> <a
				href="#contact" class="icon solid fa-envelope"><span>Contact</span></a>
			<a href="https://twitter.com/ajlkn" class="icon brands fa-twitter"><span>Twitter</span></a>
		</nav>

		<!-- Main -->
		<div id="main">
			<article id="work" class="panel">
				<header>
					<h2>Work</h2>
				</header>
				<p>Phasellus enim sapien, blandit ullamcorper elementum eu,
					condimentum eu elit. Vestibulum ante ipsum primis in faucibus orci
					luctus et ultrices posuere cubilia luctus elit eget interdum.</p>
				<section>
					<div class="row">

						<c:forEach var="v" items="${rdatas}">
							<div class="col-4 col-6-medium col-12-small">
								<a href="room.do?rpk=${v.rpk}" class="image fit"> <img
									src="images/pic01.jpg" alt="">
								</a>
							</div>
						</c:forEach>

						<%-- ${v.email} ${v.roomname}${v.password} ${v.rdatetime} --%>

					</div>
					
					<div class="row" style="margin-top:50px">
						<div class="col-2 col-3-medium col-4-small">
							<Button type="button" onclick="location.href='rinsert.jsp'">방
								생성</Button>
						</div>
						<div class="col-2 col-3-medium col-4-small">
							<Button type="button" onclick="location.href='signout.do'">회원 탈퇴</Button>
						</div>
						<div class="col-2 col-3-medium col-4-small">
							<Button type="button" onclick="location.href='logout.do'">로그 아웃!!!!</Button>
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

</body>
</html>