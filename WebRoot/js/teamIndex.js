function member(){
	var a_type = "固定研究人员";
	var type = encodeURIComponent(a_type);
	type = encodeURIComponent(type);
	location.href="read_user_detail_teamIndex?type=" + type;
	
	document.cookie="type="+a_type;
}

function memberTypeChange(){
	var a_type = $(event.target).text();
	var type = encodeURIComponent(a_type);
	type = encodeURIComponent(type);
	location.href="read_user_detail_type_teamIndex?type=" + type;
	
	document.cookie="type="+a_type;
}

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

	type = encodeURIComponent(type);
	type = encodeURIComponent(type);
	pageIndex = encodeURIComponent(pageIndex);
	pageIndex = encodeURIComponent(pageIndex);
	location.href="read_user_detail_type_page_teamIndex.action?currentPage="+pageIndex+"&type="+type;
	
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
	type = encodeURIComponent(type);
	type = encodeURIComponent(type);
	pageIndex = encodeURIComponent(pageIndex);
	pageIndex = encodeURIComponent(pageIndex);
	location.href="read_user_detail_type_page_teamIndex?currentPage="+pageIndex+"&type="+type;
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
	
	type = encodeURIComponent(type);
	type = encodeURIComponent(type);
	pageIndex = encodeURIComponent(pageIndex);
	pageIndex = encodeURIComponent(pageIndex);
	location.href="read_user_detail_type_page_teamIndex.action?currentPage="+pageIndex+"&type="+type;
}
function readDetail(){
	
	var $target = getOutDiv($(event.target));
	var name = $target.children("#memberName").children("span").text();
	name = encodeURIComponent(name);
	name = encodeURIComponent(name);
	
	location.href = "read_user_detail_type_memberDetail?name=" + name;
}

function getOutDiv($current)
{
	if($current.attr("id") == "detail")
		return $current;
	
	$current = $current.parent();
	if($current.attr("id") == "detail")
		return $current;
	
	$current = $current.parent();
	if($current.attr("id") == "detail")
		return $current;
	
	return null;
	
	
	
}