<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/lab.js"></script>
<script type="text/javascript" src="js/noticeIndex.js"></script>
<link rel="stylesheet" type="text/css" href="lab.css">
<link rel="stylesheet" type="text/css" href="css/noticeIndex.css">
<link rel="stylesheet" type="text/css" href="css/labInfoIndex.css">
<title>湖南师范大学数字内容版权保护软件产学研合作基地</title>
</head>
<body>
<div id="main">
   <div style="margin-left:10px;padding-top:10px;">
      <embed src="images/shuji.swf" width=800 height="180" type=application/x-shockwave-flash></embed>
   </div>
    <div id="navigation">
        <a href="read_index_info.action">首页&nbsp;&nbsp;</a>|
        <a href="read_labinfo_labInfoIndex.action">&nbsp;实验室概况&nbsp;&nbsp;</a>|
        <a href="read_researchIndex.action">&nbsp;科学研究&nbsp;&nbsp;</a>|
        <a onclick="member()" style="cursor:pointer">&nbsp;科研队伍&nbsp;&nbsp;</a>|
        <a onclick="nono()" style="cursor:pointer">&nbsp;科研成果&nbsp;&nbsp;</a>|
        <a href="read_newsIndex.action">&nbsp;最新动态&nbsp;&nbsp;</a>|
        <a onclick="nono()" style="cursor:pointer">&nbsp;资源共享&nbsp;&nbsp;</a>|
        <a onclick="nono()" style="cursor:pointer">&nbsp;交流平台&nbsp;&nbsp;</a>|
        <a href="read_labinfo_ruleIndex.action">&nbsp;规章制度&nbsp;&nbsp;</a>|
        <a onclick="check()" style="cursor:pointer">&nbsp;管理&nbsp;</a>
    </div>
    <div class="left_navigator">
    	<img src="images/intro.jpg" alt="实验室概况" />
    <ul style="	padding:5px; margin:0px 0px 0px 0px; margin-bottom:80px;">
       	  <li>>><a href="read_labinfo_labInfoIndex.action">实验室简介</a></li>
          <li>>><a href="read_noticeIndex_page.action">实验室通知</a></li>
    </ul>
    <div class="left">
		<div><img src="images/connect.jpg" alt="联系我们" style="padding-left:3px; padding-top:3px;"/></div>
            <div class="connect">
            	<b>地址</b>：${lab_address}<br />
           	 	<b>邮编</b>：410081<br />
            	<b>邮箱</b>：${lab_email}<br />
            	<b>电话</b>：${lab_telno}<br />
            	<b>传真</b>：${lab_fax}<br />
      	    </div>
      	</div>
    </div>
    <div class="details_container">
    	<img alt="实验室通知" src="images/noticeIndex.jpg" id="noticeIndexImg" /><span>${isNoticeNull}</span>
    	<table id="admin_notice_table" cellspacing="0">
			<tr id="notice_table_title">
				<td height="30" width="350">详情</td>
				<td width="100">发布人</td>
				<td>发布时间</td>
			</tr>
			<c:forEach var="notice" items="${noticeList}">
			<tr>
				<td id="noticeDetail"><div onClick="showNotice()" id="detail_hide"><c:out value="${notice.detail}"></c:out></div></td>
				<td id="noticeReleaser" height="40"><c:out value="${notice.releaser}"/></td>
				<td id="noticePublishTime"><c:out value="${notice.publishtime}"/></td>
			</tr>
			</c:forEach>
		</table>
		
		<div id="notice_page">
			<form action="read_noticeIndex_page.action" name="goto_page" id="goto_page">
				<span onClick="toLastPage()" style="cursor:pointer;">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<input type="text" value="${page_index}" style="width:30px; height:10px;" name="page_index"/>
				<input type="button" value="确认跳转" class="button" onClick="pageChange()"/>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<span onClick="toNextPage()" style="cursor:pointer;">下一页</span>
				<span style="padding-left:100px;">
					当前第&nbsp;&nbsp;<span id="current_page_index">${page_index}</span>&nbsp;&nbsp;页，
					总共&nbsp;&nbsp;<span id="last_page_index">${total_page_index}</span>&nbsp;&nbsp;页 
				</span>
			</form>
		</div>
    </div>
</div>
</body>
</html>