<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>poppro | 用户注册</title>
	<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" align="center">
		<tr>
			<td width="15%" height="80px"><img src="img/logo.png"></td>
			<td width="60%">
				<table align="center"  width="30%">
					<tr>
						<td><img src="img/search-ico-1-on.jpg" width="30px" height="30px"></td>
						<td>
							<input type="text" style="width: 200px ; height: 20px" value="   初音" >
						</td>
						<td><img src="img/search-ico-2-on.png" width="42px" height="32px"></td>
					</tr>
				</table>	
			</td>
			<td align="center">
				<table>
					<tr>
						<td><img  src="img/search-ico-5.png" width="30px" height="30px"></td>
						<td>登录/注册</td>
					</tr>
				</table>
			</td>

			<td align="center">
				<table>
					<tr>
						<td><img  src="img/search-ico-3-on.png" width="30px" height="30px"></td>
						<td>我要投稿</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

<div class="div1">
	<table width="100%" >
		<tr>
			<td width="14%" height="80px">
				<a href="#">首页</a>
			</td>
			<td  width="14%">
				<a href="#">音乐作品</a>
			</td>
			<td  width="14%">
				<a href="#">画作/3D模型</a>
			</td>
			<td  width="14%">
				<a href="#">文字作品</a>
			</td>
			<td  width="14%">
				<a href="#">官方征稿</a>
			</td>
			<td  width="14%">
				<a href="#">小组创作</a>
			</td>
			<td  width="14%">&nbsp;</td>
		</tr>
	</table>
</div>
<center>
<div class="div2">
	<table class="table1">
		<tr>
			<td class="td1">
				<form action="/saveUserServlet" method="post">
					<ul>
						<li><h1>用户注册</h1></li>
						<li>您的Email地址:</li>
						<li><input  class="input1" type="text" name = "email"></li>
						<li><c:if test="${emailExist==-1}">
							<span class="span2">邮箱已经被注册过了</span>
						</c:if>
						</li>
						
						<li>您的密码:</li>
						<li><input class="input1" type="password" name="password"></li>
						<li>请确认密码：</li>
						<li><input class="input1" type="password" name = "repassword"></li>
						<li><c:if test="${PasswordError==-1}">
							<span class="span2">密码与确认密码不一致，请重新输入。</span>
						</c:if>
						</li>
						<li><input class="input2" type="submit" value="立即注册"></li>
						<li><span>已经有POPPRO账户？<a href="/login.jsp">立即登录</a></span>
					</ul>
			</form>
			</td>
			<td>
				<ul>
					<li>
						您也可以使用合作网站登录
					</li>
					<li>
						<img src="img/QQlogo.png">
					</li>
				</ul>
			</td>
		</tr>
	</table>
</div>
</center>
<div class="div3">
	<div class="div4">
		<table>
			<tr>
				<td>
					<ul class="ul1">
						<li>
							<img src="img/botton1.png" >
						</li>
						<li>
							<img src="img/botton2.png">
						</li>
					</ul>
				</td>
				<td>
						<div class="div5">
							<img src="img/二维码.jpg" width="100px" height="100px">
						</div>
				</td>
			</tr>
		</table>
		
	</div>
</div>
</body>
</html>