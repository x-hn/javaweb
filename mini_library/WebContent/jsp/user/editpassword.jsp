<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx}/UiMaker/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/UiMaker/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/UiMaker/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/UiMaker/js/select-ui.min.js"></script>

<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <form action="${ctx}/userServlet?type=editPassword" method="post">
    <input type="hidden" name="id" value="${id}"/>
	    <ul class="forminfo">
		    <li><label>新密码</label><input name="password1" type="text" class="dfinput" /></li>
		    <li><label>确认密码</label><input name="password2" type="text" class="dfinput" /></li>
		    <li><label>&nbsp;</label><input name="button" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    
    </div>


</body>

</html>