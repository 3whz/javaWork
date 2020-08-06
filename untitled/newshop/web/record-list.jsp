<%--
  Created by IntelliJ IDEA.
  User: boen
  Date: 2020/5/27
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>记录表</title>
</head>
<link rel="stylesheet" href="css/record.css">
<body>
<ul>
    <li>总金额为：<span>￥${r_manay}</span></li>
<c:forEach items="${r_list}" var="r_lis" varStatus="status">
    <li><span>${r_lis.u_name}</span>在<span>${r_lis.time}</span>花费<span>￥${r_lis.p_many}</span>购买了<span>${r_lis.p_name}</span></li>
</c:forEach>
</ul>
</body>
</html>
