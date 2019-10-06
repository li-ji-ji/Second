<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<head>
<meta charset="UTF-8">
<title>社团管理</title>
<link rel="stylesheet"
	href="${base}/js/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
	<table class="layui-table" id="MenuTable" lay-filter="MenuTable">
		<!-- 表头 -->
		<thead>
			<tr>
				<th lay-data="{field:'id',width:'100',fixed:'left',align:'center'}">菜单ID</th>
				<th lay-data="{field:'name',width:'150',fixed:'left',align:'center'}">菜单名称</th>
				<th lay-data="{field:'pId',width:'150',align:'center'}">上级菜单ID</th>
				<th lay-data="{field:'pName',width:'150',align:'center'}">上级菜单名称</th>
				<th lay-data="{field:'url',width:'150',align:'center'}">跳转链接</th>
				<th lay-data="{field:'status',width:'150',align:'center'}">启用状态</th>
				<th lay-data="{field:'tool',width:'200',fixed:'right',align:'center'}">操作栏</th>
			</tr>
			<tbody>
				<#list menus as menu>
					<tr>
						<td  lay-data="{checkbox:true,align:'center'}">${menu.id}</td>
						<td  lay-data="{checkbox:true,align:'center'}">${menu.name}</td>
						<td  lay-data="{checkbox:true,align:'center'}">${menu.pId}</td>
						<td  lay-data="{checkbox:true,align:'center'}">${menu.pName}</td>
						<td  lay-data="{checkbox:true,align:'center'}">${menu.url}</td>
						<td  lay-data="{checkbox:true,align:'center'}">
							<#if menu.status==1>
									启用
								<#else>
									停用
							</#if>
						</td>
						<td  lay-data="{checkbox:true,align:'center'}">
							<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="toChild">查看社团</a>
		  					<a href="${base}/menu/toEdit?id=${menu.id}" class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
		  					<a href="${base}/menu/deleteMenuOne?id=${menu.id}" onClick="return confirm('确认删除？') " class="layui-btn layui-btn-danger layui-btn-xs">删除</a>
		  					<#if menu.status==1>
		  					<a href="${base}/menu/updateMenuOneNotEnable?id=${menu.id}" onClick="return confirm('确认禁用？') " class="layui-btn layui-btn-danger layui-btn-xs">禁用</a>
								<#else>
		  					<a href="${base}/menu/updateMenuOneEnable?id=${menu.id}" onClick="return confirm('确认启用？') " class="layui-btn  layui-btn-xs">启用</a>
							</#if>
						</td>
					</tr>
				</#list>
			</tbody>
		</thead>
	</table>
	<div id="pageTool"></div>
	<script src="${base}/js/layui/layui.js"></script>
	<script type="text/html" id="editTool">
		<!-- 工具栏 -->
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="toChild">查看下级菜单</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<!-- 
	<script type="text/html" id="toolbar">
  		<div class="layui-btn-container">
    		<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="getDeleteList">删除选中数据</button>
    		<a href="${base}/asso/toAdd"><button class="layui-btn layui-btn-sm" lay-event="getCheckLength">添加社团</button></a>
    		<#if TableType=="ExistedTable">
				<a href="${base}//asso/toExamingAssoTable"><button class="layui-btn layui-btn-sm" lay-event="isAll">查看待审核社团</button></a>
			<#elseif TableType=="ExamingTable">
				<a href="${base}/asso/toExistedAssoTable"><button class="layui-btn layui-btn-sm" lay-event="isAll">查看已成立社团</button></a>
				<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="getCheckList">批量审核选中社团</button>
			</#if>
  		</div>
	</script>
	 -->
	<script>
	layui.use(['laypage','table'],function(){
		  var table = layui.table;
		  table.init('AssoTable',{
			  height:450,
			  toolbar: '#toolbar',
			  page:true,
			  limit:10
		  });
		  //头工具栏事件
		  table.on('toolbar(MenuTable)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id);
		    switch(obj.event){
		      case 'getDeleteList':
		        var data = checkStatus.data;
		        var deleteList=[]
		        for(var item of data){
		        	deleteList.push(item.id)
		        };
		        layer.confirm('确认删除选中数据', function(index){
		        	$.ajax({
				    	  "url" : "${base}/asso/deleteList",
				    	  "data" : "deleteList="+deleteList,
				    	  "type" : "post",
				    	  "dataType" : "json",
				    	  "success"	: function (resultMsg) {
				    		  if(resultMsg==1){
				    			  layer.open({
				    				    type: 1 //不显示标题栏   title : false/标题
				    				    ,title: "删除成功"
				    				    ,btn: ['好的']
				    				    ,btnAlign: 'c'
				    				    ,success: function(layero){
				    				         var btn = layero.find('.layui-layer-btn');
				    				            btn.find('.layui-layer-btn0').attr({
				    				                 href: '${base}/asso/toExistedAssoTable'
				    				            ,target: '_self'
				    				        });
				    				    }
				    				});
				    		  }else{
				    			  layer.open({
				    				    type: 1 //不显示标题栏   title : false/标题
				    				    ,title: "删除失败"
				    				    ,btn: ['好的']
				    				    ,btnAlign: 'c'
				    				    ,success: function(layero){
				    				         var btn = layero.find('.layui-layer-btn');
				    				            btn.find('.layui-layer-btn0').attr({
				    				                 href: '${base}/asso/toExistedAssoTable'
				    				            ,target: '_self'
				    				        });
				    				    }
				    				});
				    		  }
		    			  
						}
				      });
		          });
		      break;
		      case 'getCheckList':
		    	  var data = checkStatus.data;
			        var checkList=[]
			        for(var item of data){
			        	checkList.push(item.id)
			        };
			        layer.confirm('确认通过审核', function(index){
			        	$.ajax({
					    	  "url" : "${base}/asso/setCheckedAssoList",
					    	  "data" : "checkList="+checkList,
					    	  "type" : "post",
					    	  "dataType" : "json",
					    	  "success"	: function (resultMsg) {
					    		  if(resultMsg==1){
					    			  layer.open({
					    				    type: 1 //不显示标题栏   title : false/标题
					    				    ,title: "审核成功"
					    				    ,btn: ['好的']
					    				    ,btnAlign: 'c'
					    				    ,success: function(layero){
					    				         var btn = layero.find('.layui-layer-btn');
					    				            btn.find('.layui-layer-btn0').attr({
					    				                 href: '${base}/asso/toExistedAssoTable'
					    				            ,target: '_self'
					    				        });
					    				    }
					    				});
					    		  }else{
					    			  layer.open({
					    				    type: 1 //不显示标题栏   title : false/标题
					    				    ,title: "审核失败"
					    				    ,btn: ['好的']
					    				    ,btnAlign: 'c'
					    				    ,success: function(layero){
					    				         var btn = layero.find('.layui-layer-btn');
					    				            btn.find('.layui-layer-btn0').attr({
					    				                 href: '${base}/asso/toExistedAssoTable'
					    				            ,target: '_self'
					    				        });
					    				    }
					    				});
					    		  }
			    			  
							}
					      });
			          });
		      break;
		      case 'isAll':
		        layer.msg(checkStatus.isAll ? '全选': '未全选');
		      break;
		    };
		  });
		  
	})
	</script>
</body>
</html>