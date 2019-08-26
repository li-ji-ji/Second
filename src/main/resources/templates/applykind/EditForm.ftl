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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改分类</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${base}/applyKind/updateApplyKindOne">  
      <div class="form-group">
        <div class="label">
          <label>分类ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${kind.id}" readonly name="id" data-validate="required:请输入标题" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>分类名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${kind.kindName}" name="kindName" data-validate="required:请输入标题" />
        </div>
      </div>
      <div class="form-group">
          <div class="label">
            <label>子分类：</label>
          </div>
          <div class="field">
          	<#if kind.hasChild==1>
            	<input type="text" class="input w50" value="有" readonly value="系统自动判定 " />
            <#else>
            	<input type="text" class="input w50" value="无" readonly value="系统自动判定 " />
            </#if>
            <div class="tips"></div>
          </div>
      </div>
      
      <div class="form-group">
          <div class="label">
            <label>相关活动：</label>
          </div>
          <div class="field">
            <select name="hasAct" class="input w50">
            	<option value="1">有</option>
				<option value="0" 
			  		<#if kind.hasAct== 0>
			  			selected
			  		</#if>
			  	>无</option>
			  	
            </select>
            <div class="tips"></div>
          </div>
      </div>
      
      <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>上级分类：</label>
          </div>
          <div class="field">
            <select name="pId" id="selectpId" class="input w50">
				<option value="0" <#if kind.pId == 0>selected</#if>>顶级分类</option>
			  	<#list pKinds as pKind>
			  		<option value="${pKind.id}"<#if pKind.id == kind.pId>selected</#if>>
			  			${pKind.kindName}
			  		</option>
			  	</#list>
            </select>
            <div class="tips"></div>
          </div>
        </div>
      </if>

    <input type="hidden" class="input w50" id="pName" name="pName" data-validate="required:请输入标题" />
      <div class="form-group">
          <div class="label">
            <label>启用状态：</label>
          </div>
          <div class="field">
            <select name="status" class="input w50">
            	<option value="1">启用</option>
				<option value="0" 
			  		<#if kind.status== 0>
			  			selected
			  		</#if>
			  	>禁用</option>
			  	
            </select>
            <div class="tips"></div>
          </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>分类积分：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${kind.kindIntegral}" name="kindIntegral" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>分类简介：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input w50"  name="kindIntro" data-validate="required:请输入标题" >${kind.kindIntro}</textarea>
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
          <div class="label">
            <label>佐证材料：</label>
          </div>
          <div class="field">
            <select name="needSuppDoc" class="input w50">
            	<option value="1">需要</option>
				<option value="0" 
			  		<#if kind.status== 0>
			  			selected
			  		</#if>
			  	>不需要</option>
			  	
            </select>
            <div class="tips"></div>
          </div>
      </div>
      <div class="form-group">
          <div class="label">
            <label>积分凭证：</label>
          </div>
          <div class="field">
            <select name="needSuppFile" class="input w50">
            	<option value="1">需要</option>
				<option value="0" 
			  		<#if kind.status== 0>
			  			selected
			  		</#if>
			  	>不需要</option>
			  	
            </select>
            <div class="tips"></div>
          </div>
      </div>
      <div class="form-group">
          <div class="label">
            <label>是否需要审核：</label>
          </div>
          <div class="field">
            <select name="needCheck" class="input w50">
            	<option value="1">是</option>
				<option value="0" 
			  		<#if kind.status== 0>
			  			selected
			  		</#if>
			  	>否</option>
			  	
            </select>
            <div class="tips"></div>
          </div>
      </div>
      <div class="form-group">
          <div class="label">
            <label>审核方式：</label>
          </div>
          <div class="field">
            <select name="checkKind" class="input w50">
            	<option value="1">手动</option>
				<option value="0" 
			  		<#if kind.status== 0>
			  			selected
			  		</#if>
			  	>自动</option>
			  	
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