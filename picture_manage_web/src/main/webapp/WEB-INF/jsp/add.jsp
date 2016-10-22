<%--
  Created by IntelliJ IDEA.
  User: MeiLeLe19
  Date: 2016/10/8
  Time: 17:14
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
    <%--    <meta http-equiv="refresh" content="2">--%>
    <title>新增的页面</title>
    <script type="text/javascript" src="../../js/jquery-3.0.0.js"></script>
    <style>

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
            height: 60%;
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
            height: 60%;
            padding: 8px;
            border: 8px solid #E8E9F7;
            background-color: white;
            z-index: 1002;
            overflow: hidden;
        }
    </style>


    <script>
        function showdiv() {
      /*      document.getElementById("bg").style.display = "block";*/
            document.getElementById("show").style.display = "block";

        }
        function hidediv() {
            document.getElementById("bg").style.display = 'none';
            document.getElementById("show").style.display = 'none';
        /*    location.reload();*/
        }

        /*隐藏表的增加的 Ajax*/
              $(function () {
            $("#zeng").click(function () {
                $.post("pictureadd", {
                    "picurl": $("#adpicurl").val()
//                    "pictitle": $("#adpictitle").val(),
//                    "picdesc": $("#adpicdesc").val(),
//                    "picid": $("#adpicid").val()
                }, function (data) {

               if (data == true) {

                        alert("新增成功！")
                        location.reload();
                           window.close();
                    } else {
                        alert("新增失败！")
                        location.reload();
                    }

                });
            });
        });







        function returnDele(op) {
            location.href = "deletedeta?detailid=" + op;

        }

        function openwin() {
            window.open("todetailadd", "newwindow", "height=500, width=700,top=100,left=350, toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")

        }
        /*实际表的新增的 AJAX*/
        $(function () {
            $("#save").click(function () {
                $.post("picadd", {
                    "picname": $("#picname").val(),
                    "bigpic": $("#bigpic").val(),
                    "picdesc": $("#picdesc").val(),
                    "typeid": $("#typeid").val()

                }, function (data) {
                    if (data == true) {
                        alert("新增成功！")
                        location.reload();
                        /* location = "piclist";*/
                    } else {
                        alert("新增失败！")
                        location.reload();
                        /*    location = "piclist";*/
                    }
                });
            });
        });
        function returnIndex() {
            location = "piclist";
        }

        /*        新增出来的图片的删除ajax*/
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
        function showdivtwo(deatilid) {

            document.getElementById("bgtwo").style.display = "block";
            document.getElementById("showtwo").style.display = "block";


            $.post("picedetail_edit", {detailid: deatilid}, function (data) {

                $("#xiudetailid").val(data.detailid);
                $("#xiupicurl").val(data.picurl);
                $("#xiupictitle").val(data.pictitle);
                $("#xiupicdesc").val(data.picdesc);
            });
        }
        function hidedivtwo() {
            document.getElementById("bgtwo").style.display = 'none';
            document.getElementById("showtwo").style.display = 'none';
            location.reload();
        }
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

</head>
<body>
<h2 align="center">这是一个新增的页面</h2>

