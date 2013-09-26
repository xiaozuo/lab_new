<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="lab.css">
<link rel="stylesheet" type="text/css" href="css/news.css">
<link rel="stylesheet" type="text/css" href="css/achievements.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/lab.js"></script>
<script type="text/javascript" src="js/achievements.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
<link rel="stylesheet" href="js/jquery-ui-1.10.3.custom.min.css" />
<script type="text/javascript" > 
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
	<div id="admin_method">
		<div class="navPosition">
			<img src="images/b.jpg"/>
			当前位置>>科研成果>>配置
		</div>
		<span class="admin_method_title">科研成果显示顺序的配置：</span>
		<div>
			<h4>当前选择方式：</h4><input type="button" name="currentMethod" value="按时间前后显示" style="background:none;border:none;"/><br />
			<h4>请选择科研成果的显示方式：</h4><br />
			<div class="radio">
				<input type="radio" name="method" value="按时间前后显示"/>按时间前后显示
				<input type="radio" name="method" value="按级别高低显示"/>按级别高低显示
				<br /><input type="button" value="确定" class="button" id="location" onclick="chooseMethod()"/>
			</div>
		</div>
		<span class="admin_method_title" style="padding-top:40px;">编辑科研成果的类别：</span>
		<div>
			<h4>当前已有类别：</h4>
				<div id="configDiv">
					<c:forEach var="achievement" items="${achievementType}">
						<span>
							<span onclick="showTypeDown()" id="typeName"><c:out value="${achievement.name}"></c:out></span>
							<span style="display:none;"><c:out value="${achievement.id}"></c:out></span>
							<span id="deleteType" onclick="deleteAchieveType()">×</span>&nbsp&nbsp&nbsp&nbsp
						</span>
					</c:forEach>
				</div>
			<h4>添加类别：</h4>
				<input type="text" name="newType" />
				<input type="button" class="button" value="添加类型" onclick="addAchieveType()" />
				<br />
			<h4>修改已有类别：</h4>
				<input type="text" name="editAchieveId" style="display:none;"/>
				<input type="text" name="editAchieveType"/>
				<input type="button" class="button" value="确定" onclick="editAchieveType()"/>
		</div>
	</div> 
</div>
</body>
</html>