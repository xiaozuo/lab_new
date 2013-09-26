<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="lab.css">
<link rel="stylesheet" type="text/css" href="css/labInfoIndex.css">
<link rel="stylesheet" type="text/css" href="css/researchIndex.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/researchIndex.js"></script>
<script type="text/javascript" >
</script>

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
        <a  onclick="nono()" style="cursor:pointer">&nbsp;资源共享&nbsp;&nbsp;</a>|
        <a onclick="nono()" style="cursor:pointer">&nbsp;交流平台&nbsp;&nbsp;</a>|
        <a href="read_labinfo_ruleIndex.action">&nbsp;规章制度&nbsp;&nbsp;</a>|
        <a onclick="check()" style="cursor:pointer">&nbsp;管理&nbsp;</a>
    </div>
    <div class="left_navigator">
    	<img src="images/research.jpg" alt="科学研究" />
    <ul style="	padding:5px; margin:0px 0px 0px 0px; margin-bottom:80px;cursor:pointer;">
    	<li><a onclick="read_researchIndex()" style="cursor:pointer;">研究成果</a></li>
       	  <c:forEach var="achievement" items="${achievementType}">
				<li onclick="researchIndexTypeChange()"><a><c:out value="${achievement.name}"></c:out></a></li>
		  </c:forEach>
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
    	<img src="images/researchIndex.jpg" id="researchIndexImg" />
			<div><b>名称：</b>${name}</div>
			<div><b>负责人：</b>${chief}</div>
			<div><b>主要参与成员：</b>${members}</div>
			<div><b>时间：</b>${time}</div>
			<div><b>详情：</b>${detail}</div>
	</div> 
</div>
</body>
</html>