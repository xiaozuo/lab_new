<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page session="true" %>
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
<script type="text/javascript" src="js/libinfo.js"></script>
<script type="text/javascript" >
$(function(){  
	$('#datepicker').datepicker();
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
					<li><a href="read_labrule.action">实验室规章制度</a></li>
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
	<div id="admin_lib">
		<div class="navPosition">
			<img src="images/b.jpg"/>
			当前位置>>实验室信息
		</div>
		<form>
			实验室名称：${lab_name}<br/>
			负责人：<input type="text" name="chief" value="${lab_chief}" /><br/>
			成立时间：<input type="text" name="settime" value="${lab_settime}"  id="datepicker"/><br/>
			地址：<input type="text" name="address" value="${lab_address}" /><br/>
			电话：<input type="text" name="telno" value="${lab_telno}" /><br/>
			邮箱：<input type="text" name="email" value="${lab_email}" /><br/>
			传真：<input type="text" name="fax" value="${lab_fax}" /><br/>
			简介：<br/><textarea rows="8" cols="60" name="resume" style="overflow:scroll;">${lab_resume}</textarea><br/>
			详情：<br/><textarea rows="15" cols="80" name="detail" style="overflow:scroll;">${lab_detail}</textarea><br/>
				<input type="button" value="提交" class="button" onClick="editLabInfo()"/>
		</form>
	</div> 
</div>
</body>
</html>