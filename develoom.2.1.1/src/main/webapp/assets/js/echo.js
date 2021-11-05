/**
 * 
 */


		function download(filename, textInput) {

			var element = document.createElement('a');
			element.setAttribute('href', 'data:text/plain;charset=utf-8, '
					+ encodeURIComponent(textInput));
			element.setAttribute('download', filename);
			document.body.appendChild(element);
			element.click();
		}
		document.getElementById("downBtn").addEventListener("click",
				function() {
					const element = document.getElementById("messages");
					var text = element.innerText;

					var filename = "${user.email}${param.rpk}.txt";
					download(filename, text);
				}, false);
	
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
