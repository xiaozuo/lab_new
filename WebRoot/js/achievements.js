function read_research(){
	document.cookie="type=all";
	location.href = "read_research.action";
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
		location.href="read_research_page.action?currentPage="+pageIndex;
	}
	else if(type == null){
		location.href="read_research_page.action?currentPage="+pageIndex;
	}
	else {
		type = encodeURIComponent(type);
		type = encodeURIComponent(type);
		pageIndex = encodeURIComponent(pageIndex);
		pageIndex = encodeURIComponent(pageIndex);
		location.href="read_proj_achievement_page.action?currentPage="+pageIndex+"&type="+type;
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
		location.href="read_research_page.action?currentPage="+pageIndex;
	}
	else if(type == null){
		location.href="read_research_page.action?currentPage="+pageIndex;
	}
	else {
		type = encodeURIComponent(type);
		type = encodeURIComponent(type);
		pageIndex = encodeURIComponent(pageIndex);
		pageIndex = encodeURIComponent(pageIndex);
		location.href="read_proj_achievement_page.action?currentPage="+pageIndex+"&type="+type;
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
		location.href="read_research_page.action?currentPage="+pageIndex;
	}
	else if(type == null){
		location.href="read_research_page.action?currentPage="+pageIndex;
	}
	else {
		type = encodeURIComponent(type);
		type = encodeURIComponent(type);
		pageIndex = encodeURIComponent(pageIndex);
		pageIndex = encodeURIComponent(pageIndex);
		location.href="read_proj_achievement_page.action?currentPage="+pageIndex+"&type="+type;
	}
}

function researchTypeChange(){
	var a_type = $(event.target).text();
	var type = encodeURIComponent(a_type);
	type = encodeURIComponent(type);
	location.href="read_proj_achievement?type=" + type;

	document.cookie="type="+a_type;
}
//编辑research
var researchRecord = {};
function showResearchDown(){
	var $current_target = $(event.target).parent().parent();
	$("input[name='edit_research_name']").val($current_target.text());
	researchRecord.name = $(event.target);

	$current_target = $current_target.next();
	$("textarea[name='edit_research_detail']").val($current_target.text());
	researchRecord.detail = $current_target.children();
	
	$current_target = $current_target.next();
	$("input[name='edit_research_type']").val($current_target.text());
	researchRecord.type = $current_target;
	
	$current_target = $current_target.next();
	$("input[name='edit_research_time']").val($current_target.text());
	researchRecord.time = $current_target;
	
	$current_target = $current_target.next();
	$("input[name='edit_research_level']").val($current_target.text());
	researchRecord.level = $current_target;
	
	$current_target = $current_target.next();
	$("input[name='edit_research_chief']").val($current_target.text());
	researchRecord.chief = $current_target;
	
	$current_target = $current_target.next();
	$("input[name='edit_research_members']").val($current_target.text());
	researchRecord.members = $current_target;
	
	$current_target = $current_target.next();
	$("input[name='edit_research_id']").val($current_target.text());
}

function editresearch()
{
	var name = $("input[name='edit_research_name']").val();
	var research_name = encodeURIComponent(name);
	
	var detail = $("textarea[name='edit_research_detail']").val();
	var research_detail = encodeURIComponent(detail);
	
	var type = $("input[name='edit_research_type']").val();
	var research_type = encodeURIComponent(type);
	
	var time = $("input[name='edit_research_time']").val();
	var research_time = encodeURIComponent(time);
	
	var level = $("input[name='edit_research_level']").val();
	var research_level = encodeURIComponent(level);
	
	var chief = $("input[name='edit_research_chief']").val();
	var research_chief = encodeURIComponent(chief);
	
	var members = $("input[name='edit_research_members']").val();
	var research_members = encodeURIComponent(members);
	
	var research_id = encodeURIComponent($("input[name='edit_research_id']").val());
	
	var parameters = {
					  "research_name":research_name,
					  "research_detail":research_detail,
					  "research_type":research_type,
					  "research_time":research_time,
					  "research_level":research_level,
					  "research_chief":research_chief,
					  "research_members":research_members,
					  "research_id":research_id
					  };

	//$.get("lab/edit_research.action", parameters, editresearchCallback);
	var ajax_request = {
			url:"lab/edit_research.action"
		   ,data:parameters
		   ,error:function(){alert("error");}
		   ,complete:function(){/*alert("complete");*/}
		   ,success:function(data){researchRecord.name.text(name);
		   							researchRecord.detail.text(detail);
		   							researchRecord.type.text(type);
		   							researchRecord.time.text(time);
		   							researchRecord.level.text(level);
		   							researchRecord.chief.text(chief);
		   							researchRecord.members.text(members);
		   							alert("修改成功！");}
	}
	$.ajax(ajax_request);
}

