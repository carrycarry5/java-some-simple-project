<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">葱曲信息管理系统</h1>
	<form action="/update2" method="get" >
		<table align="center" cellspacing="10px" >
			<tr>
				<td colspan="2" align="center"><h3>修改歌曲信息</h3></td>
			</tr>
			<tr>
				<td>歌曲名：</td>
				<td><input type="text" name="name" value="${song.name}"></td>
			</tr>
			<tr>
				<td>p主：</td>
				<td><input type="text" name="author" value="${song.author}"></td>
			</tr>
			<tr>
				<td>歌手：</td>
				<td><input type="text" name="singer" value="${song.singer}"></td>
			</tr>
			<tr>
				<td>发行年月：</td>
				<td><input type="text" name="releaseTime" value="${song.releaseTime}"></td>
			</tr>
			<tr>
				<td>专辑：</td>
				<td><input type="text" name="albums" value="${song.albums}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>