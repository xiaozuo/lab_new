//登录局部刷新
function init()
{
	if($("input[name='user']").val() && $("input[name='password']").val()){
		var user = $("input[name='user']").val();
		document.cookie="user="+user;
		
		$.ajax({
			url:"login.action",
			data:{"user":$("input[name='user']").val(),"password":$("input[name='password']").val()},
			success:function(data){
				var html = "<div style='padding-top:30px;text-align:center;'>" + $("input[name='user']").val() + 
							"<br/><img src='images/loginSuccess.jpg' alt='欢迎您！' style='padding-top:3px;'/></div>";
				$("#login_change").html(html);
			}
		});
	}
	else alert("用户名密码不能为空！");
}
//身份验证
function check(){
	var strCookie = document.cookie;
	var arrCookie=strCookie.split("; "); //分割符为分号+空格！！
	var user; 
	for(var i=0;i<arrCookie.length;++i)
	{ 
		var arr=arrCookie[i].split("="); 
		if("user"==arr[0]){ 
			user=arr[1]; 
			break; 
		} 
	}
	//alert(user);
	if(user == null){
		alert("您还没有登录哦！");
	}
	else{
		user = encodeURIComponent(user);
		var parameter = {"user":user};
		$.ajax({
			url:"check.action",
			data:parameter,
			error:function(){alert("error");},
			success:function(data){
				if(data == "admin")location.href="read_labinfo";
				else location.href="read_user_detail";
			}
		});
	}
}
function toggleChooseStatus()
{
	var check_status = $("#choose_all").attr("checked");
	if(check_status == "checked")
		$("input:checkbox").attr("checked", "checked");
	else
		$("input:checkbox").attr("checked", false);
}

//删除用户
function deleteUsers()
{
	var usernames = "";
	
	$("input:checkbox").each(function(){
		if($(this).attr("id") == "choose_status")
		{
			if($(this).attr("checked") == "checked")
			{
				var username = $(this).parent().siblings("#username").text();
				//alert(username);
				usernames += ("-" + username);
				$(this).parent().parent().remove();
			}
		}
	});
	
	if(usernames == "")
	{
		alert("亲，你都没选择用户，删除what？");
		return;
	}
	var parameters = {"delete_usernames": encodeURIComponent(usernames)}
	if(!confirm("亲，你确定删除么？"))
		return;
	$.get("lab/delete_user.action", parameters, removeUsersCallBack);
}

function removeUsersCallBack(data)
{
	alert("您已经删除了用户：" + decodeURIComponent(data));
}

//添加用户
function adduser()
{
	var username = encodeURIComponent($("input[name='new_user']").val());
	var userpassword = encodeURIComponent($("input[name='new_password']").val());
	var usertype = encodeURIComponent($("input[name='new_usertype']").val());
	if(username == "" || userpassword == "")
	{
		alert("用户名和密码不能为空！");
		return;
	}
	
    var parameters = {"new_user":username, "new_password":userpassword, "new_usertype":usertype};
    $.get("lab/add_user.action", parameters, addUserCallback);
}

function addUserCallback(data)
{
	if(data != "add_user_success")
	{
		alert("已经存在相同的用户名，请重新输入...");
		return;
	}
	
	//var html = "<tr><td id='username'>" 
	//			+ $("input[name='new_user']").val() 
	//			+ "</td><td id='userpassword'>" 
	//			+ "</td><td id='usertype'>" + $("input[name='new_usertype']").val() 
	//			+ "</td><td><input id='choose_status' type='checkbox'/></td></tr>";
	//$("#userinfo tr:last-child").after(html);
	
	$("input[name='new_user']").val("");
	$("input[name='new_password']").val("");
	$("input[name='new_usertype']").val("");
	alert("添加成功！");
	location.reload();
}
//上一页  提交页面参数
function toLastPage()
{
	var index = parseInt($("#user_current_page_index").text());
	if(index <= 1){
		alert("当前已是第一页！");
		return;
	}
	index -= 1;
	
	$("input[name='currentPage']").val(index);
	document.getElementById("goto_user_page").submit();
}

//下一页  提交页面参数
function toNextPage()
	{
		var index = parseInt($("#user_current_page_index").text());
		if(index >= $("#user_last_page_index").text()){
			alert("当前已是最后一页！");
			return;
		}
		index += 1;
		
		$("input[name='currentPage']").val(index);
		document.getElementById("goto_user_page").submit();
	}

