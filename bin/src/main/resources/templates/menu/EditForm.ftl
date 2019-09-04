<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="${base}/admin/css/pintuer.css">
<link rel="stylesheet" href="${base}/admin/css/admin.css">
<script src="${base}/admin/js/pintuer.js"></script>
<script src="${base}/admin/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改菜单</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${base}/menu/updateMenuOne">  
      <div class="form-group">
        <div class="label">
          <label>菜单ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${menu.id}" readonly name="id" data-validate="required:请输入标题" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>菜单名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${menu.name}" name="name" data-validate="required:请输入标题" />
        </div>
      </div>
      

     <input type="hidden" class="input w50" id="pName" name="pName" data-validate="required:请输入标题" />

      
      <div class="form-group">
        <div class="label">
          <label>跳转链接：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${menu.url}" name="url" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      
      <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>上级菜单：</label>
          </div>
          <div class="field">
            <select name="pId" id="selectpId" class="input w50">
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
            <div class="tips"></div>
          </div>
        </div>
      </if>
      <div class="form-group">
          <div class="label">
            <label>启用状态：</label>
          </div>
          <div class="field">
            <select name="status" class="input w50">
            	<option value="1">启用</option>
				<option value="0" 
			  		<#if menu.status== 0>
			  			selected
			  		</#if>
			  	>禁用</option>
			  	
            </select>
            <div class="tips"></div>
          </div>
        </div>
        <div style="padding-left: 10%;" class="field">
          <input  class="button bg-main icon-check-square-o" type="submit" value="保存" >
          <button class="button bg-main icon-check-square-o" type="reset"> 取消</button>
        </div>
    </form>
  </div>
</div>
	<script type="text/javascript">
		$('#selectpId').change(function(){
			pName=$(this).children('option:selected').text();
			//console.log(pName);
			$('#pName').attr("value",pName);
		})
	</script>
</body>
</html>