<table style="width: 60%;" align="center" id="pictable" class="table table-striped table-bordered table-hover ">
    <tr>
        <td height="41" colspan="2"><strong>基本信息</strong></td>
    </tr>
    <tr>
        <td width="83" height="41" align="right">*名称：</td>
        <td width="392">
            <input type="text" name="picname" id="picname"></td>
    </tr>
    <tr>
        <td height="61" align="right"><label><em>*</em>所属分类</label>
             
        </td>
        <td>
            <select name="typeid" id="typeid">
                <c:forEach items="${plis}" var="p">
                    <option selected="selected" value="${p.typeid}">${p.typename}</option>
                </c:forEach>

            </select>
        </td>
    </tr>
    <tr>
        <td height="44" align="right"><em>*</em>图文封面</td>
        <td><input type="text" name="bigpic" id="bigpic"></td>
    </tr>
    <tr align="right">
        <td height="47" colspan="2" align="left"><strong>套图详情</strong></td>
    </tr>
    <tr>
        <td height="68" align="right"><em>*</em>套图介绍</td>
        <td>

            <input name="picdesc" id="picdesc" cols="45" rows="5">
        </td>
    </tr>
    <tr >
        <td height="72" id="ceshi"><em>*</em>上传图片</td>
        <td></td>
       <%-- <td ><input type="text" id="n"></td>--%>
    </tr>


              <%--<c:forEach items="${addlist}" var="add" varStatus="vs">--%>
  <%--          <c:forEach items="${sessionScope.pictureList}" var="picture">
                <input type="text" value="${picture}">
                <button class="dele btn btn-danger" title="${picture}" id="picture_edit">编辑</button>
                <button class="dele btn btn-danger" title="${picture}" id="picture_delete">删除</button>

            </c:forEach>--%>


          <%--  <input type="text" value="">--%>
 <%--           <button class="dele btn btn-danger" title="${add.detailid}">删除</button>
                   &lt;%&ndash;       <button class="dele btn btn-danger" title="">删除</button>&ndash;%&gt;
             <button class="btn btn-primary" title="${add.detailid}">编辑</button>

             <button id="btnshowtwo" type="button" class="btn btn-primary" onclick="showdivtwo(${add.detailid})">
                 编辑
             </button>--%>
         <%--   <button id="btnshowtwo" type="button" class="btn btn-primary" onclick="showdivtwo()">
                编辑
            </button>--%>

             <%--</c:forEach>--%>
          <%--  <input type="button" class="btn btn-success" value="增加" onClick="openwin()">--%>

    <%--     <input type="button" value="删除" >--%>
    <%--  <c:forEach items="${delelist}" var="de">
          <button class="danger" title="${de.detailid}">删除</button>
      </c:forEach>--%>
    <%--     <button onclick="returnDele(${delelist.detailid[0]})" >删除</button>
         ${sessionScope.shoppingCart[0].price}--%>


    <tr>
        <td height="34" colspan="2" align="right">
            <input id="btnshow" type="button" value="增加" class="btn btn-success" onclick="showdiv();"/>
            <input type="button" class="btn btn-info" id="save" value="保存">
            <input class="btn btn-warning" type="button" id="index" onclick="returnIndex()" value="返回">
        </td>
    </tr>
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
    <h2 align="center">新增到详细信息表里的图片的url操作22222</h2>
    <table style="width: 60%;" align="center" class="table table-striped table-bordered table-hover ">
        <tr>
            <td width="100" height="63" align="right">图片的来源:</td>
            <td><input type="text" name="adpicurl" id="adpicurl"></td>
        </tr>
        <%--<tr>
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
        </tr>--%>
<%--<tr>
    <td>Niha</td>
    <td>Niha</td>
</tr>--%>
        <tr>

            <td height="39" colspan="2" align="right">
                <input class="btn btn-success" type="button" id="cun" value="保存">
               <%-- <input id="btnclose" type="button" class="zeng btn btn-success" value="增加" onclick="hidediv()"/>--%>
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


    <h2 align="center">这是一个编辑套图的页面111</h2>
    <table style="width: 60%;" align="center" class="table table-striped table-bordered table-hover ">
        <tr>
            <td height="49" colspan="2"><strong>套图详情</strong></td>
        </tr>
        <tr>
            <td height="48"><em>*</em>上传图片 
            </td>
            <td>
                <input type="hidden" name="xiudetailid" id="xiudetailid" value="">
                <input type="text" name="xiupicurl" id="xiupicurl" value="">
            </td>
        </tr>
        <tr>
            <td height="48"><em>*</em>套图标题
            </td>
            <td>
                <input type="text" name="xiupictitle" id="xiupictitle" value="">
            </td>
        </tr>
        <tr>
            <td height="43"><em>*</em>套图介绍</td>
            <td>
                <%-- 注意啦！！delist是单个对象，而不是一组值，所以没必要用循环处理！晕死--%>
                <input type="text" name="xiupicdesc" id="xiupicdesc" value="">
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
<%--写存到页面的的js代码--%>
<script>
    var pic=new Array();
$(function(){
   $("#cun").click(function(){
       var obj={url:$("#adpicurl").val()};
       pic.push(obj);
       show();
   });


});
    function show(){
       /* $("#ceshi tr:gt(4)").remove();*/
        for(var i=0;i<pic.length;i++){
//            $("#ceshi").append("<td>"+pic[i].url+"</td><td><input type='button' value='编辑' onclick='add()'></td>");
             $("#ceshi").next().append("<input type='button' value='uui'>");
            //console.log(a);
            /*$("table tr:eq(6)").append("<td>"+pic[i].url+"<br></td>");*/
        }
      /*  $("table tr:eq(0)").after("<tr><td>c-01</td><td>c-02</td><td>c-03</td><td>c-04</td></tr>");*/
    }
</script>
</body>
</html>
