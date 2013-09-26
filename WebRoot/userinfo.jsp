<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="lab.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/lab.js"></script>
<script type="text/javascript" >
$(function(){
	$("#choose_all").click(toggleChooseStatus);
	$("select[name='usertype'] option").each(function(){
		if($(this).text() == $(this).attr("value"))
		{
			$(this).attr("selected", "selected");
		}
	});
});
</script>
<title>湖南师范大学数字内容版权保护软件产学研合作基地</title>
</head>
<body>
<div style="margin:0 auto; width:1080px;">
<div class="admin">
	<%= session.getAttribute("s_user")%>,欢迎您！
	<a href="read_user_detail.action">修改个人信息&nbsp;</a>|
	<a href="update_password.jsp">修改密码</a>
</div>
	<div class="admin_left">
		<img src="images/a.jpg" class="menu"/>
		<a href="read_index_info.action" style="margin-left:5px;">返回首页</a>
		<div id="labinfo_c">
			<img id="submenu_lab" onclick="showlabinfo()" src="images/aa.jpg"/>
			<a href="read_labinfo.action">实验室信息</a><br />
				<ul style="display:none;"  id="labinfo">
					<li><a href="read_labResearchArea.action">研究领域</a></li>
					<li><a href="labRule.jsp">实验室规章制度</a></li>
					<li><a href="read_news.action">最新动态</a></li>
					<li><a href="read_notice.action">公告</a></li>
				</ul>
		</div>
		<div id="research_c"">
			<img id="submenu_research" onclick="showresearch()" src="images/aa.jpg"/>
			<a href="read_research.action">科学研究</a><br />
				<ul style="display:none;" id="research">
					<c:forEach var="achievement" items="${achievementType}">
						<li onclick="researchTypeChange()"><c:out value="${achievement.name}"></c:out></li>
					</c:forEach>
					<li><a href="read_achievement_type_achieveConfig.action">配置</a></li>
				</ul>
		</div>
		<div id="team_c" >
			<img id="submenu_team" onclick="showteam()" src="images/aa.jpg"/>
			<a>科研队伍</a><br />
				<ul style="display:none;" id="team">
					<li><a href="read_membertype.action">配置</a></li>
				</ul>
		</div>
		<div>
			<img src="images/a.jpg" class="menu"/>
			<a href="">友情链接</a>
		</div>
		<div>
			<img src="images/a.jpg" class="menu"/>
			<a href="user_info.action">用户管理</a>
		</div>
	</div>
	<div id="admin_user">
		<div class="navPosition">
			<img src="images/b.jpg"/>
			当前位置>>用户管理
		</div>
		<table id="userinfo" cellspacing="0">
			<tr id="tabletitle">
				<td height="45">用户名</td>
				<td>姓名</td>
				<td>用户类型</td>
				<td>修改用户类型</td>
				<td>
					<input type="checkbox" id="choose_all"/>全选
					<div onclick="deleteUsers()" style="color:#33F;text-decoration:underline;">删除用户</div>	
				</td>
			</tr>
			<c:forEach var="userinfo" items="${users}">
			<tr>
				<td id="username"  height="45"><c:out value="${userinfo.user}"></c:out></td>
				<td id="userpassword"><c:out value="${userinfo.name}"/></td>
				<td id="usertype"><c:out value="${userinfo.usertype}"/></td>
				<td>
				<form>
					<select name="usertype" id="usertype" onchange="userTypeChange()">
					<option value="${userinfo.usertype}">user</option>
					<option value="${userinfo.usertype}">admin</option>
					</select>
				</form>
				</td>
				<td><input id="choose_status" type="checkbox"/></td>
			</tr>
			</c:forEach>
		</table>
	
		<div id="user_page">
			<form action="user_info_page.action" name="goto_page" id="goto_user_page">
				<span onClick="toLastPage()" style="cursor:pointer">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<input type="text" value="${currentPage}" style="width:30px; height:10px;" name="currentPage"/>
				<input type="button" onclick="PageChange()" value="确认跳转" class="button"/>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<span onClick="toNextPage()" style="cursor:pointer">下一页</span>
				<span style="padding-left:100px;">
					当前第&nbsp;&nbsp;<span id="user_current_page_index">${currentPage}</span>&nbsp;&nbsp;页，
					总共&nbsp;&nbsp;<span id="user_last_page_index">${totalPage}</span>&nbsp;&nbsp;页 
				</span>
			</form>
		</div>
		
		<form id="adduser">
			<h4>添加</h4>
			<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="new_user"></td>
			</tr>
			<tr>
				<td>初始密码</td>
				<td><input type="text" name="new_password"></td>
			</tr>
			<tr>
				<td>用户类型</td>
				<td><input type="text" name="new_usertype"></td>
			</tr>
			</table>
			<input type="button" value="添加用户" onclick="adduser()" class="button" id="adduser_button"/>
		</form>		
		${isdone}
	</div>
</div>
</body>
</html>