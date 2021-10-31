<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper-->
	<div id="wrapper">

		<!-- Nav -->
		<nav id="nav"> <a href="#home" class="icon solid fa-home"><span>Home</span></a>
		<a href="#work" class="icon solid fa-folder"><span>Work</span></a> <a
			href="#contact" class="icon solid fa-envelope active"><span>Contact</span></a>
		<a href="https://twitter.com/ajlkn" class="icon brands fa-twitter"><span>Twitter</span></a>
		</nav>

		<!-- Main -->
		<div id="main">
			<article id="work" class="panel"> <header>
			<h2>Room</h2>
			</header>
			<section>
			<div class="row">
				<div>
					<button type="button" onclick="openSocket();">대화방 참여</button>
					<button type="button" onclick="closeSocket();">대회방 나가기</button>
				<div id="messages" style="overflow:auto; height:30em; width:40em; word-break:break-all;"></div>
					<br /> <br /> <br /> 메세지 입력 : <input type="text" id="sender"
						value="${user.email}" style="display: none;"> <input
						type="text" id="messageinput"> <input type="hidden" id="rpk" name = "rpk"
						value="${param.rpk}" readonly>
					<button type="button" onclick="send();">메세지 전송</button>
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

		function openSocket() {
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
				messages.scrollTop=messages.scrollHeight; //스크롤 맨 아래고정
			};
			ws.onclose = function(event) {
				writeResponse("대화 종료");
			}
		}
		function send() {
			var text = document.getElementById("messageinput").value + ","
					+ document.getElementById("sender").value;
			ws.send(text);
			console.log(text);
			text = "";
		}

		function closeSocket() {
			ws.close();
			location.href = "main.do";
		}

		function writeResponse(text) {
			messages.innerHTML += "<br/>" + text;
		}
	</script>
</body>
</html>