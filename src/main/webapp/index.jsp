<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6 0006
  Time: 上午 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>DoLogin</h1>
<form action="${pageContext.request.contextPath}/userAction/doLogin" method="post">
    姓名：<input name="uname"><br>
    密码：<input name="upwd"><br>
    <input type="submit" value="登录">|<a href="User_Register.jsp">用户注册</a>
</form>
</body>
</html>
