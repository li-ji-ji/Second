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
<script type="text/javascript" src="${base}${staticPath}/admin/js/bootstrap.min.js"></script>
<script src="${base}${staticPath}/admin/js/pintuer.js"></script>
<!-- 日期组件 -->
<link href="${base}${staticPath}/js/bootstrapDatetime/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${base}${staticPath}/js/bootstrapDatetime/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${base}${staticPath}/js/bootstrapDatetime/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${base}${staticPath}/js/bootstrapDatetime/bootstrap/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>查看活动</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${base}/assoAct/updateActOne">  
    <input type="hidden" class="input w50" value="${act.id}" id="id" name="id" data-validate="required:请输入标题" />
    	
      <div class="form-group">
        <div class="label">
          <label>活动ID：</label>
        </div>
        <div class="field">
          <p  class="input w50">${act.activityId}</p>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>活动名称：</label>
        </div>
        <div class="field">
          <p  class="input w50">${act.activityName}</p>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>所属单位：</label>
        </div>
        <div class="field">
         <p class="input w50">${act.activityAssoName}</p>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>所属单位编号：</label>
        </div>
        <div class="field">
         <p class="input w50">${act.activityAssoId}</p>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>活动分类：</label>
        </div>
        <div class="field">
         <p class="input w50">${act.activityKindName}</p>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>活动分类ID：</label>
        </div>
        <div class="field">
         <p class="input w50">${act.activityKindId}</p>
        </div>
      </div>
      
        <div class="form-group">
          <div class="label">
            <label>负责人：</label>
          </div>
          <div class="field">
         	<p class="input w50">${act.activityOrganizerName}</p>
          </div>
        </div>
        
        <div class="form-group">
          <div class="label">
            <label>负责人学号：</label>
          </div>
          <div class="field">
         	<p class="input w50">${act.activityOrganizerId}</p>
          </div>
        </div>
        
      <div class="form-group">
        <div class="label">
          <label>活动人数上限：</label>
        </div>
        <div class="field">
         	<p class="input w50">${act.activityNum}</p>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>已参加人数：</label>
        </div>
        <div class="field">
         	<p class="input w50">${act.activityPartNum}</p>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>开始时间：</label>
        </div>
        <div class="field">
         	<p class="input w50">${act.activityStartTime?datetime}</p>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>结束时间：</label>
        </div>
        <div class="field">
         	<p class="input w50">${act.activityFinishTime?datetime}</p>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>活动简介：</label>
        </div>
        <div class="field">
         	<p class="input w50">${act.activityIntro}</p>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>活动内容：</label>
        </div>
        <div class="field">
         	<p class="input w50">${act.activityContent}</p>
        </div>
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
				<!--活动分类-->		
		var kindAll=${kindAll};
		$('#selectpId').change(function(){
			kindName=$(this).children('option:selected').text();
			//console.log(pName);
			$('#kindName').attr("value",kindName);
		})
		function submitCheck(){
			if($('#selectpId').children('option:selected').text()=="请选择分类"){
				alert("请选择分类");
				return false;
			}
			else{
				$("#insertForm").submit();
			}
		};
		function openKindList(e){
			if(!($(e).next().hasClass("open"))){
				setTimeout(function(){
					$(e).next().addClass("open")
				},10);
			}
		}
		function openNextKindList(e){
			setTimeout(function(){
				$(e).parent().parent().next().addClass("open")
			},10);
		}
		function ulIsNull(e){
			if($(e).children("ul").children().length>1){
				$(e).children("ul").children(":first-child").hide()
			}
			else{
				$(e).children("ul").children(":first-child").show()
			}
		}
		function setChindKindList(e,pId){
			for(var i=0;i<kindAll.length;i++){
				if(kindAll[i].id==pId){
					if(kindAll[i].hasChild==1){
						$(e).parent().parent().next().children("ul").children().remove();
						for(var j=0;j<kindAll.length;j++){
							if(kindAll[j].pId==pId){
								if(kindAll[j].hasChild==1){
									$(e).parent().parent().next().children("ul").append("<li onclick='setChindKindList(this,"+kindAll[j].id+")'><a href='#'>"+kindAll[j].kindName+"</a></li>")	
								}
								else{
									$(e).parent().parent().next().children("ul").append("<li onclick='putKindMsg("+kindAll[j].id+")'><a href='#'>"+kindAll[j].kindName+"</a></li>")	
								}
							}
						}
					}
					else{
						$(e).parent().parent().next().children("ul").children().remove();
						$(e).parent().parent().next().children("ul").append("<li><a href='#'>暂无子分类</a></li>")
					}
				}
				setTimeout(function(){
					$(e).parent().parent().next().addClass("open")
			  	},10);
			}	
		}
		function putKindMsg(id){
			for(var i=0;i<kindAll.length;i++){
				if(kindAll[i].id==id){
					console.log(kindAll[i])
					$("#kindId").attr("value",kindAll[i].id)
					$("#kindName").attr("value",kindAll[i].kindName)
					$("#integral").attr("value",kindAll[i].kindIntegral)
				}
			}
		}
	</script>
</body>
</html>