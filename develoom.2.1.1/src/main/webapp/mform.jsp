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
<link rel="develoom icon" href="images/develoom.ico">
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
									<input type="submit" value="????????????">
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
									<input type="submit" value="?????? ??????">&nbsp;<input
										type="button" value="?????? ??????"
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
	         type: "GET", // ?????? ?????? ?????? ????????? GET, ????????? ?????? ????????? insert/update??? ????????? POST
	         url: "check.do", /////////// ???????
	         data: {
	            email : $("#email").val() // $().val() : ??? ????????????
	         },
	         success: function(data) { 
	        	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	        	console.log(data);
	            if (data.trim()=="false") {
	               for(var i=0; i<document.form1.email.value.length; i++){ // ????????? ????????????
	                  ch=document.form1.email.value.charAt(i) // char???????????? ??????
	             	if (document.form1.email.value.length<4 || document.form1.email.value.length>20) {
	                     $("#check").css("color","red");
	                     $("#check").css("margin-top","-5px");
	                     $("#check").css("margin-bottom","0px");
	                     $("#check").css("font-size","small");
	                     $("#check").text("???????????? 4~20????????? ??????????????????.");
	                    }
	                  else if(document.form1.email.value.match(regExp) == null){  
	                       $("#check").css("color","red");
	                       $("#check").css("margin-top","-5px");
	                       $("#check").css("margin-bottom","0px");
	                       $("#check").css("font-size","small");
	                       $("#check").text("????????? ????????? ????????? ????????????.");
	                  }
	                  else{
	                     $("#check").css("color","green");
	                     $("#check").css("margin-top","-5px");
	                     $("#check").css("margin-bottom","0px");
	                     $("#check").css("font-size","small");
	                     $("#check").text("?????? ????????? ??????????????????.");
	                  }
	              
	               }               
	               /* alert("?????? ????????? ID?????????."); */
	            } else {
	               $("#check").css("color","red");
	               $("#check").css("margin-top","-5px");
	               $("#check").css("margin-bottom","0px");
	               $("#check").css("font-size","small");
	               $("#check").text("???????????? ?????? ???????????????. ?????? ???????????????.");
	               /* alert("ID??? ?????? ???????????????. ?????? ???????????????."); */
	            }
	         },
	         error: function(xhr) {
	            console.log(xhr.status + " : " + xhr.errorText);
	            alert("????????????!");
	         }
	      });
	   }
	
	 function send(){
	      // ????????? ????????? ??????(4~12??????)
	      if (document.form1.email.value.length<4 || document.form1.email.value.length>20) {
	            alert("???????????? 4~20????????? ??????????????????.")
	            document.form1.email.focus();
	            document.form1.email.select();
	            return false;
	        }
	      // ???????????? ????????? ??????(4~16??? ?????? ??????)
	        if (document.form1.password.value.length<4 || document.form1.password.value.length>16) {
	            alert("??????????????? 4~16????????? ??????????????????.")
	            document.form1.password.focus();
	            document.form1.password.select();
	            return false;
	        }
	         // ????????? ????????? ??????
	         var regExp = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	         if(document.form1.email.value.match(regExp) == null) {
				alert('????????? ????????? ????????? ????????????.')
				document.form1.email.value = ""
				document.form1.email.focus();
				return false;
	       }
	   }
	</script>

</body>
</html>