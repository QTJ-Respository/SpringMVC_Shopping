<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/7 0007
  Time: 上午 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>ShowAllGoods</h1>
<form action="${pageContext.request.contextPath}/goodsAction/LikeSelect" method="post">
名称：<input name="goodsname">&nbsp;价格：<input name="goodsprice">
    <input type="submit" value="查询">
</form>

<table id="mytb" border="1">
<tr>
    <td>名称</td><td>价格</td><td>日期</td><td>产地</td><td>状态</td><td>图片</td><td>管理</td>
</tr>
</table>
</body>
</html>
<script>
    //根据名称查询



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
                    str += "<td>"+(v.gstate==1?'<a href=\'${pageContext.request.contextPath}/goodsAction/GoodsUP?gid='+v.gno+'\'>已上架</a>':'<a href=\'${pageContext.request.contextPath}/goodsAction/GoodsDown?gid='+v.gno+'\'>已下架</a>')+"</td>";
                    str += "<td><img src='${pageContext.request.contextPath}/images"+v.gimg+"'></td>";
                    str += "<td><a href='#'>修改</a></td>";
                    str += "</tr>";
                $("#mytb").append(str);
            });
        },"json");
    })
</script>
