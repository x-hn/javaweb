<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx}/UiMaker/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/UiMaker/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>
<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">数据表</a></li>
        <li><a href="#">基本内容</a></li>
    </ul>
</div>
<div class="rightinfo">
    <div class="tools">
    	<form action="${ctx}/reserveServlet?type=toReserve" method="post">
		    <ul class="forminfo">
			    <li>
			    	读者编号：<input name="id" type="text" class="dfinput" />
			    	<label>&nbsp;</label><input name="button" type="submit" class="btn" value="确认保存"/>
			    </li>
		    </ul>
    	</form>
    	<div class="welinfo">
		    <span><img src="${ctx}/UiMaker/images/sun.png" alt="天气" /></span>
		    <c:choose>
		    	<c:when test="${empty user}">
		    		${message}
		    	</c:when>
		    	<c:otherwise>
		    		<b>账号：${user.username},姓名：${user.realname}，最大借阅数量：${user.maxNumber},未还图书：${user.myLendNumber}</b>
		    	</c:otherwise>
		    </c:choose>
    	</div>
    </div>
    <table class="tablelist">
        <thead>
            <tr>
                <th><input name="" type="checkbox" value="" /></th>
                <th>编号<i class="sort"><img src="${ctx}/UiMaker/images/px.gif" /></i></th>
                <th>书号</th>
                <th>借书时间</th>
                <th>还书时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="obj" items="${lendlist}"> 
            <tr>
                <td><input name="checkboxId" type="checkbox"/></td>
                <td>${obj.id}</td>
                <td>${obj.bookId}</td>
                <td>${obj.lendDateTime}</td>
                <td>${obj.estimateReturnTime}</td>
                <td>
                <c:choose>
			    	<c:when test="${user.myLendNumber gt 0}">
			    		<a href="${ctx}/reserveServlet?type=reserve&userId=${user.id}&bookId=${obj.id}&lendDateTime=${obj.lendDateTime}" class="tablelink" onclick="return confirm('确定要还书？');"> 还书</a>
			    	</c:when>
			    	<c:otherwise>
			    		<a href="#" class="tablelink"> 还书</a>
			    	</c:otherwise>
		    	</c:choose>
                	
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <div class="pagin">
        <div class="message">共<i class="blue">${totalRecords}</i>条记录</div>
        
    </div>
</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>