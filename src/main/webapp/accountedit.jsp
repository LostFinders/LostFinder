<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보 수정</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <style>
        *{
			font-family: 'Noto Sans KR', sans-serif;
            font-size: 18px;
        }
        .signUp-div{
            width: 800px;
        }
        .text-input{
            width: 50%;
        }
        .text-input-noright{
            width: 93%;
        }
        .signUp-group>h2{
            text-align: center;
        }
        .sub-title{
            text-align: right;
            font-size: 23px;
            margin-right: 0px;
        }
        .sub-btn{
            margin-top: 40px;
            margin-left: 15px;
        }
        span{
        	font-size: 8px;
        }
        lable{
        	font-size: 10px;
        }
    </style>
	</head>
	<body>
       <header>
	    <nav class="navbar navbar-expand-lg bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="/LostFinder">LostFinder</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
	       	      <form class="d-flex" role="search">
			        <input class="form-control me-2" type="search" placeholder="검색어를 입력해주세요." aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">search</button>
			      </form>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
	</header>
	<section class="d-none d-sm-flex justify-content-center">
    	<div class="signUp-div d-none d-sm-flex justify-content-center">
        <form role="edit" id="signUp" name="signUp" method="post" action="edited.member">
            <div class="signUp-group">
                <h2>회원 정보 수정</h2>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">비밀번호 :</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-input-noright" id="member_pw-text" name="member_pw" type="password" placeholder="비밀번호를 입력하세요.">
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">비밀번호 확인:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-input-noright" id="member_pwck-text" name="member_pwck" type="password" placeholder="비밀번호를 재입력하세요.">
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">이름:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-input-noright" id="member_name-text" name="member_name" type="text" placeholder="ex)홍길동" value="${memberData.member_name}">
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">휴대전화 번호:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-text text-input" id="member_phone-text" name="member_phone" type="text" placeholder="010-0000-0000" value="${memberData.member_phone}">
                    <input class="signUp-control id-btn btn-sm btn-outline-primary" type="button" id="member_phone-btn" value="중복체크">
                    <span id="member_phone-span">중복체크를 해주세요</span>
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">이메일:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-text text-input" id="member_email-text" name="member_email" type="text" placeholder="xxxxxx@xxxxxx.com" value="${memberData.member_email}">
                    <input class="signUp-control id-btn btn-sm btn-outline-primary" type="button" id="member_email-btn" value="중복체크">
                    <span id="member_email-span">중복체크를 해주세요</span>
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">우편번호:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-input-right" id="member_zipcode-text" name="member_zipcode" type="text" placeholder="우편번호를 검색해주세요." value="${memberData.member_zipcode}"readonly>
                    <input class="signUp-control id-btn btn-sm btn-outline-primary" type="button" id="member_zipcode-btn" value="우편번호">
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">주소:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-input-noright" id="member_address-text" name="member_address" type="text" placeholder="우편번호를 검색해주세요." value="${memberData.member_address}" readonly>
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">세부주소:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-input-noright" id="member_building-text" name="member_building" type="text" placeholder="세부주소를 입력해주세요." value="${memberData.member_building}">
                </div>
            </div>
           	<div class="signUp-group row">
                <div class="sub-title col-4">
                    <label for="inputdefault">비밀번호 찾기 질문:</label>
                </div>
                <div class="sub-input col-8">
	                <select class="signUp-control text-input-noright" id="pwquestion_no-box" name="pwquestion_no">
					  <option id="pwquestion_no-option" value="" selected="selected">질문을 선택하세요.</option>
					</select>
                </div>
            </div>
           	<div class="signUp-group row">
                <div class="sub-title col-4">
                    <label for="inputdefault">비밀번호 찾기 답:</label>
                </div>
                <div class="sub-input col-8">
                    <input class="signUp-control text-input-noright" id="member_pwanswer-text" name="member_pwanswer" type="text" placeholder="비밀번호 찾기 질문 답변을 입력해주세요.">
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title sub-btn col-7">
                    <input class="signUp-control id-btn btn-sm btn-outline-success" type="submit" value="정보수정">
                    <input class="signUp-control id-btn btn-sm btn-outline-danger" type="button" id="cancel-btn" value="취소">
                </div>
            </div>
        </form>
    </div>
	</section>
	<footer>
		<div class="d-none d-sm-flex justify-content-center">
			<div class="d-flex">
				<div id="siteinfo">사이트 이용안내</div><label>│</label><div id="privacy">개인정보 처리방침</div><label>│</label><div id="khhome">KH정보교육원</div><label>│</label><div id="khphone">02-1544-9970</div>
			</div>
		</div>
		<div class="d-none d-xxl-flex justify-content-center">
			<div class="d-flex">
				<div>강남1관 : 서울특별시 강남구 태헤란로14길 6 남도빌딩</div><label>│</label><div>종로지원 : 서울특별시 중구 남대문로1가 18 대일빌딩</div><label>│</label><div>당산지원 : 서울특별시 영등포구 선유동2로 57 이례빌딩</div>
			</div>
		</div>
		<div class="d-none d-lg-flex justify-content-center">
			<div class="d-flex">
				<div>홈페이지에 게시된 이메일주소가 자동수집되는 것을 거부하며, 이를 위반 시 처벌될 수 있음을 양지하여 주시기 바랍니다.</div>
			</div>
		</div>
		<div class="d-flex justify-content-center">
			<div class="d-flex">
				<div>Copyright ⓒ2022 LostFinder All Right Reserved</div>
			</div>
		</div>
	</footer>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="accountedit.js"></script>
    <script>
	    let checked_phone=false;
	    $("#member_phone-btn").on("click",function(){
	    	if(regmember_phone.test($("#member_phone-text").val())){
	    		if(checked_phone){
	    			alert("이미 휴대전화검증에 통과했습니다.")
	    		}else if($("#member_phone-text").val()=="${member_phone}"){
	    			$("#member_phone-text").attr("readonly",true);
	    			$("#member_phone-span").text("사용 가능한 휴대전화 입니다.");
	    			checked_phone=true;
	    		}else{
	    			$.post("phonecheck.member",{member_phone:$("#member_phone-text").val()},function(data){
	    				if(data=="true"){
	    					$("#member_phone-text").attr("readonly",true);
	    					$("#member_phone-span").text("사용 가능한 휴대전화 입니다.");
	    					checked_phone=true;
	    				}
	    				else if(data=="false")
	    					$("#member_phone-span").text("사용 불가능한 휴대전화 입니다.");
	    			})	
	    		}
	    	}else
	    		$("#member_phone-span").text("사용 불가능한 휴대전화 입니다.");
	    	}
	    );
	    let checked_email=false;
	    $("#member_email-btn").on("click",function(){
	    	if(regmember_email.test($("#member_email-text").val())){
	    		if(checked_email){
	    			alert("이미 이메일 검증에 통과했습니다.")
	    		}else if($("#member_email-text").val()=="${member_email}"){
					$("#member_email-text").attr("readonly",true);
					$("#member_email-span").text("사용 가능한 이메일입니다.");
					checked_email=true;
	    		}else{
	    			$.post("emailcheck.member",{member_email:$("#member_email-text").val()},function(data){
	    				if(data=="true"){
	    					$("#member_email-text").attr("readonly",true);
	    					$("#member_email-span").text("사용 가능한 이메일입니다.");
	    					checked_email=true;
	    				}
	    				else if(data=="false")
	    					$("#member_email-span").text("사용 불가능한 이메일입니다.");
	    			})	
	    		}
	    	}else
	    		$("#member_email-span").text("사용 불가능한 이메일입니다.");
	    	}
	    )
    </script>
</body>
</html>