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
        <ul class="toolbar">
            <li class="click"><a href="${ctx}/jsp/user/add.jsp"><span><img src="${ctx}/UiMaker/images/t01.png" /></span>添加</a></li>
            <li class="click"><a href="${ctx}/jsp/user/add.jsp"><span><img src="${ctx}/UiMaker/images/t02.png" /></span>修改</a></li>
            <li><a href="${ctx}/jsp/user/add.jsp"><span><img src="${ctx}/UiMaker/images/t03.png" /></span>删除</a></li>
            <li><a href="${ctx}/jsp/user/add.jsp"><span><img src="${ctx}/UiMaker/images/t04.png" /></span>统计</a></li>
        </ul>
        <ul class="toolbar1">
            <li><span><img src="${ctx}/UiMaker/images/t05.png" /></span>设置</li>
        </ul>
    </div>
    <table class="tablelist">
        <thead>
            <tr>
                <th><input name="" type="checkbox" value="" /></th>
                <th>编号<i class="sort"><img src="${ctx}/UiMaker/images/px.gif" /></i></th>
                <th>账号</th>
                <th>姓名</th>
                <th>邮箱</th>
                <th>角色</th>
                <th>最大借阅数</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="obj" items="${modelList}"> 
            <tr>
                <td><input name="checkboxId" type="checkbox" value="${obj.id}" /></td>
                <td>${obj.id}</td>
                <td>${obj.username}</td>
                <td>${obj.realname}</td>
                <td>${obj.email}</td>
                <td>${obj.roleName}</td>
                <td>${obj.maxNumber}</td>
                <td>
                	<a href="${ctx}/userServlet?type=get&id=${obj.id}" class="tablelink"> 编辑</a>
                    <a href="${ctx}/userServlet?type=delete&id=${obj.id}" class="tablelink" onclick="return confirm('确定要删除？');"> 删除</a>
                    <a href="" class="tablelink"> 重设密码</a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="pagin">
        <div class="message">共<i class="blue">${totalRecords}</i>条记录，当前显示第&nbsp;<i class="blue">${page}</i>页</div>
        <ul class="paginList">
        	<c:if test="${page!=1}">
            	<li class="paginItem"><a href="${ctx}/userServlet?type=getAll&page=${page-1<1 ? 1:page-1}"><span class="pagepre"></span></a></li>
            </c:if>
            
            <c:forEach begin="1" end="${totalPages}" var="obj">
            	<li class="paginItem"><a href="${ctx}/userServlet?type=getAll&page=${obj}">${obj}</a></li>
            </c:forEach>
            <c:if test="${page!=totalPages}">
            	<li class="paginItem"><a href="${ctx}/userServlet?type=getAll&page=${page+1>totalPages ? totalPages:page+1}"><span class="pagenxt"></span></a></li>
        	</c:if>
        </ul>
    </div>
    
</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>