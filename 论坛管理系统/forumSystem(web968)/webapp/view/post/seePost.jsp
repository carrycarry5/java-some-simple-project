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
<script type="text/javascript">
window.onload = function(){
	document.getElementById("f").addEventListener("submit",function(){
		var obj=document.getElementById("review");
		if(obj.value ===""){
			alert("回复内容不能为空");
			event.preventDefault();
		} 
	},false);
};
</script>
</head>
<body>
	<div align="center" >
	<form action="/review" method="post" id="f">
		<h1 align="center">葱窝管理信息系统</h1>
		<div class="div1">当前用户：${userName}</div>
		<br>
		<br>
		<br>
		<br>
		&nbsp;&nbsp;&nbsp;<span>作者：${seePost.name}&nbsp;&nbsp;&nbsp;发帖时间：${seePost.postTime}</span><br>
		<br>
		标题：${seePost.title}
		<br>
		<br>
		<textarea rows="5" cols="40" name="message" disabled="disabled">${seePost.postMessage}</textarea><br>
		<br>
		<c:forEach items="${replyList}" var="r">
			<div>${r.replyauthor}&nbsp;回复于&nbsp;${r.time}</div>
			<textarea rows="1" cols="25" disabled="disabled">${r.replyMessage} </textarea>
			<br>
			<br>
		</c:forEach>


		<input type="text" name="reviewMessage" id="review">
		<input type="submit" value="回复"><br>
		<a href="/view/post/post.jsp">返回</a>
	</form>
	</div>
</body>
</html>