<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LostFinder</title>
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
        .list-group-item{
        	font-size:12px;
        }
        .temp-item{
        	width: 80%;
        }
        a:link {
		    text-decoration: none;
		    color:black;
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
	<section>
		<div class="d-flex justify-content-center justify-content-sm-center">
			<div class="justify-content-center row row-cols-1 row-cols-md-2 row-cols-xl-4">
				<div class="card col" style="width: 18rem;">
				  <div class="card-header">
				    분실물 게시판
				  </div>
				  <ul class="list-group list-group-flush">
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				  </ul>
				</div>
				<div class="card col" style="width: 18rem;">
				  <div class="card-header">
				    사이트 소개
				  </div>
				  <ul class="list-group list-group-flush">
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				  </ul>
				</div>
				<div class="card col" style="width: 18rem;">
				  <div class="card-header">
				    고객센터 게시판
				  </div>
				  <ul class="list-group list-group-flush">
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				  </ul>
				</div>
				<div class="card col" style="width: 18rem;">
				<c:choose>
					<c:when test="${member_id == null}">
					  <div class="card-header">
					    로그인 
					  </div>
						<form action="login.member" method="post">
						  <!-- Email input -->
						  <div class="form-outline mb-4">
						    <input type="text" name="member_id" class="form-control" placeholder="아이디를 입력해주세요." />
						  </div>
						
						  <!-- Password input -->
						  <div class="form-outline mb-4">
						    <input type="password" name="member_pw" class="form-control" placeholder="패스워드를 입력해주세요." />
						  </div>						
						  <!-- Submit button -->
						  <div class="d-grid gap-2">
						  	<input type="submit" class="form-control btn btn-primary btn-block btn-12" value="Login" />
						  </div>						
						  <!-- Register buttons -->
						  <div class="text-center">
						    <p>회원이 아니십니까? <a href="signUp.jsp">회원 가입</a></p>
						  </div>
						</form>
					</c:when>
				    <c:otherwise>
   					  <div class="card-header">
					    ${member_id} 님 환영합니다.
					  </div>
			            <div>
					        <button class="btn btn-sm btn-primary" id = "freeboard-btn">분실물게시판</button>
					        <button class="btn btn-sm btn-primary" id = "serviceboard-btn">고객상담게시판</button>
						    <button class="btn btn-sm btn-primary" id = "logout-btn">로그아웃</button>
						    <button class="btn btn-sm btn-primary" id = "editid-btn">회원수정</button>
						    <button class="btn btn-sm btn-danger" id = "removeid-btn">회원탈퇴</button>
					    </div>
				    </c:otherwise>
				</c:choose>
				  <!--<div class="card-header">
				    로그인 아이템
				  </div>
				  <ul class="list-group list-group-flush">
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				    <li class="list-group-item">게시글 example 1</li>
				  </ul>-->
				</div>
			</div>
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
	<script src="index.js"></script>
</body>
</html>