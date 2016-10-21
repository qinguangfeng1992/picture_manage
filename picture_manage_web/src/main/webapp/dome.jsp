<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/21
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title></title>
</head>
<body>

图片名：<input type="text" id="n"><br/>
图片URL:<input type="text" id="url"><br/>
<input type="button" value="添加" id="add">
<table id="pictable" border="1" width="400">
  <tr>
    <td>图片名称</td>
    <td>图片URL</td>
    <td>增加</td>
  </tr>
</table>
<script src="js/jquery-3.0.0.js"></script>
<script>
    function show(){
        $("#pictable tr:gt(0)").remove();
        for(var i=0;i<pic.length;i++){
            $("#pictable").append("<tr><td>"+pic[i].name+"</td><td>"+pic[i].url+"</td><td><input type='button' value='编辑' onclick='add()'></td> </tr>");
        }

    }
  var pic=new Array();
  $(function(){
    $("#add").click(function(){
          var obj={name:$("#n").val(),url:$("#url").val()};
          pic.push(obj);
      show();
    });


  })

</script>



</body>
</html>
