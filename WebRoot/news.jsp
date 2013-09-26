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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/lab.js"></script>
<script type="text/javascript" src="js/news.js"></script>
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
<div id="admin">
	<%= session.getAttribute("s_user")%>,欢迎您！
	<a href="read_user_detail.action">修改个人信息&nbsp;</a>
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
	<div id="admin_news">
		<div class="navPosition">
			<img src="images/b.jpg"/>
			当前位置>>实验室信息>>最新动态
		</div>
		<table id="admin_news_table" cellspacing="0">
			<tr id="news_table_title">
				<td height="45">标题</td>
				<td>详情</td>
				<td>发布人</td>
				<td>发布时间</td>
				<td style="display:none;">id</td>
				<td>
					<input type="checkbox" id="choose_all"/>全选
					<div onclick="deletenews()" style="color:#33F;text-decoration:underline;">删除动态</div>
				</td>
			</tr>
			<c:forEach var="news" items="${newsList}">
			<tr>
				<td id="newsTitle" height="45"><div onclick="showNewsDown()" class="limit_text_length"><a href="#news_change"><c:out value="${news.title}"/></a></div></td>
				<td id="newsDetail"><div class="limit_text_length"><c:out value="${news.detail}"></c:out></div></td>
				<td id="newsReleaser"><c:out value="${news.releaser}"/></td>
				<td id="newsTime"><c:out value="${news.time}"/></td>
				<td id="news_id" style="display:none;"><c:out value="${news.id}"/></td>
				<td><input id="choose_status" type="checkbox"/></td>
			</tr>
			</c:forEach>
		</table>
		
		<div id="news_page">
			<form action="read_news_page.action" name="goto_page" id="goto_news_page">
				<span onClick="toLastPage()" style="cursor:pointer;">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<input type="text" value="${news_page_index}" style="width:30px; height:10px;" name="news_page_index"/>
				<input type="button" onclick="PageChange()" value="确认跳转" class="button"/>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<span onClick="toNextPage()" style="cursor:pointer;">下一页</span>
				<span style="padding-left:100px;">
					当前第&nbsp;&nbsp;<span id="news_current_page_index">${news_page_index}</span>&nbsp;&nbsp;页，
					总共&nbsp;&nbsp;<span id="news_last_page_index">${news_total_page_index}</span>&nbsp;&nbsp;页 
				</span>
			</form>
		</div>
		
		<a name="news_change"></a>
		<div id="edit_news"><input type="text" name="edit_news_id" style="display:none;"/>
			<h4>修改/编辑</h4>标题：<input type="text" name="edit_news_title"/><br/>
			详情：<br/><textarea rows="3" cols="100" name="edit_news_detail" style="overflow:scroll;"></textarea><br />
			发布人：<input type="text" name="edit_news_releaser"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			发布时间： <input type="text" name="edit_news_date" id="datepicker" />
			<span onClick="editnews()" class="button">确认修改</span>
		</div>
		
		<div id="add_news">
			<h4>添加</h4>标题：<input type="text" name="new_news_title"/><br/>
			详情：<br/><textarea rows="3" cols="100" name="new_news_detail" style="overflow:scroll;"></textarea><br />
			发布人：<input type="text" name="new_news_releaser"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			发布时间： <input type="text" name="new_news_date" id="datepicker2" />
			<span onClick="addnews()" class="button">添加通知</span>
		</div>
	</div> 
</div>
</body>
</html>