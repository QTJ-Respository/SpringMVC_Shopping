<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/7 0007
  Time: 下午 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>

<table id="mytb" border="1">
    <tr>
        <td>名称</td><td>价格</td><td>日期</td><td>产地</td><td>图片</td><td>管理</td>
    </tr>
</table>
</body>
</html>
<script>
    //查询所有商品
    $(function(){
        $("#mytb tr:not(:first)").remove();
        $.get("${pageContext.request.contextPath}/goodsAction/showAllGoods","",function(data){
            $.each(data,function(i,v){
                var str = "<tr>";
                str += "<td>"+v.gname+"</td>";
                str += "<td>"+v.gprice+"</td>";
                var time=new Date(v.gintime);
                str += "<td>"+time.getFullYear()+"</td>";
                str += "<td>"+v.ghome+"</td>";
                str += "<td><img src='"+v.gimg+"'></td>";
                str += "<td><a href='${pageContext.request.contextPath}/goodsAction/findIDGoods?gid="+v.gno+"'>详情</a></td>";
                str += "</tr>";
                $("#mytb").append(str);
            });
        },"json");
    })
</script>

