<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
   %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.add{
			font-size:25px;
		}
		.table1{
			width:1000px;
		}
	</style>
</head>
<body>
	<h1 align="center">葱曲信息管理系统</h1>
	<%--歌曲名、作者、演唱者、发行年月、专辑 --%>
	<div class="div1">
		<table class="table1"  align="center" border="1px">
			<tr>
				<td>歌曲名</td>
				<td>p主</td>
				<td>歌手</td>
				<td>发行日期</td>
				<td>专辑</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="s">
				<tr>
					<td>${s.name}</td>
					<td>${s.author}</td>
					<td>${s.singer}</td>
					<td>${s.releaseTime}</td>
					<td>${s.albums}</td>	
					<td><a href="/delete?name=${s.name}">删除</a>/
							<a href="/update?name=${s.name}">修改</a>/
							<a href="/group?author=${s.author}" >查看该p主的歌单</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<center><a href="/add.jsp" class="add">添加歌曲</a></center>
	</div>
</body>
</html>