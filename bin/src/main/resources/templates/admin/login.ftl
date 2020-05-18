<!-- 配置页面路径  -->
<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>管理员登录</title>
  	<script type="text/javascript" src="${base}${staticPath}/js/jquery-3.3.1.js"></script>
  	<script src="${base}${staticPath}/js/layer/layer.js"></script>
</head>
<style>
    html,body{
        margin: 0 auto;
        height: 100%;
        width: 100%;
    }
    .body-box{
        height: 100%;
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #2d3a4b;
        overflow: hidden;
    }
    .admin-msg-box{
        width: 520px;
        padding: 50px 35px;
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
    }
    .msg-title{
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .msg-title span{
        font-size: 26px;
        color: #eee;
        font-weight: 700;
    }
    .msg-content{
        display: flex;
        justify-content: center;
        align-content: space-around;
        flex-wrap: wrap;
        padding: 35px;
    }
    .msg-content-item{
        width: 100%;
        padding:10px 15px;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 26px;
        color: #eee;
        font-weight: 700;
        box-sizing: border-box;
        border: 1px solid hsla(0,0%,100%,.1);
        background: rgba(0,0,0,.1);
        border-radius: 5px;
    }
    .msg-content-item svg{
        width: 24px;
        height: 24px;
        margin-right: 15px;
    }
    .msg-content-item input{
        background-color: transparent;
        border-color: transparent;
        color: #fff;
        flex: 1;
        font-size:24px;
    }
    .msg-content-item input:focus{
        outline:none;
    }
    /* 分割线 */
    .hover-line{
        height: 20px;
        width: 100%;
    }
    .submit-btn{
        width: 100%;
        height: 43px;
        background-color: #409eff;
        border-color: transparent;
        border-radius: 5px;
        font-size:20px;
        color:#fff;
    }
    .register-btn{
        width: 100%;
        height: 43px;
        background-color: #f8f8f8;
        border-color: transparent;
        border-radius: 5px;
        font-size:20px;
    }
</style>

<body>
    <div class="body-box">
        <!-- 管理员登录信息容器 -->
        <div class="admin-msg-box">
            <!-- 标题 -->
            <div class="msg-title">
                <span>管理员登录</span>
            </div>
            <!-- 登录信息 -->
            <form action="${base}/login/login" method="post">
	            <div class="msg-content">
	                <div class="msg-content-item">
	                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 130 130" id="icon-user"><path d="M63.444 64.996c20.633 0 37.359-14.308 37.359-31.953 0-17.649-16.726-31.952-37.359-31.952-20.631 0-37.36 14.303-37.358 31.952 0 17.645 16.727 31.953 37.359 31.953zM80.57 75.65H49.434c-26.652 0-48.26 18.477-48.26 41.27v2.664c0 9.316 21.608 9.325 48.26 9.325H80.57c26.649 0 48.256-.344 48.256-9.325v-2.663c0-22.794-21.605-41.271-48.256-41.271z" stroke="#979797"></path></svg>
	                    <input id="adminName" name="username" placeholder="请输入账号" type="text">
	                </div>
	                <!-- 分割线 -->
	                <div class="hover-line"></div>
	                <div class="msg-content-item">
	                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 130 130" id="icon-user"><path d="M108.8 44.322H89.6v-5.36c0-9.04-3.308-24.163-25.6-24.163-23.145 0-25.6 16.881-25.6 24.162v5.361H19.2v-5.36C19.2 15.281 36.798 0 64 0c27.202 0 44.8 15.281 44.8 38.961v5.361zm-32 39.356c0-5.44-5.763-9.832-12.8-9.832-7.037 0-12.8 4.392-12.8 9.832 0 3.682 2.567 6.808 6.407 8.477v11.205c0 2.718 2.875 4.962 6.4 4.962 3.524 0 6.4-2.244 6.4-4.962V92.155c3.833-1.669 6.393-4.795 6.393-8.477zM128 64v49.201c0 8.158-8.645 14.799-19.2 14.799H19.2C8.651 128 0 121.359 0 113.201V64c0-8.153 8.645-14.799 19.2-14.799h89.6c10.555 0 19.2 6.646 19.2 14.799z"></path></svg>
	                    <input id="password" name="password" placeholder="请输入密码" type="password">
	                </div>
	                <div class="hover-line"></div>
	                <button type="submit" class="submit-btn" onclick="admin_submit()" οnsubmit="return false;">管理员登录</button>
	                <div class="hover-line"></div>
	                <button class="register-btn" onclick="admin_submit()">注册</button>
	            </div>
            </form>
        </div>
    </div>
</body>
<script>
	$(document).ready(function(){
		var loginMsg="${msg?if_exists}"
		if(loginMsg!=""){
    		layer.msg(loginMsg);
		}
	})
    function admin_submit() {
        if($("#adminName").val()==""){
    		layer.msg('请输入账号');
            return false
        }else if($("#password").val()==""){
    		layer.msg('请输入密码"');
            return false
        }else{
        	return true
/*     	    $.ajax({
    	    	"url" : "${base}/login/adminCheck",
    	        "contentType": "application/json",
    	    	"data":JSON.stringify(adminJSON),
    	    	"type" : "post",
    	    	"dataType" : "json",
    	    	"success"	: function (resultMsg) {
    	    		console.log(resultMsg)
    	    		}
    	    	}); */
        }
    }
</script>
</html>