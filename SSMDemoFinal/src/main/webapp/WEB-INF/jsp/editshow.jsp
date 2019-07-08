<%--
  Created by IntelliJ IDEA.
  User: 比特科技
  Date: 2019/7/1
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑页面</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>

    <form action="editShowCommitFun.action" method="post">
        <input type="hidden" name="id" value="${itemsCustomKey.id}">
        Name: <input type="text" name="name" value="${itemsCustomKey.name}"><br/>
        Price:<input type="text" name="price" value="${itemsCustomKey.price}"/><br/>
        CreateTime:<input type="text" name="createtime" value="<fmt:formatDate value="${itemsCustomKey.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/><br/>
        Detail: <textarea name="detail">${itemsCustomKey.detail}</textarea><br/>
        <input type="submit" value="修改">
    </form>
</body>
</html>
