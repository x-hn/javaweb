<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="${ctx}/UiMaker/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/UiMaker/js/jquery.js"></script>
<script src="${ctx}/UiMaker/js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
	
</head>
	<%
		String username="";
		String password="";
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equalsIgnoreCase("username")){
					username=cookie.getValue();
				}
				if(cookie.getName().equalsIgnoreCase("password")){
					password=cookie.getValue();
				}
			}
		}
	%>
<body style="background-color:#1c77ac; background-image:url(${ctx}/UiMaker/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    
    <form action="${ctx}/userServlet?type=login" method="post">
	    <ul>
	    <li><input name="username" type="text" class="loginuser" value=""/></li>
	    <li><input name="password" type="password" class="loginpwd" value="" /></li>
	    <li>
	    	<input name="buttlogin" type="submit" class="loginbtn" value="登录" />
	    	<label><input name="isUserCookie" type="checkbox" checked="checked" />记住密码</label>
	    	<label><a href="#">忘记密码？</a></label>
	    </li>
	    </ul>
    </form>
    
    </div>
    
    </div>
    	
    
</body>

</html>