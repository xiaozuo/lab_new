//添加删除通知
	//添加通知
function addnotice()
{
	//alert($("textarea[name='new_notic_detail']").val());
	if($("textarea[name='new_notic_detail']").val() && $("input[name='new_notic_releaser']").val() && $("input[name='date']").val())
	{
		var noticeDetail = encodeURIComponent($("textarea[name='new_notic_detail']").val());
		var noticeReleaser = encodeURIComponent($("input[name='new_notic_releaser']").val());
		var noticePublishtime = encodeURIComponent($("input[name='date']").val());
		
	    var parameters = {"noticeDetail":noticeDetail, "noticeReleaser":noticeReleaser, "noticePublishtime":noticePublishtime};
	    //alert(parameters.toString());
	    $.get("lab/add_notice.action", parameters, addnoticeCallback);		
	}
	else {
		alert("添加通知不完整，请输入完整后提交！");
		return;
	}
}

function addnoticeCallback(data)
{
	//alert($("input[name='new_notic_releaser']").val());
	//var html = "<tr><td>" 
	//			+ $("textarea[name='new_notic_detail']").val() 
	//			+ "</td><td>" + $("input[name='new_notic_releaser']").val()
	//			+ "</td><td>" + $("input[name='date']").val() 
	//			+ "</td><td><input id='choose_status' type='checkbox'/></td></tr>";
	//$("#admin_notice tr:first-child").after(html);
	
	$("textarea[name='new_notic_detail']").val("");
	$("input[name='new_notic_releaser']").val("");
	$("input[name='date']").val("");
	alert("添加成功！");
	location.reload();
}
	//删除通知
function deleteNotice()
{
	var notice_ids = "";
	
	$("input:checkbox").each(function(index){
		if($(this).attr("id") != "choose_status")
			return true;
		if($(this).attr("checked") == "checked")
		{
			var notice_id = $(this).parent().siblings("#notice_id").text();
			notice_ids += ("-" + notice_id);
			$(this).parent().parent().remove();
			alert($(this).parent().siblings("#notice_id").text());
		}
	});
	if(!confirm("亲，你确定删除么？"))
		return;
	var parameters = {"delete_notice_ids": encodeURIComponent(notice_ids)}
	$.get("lab/delete_notice.action", parameters, removeNoticeCallBack);
}

function removeNoticeCallBack(data)
{
	location.reload();
	alert("您已经删除了所选通知！");
}
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
	location.href = "read_notice_page.action?page_index=" + page_index;
	/*$.ajax({
		   url:"lab/read_notice_page.action",
		   data:parameter,
		   success:function(data){location.reload();},
		   error:function(){alert("error");}
		   });*/
	//$.get("lab/read_notice_page.action", parameter, function(data){alert(data); location.reload();});
}

//将通知内容显示到下方修改区
function showNoticeDown()
{
	var $current_target = $(event.target).parent().parent();
	$("textarea[name='edit_notic_detail']").text($current_target.text());
	
	$current_target = $current_target.next();
	$("input[name='edit_notic_releaser']").val($current_target.text());
	
	$current_target = $current_target.next();
	$("input[name='edit_notice_date']").val($current_target.text());
	
	$current_target = $current_target.next();
	$("input[name='edit_notic_id']").val($current_target.text());
}
//修改通知
function editnotice()
{
	var editNoticeId = encodeURIComponent($("input[name='edit_notic_id']").val());
	var editNoticeDetail = encodeURIComponent($("textarea[name='edit_notic_detail']").val());
	var editNoticeReleaser = encodeURIComponent($("input[name='edit_notic_releaser']").val());
	var editNoticePublishtime = encodeURIComponent($("input[name='edit_notice_date']").val());
	//alert($("input[name='edit_notic_detail']").val());
    var parameters = {"editNoticeId":editNoticeId,"editNoticeDetail":editNoticeDetail, "editNoticeReleaser":editNoticeReleaser, "editNoticePublishtime":editNoticePublishtime};
    //alert(parameters.toString());
    $.get("lab/edit_notice.action", parameters, editnoticeCallback);
}
function editnoticeCallback(data)
{
	location.reload();
	alert("修改成功！");
}