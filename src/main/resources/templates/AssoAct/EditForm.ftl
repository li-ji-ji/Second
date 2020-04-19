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
            <label>活动分类：</label>
          </div>
          <div class="field">
          	<input type="text" class="input w50" value="${act.activityKindName?if_exists}" readonly  id="kindName" name="activityKindName" onclick="openKindList(this)" />
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
      
    <input type="hidden" class="input w50" id="kindId" name="activityKindId" readonly value="" data-validate="required:请输入标题" />
      
      
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
        <div class="field input-group date form_datetime" style="width:21.5%;" data-date-format="yyyy-MM-dd hh:mm:ss" data-link-field="dtp_input1">
        	<input class="form-control" size="16" type="text" value="${act.activityStartTime?datetime}" id="activityStartTime" name="activityStartTime" readonly>
            <span class="input-group-addon"><span class="glyphicon glyphicon-th" style="display:none;"></span><span class="icon-plus-square-o"></span></span>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>结束时间：</label>
        </div>
        <div class="field input-group date form_datetime" style="width:21.5%;" data-date-format="yyyy-MM-dd hh:mm:ss" data-link-field="dtp_input1">
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

      <div class="form-group">
        <div class="label">
          <label>活动内容：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input w50"  placeholder="请输入活动内容" name="activityContent" data-validate="required:请输入活动 内容">${act.activityContent}</textarea>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>活动图片：</label>
        </div>
        <div class="field">
	        <div class="input-group" style="width:70%;">
			  <input type="text" class="form-control input" value="${act.activityImg?if_exists}" name="activityImg" id="activityImg" aria-label="...">
			  <div class="input-group-btn">
  				<button type="button" class="btn btn-default" onclick="clickInput()">选择图片</button>
			  </div>
			</div>
          	<input type="file" id="imgInput" style="display: none;" onchange ="UpladFile()">
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
				/* console.log("1") */
			}
			else{
				/* console.log("2") */
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
		
		<!--图片上传-->
		function clickInput(){
	    	$('#imgInput').click();
	    }
		function UpladFile() {
            var fileObj = document.getElementById("imgInput").files[0]; // 获取文件对象
            var FileController = "https://qzimp.cn/api/file/uploadFile";                    // 接收上传文件的后台地址 
            // FormData 对象
            var form = new FormData();
            form.append("author", "hooyes");                        // 可以增加表单数据
            form.append("file", fileObj);                           // 文件对象
            // XMLHttpRequest 对象
            var xhr = new XMLHttpRequest();
            xhr.open("post", FileController, true);
            xhr.onload = function (res) {
            	var msg=JSON.parse(res.currentTarget.response)
            	document.getElementById("activityImg").value=msg.data.src
            };
            xhr.send(form);
        }
		
		
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