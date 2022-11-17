$("#freeboard-btn").on("click",function(){
    location.replace("list.lostfinderboard?page=1");
})
$("#serviceboard-btn").on("click",function(){
    location.replace("list.serviceboard?page=1");
})
$("#logout-btn").on("click",function(){
    $.post("logout.member");
    location.replace("/LostFinder");
})
$("#editid-btn").on("click",function(){
	location.replace("edit.member");
})
$("#removeid-btn").on("click",function(){
	swal({
	  title: "회원 탈퇴",
	  text: "정말로 회원 탈퇴하시겠습니까?\n탈퇴하면 회원정보가 즉시 삭제되어 복구가 불가능합니다.",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((choice) => {
		if (choice) {
			$.post("delete.member",function(data){
				if(data=="true"){
			    	swal("감사합니다 안녕히 가십시요.", {icon: "success",});
			    	    $.post("logout.member");
						location.replace("/LostFinder");
			    }else if(data=="false")
					swal("회원 탈퇴가 취소되었습니다.");
			});
		}else{
	    	swal("회원 탈퇴가 취소되었습니다.");
	  	}
	});
})