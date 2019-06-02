<%@ page import="com.dong.vo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/29
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<User> userList = (List<User>) request.getSession().getAttribute("userList_key");
    for(Iterator it = userList.iterator(); it.hasNext();){
        User user = (User) it.next();
%>


<tr>
    <th>Id</th>
    <th>UserName</th>
    <th>password</th>
</tr>
<tr>
    <td>
        <%=user.getUserid()%>
    </td>
    <td>
        <%=user.getUsername()%>
    </td>
    <td>
        <%=user.getPassword()%>
    </td>
</tr>
<%}%>
</table>


</body>
</html>
