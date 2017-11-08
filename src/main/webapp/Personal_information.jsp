<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6 0006
  Time: 上午 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Personal information</h1>
<form method="post" action="${pageContext.request.contextPath}/userAction/uploadFile" enctype="multipart/form-data">
    姓名：<input value="${user.uname}" name="u_name"><br>
    性别：<input name="u_sex" type="radio" value="男" checked>男
          <input name="u_sex" type="radio" value="女">女<br>
    电话：<input name="u_tel"><br>
    出身：<input name="u_Birth" type="date"><br>
    邮寄：<input name="u_email"><br>
    头像：<input name="ufile" type="file"><br>
    <input type="hidden" name="user.uno" value="${user.uno}">
    <input type="submit"value="保存信息"><a href="index.jsp">取消保存</a>
</form>
</body>
</html>
