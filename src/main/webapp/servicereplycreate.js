$("#create-btn").on("click",function(){  
		$.get("create.servicereply"+window.location.search,{reply_content:$("#contents").text()});
		location.reload();
   });
$("#files-input").change(function(){
   let filelist = $("#files-input")[0].files;
   if(filelist.length>5){
      alert("5개까지 업로드 할 수 있습니다.")
      $("#files-input").val("");
   }else if(filelist.length>1){
      $("#filelist-span").text("");
      for(var i=0;i<filelist.length;i++)
         $("#filelist-span").text($("#filelist-span").text()+" "+(i+1)+". "+filelist[i].name);
   }
});
$("#back-btn").on("click",function(){
   location.replace("servicereply.jsp?page=1");
})