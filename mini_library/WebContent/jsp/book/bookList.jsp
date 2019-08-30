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
            <li class="click"><a href="${ctx}/jsp/book/add.jsp"><span><img src="${ctx}/UiMaker/images/t01.png" /></span>添加</a></li>
            <li class="click"><span><img src="${ctx}/UiMaker/images/t02.png" /></span>修改</li>
            <li><span><img src="${ctx}/UiMaker/images/t03.png" /></span>删除</li>
            <li><span><img src="${ctx}/UiMaker/images/t04.png" /></span>统计</li>
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
                <th>书名</th>
                <th>书号</th>
                <th>类型</th>
                <th>作者</th>
                <th>出版社</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="obj" items="${bookList}"> 
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>${obj.id}</td>
                <td>${obj.bookName}</td>
                <td>${obj.bookNumber}</td>
                <td>${obj.categoryName}</td>
                <td>${obj.author}</td>
                <td>${obj.publisher}</td>
                <td>
                	<a href="#" class="tablelink"> 编辑</a>
                    <a href="${ctx}/bookServlet?type=delete&id=${obj.id}" class="tablelink" onclick="return confirm('确定要删除？');"> 删除</a>
                    <a href="#" class="tablelink"> 重设密码</a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="pagin">
        <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="javascript:;">1</a></li>
            <li class="paginItem current"><a href="javascript:;">2</a></li>
            <li class="paginItem"><a href="javascript:;">3</a></li>
            <li class="paginItem"><a href="javascript:;">4</a></li>
            <li class="paginItem"><a href="javascript:;">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;">10</a></li>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>
        <div class="tipinfo"> 
			<span><img src="${ctx}/UiMaker/images/ticon.png" /></span>
            <div class="tipright">
                姓名：<input type="text"/>
				<p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite> </div>
        	</div>
        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />
            &nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>
    </div>
</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>