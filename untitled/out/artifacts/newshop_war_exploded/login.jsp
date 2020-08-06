<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	application.setAttribute("path", path);
%>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>二手商城后台管理系统</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="${path}/css/font.css">
    <link rel="stylesheet" href="${path}/css/login.css">
	  <link rel="stylesheet" href="${path}/css/xadmin.css">
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
    <script src="${path}/lib/layui/layui.js" charset="utf-8"></script>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">二手商城后台管理系统-登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" action="${path}/login" onsubmit="return check();">
            <input name="username" id="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" id="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
            <span style="color: red">${msg}</span>
        </form>
    </div>

    <script>
    	function check(){
    		var username = document.getElementById("username").value;
    		var password = document.getElementById("password").value;
    		if (username == null || username == "") {
    			alert("用户名不能为空");
    			return false;
    		}
    		if (password == null || password == "") {
    			alert("密码不能为空");
    			return false;
    		}
    		return true;
    	}
       /*
       $(function () {
            layui.use('form', function(){
              var form = layui.form;
              //监听提交
              form.on('submit(login)', function(data){
                layer.msg(JSON.stringify(data.field),function(){
                    location.href='doLogin.jsp'
                });
                return false;
              });
            });
        })
        */
    </script>
</body>
</html>