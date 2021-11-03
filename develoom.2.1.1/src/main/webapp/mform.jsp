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
			<a href="main.do" class="icon solid fa-home"><span>Home</span></a> <a
				href="myroom.do" class="icon solid fa-folder"><span>Work</span></a> <a
				href="" class="icon solid fa-envelope"><span>Contact</span></a>
			<a href="mform.jsp" class="icon brands fa-twitter active"><span>Twitter</span></a>
		</nav>

		<!-- Main -->
		<div id="main">
			<article id="home" class="panel intro">
				<c:choose>
					<c:when test="${user == null}">
						<header style="margin-top: 50px">
							<h2>Sign Up</h2>
							<br>
							<form action="signup.do" method="post" name="form1">

								<div class="col-4 col-6-medium col-12-small">
									<input type="text" name="email" placeholder="email" required>
								</div>
								<br>
								<div class="col-4 col-6-medium col-12-small">
									<input type="text" name="nickname" placeholder="nickname"
										required>
								</div>
								<br>
								<div class="col-4 col-6-medium col-12-small">
									<input type="password" name="password" placeholder="password"
										required>
								</div>


								<br>
								<div class="col-4 col-6-medium col-12-small">
									<input type="submit" value="회원가입">
								</div>

							</form>
						</header>

						<a href="login.jsp" class="jumplink pic"> <span
							class="arrow icon solid fa-chevron-left"><span>See
									my work</span></span> <img src="images/me.jpg" alt="" />
						</a>
					</c:when>
					<c:otherwise>
						<header style="margin-top: 50px">
							<h2>Edit Member</h2>
							<br>
							<form action="mupdate.do" method="post" name="form2">
								<div class="col-4 col-6-medium col-12-small">
									<input type="text" name="email" placeholder="email"
										value="${user.email}" readonly required>
								</div>
								<br>
								<div class="col-4 col-6-medium col-12-small">
									<input type="text" name="nickname" placeholder="nickname"
										value="${user.nickname}" required>
								</div>
								<br>
								<div class="col-4 col-6-medium col-12-small">
									<input type="password" name="password" placeholder="password"
										value="${user.password}" required>
								</div>

								<br>
								<div class="col-4 col-6-medium col-12-small">
									<input type="submit" value="정보 수정">&nbsp;<input type="button" value="회원 탈퇴">
								</div>
							</form>
						</header>

						<a href="main.do" class="jumplink pic"> <span
							class="arrow icon solid fa-chevron-left"><span>See
									my work</span></span> <img src="images/me.jpg" alt="" />
						</a>
					</c:otherwise>
				</c:choose>
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