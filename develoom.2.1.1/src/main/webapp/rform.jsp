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
				href="myroom.do" class="icon solid fa-folder"><span>Work</span></a>
			<a href="" class="icon solid fa-envelope active"><span>Contact</span></a>
			<a href="mform.jsp" class="icon brands fa-twitter"><span>Twitter</span></a>
		</nav>

		<!-- Main -->
		<div id="main">
			<article id="home" class="panel intro">
				<c:choose>
					<c:when test="${rdata == null}">
						<header>
							<h2>Create Room</h2>
							<br>
							<form action="rinsert.do" method="post" name="form1"
								enctype="multipart/form-data">
								<input type="hidden" name="email" value="${user.email}">
								<div class="col-6col-6-medium col-12-small">
									<input type="text" name="roomname" placeholder="roomname"
										required>
								</div>
								<br>
								<div class="col-6 col-6-medium col-12-small">
									<input type="password" name="password" placeholder="password"
										required>
								</div>
								<div class="col-6 col-6-medium col-12-small">
									<input type="file" name="fileupload" id = "imageSelector" accept="image/jpeg, image/jpg, image/png">
								</div>

								<div class="col-6 col-6-medium col-12-small"
									style="margin-top: 50px">
									<input type="submit" value="방 생성">
								</div>

							</form>
						</header>
						<a href="myroom.do" class="jumplink pic"> <span
							class="arrow icon solid fa-chevron-left"><span>See
									my work</span></span> <img src="images/me.jpg" alt="기본 이미지" class = "thumb"/>
						</a>
					</c:when>
					<c:otherwise>
						<header>
							<h2>Edit Room</h2>
							<br>
							<form action="rupdate.do" method="post" name="form2"
								enctype="multipart/form-data">
								<input type="hidden" name="rpk" value="${rdata.rpk}">
								<input type="hidden" name="email" value="${user.email}">
								<input type="hidden" name="filepath" value ="${rdata.filepath}">
								<div class="col-6col-6-medium col-12-small">
									<input type="text" name="roomname" placeholder="roomname"
										value="${rdata.roomname}" required>
								</div>
								<br>
								<div class="col-6 col-6-medium col-12-small">
									<input type="password" name="password" placeholder="password"
										value="${rdata.password}" required>
								</div>
								<div class="col-6 col-6-medium col-12-small">
									<input type="file" name="fileupload" id = "imageSelector" accept="image/jpeg, image/jpg, image/png">
								</div>

								<div class="col-6 col-6-medium col-12-small"
									style="margin-top: 50px">
									<input type="submit" value="방 수정"> &nbsp; <input
										type="button" value="방 삭제"
										onclick="location.href='rdelete.do?rpk=${rdata.rpk}&filepath=${rdata.filepath}'">
								</div>


							</form>
						</header>
						<a href="myroom.do" class="jumplink pic"> <span
							class="arrow icon solid fa-chevron-left"><span>See
									my work</span></span> <img src="images/${rdata.filepath}" alt="수정 이미지" class = "thumb"/>
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
	 <script src="assets/js/upload.js"></script>

</body>
</html>