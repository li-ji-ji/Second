<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<script type="text/javascript" src="${base}${staticPath}/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="${base}${staticPath}/admin/css/pintuer.css">
<link rel="stylesheet" href="${base}${staticPath}/admin/css/admin.css">
<script src="${base}${staticPath}/admin/js/pintuer.js"></script>
</head>
<style>
</style>
<body style="padding-right:10px;padding-bottom: 10px;">
<form method="post" action="" id="listform">
	<div class="padding border-bottom">
    	<ul class="search" style="padding-left:10px;">
    	    <li>
            	<input type="checkbox" id="checkall"/> 全选 </li>
            <li>	
            	<a href="javascript:void(0)" class="button border-red" style="padding:5px 8px;" onclick="DelSelect()"><span class="icon-trash-o"></span>&nbsp;批量删除</a>
            </li>
            <li>	
            	<a href="javascript:void(0)" class="button border-green" style="padding:5px 8px;" onclick="CheckSelect()">&nbsp;批量通过</a>
            </li>
            <li>	
            	<a href="javascript:void(0)" class="button border-red" style="padding:5px 8px;" onclick="RejectSelect()">&nbsp;批量驳回</a>
            </li>
        	<li> <a class="button border-main icon-plus-square-o" style="padding:5px 8px;" href="${base}/apply/toAdd"> 添加申请</a> </li>
        	<li>搜索：</li>
        	<li>
          		<input type="text" placeholder="请输入申请ID" id="keywords" class="input" style="width:250px;padding: 6px;display:inline-block">
          		<a href="javascript:void(0);" id="keySearch" class="button border-main icon-search" style="padding:5px 8px;" onclick="changesearch()"> 搜索</a>
          	</li>    
            <!-- <li> <a class="button border-main icon-plus-square-o" style="padding:5px 8px;" href="addreward.html"> 导出</a> </li> -->

       </ul> 
    </div>
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">活动、积分分类列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <table class="table table-hover text-center" style="width:100%;">
      <tr>
        <th style="text-align:center; padding-left:20px;" width="90">选中</th>
        <th>申请书ID</th>
        <th>申请类别</th>
		<th>学生(申请人)ID</th>
		<th>申请状态</th>
		<th>审核状态</th>
		<th>提交时间</th>
		<th>申请积分</th>
		<th>操作栏</th>
      </tr>
      <volist name="list" id="vo">
      		<#list applyList as apply>
				<tr>          
					<td style="text-align:center; padding-left:20px;"><input type="checkbox" name="id" value="${apply.id}" /></td>
					<td>${apply.id}</td>
					<td>${apply.kindName?if_exists}</td>
					<td>${apply.stuId}</td>
					<td>
						<#if apply.status==0>
							申请中
						<#elseif apply.status==1>
							已通过
						<#elseif apply.status==2>
							申诉中
						<#else>
							已取消
						</#if>
					</td>
					<td>
						<#if apply.checkStatus==0>
							审核中
						<#elseif apply.checkStatus==1>
							已通过
						<#else>
							已驳回
						</#if>
					</td>
					<td>${apply.applyTime?date?if_exists}</td>
					<td>${apply.integral?if_exists}</td>
					<td>
						<div class="button-group">
							<a href="${base}/apply/toDetail?id=${apply.id}" class="button border-main" style="padding:6px 10px;">查看详情</a>
			  				<a href="${base}/apply/toEdit?id=${apply.id}" class="button border-green" style="padding:6px 10px;">修改</a>
			  				<a href="${base}/apply/delApplyOneById?id=${apply.id}" onClick="return confirm('确认删除？') " class="button border-red" style="padding:6px 10px;">删除</a>
			  				<#if apply.checkStatus==1>
			  					<a href="${base}/apply/rejectApplyOne?id=${apply.id}" onClick="return confirm('确认驳回申请？') " class="button border-red" style="padding:6px 10px;">驳回</a>
							<#else>
			  					<a href="${base}/apply/checkApplyOne?id=${apply.id}" onClick="return confirm('确认通过审核？') " class="button border-green" style="padding:6px 10px;">通过</a>
							</#if>
						</div>
					</td>
				</tr>
		</#list>
	  </volist>
	      <tr>
	        <td colspan="9">
	        	<div class="pagelist">
		  			<#if hasPage==1>
		  				第&nbsp; <input type="text" id="pageNum" class="input" style="width:50px;padding:4px 20px;display:inline-block; "/>&nbsp; 页
		  				<a id="toPage" href="javascript:void(0)" onclick="toPage(this)">跳转</a>
		        		<a href="${base}/apply/toTable">首页</a> 
		        		<#if (pageNow!=1)><a href="${base}/apply/toTable?page=${pageNow-1}">上一页</a></#if>
			        	<#if (pageNow-3>0)><a href="${base}/apply/toTable?page=${pageNow-3}"">${pageNow-3}</a></#if>
			        	<#if (pageNow-2>0)><a href="${base}/apply/toTable?page=${pageNow-2}"">${pageNow-2}</a></#if>
			        	<#if (pageNow-1>0)><a href="${base}/apply/toTable?page=${pageNow-1}"">${pageNow-1}</a></#if>
			        	<span class="current">${pageNow}</span>
		        		<#if (pageNum>=pageNow+1)><a href="${base}/apply/toTable?page=${pageNow+1}">${pageNow+1}</a></#if>
			        	<#if (pageNum>=pageNow+2)><a href="${base}/apply/toTable?page=${pageNow+2}">${pageNow+2}</a></#if>
			        	<#if (pageNum>=pageNow+3)><a href="${base}/apply/toTable?page=${pageNow+3}">${pageNow+3}</a></#if>
			        	<#if (pageNow!=pageNum)><a href="${base}/apply/toTable?page=${pageNow+1}">下一页</a></#if>
			        	<a href="${base}/apply/toTable?page=${pageNum}">尾页</a>
	      			</#if>
		        	<span href="javascript:void(0);">共${pageNum}页</span>
	        	</div>
	        </td>
	      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">
