//上一页  提交页面参数
function toLastPage()
{
	var index = parseInt($("#news_current_page_index").text());
	if(index <= 1){
		alert("当前已是第一页！");
		return;
	}
	index -= 1;
	
	$("input[name='news_page_index']").val(index);
	document.getElementById("goto_news_page").submit();
}

//下一页  提交页面参数
function toNextPage()
	{
		var index = parseInt($("#news_current_page_index").text());
		if(index >= $("#news_last_page_index").text()){
			alert("当前已是最后一页！");
			return;
		}
		index += 1;
		
		$("input[name='news_page_index']").val(index);
		document.getElementById("goto_news_page").submit();
	}

//输入页面在正确范围之内
function PageChange()
{
	var index = $("input[name='news_page_index']").val();
	if(index > $("#news_last_page_index").text() || index < 0){
		alert("输入页码不在正确范围之内，请重新输入！");
		return;
	}
	location.href = "read_newsIndex_page.action?news_page_index="+index;
}
function showNews(){
	var $currentNews = $(event.target);
	var title = $currentNews.text();
	
	$currentNews = $currentNews.parent().next();
	var detail = $currentNews.text();
	
	$currentNews = $currentNews.next();
	var releaser = $currentNews.text();
	
	$currentNews = $currentNews.next();
	var time = $currentNews.text();

	$("tr").remove();
	
	var html = "<a onclick='f5()' id='return'>返回最新动态主页</a><div style='margin-top:10px;'><b>标题：</b>"
		+ title +"</div><div><b>发布人：</b>"
		+ releaser +"</div><div><b>发布时间：</b>"
		+ time +"<div><b>详情：</b><div style='height:360px;width:540px;overflow:auto;'>" 
		+ detail + "</div>";
	
	$("#admin_news_table").replaceWith(html);
	$("#news_page").remove();
}
function f5(){
	location.reload();
}