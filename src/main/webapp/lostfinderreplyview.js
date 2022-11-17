$(document).on("click",".delete",function(){//동적으로 생성 된 버튼은 바로 못불러오고 window에서 불러와야됨. 
	$.post("delete.lostfinderreply",{reply_uuid:$(this).val()},function(data){
		if(data=="true"){
			alert("삭제에 성공 했습니다.")
			location.reload(); 
		}else{
			alert("잘못된 접근 입니다.(ex)다른 사용자의 댓글 삭제 시도)");
		}
	})
})

let editable=false;
$(document).on("click",".update",function(){ // post통신에서 돌려받은 값의 true, false로 수정이 성공했는지 확인하는 메세지 출력, 여기서 update 이면 controller에서도 update
	if(editable==false){
    	alert("내용을 직접 수정해주세요")
      	editable=true;
      	$($($(this).parent()).parent()).children(".reply_content").attr({"contenteditable":"true"}).css({backgroundColor: 'gainsboro'}); //숙제! 이 부분에 넣으면 됨 
	}else{
        $.get("update.lostfinderreply"+window.location.search,{reply_content:$($($(this).parent()).parent()).children(".reply_content").text(), reply_uuid:$(this).val()});
        //alert(window.location.search); //?board_no=0
        alert("수정완료!!!")
        location.reload();
    }
}); 
