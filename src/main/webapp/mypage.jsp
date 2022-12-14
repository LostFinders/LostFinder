<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 모듈</title>
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
            width: 600px;
            display:none
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
    </style>
</head>
<body>
    <div>
        ${member_id}님 환영합니다.<br>
    </div>
    <div>
        <button id = "freeboard-btn">분실물게시판</button>
        <button id = "serviceboard-btn">고객상담게시판</button>
	    <button id = "logout-btn">로그아웃</button>
	    <button id = "editid-btn">회원수정</button>
	    <button id = "removeid-btn">회원탈퇴</button>
    </div>
    <div class="signUp-div">
        <form role="signUp" id="signUp" name="signUp" method="post" action="create.member">
            <div class="signUp-group">
                <h2>회원 가입 정보 입력</h2>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">아이디 :</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-text text-input" id="member_id-text" name="member_id" type="text" placeholder="아이디를 입력하세요.">
                    <input class="signUp-control id-btn btn-sm btn-outline-primary" type="button" id="member_id-btn" value="중복체크">
                    <span id="member_id-span">중복체크를 해주세요</span>
                </div>
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
                    <input class="signUp-control text-input-noright" id="member_name-text" name="member_name" type="text" placeholder="이름을 입력해주세요.">
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">휴대전화 번호:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-text text-input" id="member_phone-text" name="member_phone" type="text" placeholder="휴대전화 번호를 입력하세요.">
                    <input class="signUp-control id-btn btn-sm btn-outline-primary" type="button" id="member_phone-btn" value="중복체크">
                    <span id="member_phone-span">중복체크를 해주세요</span>
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">이메일:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-text text-input" id="member_email-text" name="member_email" type="text" placeholder="이메일을 입력하세요.">
                    <input class="signUp-control id-btn btn-sm btn-outline-primary" type="button" id="member_email-btn" value="중복체크">
                    <span id="member_email-span">중복체크를 해주세요</span>
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">우편번호:</label>
                </div>
                <div class="sub-input col-6">
                    <input class="signUp-control text-input-right" id="member_zipcode-text" name="member_zipcode" type="text" placeholder="우편번호를 검색해주세요." readonly>
                    <input class="signUp-control id-btn btn-sm btn-outline-primary" type="button" id="member_zipcode-btn" value="우편번호">
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">주소:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-input-noright" id="member_address-text" name="member_address" type="text" placeholder="우편번호를 검색해주세요." readonly>
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">세부주소:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-input-noright" id="member_building-text" name="member_building" type="text" placeholder="세부주소를 입력해주세요.">
                </div>
            </div>
           	<div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">비밀번호 찾기 질문:</label>
                </div>
                <div class="sub-input col-9">
	                <select class="signUp-control text-input-noright" id="pwquestion_no-box" name="pwquestion_no">
					  <option id="pwquestion_no-option" value="" selected="selected">질문을 선택하세요.</option>
					</select>
                </div>
            </div>
           	<div class="signUp-group row">
                <div class="sub-title col-3">
                    <label for="inputdefault">비밀번호 찾기 답:</label>
                </div>
                <div class="sub-input col-9">
                    <input class="signUp-control text-input-noright" id="member_pwanswer-text" name="member_pwanswer" type="text" placeholder="비밀번호 질문 답변을 입력해주세요.">
                </div>
            </div>
            <div class="signUp-group row">
                <div class="sub-title sub-btn col-7">
                    <input class="signUp-control id-btn btn-sm btn-outline-success" type="submit" value="수정완료">
                    <input class="signUp-control id-btn btn-sm btn-outline-danger" type="button" id="cancel-btn" value="취소">
                </div>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="mypage.js"></script>
    <script>
        $("#member_id-text").val("${member_id}");
        $("#member_id-text").attr("readonly","true");
        $("#member_name-text").val("${member_name}");
        $("#member_name-text").attr("readonly","true");
        $("#member_phone-text").val("${member_phone}");
        $("#member_phone-text").attr("readonly","true");
        $("#member_email-text").val("${member_email}");
        $("#member_zipcode-text").val("${member_zipcode}");
        $("#member_address-text").val("${member_address}");
        $("#member_building-text").val("${member_building}");
        $("#pwquestion_no-box").val("${pwquestion_no}");
        $("#member_pwanswer-text").val("${member_pwanswer}");

        $("#cancel-btn").on("click",function(){
            $("#member_id-text").val("${member_id}");
            $("#member_name-text").val("${member_name}");
            $("#member_phone-text").val("${member_phone}");
            $("#member_email-text").val("${member_email}");
            $("#member_zipcode-text").val("${member_zipcode}");
            $("#member_address-text").val("${member_address}");
            $("#member_building-text").val("${member_building}");
            $(".signUp-div").prop("style","display:none");
    	    editId=true;
        })
    </script>
</body>
</html>