//RegExp
//id : 8 ~ 16자 소문자,숫자,_사용가능.
let regmember_id=/^(?=.*[a-z\dA-Z])[a-z\dA-Z]{8,16}$/;
//pw : 8 ~ 20자 특수문자(!@#%&) 대,소문자,숫자 혼용 필수.
let regPw=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*!@#%&)[a-zA-Z\d!@#%&]{8,20}$/;
//name : 2 ~ 5자 한글
let regName=/^(?=.*[가-힣])[가-힣]{2,5}$/;
//phone : 휴대전화 숫자만 받음.
let regPhone=/^01\d{8,9}/;
//email : [영어&숫자] n글자 @ [영어&숫자] n글자+ . +[영어] 2~3글자
let regEmail=/^[a-zA-Z\d]*@[a-zA-Z\d]*[.][a-zA-Z]{2,3}/;


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

//signUp form RegExp
let signUp=document.getElementById("signUp");
signUp.onsubmit=function(){
    let id=document.getElementById("id-text");
    let pw=document.getElementById("pw-text");
    let pwck=document.getElementById("pwck-text");
    let name=document.getElementById("name-text");
    let phone=document.getElementById("phone-text");
    let email=document.getElementById("email-text");
    let address=document.getElementById("address-text");
    let building=document.getElementById("building-text");
    let checkfails=function(object){
        let str;
        switch(object.name){
            case"id":
                str="아이디";
                break;
            case"pw":
                str="비밀번호";
                pwck.value="";
                break;
            case"pwck":
                str="비밀번호 확인"
                pw.value=""
                break;
            case"name":
                str="이름";
                break;
            case"phone":
                str="휴대전화 번호";
                break;
            case"email":
                str="이메일";
                break;
            case"address":
                str="주소";
                break;
            case"building":
                str="세부주소";
                break;
            default:
                console.log(object.name+"확인");
                break;
        }
        swal({
            title : str+"입력 오류",
            icon : "error",
            text : str+"을(를) 다시 입력해주세요",
            closeOnClickOutside : false
        }).then(function(){
            object.value="";
            object.focus();
            if(object.name=="pwck")
                pw.focus();
        });
    }
    if(!(regId.test(id.value))||checked=='f'){
        checkfails(id);
        $("#id-text").attr("readonly",false);
        return false;
    }
    if(!(regPw.test(pw.value))){
        checkfails(pw);
        return false;
    }
    if(!(pw=pwck)){
        checkfails(pwck);
        return false;
    }
    if(!(regName.test(name.value))){
        checkfails(name);
        return false;
    }
    if(!(regPhone.test(phone.value))){
        checkfails(phone);
        return false;
    }
    if(!(regEmail.test(email.value))){
        checkfails(email);
        return false;
    }
    if(address.value==""){
        checkfails(address);
        return false;
    }
    if(building.value==""){
        checkfails(building);
        return false;
    }
}
regmember_id;
let checked_id=true;
$("#member_id-btn").on("click",function(){
	if(regmember_id.test($("#member_id-text").val())){}
		if(checked_id){
			$.post("idcheck.member",{member_id:$("#member_id-text").val()},function(data){
				
			})	
		}
	}
);