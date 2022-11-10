$("#logout-btn").on("click",function(){
    $.post("logout.mem");
    location.replace("/lostfinder");
})
$("#createid-btn").on("click",function(){
    location.replace("signUp.jsp");
})