$(document).ready(function(){
    $("#keywords").on('blur',function(){
		//console.log("失去焦点");
    	keyWord=$("#keywords").val();
    	searchUrl="${base}/apply/getApplyById?keyWord="+keyWord;
    	$("#keySearch").attr("href",searchUrl);
    })
    toPage=function(e){
    	pageNum=$("#pageNum").val();
    	//console.log(pageNum)
    	if(pageNum==""){
    		alert("请输入页码")
    	}
    	else{
        	searchUrl="${base}/apply/toTable?page="+pageNum;
        	$("#toPage").attr("href",searchUrl)
    	}
    }
/*     $("#pageNum").on('blur',function(){
		//console.log("失去焦点");
    	pageNum=$("#pageNum").val();
    	searchUrl="${base}/applyKind/toTable?page="+pageNum;
    	$("#toPage").attr("href",searchUrl);
    })
    PageNull=function(e){
    	if(e.href=="javascript:void(0)"){
    		alert("请输入页码")
    	}
    } */
});
//搜索
function changesearch(){	

}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;	
		$("#listform").attr("action","${base}/apply/delApplyListById")
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量通过
function CheckSelect(){
	var Checkbox=false;
	 $("input[name='id']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要审核选中的内容吗？");
		if (t==false) return false;	
		$("#listform").attr("action","${base}/apply/checkApplyListById")
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量驳回
function RejectSelect(){
	var Checkbox=false;
	 $("input[name='id']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要审核选中的内容吗？");
		if (t==false) return false;	
		$("#listform").attr("action","${base}/apply/rejectApplyListById")
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

////批量排序
//function sorts(){
//	var Checkbox=false;
//	 $("input[name='id[]']").each(function(){
//	  if (this.checked==true) {		
//		Checkbox=true;	
//	  }
//	});
//	if (Checkbox){	
//		
//		$("#listform").submit();		
//	}
//	else{
//		alert("请选择要操作的内容!");
//		return false;
//	}
//}
//
//
////批量首页显示
//function changeishome(o){
//	var Checkbox=false;
//	 $("input[name='id[]']").each(function(){
//	  if (this.checked==true) {		
//		Checkbox=true;	
//	  }
//	});
//	if (Checkbox){
//		
//		$("#listform").submit();	
//	}
//	else{
//		alert("请选择要操作的内容!");		
//	
//		return false;
//	}
//}
//
////批量推荐
//function changeisvouch(o){
//	var Checkbox=false;
//	 $("input[name='id[]']").each(function(){
//	  if (this.checked==true) {		
//		Checkbox=true;	
//	  }
//	});
//	if (Checkbox){
//		
//		
//		$("#listform").submit();	
//	}
//	else{
//		alert("请选择要操作的内容!");	
//		
//		return false;
//	}
//}
//
////批量置顶
//function changeistop(o){
//	var Checkbox=false;
//	 $("input[name='id[]']").each(function(){
//	  if (this.checked==true) {		
//		Checkbox=true;	
//	  }
//	});
//	if (Checkbox){		
//		
//		$("#listform").submit();	
//	}
//	else{
//		alert("请选择要操作的内容!");		
//	
//		return false;
//	}
//}
//
//
////批量移动
//function changecate(o){
//	var Checkbox=false;
//	 $("input[name='id[]']").each(function(){
//	  if (this.checked==true) {		
//		Checkbox=true;	
//	  }
//	});
//	if (Checkbox){		
//		
//		$("#listform").submit();		
//	}
//	else{
//		alert("请选择要操作的内容!");
//		
//		return false;
//	}
//}
//
////批量复制
//function changecopy(o){
//	var Checkbox=false;
//	 $("input[name='id[]']").each(function(){
//	  if (this.checked==true) {		
//		Checkbox=true;	
//	  }
//	});
//	if (Checkbox){	
//		var i = 0;
//	    $("input[name='id[]']").each(function(){
//	  		if (this.checked==true) {
//				i++;
//			}		
//	    });
//		if(i>1){ 
//	    	alert("只能选择一条信息!");
//			$(o).find("option:first").prop("selected","selected");
//		}else{
//		
//			$("#listform").submit();		
//		}	
//	}
//	else{
//		alert("请选择要复制的内容!");
//		$(o).find("option:first").prop("selected","selected");
//		return false;
//	}
//}

</script>
</body>
</html>