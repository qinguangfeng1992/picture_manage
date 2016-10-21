<%--
  Created by IntelliJ IDEA.
  User: MeiLeLe19
  Date: 2016/10/8
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<%--   <meta http-equiv="refresh" content="2">--%>
<head>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        ul li {
            list-style: none;
            float: left;
            padding: 4px;
        }

        .wrap {
            width: 80%;
            margin: 0 auto;
        }

        .wrap ul {
            display: block;
        }
    </style>
    <%-- <script type="text/javascript" src="../../js/jquery-3.0.0.js"></script>--%>
    <script>

        function returnAdd() {
            location.href = "topicadd";

        }
        function returnEdit(op) {
            location.href = "editpic?picid=" + op;

        }
        /* function openwin(op) {
         window.open ("editpic?picid=" + op, "newwindow", "height=500, width=700,top=100,left=350, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")

         }*/

        /* setInterval(function () {
         window.history.reload();
         }, 3000);*/

        $(function () {
            $(".dele").click(function () {
                if (confirm("您确认删除吗？")) {
                    var pid = $(this).attr("title");
                    $.post("deletepic", {picid: pid}, function (data) {
                        if (data == 1) {
                            alert("删除成功")
                            location.reload();
                        } else {
                            alert("删除失败")
                            location.reload();
                        }
                    });
                }
            });
        });
    </script>
    <title>首页</title>


</head>
<body>
<div class="wrap">
    <h1 align="center">图片信息管理</h1>
    <table style="width: 100%;" align="center" class="table table-striped table-bordered table-hover ">
        <tr>
            <td height="39" colspan="5" align="right"><input class="btn btn-success" type="button" onClick="returnAdd()"
                                                             value="新增"></td>
        </tr>
        <tr>
            <td height="52" align="center">套图标题</td>
            <td align="center">缩略图</td>
            <td align="center">分类名称</td>
            <td align="center">创建时间</td>
            <td align="center">操作</td>


        </tr>
        <c:forEach items="${pplist.content}" var="lis">
        <tr>
            <td height="104">${lis.picname}</td>
            <td><img width="100px" src="${lis.bigpic}"></td>
            <c:forEach items="${tylist}" var="ty">
            <c:if test="${lis.typeid==ty.typeid}">
            <td>${ty.typename}</td>
            </c:if>
            </c:forEach>
            <td>${lis.pictime}</td>
            <td>
                <input class="btn btn-primary" type="button" onClick="returnEdit(${lis.picid})" value="编辑">
                    <%--  <input type="button" onClick="openwin(${lis.picid})" value="编辑">--%>
                <button class="dele btn btn-danger" title="${lis.picid}">删除</button>
            </td>
            </c:forEach>

    </table>


</div>
<div align="center">
    <ul class="pagination ul">
        <li><a href="piclist?page=${currpage-1}">&laquo;</a></li>
        <li><a href="piclist">首页</a></li>
        <c:forEach var="p" begin="0" end="${pplist.totalPages-1}">
            <li><a href="piclist?page=${p}">${p+1}</a></li>

        </c:forEach>

        <li><a href="piclist?page=${pplist.totalPages-1}">尾页</a></li>
        <li><a href="piclist?page=${currpage+1}">&raquo;</a></li>
    </ul>

</div>

</body>
</html>
