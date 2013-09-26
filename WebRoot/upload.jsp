<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/upload.js"></script>
<link rel="stylesheet" type="text/css" href="lab.css">
<link rel="stylesheet" type="text/css" href="css/labInfoIndex.css">
<link rel="stylesheet" type="text/css" href="css/upload.css">
<title>湖南师范大学数字内容版权保护软件产学研合作基地</title>
</head>
<body>
<div id="main">
   <div style="margin-left:10px;padding-top:10px;">
      <embed src="images/shuji.swf" width=800 height="180" type=application/x-shockwave-flash></embed>
   </div>
    <div id="navigation">
        <a href="index.jsp">首页&nbsp;&nbsp;</a>¦
        <a href="read_labinfo_labInfoIndex.action">&nbsp;实验室概况&nbsp;&nbsp;</a>¦
        <a href="read_researchIndex.action">&nbsp;科学研究&nbsp;&nbsp;</a>¦
        <a href="team.html">&nbsp;科研队伍&nbsp;&nbsp;</a>¦
        <a href="plug-in.html">&nbsp;科研成果&nbsp;&nbsp;</a>¦
        <a href="news.html">&nbsp;最新动态&nbsp;&nbsp;</a>¦
        <a href="resource.html">&nbsp;资源共享&nbsp;&nbsp;</a>¦
        <a href="community.html">&nbsp;交流平台&nbsp;&nbsp;</a>¦
        <a href="rules.html">&nbsp;规章制度&nbsp;</a>
    </div>
    <div class="left_navigator">
    	<img src="images/resoure.jpg" alt="资源共享" />
    </div>
    <div class="details_container">
    	<img src="images/upload.jpg" id="labInfoIndexImg" />
    	<div id="upload">
	    	<form action="file_upload.action" method="post" enctype="multipart/form-data">
				<b>文件上传：</b><input type="file" id="choose_file" name="clientFile"/>
				<input type="submit" value="确认上传" class="button"/>
			</form>
		</div>
			<table id="file_table" cellspacing="0">
			<tr id="file_table_title">
				<td height="30" width="350">文件名</td>
				<td style="display:none">路径</td>
				<td width="100">上传人</td>
				<td>上传时间</td>
			</tr>
			<c:forEach var="files" items="${uploadFileList}">
			<tr height="20">
				<td><div id='${files.id}'  onClick="download(this)"><input id='${files.id}_file' type='hidden' value='${files.filepath}'><c:out value="${files.filename}"></c:out></div></td>
				<td><c:out value="${files.user}"/></td>
				<td><c:out value="${files.time}"/></td>
			</tr>
			</c:forEach>
		</table>
    </div>
</div>
</body>
</html>