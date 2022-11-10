let lists, pages, selectpage;
$("#boardwriter-btn").on("click",function(){
	location.replace("serviceboardcreate.jsp");
})
$(document).on("click",".listpage-btn",function(){
	location.replace("list.serviceboard?page="+$(this).attr("id").toString().substring(0,$(this).attr("id").toString().indexOf("-")));
});
$(document).on("click","#leftlist-btn",function(){
	let listpage=parseInt(document.location.toString().substring(document.location.toString().lastIndexOf("?page=")+6))-1;
	if (listpage<=0)
		listpage=1
	location.replace("list.serviceboard?page="+listpage);
});