//输入页面在正确范围之内
function PageChange()
{
	var index = $("input[name='currentPage']").val();
	if(index > $("#user_last_page_index").text() || index < 0){
		alert("输入页码不在正确范围之内，请重新输入！");
		return;
	}
	location.href = "user_info_page.action?currentPage="+index;
}


//导航显示与隐藏
function showlabinfo(){
	if($("#labinfo").css('display') == "none"){
		$("#labinfo").show("normal");
		$("#submenu_lab").attr("src","images/aa1.jpg");
	}
		
	else {
		$("#labinfo").hide("normal");
		$("#submenu_lab").attr("src","images/aa.jpg");
	}
	//$("#labinfo_c").hover(showlabinfo, hidelabinfo);
	//$("#research_c").hover(showresearch, hideresearch);
	//$("#team_c").hover(showteam, hideteam);
}
	//实验室信息

	//科学研究
function showresearch()
{
	if($("#research").css('display') == "none"){
		$("#research").show("normal");
		$("#submenu_research").attr("src","images/aa1.jpg");
	}
		
	else {
		$("#research").hide("normal");
		$("#submenu_research").attr("src","images/aa.jpg");
	}
}
	//科研队伍
function showteam()
{
	if($("#team").css('display') == "none"){
		$("#team").show("normal");
		$("#submenu_team").attr("src","images/aa1.jpg");
	}
		
	else {
		$("#team").hide("normal");
		$("#submenu_team").attr("src","images/aa.jpg");
	}
}


//用户详情编码转换
function change_code(){
	//alert($("textarea[name='workexperience']").val());
	var username = encodeURIComponent($("input[name='username']").val());
	var sex = encodeURIComponent($("select[name='sex'] option:selected").text());
	var birthday = encodeURIComponent($("input[name='birthday']").val());
	var enteryear = encodeURIComponent($("input[name='enteryear']").val());
	var major = encodeURIComponent($("input[name='major']").val());
	var education = encodeURIComponent($("select[name='education'] option:selected").text());
	var research = encodeURIComponent($("input[name='research']").val());
	var membertype = encodeURIComponent($("select[name='membertype'] option:selected").text());
	var resume = encodeURIComponent($("textarea[name='resume']").val());
	var workexperience = encodeURIComponent($("textarea[name='workexperience']").val());
	var telno = encodeURIComponent($("input[name='telno']").val());
	var email = encodeURIComponent($("input[name='email']").val());
	var QQ = encodeURIComponent($("input[name='QQ']").val());
	
    var parameters = {"username":username,"sex":sex,"birthday":birthday,"enteryear":enteryear,"major":major,"education":education,"research":research,"membertype":membertype,"resume":resume,"workexperience":workexperience,"telno":telno,"email":email,"QQ":QQ};
    
    $.get("lab/update_user_detail.action", parameters, function(data){alert("修改成功");});
}

//用户管理  更改用户类型
function user_type_change(){
	alert($("select[name='usertype'] option:selected").val());
}

//页面跳转

function userTypeChange(){
	var $target = $(event.target);
	var newType = $target.children("option:selected").text();
	var username = $target.parent().parent().siblings("[id='username']").text();
	newType = encodeURIComponent(newType);
	username = encodeURIComponent(username);
	
	var parameters = {"newType":newType,"username":username};
	
	$.ajax({
		url:"change_usertype.action",
		data:parameters,
		error:function(){alert("error");},
		success:function(){alert("修改成功！");$target.parent().parent().siblings("[id='usertype']").text(newType);}
	});
}

function newsDetail(){
	var id = $(event.target).next().text();
	location.href = "read_newsDetail?id="+id;
}
function noticeDetail(){
	var id = $(event.target).next().text();
	location.href = "read_noticeDetail?id="+id;
}
function achieveDetail(){
	var id = $(event.target).next().text();
	location.href = "read_achievementDetail?id="+id;
}

function member(){
	var a_type = "固定研究人员";
	var type = encodeURIComponent(a_type);
	type = encodeURIComponent(type);
	location.href="read_user_detail_teamIndex?type=" + type;
	
	document.cookie="type="+a_type;
}

function nono(){
	alert("您没有访问权限哦！");
}