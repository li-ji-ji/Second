<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
    <meta charset="UTF-8">
    <title>选择文件及上传</title>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.3.2.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        
        body {
            height: 100%;
            width: 100%;
            background: rgba(0, 0, 0, 0.7);
            background-size: cover;
        }
        /* .bg {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background: rgb(138, 193, 245)
        } */
        
        #input1 {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background: rgb(138, 193, 245);
            text-align: center;
            outline: 0;
            position: relative;
            opacity: 0;
            top: -139px;
            margin-top: 20px
        }
        
        .input2 {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background: rgb(138, 193, 245);
            text-align: center;
            outline: 0;
            position: relative;
            opacity: 0;
            top: -119px;
            margin-top: 20px
        }
        
        .asd {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background: rgb(117, 238, 117);
            text-align: center;
            line-height: 100px;
            margin: 100px auto;
            color: #fff;
        }
        
        .qwe {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background: rgb(248, 193, 92);
            text-align: center;
            line-height: 100px;
            margin: 165px auto;
            color: #fff
        }
    </style>
</head>

<body>
    <div>
    
     
        <form id="form1" action="http://qzimp.cn/api/file/print/upload" target="frame1" method="post" enctype="multipart/form-data">
            <div class="qwe">选择文件<input id="input1" type="file" name="file"></div>
            <div class="asd" >上传<input class="input2" type="button" value="上传" ></div>
        </form> 
        <iframe name="frame1" frameborder="0" height="40"></iframe>
            <!-- <a href="#"  id="input2">测试</a>  --> 
        <!-- 其实我们可以把iframe标签隐藏掉 -->
    </div>
    
            <script type="text/javascript" >
           /*  function upload() {
                $("#form1").submit();
                var t = setInterval(function() {
                        //获取iframe标签里body元素里的文字。即服务器响应过来的"上传成功"或"上传失败"	
                        var word = $("iframe[name='frame1']").contents().find("body").text();
                        if (word != "") { //				
                            alert(word); //弹窗提示是否上传成功//				
                            clearInterval(t); //清除定时器			
                        }
                    },
                    1000);
            } */
                    function asd(e){
                    	alert("aaa")
                    	console.log("aaa")
                    }
            		var page=${page}
            		console.log("=========================================================")
            		console.log(page)
            		console.log("=========================================================")
                    $(".input2").on("click",function(){
                    	 console.log(document.getElementById("input1").files[0]); 
                    	 var fileName=document.getElementById("input1").files[0].name;
                    	 
                    	console.log(document.getElementById("input1").files[0])
                    	/* prevPage.setData({
                    			  fileName：document.getElementById("input1").files[0]
                    			}) */
                    		 /*  var pages = getCurrentPages();
                    			var currPage = pages[pages.length - 1];   //当前页面
                    			var prevPage = pages[pages.length - 2];   //上一个页面 */
/*                     			page.setData({
                        			   fileName:document.getElementById("input1").files[0] 
                        			})  */
                        wx.miniProgram.postMessage({
                        	data:{
                        		fileName:File.name,
                        	}
                        })
                    	wx.miniProgram.navigateBack({
                    	})
                    })

        </script>
</body>

</html>