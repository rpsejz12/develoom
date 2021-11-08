<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
	Astral by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Astral by HTML5 UP</title>
<meta http-equiv="Content-Type">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="develoom icon" href="images/develoom.ico">
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper-->
	<div id="wrapper">

		<!-- Nav -->
		<nav id="nav"> <a href="#home" class="icon solid fa-home"><span>Home</span></a>
		<a href="" class="icon solid fa-folder"><span>Work</span></a> <a
			href="" class="icon solid fa-envelope active"><span>Contact</span></a>
		<a href="" class="icon brands fa-twitter"><span>Twitter</span></a> </nav>

		<!-- Main -->
		<div id="main">
			<article id="work" class="panel"> <header>
			<h2>
				Room
				<button type="button" onclick="location.href='chatlog.do?rpk=${param.rpk}'"
					style="float: right; margin-left: 10px">채팅 다운로드</button>

				<button type="button" onclick="closeSocket();" style="float: right;">대회방
					나가기</button>
			</h2>


			</header> <section>
			<div class="row">
				<div>
					<br>
					<div id="messages"
						style="overflow: auto; height: 20em; width: 40em; word-break: break-all;">
						<c:forEach var="v" items="${cdatas}">
							<c:if test="${v.email== user.email}">&lt;나&gt;</c:if>
							<c:if test="${v.email!= user.email}">${v.nickname}</c:if> : ${v.content}<br>
						</c:forEach>
					</div>
					<br />
					<div>
						<br /> <input type="hidden" id="sender" value="${user.email},${user.nickname}">
						<textarea id="messageinput" onkeydown="onKeydown()"
							onkeyup="onKeyup()"
							style="resize: none; width: 80%; height: 100px;"></textarea>
						<input type="hidden" id="rpk" name="rpk" value="${param.rpk}"
							readonly>
						<button type="button" onclick="send();" id="send"
							style="float: right">메세지 전송</button>
					</div>
				</div>
				<!-- Server responses get written here -->
			</div>
			</section> </article>


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
	<script type="text/javascript">
		var ws;
		var messages = document.getElementById("messages");

		var app = function() {
			if (ws !== undefined && ws.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
			}
			//웹소켓 객체 만드는 코드
			ws = new WebSocket("ws://localhost:8066/echo.do/${param.rpk}");
			ws.onopen = function(event) {
				if (event.data === undefined) {
					return;
				}
				writeResponse(event.data);
			};
			ws.onmessage = function(event) {
				console.log('writeResponse');
				console.log(event.data)
				writeResponse(event.data);
				messages.scrollTop = messages.scrollHeight; //스크롤 맨 아래고정
			};
			ws.onclose = function(event) {
				writeResponse("대화 종료");
			}
		};

		function send() {
			var text = document.getElementById("messageinput").value + ","
					+ document.getElementById("sender").value;
			ws.send(text);
			console.log(text);
			text = "";
			$('textarea').val('');
		}

		function closeSocket() {
			ws.close();
			location.href = "main.do";
		}

		function writeResponse(text) {
			messages.innerHTML += "<br/>" + text;
		}

		function onKeydown() {
			if (event.keyCode == 13) {
				document.getElementById('send').click();
			}
		}

		function onKeyup() {
			if (event.keyCode == 13) {
				$('textarea').val('');
			}
		}

		app();
	</script>

</body>
</html>