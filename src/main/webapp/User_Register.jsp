<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6 0006
  Time: 上午 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User_Register</h1>
<form action="${pageContext.request.contextPath}/userAction/addUser" method="post">
    姓名：<input name="uname"><br>
    密码：<input name="upwd"><br>
    重复密码：<input name=""><br>
    <input type="submit" value="用户注册">|<a href="index.jsp">取消注册</a>
</form>
</body>
</html>
