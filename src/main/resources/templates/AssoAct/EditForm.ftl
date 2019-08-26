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
<script type="text/javascript" src="${base}/admin/js/bootstrap.min.js"></script>
<script src="${base}/admin/js/pintuer.js"></script>
<!-- 日期组件 -->
<link href="${base}/js/bootstrapDatetime/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${base}/js/bootstrapDatetime/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${base}/js/bootstrapDatetime/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${base}/js/bootstrapDatetime/bootstrap/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改活动</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${base}/assoAct/updateActOne">  
    <input type="hidden" class="input w50" value="${act.id}" id="id" name="id" data-validate="required:请输入标题" />
    	
      <div class="form-group">
        <div class="label">
          <label>活动ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${act.activityId}" readonly name="activityId" data-validate="required:请输入标题" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>活动名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${act.activityName}" name="activityName" data-validate="required:请输入标题" />
        </div>
      </div>
      
      <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>所属单位：</label>
          </div>
          <div class="field">
            <select name="activityAssoId" id="selectAssoName" class="input w50">
			  	<#list assoList as asso>
			  		<option value="${asso.assoId}"
			  		<#if asso.assoId == act.activityAssoId>
			  			selected
			  		</#if>
			  		>${asso.assoName}</option>
			  	</#list>
            </select>
            <div class="tips"></div>
          </div>
        </div>
      </if>
      <!-- 社团名称 -->
     <input type="hidden" class="input w50" value="${act.activityAssoName}" id="activityAssoName" name="activityAssoName" data-validate="required:请输入标题" />

      
     <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>负责人：</label>
          </div>
          <div class="field">
            <select name="activityOrganizerId" id="activityOrganizerId" class="input w50">
			  	<#list stuList as stu>
			  		<option value="${stu.sId}"
			  		<#if stu.sId == act.activityOrganizerId>
			  			selected
			  		</#if>
			  		>${stu.sName}</option>
			  	</#list>
            </select>
            <div class="tips"></div>
          </div>
        </div>
      </if>
      <!-- 活动负责人 -->
     <input type="hidden" class="input w50" value="${act.activityOrganizerName}" id="activityOrganizerName" name="activityOrganizerName" data-validate="required:请输入标题" />
      
      
      <div class="form-group">
        <div class="label">
          <label>活动人数上限：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${act.activityNum}" name="activityNum" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>开始时间：</label>
        </div>
        <div class="field input-group date form_datetime" style="width:21.5%;" data-date-format="yyyy-MM-dd hh:mm" data-link-field="dtp_input1">
        	<input class="form-control" size="16" type="text" value="${act.activityStartTime?datetime}" id="activityStartTime" name="activityStartTime" readonly>
            <span class="input-group-addon"><span class="glyphicon glyphicon-th" style="display:none;"></span><span class="icon-plus-square-o"></span></span>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>结束时间：</label>
        </div>
        <div class="field input-group date form_datetime" style="width:21.5%;" data-date-format="yyyy-MM-dd hh:mm" data-link-field="dtp_input1">
        	<input class="form-control" size="16" type="text" value="${act.activityFinishTime?datetime}" id="activityFinishTime" name="activityFinishTime" readonly>
            <span class="input-group-addon"><span class="glyphicon glyphicon-th" style="display:none;"></span><span class="icon-plus-square-o"></span></span>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>活动简介：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input w50"  name="activityIntro" data-validate="required:请输入标题">${act.activityIntro}</textarea>
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
	    $('.form_datetime').datetimepicker({
	        language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0
	    });
	    $("#activityFinishTime").on('blur',function(){
			//console.log("失去焦点");
			var dateStart=$("#activityStartTime").val();
			var dateFinish=$("#activityFinishTime").val();
			console.log(dateStart)
			console.log(dateFinish)
			if(dateStart>dateFinish){
				console.log("1")
			}
			else{
				console.log("2")
			}
			
			
	    })
		$('#selectAssoName').change(function(){
			activityAssoName=$(this).children('option:selected').text();
			//console.log(activityAssoName);
			$('#activityAssoName').attr("value",activityAssoName);
		})
		$('#activityOrganizerId').change(function(){
			activityOrganizerName=$(this).children('option:selected').text();
			//console.log(activityOrganizrName);
			$('#activityOrganizerName').attr("value",activityOrganizerName);
		})
	</script>
</body>
</html>