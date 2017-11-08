<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/7 0007
  Time: 下午 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<table id="mytb"></table>
</body>
</html>
<script>
    $(function(){
        $.get("${pageContext.request.contextPath}/carAction/findOrder","",function(data){
            $.each(data,function(i,v){
                alert(v.c_no);
            })
        });
    })
</script>
