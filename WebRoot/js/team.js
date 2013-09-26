function addMemberType(){
	var newType = $("input[name='newType']").val();
	newType = encodeURIComponent(newType);
	
	var html = '<span onclick="showTypeDown()" id="memberTypeName"></span><span style="display:none;"></span><span id="deleteType" onclick="deleteMemberType()">×</span>&nbsp&nbsp&nbsp&nbsp';
	
	var parameter = {"newType":newType};
	
	$.ajax({
		url:"add_membertype.action",
		data:parameter,
		error:function(){alert("error");},
		success:function(data){alert("添加成功！");$("#configDiv").append(html);}
	});
}
function deleteMemberType(){
	var deleteType = $(event.target).parent().text();
	deleteType = deleteType.substr(8,deleteType.length-38);
	//alert(deleteType.length);
	deleteType = encodeURIComponent(deleteType);
	
	var parameter = {"deleteType":deleteType};
	if(!confirm("亲，你确定删除么？"))
		return;
	$(event.target).parent().remove();
	$.ajax({
		url:"delete_membertype.action",
		data:parameter,
		error:function(){alert("error");},
		success:function(data){alert("删除成功！");}
	});	
}

var $gTypeTarget = null;
function showTypeDown(){
	$gTypeTarget = $(event.target);
	var editType = $(event.target).text();
	var editId = $(event.target).next().text()
	$("input[name='editMemberType']").val(editType);
	$("input[name='memberId']").val(editId);
}
function editMemberType(){
	var editTypeText = $("input[name='editMemberType']").val();
	var editId = $("input[name='memberId']").val();
	editId = encodeURIComponent(editId);
	var editType = encodeURIComponent(editTypeText);
	
	var parameters = {"editType":editType,"editId":editId};
	$.ajax({
		url:"edit_achievement_type.action",
		data:parameters,
		error:function(){alert("error");},
		success:function(){alert("编辑成功！"); $gTypeTarget.text(editTypeText);}
	});
}