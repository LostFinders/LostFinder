//RegExp
//id : 8 ~ 16자 대,소문자,숫자 사용가능.
let regmember_id=/^(?=.*[a-z\dA-Z])[a-z\dA-Z]{8,16}$/;
//pw : 8 ~ 20자 특수문자(!@#%&) 대,소문자,숫자 혼용 필수.
let regmember_pw=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#%&])[a-zA-Z\d!@#%&]{8,20}$/;
//name : 2 ~ 5자 한글
let regmember_name=/^(?=.*[가-힣])[가-힣]{2,5}$/;
//phone : 휴대전화 숫자만 받음.
let regmember_phone=/^01\d{8,9}$/;
//email : [영어&숫자] n글자 @ [영어&숫자] n글자+ . +[영어] 2~3글자
let regmember_email=/^[a-zA-Z\d]*@[a-zA-Z\d]*[.][a-zA-Z]{2,3}$/;

//signUp
//kakao address
let zipcodeBtn=document.getElementById("member_zipcode-btn");
zipcodeBtn.onclick=function(){
    new daum.Postcode({
        oncomplete: function(data) {
            document.getElementById("member_zipcode-text").value=data.zonecode;
            document.getElementById("member_address-text").value=data.address;
            document.getElementById("member_building-text").value=data.buildingName;
        }
    }).open();
}
let editId=true;

$("#freeboard-btn").on("click",function(){
    location.replace("board.jsp?page=1");
})
$("#logout-btn").on("click",function(){
    $.post("logout.mem");
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