<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx}/UiMaker/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/UiMaker/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>
<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>通讯录</div>
<dl class="leftmenu">
    <dd>
        <div class="title"> <span><img src="${ctx}/UiMaker/images/leftico01.png" /></span>系统管理 </div>
        <ul class="menuson">
            <li><cite></cite><a href="${ctx}/userServlet?type=getAll" target="rightFrame">用户管理</a><i></i></li>
            <li><cite></cite><a href="${ctx}/bookServlet?type=getAll" target="rightFrame">图书管理</a><i></i></li>
        </ul>
    </dd>
    <dd>
        <div class="title"> <span><img src="${ctx}/UiMaker/images/leftico02.png" /></span>我的借阅 </div>
        <ul class="menuson">
            <li><cite></cite><a href="#">借阅记录</a><i></i></li>
            <li><cite></cite><a href="#">未还图书</a><i></i></li>      
            <li><cite></cite><a href="#">我的预约</a><i></i></li>        
        </ul>
    </dd>
    <dd>
        <div class="title"><span><img src="${ctx}/UiMaker/images/leftico03.png" /></span>编辑器</div>
        <ul class="menuson">
            <li><cite></cite><a href="#">修改密码</a><i></i></li>
            <li><cite></cite><a href="#">我的资料</a><i></i></li>            
        </ul>
    </dd>
    <dd>
        <div class="title"><span><img src="${ctx}/UiMaker/images/leftico04.png" /></span>日期管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="#">自定义</a><i></i></li>            
            <li><cite></cite><a href="#">其他</a><i></i></li>
        </ul>
    </dd>
</dl>
</body>
</html>