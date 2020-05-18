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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改申请</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${base}/apply/updateApplyOne">  
      <div class="form-group">
        <div class="label">
          <label>分类ID：</label>
        </div>
        <div class="field">
          <p  class="input w50">${apply.id}</p>
        </div>
      </div>

      
      <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>申请分类：</label>
          </div>
          <div class="field">
          	<p class="input w50">${apply.kindName}</p>    
       	  </div>
        </div>
      </if>

    <input type="hidden" class="input w50" id="kindId" name="kindId" readonly value="${apply.kindId}" data-validate="required:请输入标题" />

    <div class="form-group">
       <div class="label">
         <label>学生ID：</label>
       </div>
       <div class="field">
          	<p class="input w50">${apply.stuId}</p>   
       </div>
    </div>
    
    <div class="form-group">
          <div class="label">
            <label>申请状态：</label>
          </div>
          <div class="field">
          	<#if apply.status== 0>
          		<p class="input w50">申请中</p>
          	<#elseif apply.status== 1>
          		<p class="input w50">已通过</p>
          	<#elseif apply.status== 2>
          		<p class="input w50">申诉中</p>
          	<#elseif apply.status== 3>
          		<p class="input w50">已取消</p>
          	</#if>
          </div>
    </div>
    <div class="form-group">
          <div class="label">
            <label>审核状态：</label>
          </div>
          <div class="field">
          	<#if apply.status== 0>
          		<p class="input w50">审核中</p>
          	<#elseif apply.status== 1>
          		<p class="input w50">已通过</p>
          	<#elseif apply.status== 2>
          		<p class="input w50">已驳回</p>
          	</#if>
          </div>
    </div>
    
    <div class="form-group">
        <div class="label">
          <label>佐证材料：</label>
        </div>
        <div class="field">
          	<p class="input w50">${apply.supportDoc}</p>
        </div>
    </div>
    
    <div class="form-group">
        <div class="label">
          <label>附件：</label>
        </div>
        <div class="field">
          	<p class="input w50">${apply.supportFile}</p>
        </div>
    </div>
    
    <div class="form-group">
        <div class="label">
          <label>提交日期：</label>
        </div>
        <div class="field">
          	<p class="input w50">${apply.applyTime?datetime}</p>
        </div>
    </div>
    
    <div class="form-group">
        <div class="label">
          <label>申请积分：</label>
        </div>
        <div class="field">
          	<p class="input w50">${apply.integral}</p>
        </div>
    </div>


      
        <div style="padding-left: 10%;" class="field">
          <a href="${base}/apply/checkApplyOne?id=${apply.id}" onClick="return confirm('确认通过审核？') " class="button border-green" style="text-decoration: none;">通过申请</a>
          <a href="${base}/apply/rejectApplyOne?id=${apply.id}" onClick="return confirm('确认驳回申请？') " class="button border-red" style="text-decoration: none;margin-left: 5%;">驳回申请</a>
        </div>
    </form>
  </div>
</div>
	<script type="text/javascript">
		var kindAll=${kindAll};
		$('#selectpId').change(function(){
			kindName=$(this).children('option:selected').text();
			//console.log(pName);
			$('#kindName').attr("value",kindName);
		});

		$('.form_date').datetimepicker({
	        language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0
	    });
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
/* 		//点击获取下级分类并渲染
		function setChindKindList(e,pId){
			$.ajax({
				  type: 'get',
				  url: "${base}/apply/getApplyKindAll",
				  //data: "pId="+pId,
				  dataType: "JSON",
				  success:function(res){
					  kindList=res
					  console.log(kindList);
					  if(res.length>0){
						  $(e).parent().parent().next().children("ul").children(":first-child").remove();
						  for(var i=0;i<res.length;i++){
							  if(res[i].hasChild==1){
								  $(e).parent().parent().next().children("ul").append("<li onclick='setChindKindList(this,"+res[i].id+")'><a href='#'>"+res[i].kindName+"</a></li>")
							  }
							  else{
								  $(e).parent().parent().next().children("ul").append("<li onclick='setChindKindList(this,"+res[i].id+")'><a href='#'>"+res[i].kindName+"</a> </li>")
							  }
						  }
					  }
					  else{
						  $(e).parent().parent().next().children("ul").children("li").children("a").text("无")
						  kindList=res
					  }
					  setTimeout(function(){
							$(e).parent().parent().next().addClass("open")
					  },10);
				  } 
				});
		} */
		//点击填写分类数据
		function putMsgByKind(){
			
		}
	</script>
</body>
</html>