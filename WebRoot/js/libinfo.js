//修改实验室信息
function editLabInfo()
{
	var lab_chief = encodeURIComponent($("input[name='chief']").val());
	var lab_settime = encodeURIComponent($("input[name='settime']").val());
	var lab_address = encodeURIComponent($("input[name='address']").val());
	var lab_telno = encodeURIComponent($("input[name='telno']").val());
	var lab_email = encodeURIComponent($("input[name='email']").val());
	var lab_fax = encodeURIComponent($("input[name='fax']").val());
	var lab_resume = encodeURIComponent($("textarea[name='resume']").text());
	var lab_detail = encodeURIComponent($("textarea[name='detail']").text());
	
	var parameters = {"lab_chief":lab_chief,"lab_settime":lab_settime,"lab_address":lab_address,"lab_telno":lab_telno,"lab_email":lab_email,"lab_fax":lab_fax,"lab_resume":lab_resume,"lab_detail":lab_detail};
	
	$.get("lab/edit_labinfo.action",parameters,editLabInfoCallback);
}
function editLabInfoCallback(){
	alert("修改成功！");
}

//修改实验室规章制度
function editLabRule(){
	//alert($("textarea[name='rule']").val());
	var lab_rule = encodeURIComponent($("textarea[name='rule']").val());
	var parameter = {"lab_rule":lab_rule};
	
	$.get("lab/edit_labrule.action",parameter,editLabInfoCallback);
}

//修改实验室研究领域
function editLabResearchArea(){
	var lab_researchArea = encodeURIComponent($("textarea[name='researchArea']").val());
	var parameter = {"lab_researchArea":lab_researchArea};
	
	$.get("lab/edit_labResearchArea.action",parameter,editLabInfoCallback);
}