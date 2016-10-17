<%--
  Created by IntelliJ IDEA.
  User: MeiLeLe19
  Date: 2016/10/8
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%--<%
    Object name = session.getAttribute("username");
    if (name == null) {
        response.sendRedirect("denglu.html");
        return;
    }
%>--%>
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

        #bg {
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index: 1001;
            -moz-opacity: 0.80;
            opacity: .80;
            filter: alpha(opacity=80);
        }

        #show {
            display: none;
            position: absolute;
            top: 25%;
            left: 22%;
            width: 60%;
            height: 49%;
            padding: 8px;
            border: 8px solid #E8E9F7;
            background-color: white;
            z-index: 1002;
            overflow: hidden;
        }

        #bgtwo {
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index: 1001;
            -moz-opacity: 0.80;
            opacity: .80;
            filter: alpha(opacity=80);
        }

        #showtwo {
            display: none;
            position: absolute;
            top: 25%;
            left: 22%;
            width: 60%;
            height: 49%;
            padding: 8px;
            border: 8px solid #E8E9F7;
            background-color: white;
            z-index: 1002;
            overflow: hidden;
        }

        em {
            color: red
        }
    </style>
    <script type="text/javascript" src="../../js/jquery-3.0.0.js"></script>


    <script>

        function showdivtwo() {

            document.getElementById("bgtwo").style.display = "block";
          /*  location.href="editdetail?detailid=" + op;*/
            document.getElementById("showtwo").style.display = "block";
//             location.href="editdetail?detailid=" + op;
        }
        function hidedivtwo() {
            document.getElementById("bgtwo").style.display = 'none';
            document.getElementById("showtwo").style.display = 'none';
            location.reload();
        }

        function showdiv() {
            document.getElementById("bg").style.display = "block";
            document.getElementById("show").style.display = "block";

        }
        function hidediv() {
            document.getElementById("bg").style.display = 'none';
            document.getElementById("show").style.display = 'none';
            location.reload();
        }


        /*   function openWindow(op) {
         window.open("editdetail?detailid=" + op, "newwindow", "height=500, width=700,top=100,left=350, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")
         }*/

        $(function () {
            $(".dele").click(function () {
                if (confirm("您确认删除吗？")) {
                    var dtid = $(this).attr("title");
                    $.post("deletedeta", {detailid: dtid}, function (data) {
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

        /*  function openWin() {
         window.open("todetailadd", "newwindow", "height=500, width=700,top=100,left=350, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")

         }*/
        /*编辑页面的返回按钮的 返回首页的 执行js代码*/
        function returnIndex() {
            location = "piclist";
        }


        /*编辑页面的修改按钮的  执行js代码*/
        $(function () {
            $("#update").click(function () {
                $.post("doeditpic", {
                    "picid": $("#edpicid").val(),
                    "picname": $("#edpicname").val(),
                    "typeid": $("#edtypeid").val(),
                    "bigpic": $("#edbigpic").val()
                }, function (data) {
                    if (data == 1) {
                        alert("修改成功！")
                        location.reload();
                        /*    window.close();*/
                    } else {
                        alert("修改失败！")
                        location.reload();
                        /*     location = "piclist";*/
                    }

                });
            });
        });
        /*编辑页面的新增按钮的  执行js代码*/
        $(function () {
            $("#zeng").click(function () {
                $.post("detailadd", {
                    "picurl": $("#adpicurl").val(),
                    "pictitle": $("#adpictitle").val(),
                    "picdesc": $("#adpicdesc").val(),
                    "picid": $("#adpicid").val()
                }, function (data) {

                    if (data == true) {

                        alert("新增成功！")
                        location.reload();
                        /*   window.close();*/
                    } else {
                        alert("新增失败！")
                        location.reload();
                    }

                });
            });
        });

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
                        /*       window.close();*/
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

<h2 align="center">这是一个编辑的页面</h2>

<%--编辑页面的表格，开始--%>
<table style="width: 60%;" align="center" class="table table-striped table-bordered table-hover ">
    <tr>
        <td height="59" colspan="2"><strong>基本信息</strong></td>
    </tr>
    <tr>
        <td width="147" height="46"><em>*</em>名称：</td>
        <td width="328">
            <input type="hidden" name="edpicid" id="edpicid" value="${pic.picid}">
            <input type="text" name="edpicname" id="edpicname" value="${pic.picname}"></td>
    </tr>


    <tr>
        <td height="44"><em>*</em>所属分类
        </td>
        <td>
            <%-- <input type="hidden" name="typeid" id="typeid" value="${pic.typeid}">--%>

            <select name="edtypeid" id="edtypeid">
                <c:forEach items="${plis}" var="p">
                    <option selected="selected" value="${p.typeid}">${p.typename}</option>
                </c:forEach>
            </select>


        </td>
    </tr>


    <tr>
        <td height="44"><em>*</em>图文封面</td>
        <td><input type="text" name="edbigpic" id="edbigpic" value="${pic.bigpic}"></td>
    </tr>



    <tr>
        <td height="49" colspan="2"><strong>套图详情</strong></td>
    </tr>
    <tr>
        <td height="43"><em>*</em>套图介绍</td>
        <td>
            <c:forEach items="${tlist}" var="t">
                <%--    <c:if test="${pic.picid==t.picid}">--%>
                <%--   <input type="hidden" name="picid" id="picid" value="${t.picid}">--%>
                <input type="text" name="adpicdesc" id="adpicdesc" value="${t.picdesc}">
                <%--     </c:if>--%>
            </c:forEach>

            <%--   <input type="text" name="picdesc" id="picdesc" value="${delist.picdesc}">--%>

        </td>
    </tr>
    <tr>
        <td height="48"><em>*</em>上传图片</td>
        <td>
            <c:forEach items="${tlist}" var="t">
                <input type="text" name="picurl" id="picurl" value="${t.picurl}">
                <button class="dele btn btn-danger" title="${t.detailid}">删除</button>
                <%--这里没法做下去了，因为我设计的数据库有问题了，没法在图片表里面查到套图表的detailid
                ，也就没法 不传参数。。--%>
                <button id="btnshowtwo" type="button" class="btn btn-primary" onclick="showdivtwo(${t.detailid})">
                    编辑
                </button>
                <%--  <button class="btn btn-primary" onclick="openWindow(${t.detailid})">编辑</button>--%>
            </c:forEach>
        </td>


    </tr>

    <tr>
        <td height="38" colspan="2" align="right">
            <%-- <input type="button"  onclick="openWin()" value="增加">--%>
            <input id="btnshow" type="button" value="增加" class="btn btn-success" onclick="showdiv();"/>
            <%-- <input id="btnclose" type="button" class="btn btn-success" value="增加" onclick="hidediv();"/>--%>
            <input class="btn btn-primary" type="button" id="update" value="修改">
            <input class="btn btn-warning" type="button" id="index" onclick="returnIndex()" value="返回">
        </td>
    </tr>
    <%--编辑页面的表格，结束--%>
</table>

<%--下面是第一个隐藏显示层--%>
<div id="bg">
    <%-- 隐藏的DIV，显示--%>
</div>


<div id="show">

    <form name="form1" method="post" action="">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td align="right">
                    <%-- <input type="button" name="button" id="button" value="关闭">--%>
                    <input id="btnclose" type="button" class="btn btn-danger" value="关闭" onclick="hidediv()"/>
                </td>
            </tr>
        </table>
    </form>
    <h2 align="center">新增到详细信息表里的图片的url操作</h2>
    <table style="width: 60%;" align="center" class="table table-striped table-bordered table-hover ">
        <tr>
            <td width="100" height="63" align="right">图片的来源:</td>
            <td><input type="text" name="adpicurl" id="adpicurl"></td>
        </tr>
        <tr>
            <td height="64" align="right">图片的标题：</td>
            <td><input type="text" name="adpictitle" id="adpictitle"></td>
        </tr>
        <tr>
            <td height="58" align="right">图片的名字：</td>
            <td>


                <select name="adpicid" id="adpicid">
                    <c:forEach items="${plist}" var="lis">
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
                <%--<input id="btnclose" type="button" class="zeng btn btn-success" value="增加" onclick="hidediv()"/>--%>
            </td>
        </tr>

    </table>


    <%--隐藏的div，结束--%>
</div>

<%--第二个隐藏显示开始--%>




<div id="bgtwo">

</div>
<%--detailedit.jsp页面上的DIV，展示的--%>
<div id="showtwo">

    <form name="form2" method="post" action="">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td align="right">
                    <%-- <input type="button" name="button" id="button" value="关闭">--%>
                    <input id="btnclosetwo" type="button" class="btn btn-danger" value="关闭" onclick="hidedivtwo()"/>
                </td>
            </tr>
        </table>
    </form>


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
                <%-- 注意啦！！delist是单个对象，而不是一组值，所以没必要用循环处理！晕死--%>
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
</div>


</body>
</html>
