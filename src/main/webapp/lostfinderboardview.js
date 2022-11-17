$("#delete-btn").on("click",function(){
    $.post("delete.lostfinderboard"+window.location.search);
    location.replace("list.lostfinderboard?page=1");
});
let edited=true;

$(document).on("click","#edit-btn",function(){
	if(edited){
		alert("내용을 직접 수정해주세요")
		edited=false;
		$("#title").attr({"contenteditable":"true","placeholder":"글 제목"});
		$("#contents").attr({"contenteditable":"true","placeholder":"내용을 입력해주세요."});
		$("#location").attr("disabled",false);
		$("#edit-btn").html("수정 완료");
	}else{
        $.get("update.lostfinderboard"+window.location.search,{board_title:$("#title").text(),location_no:$("#location option:selected").val(),board_content:$("#contents").text()});
        location.reload();
    }
});
$("#back-btn").on("click",function(){
    location.replace("list.lostfinderboard?page=1");
});