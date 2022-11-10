let editId=true;

$("#freeboard-btn").on("click",function(){
    location.replace("board.jsp?page=1");
})
$("#serviceboard-btn").on("click",function(){
    location.replace("serviceboard.jsp?page=1");
})
$("#logout-btn").on("click",function(){
    $.post("logout.member");
    location.replace("/LostFinder");
})
$("#removeid-btn").on("click",function(){
    $.post("delete.mem");
    location.replace("/LostFinder");
})
$("#editid-btn").on("click",function(){
	if(editId){
    	$(".signUp-div").prop("style","display:inline-block");
    	editId=false;
    }else{
    	$(".signUp-div").prop("style","display:none");
    	editId=true;
    }
})