<%--
  Created by IntelliJ IDEA.
  User: 比特科技
  Date: 2019/6/27
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="xxxx" method="post">
        <table width="100%" border="1" align="center">
            <tr>
                <td>Name</td>
                <td>Price</td>
                <td>Detail</td>
                <td>CreateTime</td>
                <td>Operator</td>
            </tr>
            <c:forEach items="${itemslistKey}" var="items1">
                <tr>
                    <td>${items1.name}</td>
                    <td>${items1.price}</td>
                    <td>${items1.detail}</td>
                    <td>
                        <fmt:formatDate value="${items1.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                    <td>
                        <a href="xxxx">Modify</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
