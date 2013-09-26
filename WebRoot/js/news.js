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
	location.href = "read_news_page.action?news_page_index="+index;
}

//添加删除新闻动态
//添加新闻动态
function addnews()
{
//alert($("textarea[name='new_news_detail']").val());
if($("input[name='new_news_title']").val() && $("textarea[name='new_news_detail']").val() && $("input[name='new_news_releaser']").val() && $("input[name='new_news_date']").val())
{
	var newsTitle = encodeURIComponent($("input[name='new_news_title']").val());
	var newsDetail = encodeURIComponent($("textarea[name='new_news_detail']").val());
	var newsReleaser = encodeURIComponent($("input[name='new_news_releaser']").val());
	var newsPublishtime = encodeURIComponent($("input[name='new_news_date']").val());
	
    var parameters = {"newsTitle":newsTitle ,"newsDetail":newsDetail, "newsReleaser":newsReleaser, "newsPublishtime":newsPublishtime};
    //alert(parameters.toString());
    $.get("lab/add_news.action", parameters, addnewsCallback);		
}
else {
	alert("添加新闻动态信息不完整，请输入完整后提交！");
	return;
}
}

function addnewsCallback(data)
{
	//alert($("input[name='new_news_releaser']").val());
	//var html = "<tr><td>"+ $("input[name='new_news_title']").val()
	//			+ "</td><td>" + $("textarea[name='new_news_detail']").val() 
	//			+ "</td><td>" + $("input[name='new_news_releaser']").val()
	//			+ "</td><td>" + $("input[name='new_news_date']").val() 
	//			+ "</td><td><input id='choose_status' type='checkbox'/></td></tr>";
	//$("#admin_news_table tr:first-child").after(html);
	
	$("input[name='new_news_title']").val("");
	$("textarea[name='new_news_detail']").val("");
	$("input[name='new_news_releaser']").val("");
	$("input[name='new_news_date']").val("");
	
	location.reload();
	
	alert("添加成功！");
}
//删除新闻动态
function deletenews()
{
var news_ids = "";

$("input:checkbox").each(function(index){
	if($(this).attr("id") != "choose_status")
		return true;
	if($(this).attr("checked") == "checked")
	{
		var news_id = $(this).parent().siblings("#news_id").text();
		news_ids += ("-" + news_id);
		$(this).parent().parent().remove();
		//alert($(this).parent().siblings("#news_id").text());
	}
});
	if(!confirm("亲，你确定删除么？"))
		return;

	var parameters = {"delete_news_ids": encodeURIComponent(news_ids)}
	$.get("lab/delete_news.action", parameters, removenewsCallBack);
}

function removenewsCallBack(data)
{
	location.reload();
	alert("您已经删除了所选动态！");
}
//将新闻动态内容显示到下方修改区
function showNewsDown()
{
	//alert("...");
	//alert($(event.target).text());
	var $current_target = $(event.target).parent().parent();
	$("input[name='edit_news_title']").val($current_target.text());

	$current_target = $current_target.next();
	$("textarea[name='edit_news_detail']").text($current_target.text());
	
	$current_target = $current_target.next();
	$("input[name='edit_news_releaser']").val($current_target.text());
	
	$current_target = $current_target.next();
	$("input[name='edit_news_date']").val($current_target.text());
	
	$current_target = $current_target.next();
	$("input[name='edit_news_id']").val($current_target.text());
}
//修改新闻动态
function editnews()
{
	var editNewsId = encodeURIComponent($("input[name='edit_news_id']").val());
	var editNewsTitle = encodeURIComponent($("input[name='edit_news_title']").val());
	var editNewsDetail = encodeURIComponent($("textarea[name='edit_news_detail']").val());
	var editNewsReleaser = encodeURIComponent($("input[name='edit_news_releaser']").val());
	var editNewsTime = encodeURIComponent($("input[name='edit_news_date']").val());
	//alert($("input[name='edit_notic_detail']").val());
    var parameters = {"editNewsId":editNewsId,"editNewsTitle":editNewsTitle,"editNewsDetail":editNewsDetail, "editNewsReleaser":editNewsReleaser, "editNewsTime":editNewsTime};
    //alert(parameters.toString());
    $.get("lab/edit_news.action", parameters, editnewsCallback);
}
function editnewsCallback(data)
{
	location.reload();
	alert("修改成功！");
}