<%--
  Created by IntelliJ IDEA.
  User: 比特科技
  Date: 2019/6/27
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <script language="javascript">
        function chooseItem(row,obj){
            row = parseInt(row);
        }
        function operateData(param){
            //得到页面所有的checkbox对象
            var selItem = document.getElementsByName("selItem");
            var index=0;  //对操作数量进行定义
            for(var i=0;i<selItem.length;i++){
                //得到一个具体的checkbox对象
                if(selItem[i].checked){
                    index++;
                }
            }
            if(index==0){
                alert('请选择要操作的对象数据!');
            }else if(index==1 && param=='checkboxupdate'){
                //修改-->去到修改的页面
                itemsForm.action='editshowfun.action';
                itemsForm.submit();//提交
            }else if(index>=1 && param=='delete'){
                //删除
                itemsForm.action='deleteIds.action';
                itemsForm.submit();
            }else{
                alert(param+'只能选择一条记录进行操作！');
            }
        }
        //选中最上面一个复选框，则下面的自动全部选择
        function checkall(){
            var selItem = document.getElementsByName("selItem");
            var chooseAll = document.getElementsByName("chooseAll")[0].checked;
            for(var i=0;i<selItem.length;i++){
                selItem[i].checked=chooseAll;
            }
        }
    </script>
</head>
<body>
    <form action="queryItemsList.action" method="post" name="itemsForm">


        <table border="0" align="right">
            <tr>
                <td>
                    <input type="text" name="itemsCustom.name">
                    <input type="submit" value="依据名称查询">
                </td>
                <td>
                    <input type="button" name="addbtn" value="新增" onclick="window.location.href='addItems.action'" class="btn"/>
                    <input type="button" name="modbtn" value="修改" onclick="operateData('checkboxupdate')" class="btn"/>
                    <input type="button" name="delbtn" value="删除" onclick="operateData('delete')" class="btn"/>
                    <input type="button" name="delbtn" value="查询" onclick="window.location.href='queryItemsList.action'" class="btn"/>
                </td>
            </tr>
        </table>

        <table width="100%" border="1" align="center">
            <tr>

                <td>
                    <input type="checkbox"  name="chooseAll" onclick="checkall();"/>
                </td>

                <td>Name</td>
                <td>Price</td>
                <td>Detail</td>
                <td>CreateTime</td>
                <td>Operator</td>
            </tr>
            <c:forEach items="${itemslistKey}" var="items1">
                <tr>
                    <td>
                        <input type="checkbox" name="selItem" value="${items1.id }">
                    </td>
                    <td>${items1.name}</td>
                    <td>${items1.price}</td>
                    <td>${items1.detail}</td>
                    <td>
                        <fmt:formatDate value="${items1.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                    <td>
                        <a href="editshowfun.action?id=${items1.id}">Modify</a><br/>
                        <a href="deleteSingle.action?id=${items1.id}">Delete</a><br/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
