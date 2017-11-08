<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6 0006
  Time: 下午 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>AddGoods</h1>
<div style="font-size: 18px">
    <c:if test="${param.rtype==1}">
    <p style="color:green;">添加成功!</p>
    </c:if>
    <c:if test="${param.rtype==-1}">
    <p style="color:red;">添加失败!</p>
    </c:if>
<form action="${pageContext.request.contextPath}/goodsAction/addGoods" method="post" enctype="multipart/form-data">
    名称：<input name="gname"><br>
    价格：<input name="gprice"><br>
    日期：<input name="gintime" type="date"><br>
    商家：<input name="ghome"><br>
    状态：<input name="gstate" type="radio" value="1">已上架
          <input name="gstate" type="radio" value="0">已下架<br>
    图片：<input name="ufile" type="file"><br>
    <input type="submit" value="添加">|<a href="${pageContext.request.contextPath}/ShowAllGoods.jsp">管理商品</a>|<a href="${pageContext.request.contextPath}/ShoppingInfo.jsp">返回主页</a>
</form>
</body>
</html>
