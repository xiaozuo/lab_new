function read_researchIndex(){
	document.cookie="type=all";
	location.href = "read_researchIndex.action";
}


//上一页
function toLastPage(){
	var pageIndex = parseInt($("#current_page_index").text());
	if(pageIndex < 2){
		alert("当前已是第一页！");
		return;
	}
	else{
		pageIndex -= 1;
		$("input[name='currentPage']").val(pageIndex);
	}
	
	var strCookie = document.cookie;
	var arrCookie=strCookie.split("; "); //分割符为分号+空格！！
	var type; 
	for(var i=0;i<arrCookie.length;++i)
	{ 
		var arr=arrCookie[i].split("="); 
		if("type"==arr[0]){ 
			type=arr[1]; 
			break; 
		} 
	}
	if(type == "all"){
		location.href="read_researchIndex_page.action?currentPage="+pageIndex;
	}
	else if(type == null){
		location.href="read_researchIndex_page.action?currentPage="+pageIndex;
	}
	else {
		type = encodeURIComponent(type);
		type = encodeURIComponent(type);
		pageIndex = encodeURIComponent(pageIndex);
		pageIndex = encodeURIComponent(pageIndex);
		location.href="read_proj_achievementIndex_page.action?currentPage="+pageIndex+"&type="+type;
	}
}
//下一页
function toNextPage(){
	var pageIndex = parseInt($("#current_page_index").text());
	//alert(pageIndex);
	//alert($("#last_page_index").text());
	if(pageIndex >= $("#last_page_index").text() ){
		alert("当前已是最后一页！");
		return;
	}
	else{
		pageIndex += 1;
		//alert(pageIndex);
		$("input[name='currentPage']").val(pageIndex);
	}
	
	var strCookie = document.cookie;
	var arrCookie=strCookie.split("; "); //分割符为分号+空格！！
	var type; 
	for(var i=0;i<arrCookie.length;++i)
	{ 
		var arr=arrCookie[i].split("="); 
		if("type"==arr[0]){ 
			type=arr[1]; 
			break; 
		} 
	}
	if(type == "all"){
		location.href="read_researchIndex_page.action?currentPage="+pageIndex;
	}
	else if(type == null){
		location.href="read_researchIndex_page.action?currentPage="+pageIndex;
	}
	else {
		type = encodeURIComponent(type);
		type = encodeURIComponent(type);
		pageIndex = encodeURIComponent(pageIndex);
		pageIndex = encodeURIComponent(pageIndex);
		location.href="read_proj_achievementIndex_page?currentPage="+pageIndex+"&type="+type;
	}
}
//页面跳转
function PageChange(){
	var pageIndex = parseInt($("input[name='currentPage']").val());
	if(pageIndex < 1 || pageIndex > $("#last_page_index").text()){
		alert("输入页码不在正确范围之内，请重新输入！");
		return;
	}
	var strCookie = document.cookie;
	var arrCookie=strCookie.split("; "); //分割符为分号+空格！！
	var type; 
	for(var i=0;i<arrCookie.length;++i)
	{ 
		var arr=arrCookie[i].split("="); 
		if("type"==arr[0]){ 
			type=arr[1]; 
			break; 
		} 
	}
	if(type == "all"){
		location.href="read_researchIndex_page.action?currentPage="+pageIndex;
	}
	else if(type == null){
		location.href="read_researchIndex_page.action?currentPage="+pageIndex;
	}
	else {
		type = encodeURIComponent(type);
		type = encodeURIComponent(type);
		pageIndex = encodeURIComponent(pageIndex);
		pageIndex = encodeURIComponent(pageIndex);
		location.href="read_proj_achievementIndex_page.action?currentPage="+pageIndex+"&type="+type;
	}
}
function researchIndexTypeChange(){
	var a_type = $(event.target).text();
	var type = encodeURIComponent(a_type);
	type = encodeURIComponent(type);
	location.href="read_proj_achievementIndex?type=" + type;

	document.cookie="type="+a_type;
}

//researchIndex 显示详细
function showResearch(){
	var $currentResearch = $(event.target);
	var name = $currentResearch.text();
	
	$currentResearch = $currentResearch.parent().next();
	var detail = $currentResearch.text();
	
	$currentResearch = $currentResearch.next();
	$currentResearch = $currentResearch.next();
	var time = $currentResearch.text();
	
	$currentResearch = $currentResearch.next();
	var chief = $currentResearch.text();
	
	$currentResearch = $currentResearch.next();
	var members = $currentResearch.text();

	$("tr").remove();
	
	var html = "<a onclick='f5()' id='return'>返回科学研究主页</a><div style='margin-top:10px;'><b>标题：</b>"
		+ name +"</div><div><b>时间：</b>"
		+ time +"</div><div><b>负责人：</b>"
		+ chief +"</div><div><b>主要成员：</b>"
		+ members +"<div><b>详情：</b><div style='height:330px;width:560px;overflow:auto;'>" 
		+ detail + "</div>";
	
	$("#research_table").replaceWith(html);
	$("#research_page").remove();
}
function f5(){
	location.reload();
}