//function editresearchCallback(data)
//{
//	alert(data);
//	location.reload();
//}

//添加research
function addresearch(){
	var new_research_name = encodeURIComponent($("input[name='new_research_name']").val());
	var new_research_detail = encodeURIComponent($("textarea[name='new_research_detail']").val());
	var new_research_type = encodeURIComponent($("input[name='new_research_type']").val());
	var new_research_time = encodeURIComponent($("input[name='new_research_time']").val());
	var new_research_level = encodeURIComponent($("input[name='new_research_level']").val());
	var new_research_chief = encodeURIComponent($("input[name='new_research_chief']").val());
	var new_research_members = encodeURIComponent($("input[name='new_research_members']").val());

	alert($("input[name='new_research_time']").val());
	if(!(new_research_name && new_research_detail && new_research_type && new_research_time && new_research_level && new_research_chief && new_research_members))
	{
		alert("输入信息不完整，请填写完整后提交！");
		return;
	}
	var parameters = {"new_research_name":new_research_name,
					  "new_research_detail":new_research_detail,
					  "new_research_type":new_research_type,
					  "new_research_time":new_research_time,
					  "new_research_level":new_research_level,
					  "new_research_chief":new_research_chief,
					  "new_research_members":new_research_members};
	$.ajax({
		url:"lab/add_research.action",
		data:parameters,
		error:function(){alert("error");},
		success:function(data){alert("添加成功！");location.href="read_research";}
	});
	//$.get("lab/add_research.action",parameters,function(data){location.href="read_research";});
	//document.getElementById("add_research").submit();
}

function chooseMethod(){
	var choosen = $("input[type='radio']:checked").val();
	if(!(choosen)){
		alert("请先选择！");
		return;
	}
	$("input[name='currentMethod']").val(choosen);
	choosen = encodeURIComponent(choosen);
	//Httpsession session = null;
	var parameter = {"choosen":choosen};
	
	$.ajax({
		url:"lab/show_method.action",
		data:parameter,
		error:function(){alert("error");},
		success:function(data){alert("修改成功！");location.href="achieveConfig.jsp";}
	});
} 

//function getPosition(){
//	var $current_target = $(event.target).text();
//	alert($current_target);
//	$("input[name='currentPosition']").val($current_target);
//}
function addAchieveType(){
	var newType = $("input[name='newType']").val();
	var html = '<span><span onclick="showTypeDown()" id="typeName">' + newType + '</span><span style="display:none;"></span><span id="deleteType" onclick="deleteAchieveType()">×</span>&nbsp&nbsp&nbsp&nbsp</span>';
	
	newType = encodeURIComponent(newType);
	var parameter = {"newType":newType};
	
	$.ajax({
		url:"add_achievement_type.action",
		data:parameter,
		error:function(){alert("error");},
		success:function(data){alert("添加成功！"); $("#configDiv").append(html);}
	});
}
function deleteAchieveType(){
	var deleteType = $(event.target).parent().text();
	deleteType = deleteType.substr(8,deleteType.length-38);
	//alert(deleteType.length);
	deleteType = encodeURIComponent(deleteType);
	
	var parameter = {"deleteType":deleteType};
	if(!confirm("亲，你确定删除么？"))
		return;
	$(event.target).parent().remove();
	$.ajax({
		url:"delete_achievement_type.action",
		data:parameter,
		error:function(){alert("error");},
		success:function(data){alert("删除成功！");}
	});	
}

var $type = null;
function showTypeDown(){
	$type = $(event.target);
	var editType = $(event.target).text();
	var editId = $(event.target).next().text()
	$("input[name='editAchieveType']").val(editType);
	$("input[name='editAchieveId']").val(editId);
}
function editAchieveType(){
	var a_editType = $("input[name='editAchieveType']").val();
	var editId = $("input[name='editAchieveId']").val();
	editId = encodeURIComponent(editId);
	var editType = encodeURIComponent(a_editType);
	
	var parameters = {"editType":editType,"editId":editId};
	$.ajax({
		url:"edit_achievement_type.action",
		data:parameters,
		error:function(){alert("error");},
		success:function(){alert("编辑成功！");$type.text(a_editType);}
	});
}

