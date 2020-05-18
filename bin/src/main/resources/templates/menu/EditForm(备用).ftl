<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${base}/js/layui/css/layui.css" media="all">
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<script src="${base}/js/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" method="post" action="${base}/menu/updateMenuOne" style="margin-top:50px;"   >
  
<div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">菜单ID</label>
    <div class="layui-input-block">
      <input type="id" name="id" readonly value="${menu.id?if_exists}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">菜单名称</label>
    <div class="layui-input-block">
      <input type="text" name="name"  value="${menu.name?if_exists}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>  
  <div class="layui-form-item" style="display:none;">
    <label class="layui-form-label" style="width: 150px;">菜单名称</label>
    <div class="layui-input-block">
      <input type="text" name="pName" id="pName"  value="" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">上级菜单名称</label>
    <div class="layui-input-block"style="width:46%;margin-left:180px;">
      <select name="pId" id="pId" lay-verify="" lay-search lay-filter="parentSelect">
      	  <option value="0" 
		  		<#if menu.pId == 0>
		  			selected
		  		</#if>
		  	>顶级菜单</option>
		  <#list pMenus as pMenu>
		  	<option value="${pMenu.id}"
		  		<#if pMenu.id == menu.pId>
		  			selected
		  		</#if>
		  	>${pMenu.name}</option>
		  </#list>
	  </select>  
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">跳转链接</label>
    <div class="layui-input-block">
      <input type="text" name="url"  value="${menu.url?if_exists}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>  
  <div class="layui-form-item" >
    <label class="layui-form-label" style="width:150px;">启用状态</label>
    <div class="layui-input-block" style="width:45%;margin-left: 180px;">
    	<input type="checkbox" name="status" value="1" title="启用"  
    		<#if menu.status==1 >
    			checked
    		</#if>
    	>
    </div>
  </div>



 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button  class="layui-btn" type="submit" lay-submit="" lay-filter="MsgSubmit">立即提交</button>
    </div>
  </div>
</form>
<script>
var status;
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  form.on('select(parentSelect)',function(data){
	  menuName=data.elem[data.elem.selectedIndex].text
	  $("#pName").attr("value",menuName)
	  //console.log(data.elem[data.elem.selectedIndex].text)
  });
});
</script>
</body>
</html>