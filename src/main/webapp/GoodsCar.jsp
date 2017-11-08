<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/7 0007
  Time: 上午 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/carAction/addGoodsCar" method="post" enctype="multipart/form-data">
    <input  value="${goods.gno}" name="gid"><br>
    <input  value="${goods.gimg}" name="gimg"><br>
    名称：<input value="${goods.gname}" name="gname"><br>
    价格：<input value="${goods.gprice}" name="gprice"><br>
    日期：<input value="${goods.gintime}" name="gintime"><br>
    商家：<input value="${goods.ghome}" name="ghome"><br>
    购买数量:<input name="c_num">
    <input type="submit" value="提交订单">
</form>
</body>
</html>
