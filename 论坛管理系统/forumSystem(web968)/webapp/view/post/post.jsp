<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	<center><button onclick="sendPost()">发帖</button></center>
	<br>
	<br>
	<div align="center">
		<c:forEach items="${postList}" var="p">
			<span>贴子编号：${p.id}</span><span>&nbsp;&nbsp;作者：${p.name}</span><span>&nbsp;&nbsp;&nbsp;发帖时间：${p.postTime}</span><br>
			<div><a href="/seePost?id=${p.id}" >标题：${p.title}</a></div>
		</c:forEach>
	</div>
	
</body>
<script type="text/javascript">
	function sendPost(){
		window.open("/view/post/sendPost.jsp");
	}
	
</script>
</html>