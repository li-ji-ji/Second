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
<script src="${base}${staticPath}/admin/js/pintuer.js"></script>
<!-- 日期组件 -->
<link href="${base}${staticPath}/js/bootstrapDatetime/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${base}${staticPath}/js/bootstrapDatetime/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${base}${staticPath}/js/bootstrapDatetime/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${base}${staticPath}/js/bootstrapDatetime/bootstrap/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加申请</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" id="insertForm" action="${base}/apply/insertApplyOne">  
      <div class="form-group">
        <div class="label">
          <label>分类ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" readonly name="id" placeholder="系统自动分配" />
        </div>
      </div>

      
     <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>申请分类：</label>
          </div>
          <div class="field">
          	<input type="text" class="input w50" value="" readonly id="kindName" name="kindName" onclick="openKindList(this)" data-validate="required:请输入标题" />
			<div class="btn-group" style="margin:4px 0 4px 10px;">
			  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				 一级分类<span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" >
			  	<#list kindList as kind>
			    	<li onclick="setChindKindList(this,${kind.id})" ><a href="#">${kind.kindName}</a></li>
			    </#list>
			  </ul>
		    </div>
		    <div class="btn-group" disabled style="margin:4px 0 4px 10px;">
			  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				二级分类<span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu">
			  	<li><a href="#">请选择上级分类</a></li>
			  </ul>
		    </div>
		    <div class="btn-group"  style="margin:4px 0 4px 10px;">
			  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				三级分类<span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu">
			  	<li><a href="#">请选择上级分类</a></li>
			  </ul>
		    </div>
       	  </div>
        </div>
      </if>

    <input type="hidden" class="input w50" id="kindId" name="kindId" readonly value="" data-validate="required:请输入标题" />

    <div class="form-group">
       <div class="label">
         <label>学生ID：</label>
       </div>
       <div class="field">
         <input type="text" class="input w50" name="stuId" data-validate="required:请输入标题" />
       </div>
    </div>
    
    <div class="form-group">
          <div class="label">
            <label>申请状态：</label>
          </div>
          <div class="field">
            <select name="status" class="input w50">
				<option value="0">申请中</option>
            	<option value="1">已通过</option>
            	<option value="2">申诉中</option>
            	<option value="3">已取消</option>
            </select>
            <div class="tips"></div>
          </div>
    </div>
    <div class="form-group">
          <div class="label">
            <label>审核状态：</label>
          </div>
          <div class="field">
            <select name="checkStatus" class="input w50">
				<option value="0">审核中</option>
            	<option value="1">已通过</option>
            	<option value="2">已驳回</option>
            </select>
            <div class="tips"></div>
          </div>
    </div>
    
    <div class="form-group">
        <div class="label">
          <label>佐证材料：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="supportDoc"/>
          <div class="tips"></div>
        </div>
    </div>
    
    <div class="form-group">
        <div class="label">
          <label>附件：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  name="supportFile"/>
          <div class="tips"></div>
        </div>
    </div>
    
    <div class="form-group">
        <div class="label">
          <label>提交日期：</label>
        </div>
        <div class="field input-group date form_datetime" style="width:21.5%;" data-date="" data-date-format="yyyy-MM-dd hh:mm:ss" data-link-field="dtp_input1">
            <input class="input w50 form-control" name="applyTime" type="text" value="" readonly>
			<span class="input-group-addon"><span class="glyphicon glyphicon-th" style="display:none;"></span><span class="icon-plus-square-o"></span></span>
        </div>
    </div>
    
    <div class="form-group">
        <div class="label">
          <label>申请积分：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="integral" readonly  name="integral" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
    </div>



      
        <div style="padding-left: 10%;" class="field">
          <a href="javascript:void(0)" class="button bg-main"  onclick="submitCheck()">提交</a>
          <button class="button bg-main" type="reset"> 取消</button>
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

		$('.form_datetime').datetimepicker({
	        language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
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
	</script>
</body>
</html>