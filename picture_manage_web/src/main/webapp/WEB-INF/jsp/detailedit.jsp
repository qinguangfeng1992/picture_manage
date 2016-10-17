<%--
  Created by IntelliJ IDEA.
  User: MeiLeLe19
  Date: 2016/10/8
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<html>
<head>
    <%--    <meta http-equiv="refresh" content="2">--%>

    <style>
        em {
            color: red
        }
    </style>
    <script type="text/javascript" src="../../js/jquery-3.0.0.js"></script>
    <script>
        $(function () {
            $("#xiugai").click(function () {
                $.post("doeditdeta", {
                    "picurl": $("#xiupicurl").val(),
                    "pictitle": $("#xiupictitle").val(),
                    "detailid": $("#xiudetailid").val(),
                    "picdesc": $("#xiupicdesc").val()
                }, function (data) {
                    if (data == 1) {
                        alert("修改成功！")
                        location.reload();
                        window.close();
                    } else {
                        alert("修改失败！")
                        location.reload();

                    }
                });
            });
        });
    </script>
    <title>编辑</title>
</head>
<body>
<h2 align="center">这是一个编辑套图的页面</h2>
<table style="width: 60%;" align="center" class="table table-striped table-bordered table-hover ">
    <tr>
        <td height="49" colspan="2"><strong>套图详情</strong></td>
    </tr>
    <tr>
        <td height="48"><em>*</em>上传图片 
        </td>
        <td>
            <input type="hidden" name="xiudetailid" id="xiudetailid" value="${delist.detailid}">
            <input type="text" name="xiupicurl" id="xiupicurl" value="${delist.picurl}">
        </td>
    </tr>

    <tr>
        <td height="48"><em>*</em>套图标题
        </td>
        <td>
            <input type="text" name="xiupictitle" id="xiupictitle" value="${delist.pictitle}">
        </td>
    </tr>
    <tr>
        <td height="43"><em>*</em>套图介绍</td>

        <td>
            <%-- 注意啦！！serlist是单个对象，而不是一组值，所以没必要用循环处理！晕死--%>
            <input type="text" name="xiupicdesc" id="xiupicdesc" value="${delist.picdesc}">
        </td>
    </tr>

    <%-- <tr>
         <td height="44"><em>*</em>图片的名字
         </td>
         <td>

             <select name="typeid" id="typeid">
                 <c:forEach items="${plist}" var="p">
                     <c:if test="${delist.picid==p.picid}">
                         <option selected="selected" value="${delist.picid}">${p.picname}</option>
                     </c:if>
                 </c:forEach>
             </select>
         </td>
     </tr>--%>


    <tr>
        <td height="38" colspan="2" align="right">
            <input class="btn btn-primary" type="button" id="xiugai" value="修改">
        </td>
    </tr>
</table>

</body>
</html>
