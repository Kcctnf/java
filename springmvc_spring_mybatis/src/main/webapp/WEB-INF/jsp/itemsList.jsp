<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="" method="post">
        查询条件
        <table border="1" width="100%">
            <tr>
                <td>
                    <input type="submit" value="查询">
                </td>
            </tr>
        </table>
        商品列表
        <table width="100%" border="1">
            <tr>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>生产日期</td>
                <td>商品描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${itemsExListKey}" var="items">
                <tr>
                    <td>${items.name}</td>
                    <td>${items.price}</td>
                    <td><fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${items.detail}</td>
                    <td>
                        <a href="">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
