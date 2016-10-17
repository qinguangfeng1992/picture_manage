<%--
  Created by IntelliJ IDEA.
  User: MeiLeLe19
  Date: 2016/10/10
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <script type="text/javascript" src="../../js/jquery-3.0.0.js"></script>
    <script>

        $(function () {
            $("#zeng").click(function () {
                $.post("detailadd", {
                    "picurl": $("#picurl").val(),
                    "pictitle": $("#pictitle").val(),
                    "picid": $("#picid").val()
                }, function (data) {

                    if (data == true) {

                        alert("新增成功！")

                        window.close();

                    } else {
                        alert("新增失败！")

                    }

                });
            });
        });
    </script>
    <title>简单的增加一个文本框的页面</title>
</head>
<body>



<form name="form1" method="post" action="">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" >
    <tr>
      <td align="right"><input type="button" name="button" id="button" value="关闭"></td>
    </tr>
  </table>
</form>
<h2 align="center">&nbsp;</h2>
<h2 align="center">新增到详细信息表里的图片的url操作</h2>
<table style="width: 60%;" align="center" class="table table-striped table-bordered table-hover ">
    <tr>
        <td width="100" height="63" align="right">图片的来源:</td>
        <td><input type="text" name="picurl" id="picurl"></td>
    </tr>
    <tr>
        <td height="64" align="right">图片的标题：</td>
        <td><input type="text" name="pictitle" id="pictitle"></td>
    </tr>
    <tr>
        <td height="58" align="right">图片的名字：</td>
        <td>


            <select name="picid" id="picid">
                <c:forEach items="${list}" var="lis">
                    <option value="${lis.picid}">
                            ${lis.picname}
                    </option>
                </c:forEach>
            </select>


        </td>
    </tr>

    <tr>
        <td></td>
        <td height="39" colspan="2" align="right">
            <input class="btn btn-success" type="button" id="zeng" value="增加">
        </td>
    </tr>

</table>




</body>
</html>
