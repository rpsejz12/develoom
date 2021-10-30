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
				href="#contact" class="icon solid fa-envelope active"><span>Contact</span></a>
			<a href="https://twitter.com/ajlkn" class="icon brands fa-twitter"><span>Twitter</span></a>
		</nav>

		<!-- Main -->
		<div id="main">
			<!-- <article id="contact" class="panel">
				<header>
					<h2>Sign Up</h2>
				</header>
				<section>
					<div class="column">
						<form action="signup.do" method="post">
							<div class="col-6 col-6-medium col-12-small"><span>ID</span></div>
							<div class="col-6 col-6-medium col-12-small">
								<input type="text" name="email" required>
							</div>
							<div class="col-6 col-6-medium col-12-small">Nick Name</div>
							<div class="col-6 col-6-medium col-12-small">
								<input type="text" name="nickname" required>
							</div>

							<div class="col-6 col-6-medium col-12-small">Password</div>
							<div class="col-6 col-6-medium col-12-small">
								<input type="password" name="password" required>
							</div>

							<div class="col-6 col-6-medium col-12-small" style="margin-top:50px">
								<input type="submit" value="회원가입">
							</div>

						</form>
					</div>
				</section>
			</article> -->

			<article id="home" class="panel intro">
				<header style="margin-top: 50px">
					<h2>Sign Up</h2>
					<br>
					<form action="signup.do" method="post" name="form1">
						<div class="col-4 col-6-medium col-12-small">
							<input type="text" name="email" placeholder = "email" required>
						</div>
						<br>
						<div class="col-4 col-6-medium col-12-small">
							<input type="text" name="nickname" placeholder = "nickname" required>
						</div>
						<br>
						<div class="col-4 col-6-medium col-12-small">
							<input type="password" name="password" placeholder = "password" required>
						</div>

						<br>
						<div class="col-4 col-6-medium col-12-small">
							<input
								type="button" value="회원가입" onclick="location.href='signup.jsp'">
						</div>
					</form>
				</header>

				<a href="login.jsp" class="jumplink pic"> <span
					class="arrow icon solid fa-chevron-left"><span>See
							my work</span></span> <img src="images/me.jpg" alt="" />
				</a>
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