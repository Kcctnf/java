<%--
  Created by IntelliJ IDEA.
  User: 比特科技
  Date: 2019/7/8
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>AddPage</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
    <form action="addItemsSubmit.action" method="post">
        name: <input type="text" name="name"><br>
        price: <input type="text" name="price"><br>
        <%--createtime:<input type="text" name="createtime"><br>--%>
        detail:<textarea name="detail"></textarea><br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
