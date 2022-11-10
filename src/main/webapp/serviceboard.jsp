<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="day" class="java.util.Date"/>
<fmt:formatDate value="${day}" pattern="yyyy-MM-dd HH:mm:ss.SSS" var="today"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 템플릿</title>
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
        .bgcontents{
            position: absolute;
            top:0px;
            left:0px;
            width: 100%;
            height: 100%;
        }
        .postbg{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            width: 700px;
            height: 600px;
        }
        .post{
            float: none; 
            margin: 0 auto;
            font-size: 30px;
            width: 80%;
            min-width: 500px;
            height: auto;
            color: black;
            text-align: center;
        }
        .posts{
            background: rgba(240,240,240,0.5);
        }
        a:link {
		    text-decoration: none;
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
		<table border="1" align="center" width="800px">
	        <tr>
	            <th colspan="5">고객상담게시판 ${member_id}님 환영합니다.</th>
	        </tr>
	        <tr>
	            <td width="5%"></td>
	            <td width="60%" align="center">제목</td>
	            <td width="15%" align="center">작성자</td>
	            <td width="15%" align="center">날짜</td>
	            <td width="5%">조회</td>
	        </tr>        
	        <c:if test="${serviceboardListData ne null}">
	        	<c:forEach var="i" items="${serviceboardListData}" begin="0" end="${fn:length(serviceboardListData)}" step="1">
	       			<tr>
	       				<td>${i.service_no}
		       			<td><a href="view.serviceboard?service_no=${i.service_no}">${i.service_title}</a>
		       			<td>${i.member_id}
		       			<td>${fn:substring(i.service_createdate,0,10)}
		       			<td>${i.service_viewcount}
	       			</tr>
	        	</c:forEach>
	        </c:if>
	        <c:if test="${serviceboardListPage ne null}">
       			<tr>
       				<td colspan="5">
	       				<div class="d-flex justify-content-center">
		       				<div>
		       					<button class="page-btn" id="leftlist-btn">◀</button>
		       				</div>
				        	<c:forEach var="j" begin="1" end="${serviceboardListPage}" step="1">
								<div>
									<button class="listpage-btn" id="${j}-btn">${j}</button>
								</div>
				        	</c:forEach>
		        			<div>
		        				<button class="page-btn" id="rightlist-btn">▶</button>
		        			</div>
		        		</div>
	        		</td>
	        	</tr>
	        </c:if>
	        <tr>
     	    	<td colspan=5 align="right">
		        	<c:if test="${member_id ne null}">
		                <button id=boardwriter-btn>작성하기</button>
		        	</c:if>
	        	</td>
	        </tr>
	    </table>
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
	<script src="serviceboard.js"></script>
	<script>
		$(document).on("click","#rightlist-btn",function(){
			let listpage=parseInt(document.location.toString().substring(document.location.toString().lastIndexOf("?page=")+6))+1;
			if (parseInt(listpage)>=${serviceboardListPage})
				listpage=${serviceboardListPage};
			location.replace("list.serviceboard?page="+listpage);
	});
	</script>
</body>
</html>