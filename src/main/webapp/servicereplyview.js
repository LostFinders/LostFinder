$(document).on("click",".delete-btn",function(){//동적으로 생성 된 버튼은 바로 못불러오고 document에서 불러와야됨. 
   $.post("delete.servicereply",{reply_uuid:$(this).val()},function(data){
      if(data=="true"){
         alert("삭제에 성공 했습니다.")
         location.reload();
      }else if(data=="false"){
         alert("삭제에 실패 했습니다.")
         location.reload();
      }else{
         alert("잘못된 접근 입니다.");
      }
   })});
  
let edit=false; 
$(document).on("click",".edit-btn",function(){//동적으로 생성 된 버튼은 바로 못불러오고 document에서 불러와야됨. 
	if(edit==false){
		alert("내용을 수정하고 다시 클릭해주세요.")
		edit=true;
		$($($(this).parent()).parent()).children(".reply_content").attr({"contenteditable":"true"}).css({backgroundColor: 'gainsboro'});
  }else{
	$.get("update.servicereply"+window.location.search,{reply_content:$($($(this).parent()).parent()).children(".reply_content").text(), reply_uuid:$(this).val()});
  	alert("수정 되었습니다");
  	location.reload();
}});