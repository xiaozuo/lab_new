<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="lab.css">
<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.10.3.custom.min.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
<script type="text/javascript" src="js/lab.js"></script>
<script type="text/javascript" >
$(function(){
	$("select[name='sex'] option").each(function(){
		if($(this).text() == $(this).attr("value"))
		{
			$(this).attr("selected", "selected");
		}
	});
		$("select[name='education'] option").each(function(){
		if($(this).text() == $(this).attr("value"))
		{
			$(this).attr("selected", "selected");
		}
	});
		$("select[name='membertype'] option").each(function(){
		if($(this).text() == $(this).attr("value"))
		{
			$(this).attr("selected", "selected");
		}
	});	
	$('#datepicker').datepicker({
				dateFormat:'yy-mm-dd',
				changeYear:true,
				changeMonth:true,
				monthNamesShort:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
				});

});
</script>
<title>湖南师范大学数字内容版权保护软件产学研合作基地</title>
</head>
<body>
<div style="margin:0 auto; width:860px;">
<div class="admin">
	<div id="user_detail_nav">
		<img src="images/a.jpg" class="menu"/>
		<a href="read_index_info.action">返回首页</a><br/>
		<img src="images/a.jpg" class="menu"/>
		<a href="update_password.jsp">修改密码</a>
	</div>
		${update_flag }
	<div id="userdetail">
		<form action="update_user_detail">
			用户名：<%= session.getAttribute("s_user")%>照片：<br />
			姓名：<input type="text" name="username" value="${username}" /><br />
			出生年月：<input type="text" name="birthday" id="datepicker" value="${birthday}" />例：2012.1.1<br />
			性别：
				<select name="sex">
					<option value="${sex}">男</option>
					<option value="${sex}">女</option>
				</select><br />
		 	 入学年份：<input type="text" name="enteryear" value="${enteryear}"/>年（例：2013）<br />
			专业：<input type="text" name="major" value="${major}"/><br />
				学历：
				<select name="education">
					<option value="${education}">博士后</option>
					<option value="${education}">博士</option>
					<option value="${education}">研究生</option>
					<option value="${education}">本科生</option>
				</select>
			研究方向：<input type="text" name="research" value="${research}" /><br />
			成员类型：
				<select name="membertype">
					<c:forEach var="memberType" items="${researchMemberType}">
						<option value="${membertype}"><c:out value="${memberType.name}"></c:out></option>
					</c:forEach>
				</select>
			个人简介：<br /><textarea rows="5" cols="60" name="resume">${resume}</textarea><br />
			教育工作经历：<br /><textarea rows="5" cols="60" name="workexperience">${workexperience}</textarea><br />
			电话号码：<input type="text" name="telno" value="${telno}" /><br />
			邮箱：<input type="text" name="email" value="${email}" /><br />
			QQ:<input type="text" name="QQ" value="${QQ}" /><br />
		<div id="user_detail_submit"><a onclick="change_code()" class="button">提交</a></div>
		</form>
	</div>
</div>
</div>
</body>
</html>