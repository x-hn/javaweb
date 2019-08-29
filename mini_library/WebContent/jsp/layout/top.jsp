<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${ctx}/UiMaker/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/UiMaker/js/jquery.js"></script>
</head>
<body style="background:url(${ctx}/UiMaker/images/topbg.gif) repeat-x;">
<div class="topleft"> <a href="main.html" target="_parent"><img src="${ctx}/UiMaker/images/logo.png" title="系统首页" /></a> </div>
<div class="topright">
    <ul>
        <li><a href="#">网站前台</a></li>
        <li><a href="${ctx}/userServlet?type=loginOut" target="_parent">退出</a></li>
    </ul>
    <div class="user"> <span>欢迎您，${loginUser.realname}</span> </div>
</div>
</body>
</html>