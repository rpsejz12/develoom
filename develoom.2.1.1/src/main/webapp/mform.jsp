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
			<a href="" class="icon solid fa-envelope"><span>Contact</span></a> <a
				href="mform.jsp" class="icon brands fa-twitter active"><span>Twitter</span></a>
		</nav>

		<!-- Main -->
		<div id="main">
			<article id="home" class="panel intro">
				<c:choose>
					<c:when test="${user == null}">
						<header style="margin-top: 50px">
							<h2>Sign Up</h2>
							<br>
							<form action="signup.do" method="post" name="form1" onsubmit="return send();">

								<div class="col-4 col-6-medium col-12-small">
									<input type="email" name="email" id="email" onkeyup="checkId()" placeholder="email" required>
								</div>
								<p id="check" style="margin-bottom: -5px;"></p>
								<br>
								<div class="col-4 col-6-medium col-12-small">
									<input type="text" name="nickname" placeholder="nickname"
										required>
								</div>
								<br>
								<div class="col-4 col-6-medium col-12-small">
									<input type="password" name="password" placeholder="password"
										id = "password" required>
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
									<input type="email" name="email" placeholder="email" id="email"
										value="${user.email}" readonly required>
								</div>
								<p id="check" style="margin-bottom: -5px;"></p>
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
									<input type="submit" value="정보 수정">&nbsp;<input
										type="button" value="회원 탈퇴"
										onclick="location.href='signout.do'">
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
	<script type="text/javascript">
	function checkId(){
	      $.ajax({ 
	         type: "GET", // 단순 정보 조회 시에는 GET, 정보가 너무 많거나 insert/update를 할때는 POST
	         url: "check.do", /////////// ???????
	         data: {
	            email : $("#email").val() // $().val() : 값 가져오기
	         },
	         success: function(data) { 
	        	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	        	console.log(data);
	            if (data.trim()=="false") {
	               for(var i=0; i<document.form1.email.value.length; i++){ // 아이디 길이체크
	                  ch=document.form1.email.value.charAt(i) // char타입으로 변환
	             	if (document.form1.email.value.length<4 || document.form1.email.value.length>20) {
	                     $("#check").css("color","red");
	                     $("#check").css("margin-top","-5px");
	                     $("#check").css("margin-bottom","0px");
	                     $("#check").css("font-size","small");
	                     $("#check").text("이메일을 4~20자까지 입력해주세요.");
	                    }
	                  else if(document.form1.email.value.match(regExp) == null){  
	                       $("#check").css("color","red");
	                       $("#check").css("margin-top","-5px");
	                       $("#check").css("margin-bottom","0px");
	                       $("#check").css("font-size","small");
	                       $("#check").text("올바른 이메일 형식이 아닙니다.");
	                  }
	                  else{
	                     $("#check").css("color","green");
	                     $("#check").css("margin-top","-5px");
	                     $("#check").css("margin-bottom","0px");
	                     $("#check").css("font-size","small");
	                     $("#check").text("사용 가능한 이메일입니다.");
	                  }
	              
	               }               
	               /* alert("사용 가능한 ID입니다."); */
	            } else {
	               $("#check").css("color","red");
	               $("#check").css("margin-top","-5px");
	               $("#check").css("margin-bottom","0px");
	               $("#check").css("font-size","small");
	               $("#check").text("이메일이 이미 존재합니다. 다시 입력하세요.");
	               /* alert("ID가 이미 존재합니다. 다시 입력하세요."); */
	            }
	         },
	         error: function(xhr) {
	            console.log(xhr.status + " : " + xhr.errorText);
	            alert("에러발생!");
	         }
	      });
	   }
	
	 function send(){
	      // 아이디 유효성 검사(4~12글자)
	      if (document.form1.email.value.length<4 || document.form1.email.value.length>20) {
	            alert("이메일을 4~20자까지 입력해주세요.")
	            document.form1.email.focus();
	            document.form1.email.select();
	            return false;
	        }
	      // 비밀번호 유효성 검사(4~16자 까지 허용)
	        if (document.form1.password.value.length<4 || document.form1.password.value.length>16) {
	            alert("비밀번호를 4~16자까지 입력해주세요.")
	            document.form1.password.focus();
	            document.form1.password.select();
	            return false;
	        }
	         // 이메일 유효성 검사
	         var regExp = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	         if(document.form1.email.value.match(regExp) == null) {
				alert('올바른 이메일 형식이 아닙니다.')
				document.form1.email.value = ""
				document.form1.email.focus();
				return false;
	       }
	   }
	</script>

</body>
</html>