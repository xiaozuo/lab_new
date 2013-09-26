function download(obj){
	//var d_href = $(event.target).parent().next().text();
	var id=obj.id+'_file';
	var d_href=document.getElementById(id).value;
	//alert(d_href);
	location.href = "\\lab" + d_href;
}