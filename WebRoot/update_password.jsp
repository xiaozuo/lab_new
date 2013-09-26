<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="lab.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
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
});
</script>
<title>Insert title here</title>
</head>
<body>
<div id="password">
	<div id="pass_nav">
		<div><a href="read_index_info.action">返回首页</a></div>
		修改密码
	</div>
	<div id="password_content">
		<form action="change_user_password.action">
			<table cellspacing="15">
				<tr>
					<td align="right">用户名：</td>
					<td><%= session.getAttribute("s_user")%></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password"/ name="password"></td>
				</tr>
				<tr>
					<td align="right">新密码：</td>
					<td><input type="password" name="new_password"/></td>
				</tr>
				<tr>
					<td align="right">重复新密码：</td>
					<td><input type="password" name="new_password_confirm"/></td>
				</tr>
				<tr>
					<th colspan="2" align="center">${password_change_flag}</th>
				</tr>
			</table>
			<div id="pass_submit"><input type="submit" value="确认修改"></div>
		</form>
	</div>

</div>
</body>
</html>