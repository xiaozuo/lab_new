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
$(function(){  
	$('#datepicker').attr("readonly", "true").datepicker({
				dateFormat:'yy-mm-dd',
				changeYear:true,
				changeMonth:true,
				monthNamesShort:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
				});
	//$('#datepicker').attr("readonly", "true").datepicker({changeYear:true});
	$('#datepicker2').attr("readonly", "true").datepicker({
				dateFormat:'yy-mm-dd',
				changeYear:true,
				changeMonth:true,
				monthNamesShort:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
				});
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
			<a onclick="read_research()" style="cursor:pointer;">科学研究</a><br />
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
	<div id="admin_news">
		<div class="navPosition">
			<img src="images/b.jpg"/>
			当前位置>>科学研究
		</div>
		<table id="admin_research_table" cellspacing="0">
			<tr id="news_table_title">
				<td height="45">名称</td>
				<td>详情</td>
				<td>类型</td>
				<td>完成时间</td>
				<td align="center">重要级别</td>
				<td>负责人</td>
				<td>主要成员</td>
				<td style="display:none;">id</td>
				<td>
					<input type="checkbox" id="choose_all"/>全选
					<div onclick="deletenews()" style="color:#33F;text-decoration:underline;">删除成果</div>
				</td>
			</tr>
			
			<c:forEach var="achieve" items="${achieve}">
			<tr id="news_table_content">
				<td id="achieveName" height="45">${isAchievementNull}<div onclick="showResearchDown()" id="research_delete" class="limit_text_length"><a href="#research_change"><c:out value="${achieve.name}"/></a></div></td>
				<td id="achieveDetail"><div class="limit_text_length"><c:out value="${achieve.detail}"></c:out></div></td>
				<td id="achieveType"><c:out value="${achieve.type}"/></td>
				<td id="achieveTime"><c:out value="${achieve.time}"/></td>
				<td id="achieveLevel" align="center"><c:out value="${achieve.level}"/></td>
				<td id="achieveChief"><c:out value="${achieve.chief}"/></td>
				<td id="achieveMembers"><div class="limit_text_length"><c:out value="${achieve.members}"/></div></td>
				<td id="achieve_id" style="display:none;"><c:out value="${achieve.id}"/></td>
				<td><input id="choose_status" type="checkbox"/></td>
			</tr>
			</c:forEach>
		</table>
		
		<div id="news_page">
			<form id="goto_research_page">
				<span onClick="toLastPage()" style="cursor:pointer;">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<input type="text" value="${currentPage}" style="width:30px; height:10px;" name="currentPage"/>
				<input type="button" onclick="PageChange()" value="确认跳转" class="button"/>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<span onClick="toNextPage()" style="cursor:pointer;">下一页</span>
				<span style="padding-left:100px;">
					当前第&nbsp;&nbsp;<span id="current_page_index">${currentPage}</span>&nbsp;&nbsp;页，
					总共&nbsp;&nbsp;<span id="last_page_index">${totalPage}</span>&nbsp;&nbsp;页 
				</span>
			</form>
		</div>
		
		<a name="research_change"></a>
		<div id="edit_research"><input type="text" name="edit_research_id" style="display:none;"/>
			<h4>修改/编辑</h4>名称：<input type="text" name="edit_research_name"/>&nbsp;&nbsp;
			类型：<input type="text" name="edit_research_type"/>&nbsp;&nbsp;
			负责人：<input type="text" name="edit_research_chief"/>&nbsp;&nbsp;
			重要级别：<input type="text" name="edit_research_level"/><br/>
			详情：<br/><textarea rows="3" cols="100" name="edit_research_detail" style="overflow:scroll;"></textarea><br />
			主要成员：<input type="text" name="edit_research_members"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			完成时间： <input type="text" name="edit_research_time" id="datepicker" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span onClick="editresearch()" class="button">确认修改</span>
		</div>
		
		<div id="add_research">
			<h4>添加</h4>名称：<input type="text" name="new_research_name"/>&nbsp;&nbsp;
			类型：<input type="text" name="new_research_type"/>&nbsp;&nbsp;
			负责人：<input type="text" name="new_research_chief"/>&nbsp;&nbsp;
			重要级别：<input type="text" name="new_research_level"/><br/>
			详情：<br/><textarea rows="3" cols="100" name="new_research_detail" style="overflow:scroll;"></textarea><br />
			主要成员：<input type="text" name="new_research_members"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			完成时间： <input type="text" name="new_research_time" id="datepicker2" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span onClick="addresearch()" class="button">添加成果</span>
		</div>
	</div> 
</div>
</body>
</html>