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
    
    <form action="${ctx}/bookServlet?type=updateBook" method="post">
    <input type="hidden" name="id" value="${obj.id}" />
	    <ul class="forminfo">
		    <li><label>书名</label><input name="bookName" type="text" class="dfinput" value="${obj.bookName}" readonly="readonly" /><i>书名不能修改</i></li>
		    <li><label>书号</label><input name="bookNumber" type="text" class="dfinput" value="${obj.bookNumber}" /><i>不能使用特殊字符</i></li>
		    <li><label>类型号</label>
			    <div class="vocation">
				    <select class="select1" name="categoryId" >
					    <option value="1" <c:if test="${obj.categoryId==1}">selected="selected"</c:if>>程序设计</option>
					    <option value="2" <c:if test="${obj.categoryId==2}">selected="selected"</c:if>>数据库</option>
					    <option value="3" <c:if test="${obj.categoryId==3}">selected="selected"</c:if>>算法</option>
					    <option value="4" <c:if test="${obj.categoryId==4}">selected="selected"</c:if>>数据库</option>
					    <option value="5" <c:if test="${obj.categoryId==5}">selected="selected"</c:if>>操作系统</option>
				    </select>
			    </div>
		    </li>
		    <li><label>作者</label><input name="author" type="text" class="dfinput" value="${obj.author}"/></li>
		    <li><label>出版社</label><input name="publisher" type="text" class="dfinput" value="${obj.publisher}"/></li>
		    <li>
		    	<input name="button" type="submit" class="btn" value="确认保存"/>
		    	<label>&nbsp;</label><input name="button" type="submit" class="btn" onclick="javascript:history.go(-1)" value="返回"/>
		    </li>
	    </ul>
    </form>
    
    </div>


</body>

</html>