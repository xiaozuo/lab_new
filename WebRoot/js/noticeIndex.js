//上一页  提交页面参数
function toLastPage()
{
	var index = parseInt($("#current_page_index").text());
	if(index <= 1){
		alert("当前已是第一页！");
		return;
	}
	index -= 1;
	
	$("input[name='page_index']").val(index);
	document.getElementById("goto_page").submit();
}

//下一页  提交页面参数
function toNextPage()
	{
		var index = parseInt($("#current_page_index").text());
		if(index >= $("#last_page_index").text()){
			alert("当前已是最后一页！");
			return;
		}
		index += 1;
		
		$("input[name='page_index']").val(index);
		document.getElementById("goto_page").submit();
	}
//输入页面要在范围之内
function pageChange()
{
	//alert($("input[name='page_index']").val());
	var page_index = $("input[name='page_index']").val();
	if(page_index > $("#last_page_index").text() || page_index < 0){
		alert("输入页码不在正确范围之内，请重新输入！");
		return;
	};
	var parameter = {"page_index":page_index};
	location.href = "read_noticeIndex_page.action?page_index=" + page_index;
}
function showNotice(){
	var $currentNotice = $(event.target);
	var detai = $currentNotice.text();
	
	$currentNotice = $currentNotice.parent().next();
	var releaser = $currentNotice.text();
	
	$currentNotice = $currentNotice.next();
	var time = $currentNotice.text();

	$("tr").remove();
	
	var html = "<a onclick='f5()' id='return'>返回通知主页</a><div style='margin-top:10px;'><b>发布人：</b>"
		+ releaser +"</div><div><b>发布时间：</b>"
		+ time +"<div><b>详情：</b><div style='height:400px;width:540px;overflow:auto;'>" 
		+ detai + "</div>";
	
	$("#admin_notice_table").replaceWith(html);
	$("#notice_page").remove();
}
function f5(){
	location.reload();
}