<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="rinsert.do" method="post">
	<input type = "hidden" name = "email" value="${user.email}">
		<table border="1">
			<tr>
				<td>Room Name</td>
				<td><input type="text" name="roomname" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>

</body>
</html>