$("#create-btn").on("click",function(){
	$("#lostfinderboard_title-hidden").val($("#title").text());			
	$("#lostfinderboard_content-hidden").val($("#contents").text());
	$("#lostfinderboard_location_no-hidden").val($("#location_option").val());
	$("#lostfinderboard_board_tag-hidden").val($("#board_tag").val());
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
$(window).ready(function() {
	$.post("locationlist.lostfinderboard", function(data) {
		var loca = JSON.parse(data);
		for(var i=0;i<loca.length;i++) {
			$("#location_no-option").after("<option value='"+loca[i].location_no+"'>"+loca[i].location_str+"</option>");
		console.log(i)
		}
	})
})
$("#back-btn").on("click",function(){
	location.replace("list.lostfinderboard?page=1");
})

	