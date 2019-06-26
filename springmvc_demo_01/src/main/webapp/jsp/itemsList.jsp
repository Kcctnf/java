<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/item/queryItem.action" method="post">
        商品查询
        <table border="1" width="100%">
            <tr>
                <td>
                    <input type="submit" value="查询">
                </td>
            </tr>
        </table>
        商品展示
        <table border="1" width="100%">
            <tr>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>商品明细</td>
                <td>创建时间</td>
            </tr>
            <c:forEach items="${itemsListKey}" var="myVar">
                <tr>
                    <td>${myVar.name}</td>
                    <td>${myVar.price}</td>
                    <td>${myVar.detail}</td>
                    <td>    
                        <fmt:formatDate value="${myVar.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/item/editItems?id=${myVar.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
