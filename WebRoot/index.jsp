<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="utf-8"%>
<%@page session="true" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>湖南师范大学数字内容版权保护软件产学研合作基地</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="lab.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/lab.js"></script>
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
       <a onClick="member()" style="cursor:pointer">&nbsp;科研队伍&nbsp;&nbsp;</a>|
       <a onClick="nono()" style="cursor:pointer">&nbsp;科研成果&nbsp;&nbsp;</a>|
       <a href="read_newsIndex.action">&nbsp;最新动态&nbsp;&nbsp;</a>|
       <a onClick="nono()" style="cursor:pointer">&nbsp;资源共享&nbsp;&nbsp;</a>|
       <a onClick="nono()" style="cursor:pointer">&nbsp;交流平台&nbsp;&nbsp;</a>|
       <a href="read_labinfo_ruleIndex.action">&nbsp;规章制度&nbsp;&nbsp;</a>|
       <a onClick="check()" style="cursor:pointer">&nbsp;管理&nbsp;</a>
   </div>
        <div class="left" id="login">
       	 	<div><img src="images/register.jpg" alt="用户登录" style="padding-left:3px; padding-top:3px;"/></div>
			<form id="login_change">
         		 <div id="form_style">
            		 用户名：<input type="text" name="user" class = "text_style" /><br />
            		 密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" class = "text_style" /><br />
             	</div>
      			<input onClick="init()" type="button" value="登录" style = "float:left; margin-left:70px; margin-top:15px;"/>
          		<br><span style="padding-left:5px;">${result}</span>
          	</form>
        </div>
        
		<div class="middle">
        	<div class="title"><img src="images/introduce.jpg" alt="简介" /></div>
            <div class="content">
            	${resume }
            </div>
            <div id="introduce"><a href="read_labinfo_labInfoIndex.action">[详情]</a></div>
        </div>
        <div class="news_notice">
        	<div class="title"><img src="images/news.jpg" alt="动态" /></div>
        		<div class="n_content">
        			${isNewsNull}
        			<c:forEach var="news" items="${newsList}">
						<div class="noticeNewsDetail" onClick="newsDetail()" style="cursor:pointer">
							<c:out value="${news.detail}"></c:out>
						</div>
						<div style="display:none;"><c:out value="${news.id}"></c:out><br/></div>
					</c:forEach>
				</div>
        </div>
		<div class="left">
        	<div><img src="images/connect.jpg" alt="联系我们" style="padding-left:3px; padding-top:3px;"/></div>
            <div class="connect">
            	<b>地址</b>：${address}<br />
           	 	<b>邮编</b>：410081<br />
            	<b>邮箱</b>：${email}<br />
            	<b>电话</b>：${telno}<br />
            	<b>传真</b>：${fax}<br />
            </div>
        </div>
		<div class="middle">
        	<div class="title"><img src="images/achieve.jpg" alt="成果图标" />
            	<span id="more"> 　　　　　　　　　　　　　　　>><a href="read_researchIndex.action">&nbsp;更多</a></span>
            </div>
            <div class="n_content">
            	${isAchieveNull}
            	<c:forEach var="achievement" items="${achievement}">
            		<div id="achievementDetail" onClick="achieveDetail()" style="cursor:pointer">
            			<c:out value="${achievement.detail}"></c:out>
            		</div>
            		<div style="display:none;"><c:out value="${achievement.id}"></c:out><br/></div>
            	</c:forEach>
            </div>
        </div>
        <div class="news_notice">
        	<div class="title"><img src="images/notice.jpg" alt="通告图标" /></div>
        	    <div class="n_content">
        	    	${isNoticeNull}
        			<c:forEach var="notice" items="${noticeList}">
						<div class="noticeNewsDetail" onClick="noticeDetail()" style="cursor:pointer">
							<c:out value="${notice.detail}"></c:out>
						</div>
						<div style="display:none;"><c:out value="${notice.id}"></c:out><br/></div>
					</c:forEach>
				</div>
        </div>
        <div id="chain">
        	<p>友情链接</p>
            <div>
            <a href="http://www.hunnu.edu.cn/">&nbsp;湖南师范大学&nbsp;&nbsp;</a>|
            <a href="http://mc.hunnu.edu.cn/">&nbsp;湖南师范大学数学与计算机科学学院&nbsp;&nbsp;</a>|
            <a href="http://yjsc.hunnu.edu.cn/">&nbsp;湖南师范大学研究生处&nbsp;&nbsp;</a>|
            <a href="http://zsb.hunnu.edu.cn/">&nbsp;湖南师范大学招生信息网&nbsp;&nbsp;</a>|
            <a href="http://tieba.baidu.com/f?ie=utf-8&kw=%E6%B9%96%E5%8D%97%E5%B8%88%E8%8C%83%E5%A4%A7%E5%AD%A6">&nbsp;湖南师范大学百度贴吧&nbsp;</a></div>
        	</div>
        <div id="foot">Copyright hnnu.cn 湖南师范大学 2013</div>
</div>
  </body>
</html>
