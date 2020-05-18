<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <title>第二课堂后台管理系统</title>
<script type="text/javascript" src="${base}${staticPath}/js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="${base}${staticPath}/admin/css/pintuer.css">
    <link rel="stylesheet" href="${base}${staticPath}/admin/css/admin.css">
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="${staticPath}/admin/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />第二课堂后台管理系统</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="javascript:void(0);" onclick="menuClick('/board/toBoard')" >数据中心</a>  &nbsp;&nbsp;
  	<a class="button button-little bg-red" href="/login/logout" >
  		<span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>

<#list menus as fisrtMenu>
    <h2><span class="icon-pencil-square-o"></span>${fisrtMenu.name}</h2>
    <ul>
    	<#if (fisrtMenu.menus?size>0)>
    		<#list fisrtMenu.menus as secondMenu>
	    		<li><a href="javascript:void(0);" onclick="menuClick('${secondMenu.url}')" target="right"><span class="icon-caret-right"></span>${secondMenu.name}</a></li> 
  			</#list>
	  	</#if>
  	</ul>  
</#list>

</div>
<script type="text/javascript">

$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
  
    $(".icon-home").click(function(){
	    $("#a_leader_txt").text("欢迎使用");
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
  
});


</script>
<ul class="bread">
  <li><a href="${base}/board/toBoard" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">公告信息</a></li>
</ul>
<div class="admin" style="overflow:hidden;padding-bottom:20px;">
  <iframe id="data-table" scrolling="auto" style="padding-bottom:20px;" rameborder="0" src="${base}/board/toBoard" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>
<script type="text/javascript">
function menuClick(url){
		$("#data-table").attr("src",url);
		//console.log(url);
	}
</script>

</html>