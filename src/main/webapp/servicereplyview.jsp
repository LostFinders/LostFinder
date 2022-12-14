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
    <title>Lostfinder</title>
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
        
         #board-item{
            width: 700px;
            height: 50px;
            background: rgba(240,240,240,0.5);
            table-layout:fixed;
        }
        #title{
             width:100%;
            height:10%;
            table-layout:fixed;
        }
        #content{
           width:100%;
            height:80%;
            table-layout:fixed;
        }
        #footer{
           width:100%;
            height:10%;
        }
        .board-input{
            
        }
        [contenteditable="true"]:empty:before {
         content: attr(placeholder);
      }
      #create{
          font-size: 21px;
           width:80px;
        }
        .update{
           font-size: 16px;
           width:50px;
           align=left;
        }
        .delete{
           font-size: 16px;
           width:50px;
           align=left;
        }
        
    </style>
</head>
<body>
    <div>
        ${member_id}??? ???????????????. ???????????????~ ?????????~!<br>
    </div>
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
			        <input class="form-control me-2" type="search" placeholder="???????????? ??????????????????." aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">search</button>
			      </form>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
	</header>
	<section>
	<table id="board-item" border=1 align=center>
         <tr>
            <td id="contents" contenteditable=true></td>
         </tr>
         <tr>
            <td id="footer" align=left><!-- ?????? ???????????? ??????????????? ??????????????? -->
                  <input type="hidden" id="service_content-hidden" name="reply_content">
                  <button id="create-btn" class="btn btn-outline-success" type="button" style="float: right;" aria-label="Search">??????</button> <!-- ?????? ????????? ??????????????? ???????????? -->
            </td>
         </tr>
      </table>
		
	   	<table border="1" align="center" width="700px">
   	
   			<tr id="list">
   				<td>?????????</td>
   				<td>??????</td>
   				<td>??????</td>
  		 	</tr>
   	
  		 	<c:if test="${servicereplyData ne null}">
   				<c:forEach var="i" items="${servicereplyData}" begin="0" end="${fn:length(servicereplyData)}" step="1">
					<tr>
   						<td>${i.member_id}</td>
   						<td class="reply_content">${i.reply_content}</td>
   						<td>${fn:substring(i.reply_createdate,5,19)}</td>
 						<td><button class="edit-btn" value="${i.reply_uuid}">??????</button>
 							<button class="delete-btn" value="${i.reply_uuid}">??????</button></td>	

   					</tr>		
   				</c:forEach>
   			</c:if>
   		</table>
	</section>
	<footer>
		<div class="d-none d-sm-flex justify-content-center">
			<div class="d-flex">
				<div id="siteinfo">????????? ????????????</div><label>???</label><div id="privacy">???????????? ????????????</div><label>???</label><div id="khhome">KH???????????????</div><label>???</label><div id="khphone">02-1544-9970</div>
			</div>
		</div>
		<div class="d-none d-xxl-flex justify-content-center">
			<div class="d-flex">
				<div>??????1??? : ??????????????? ????????? ????????????14??? 6 ????????????</div><label>???</label><div>???????????? : ??????????????? ?????? ????????????1??? 18 ????????????</div><label>???</label><div>???????????? : ??????????????? ???????????? ?????????2??? 57 ????????????</div>
			</div>
		</div>
		<div class="d-none d-lg-flex justify-content-center">
			<div class="d-flex">
				<div>??????????????? ????????? ?????????????????? ?????????????????? ?????? ????????????, ?????? ?????? ??? ????????? ??? ????????? ???????????? ????????? ????????????.</div>
			</div>
		</div>
		<div class="d-flex justify-content-center">
			<div class="d-flex">
				<div>Copyright ???2022 LostFinder All Right Reserved</div>
			</div>
		</div>
	</footer>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="servicereplycreate.js"></script>
	<script src="servicereplyview.js"></script>
</body>
</html>