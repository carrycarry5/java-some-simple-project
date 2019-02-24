<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.div1{
	float : right;
}

</style>
</head>
<body>
	<h1 align="center">葱窝管理信息系统</h1>
	<div class="div1">当前用户：${userName}</div>
	<br>
	<br>
	<br>
	<br>

	<div align="center" >
	<form action="/sendPost" method="post">
		标题：<input type="text" name="title" size="32"><br>
		<textarea rows="5" cols="40" name="message"></textarea><br>
		<input type="submit" value="发送">
	</form>
	</div>
</body>
</html>