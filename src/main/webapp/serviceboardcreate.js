$("#create-btn").on("click",function(){
	$("#service_title-hidden").val($("#title").text());			
	$("#service_content-hidden").val($("#contents").text());
	$("#data-form").submit();
	});
$("#files-input").change(function(){
	let filelist = $("#files-input")[0].files;
	if(filelist.length>5){
		alert("5개까지 업로드 할 수 있습니다.")
		$("#files-input").val("");
	}else if(filelist.length>1){
		$("#filelist-span").text("");
		for(var i=0;i<filelist.length;i++)
			$("#filelist-span").text($("#filelist-span").text()+" "+(i+1)+". "+filelist[i].name);
	}
});
$("#back-btn").on("click",function(){
	location.replace("serviceboard.jsp?page=1");
})
