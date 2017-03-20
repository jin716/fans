<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/Ymai.css" rel="stylesheet" type="text/css" />
<link href="../css/taobao_nav.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/yahoo-dom-event.js"></script>
<script type="text/javascript" src="../js/selector-min.js"></script>
<script type="text/javascript" src="../js/event-delegate-min.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>

<script type="text/javascript">
jQuery.ajaxSetup({async:false});

(function() {
	
	var Dom=YAHOO.util.Dom,
		Event=YAHOO.util.Event,
		CE=YAHOO.util.CustomEvent;
	
		var sendCodeBtn;
		var timer;
		var countDown = function () {
			sendCodeBtn.disabled = true;
			var time = 60;
			timer = setInterval(function () {
				time--;
				if (time !== 0) {
					sendCodeBtn.innerHTML = "\u5728" + time + "\u79d2\u540e\u70b9\u6b64\u91cd\u53d1";
				} else {
					sendCodeBtn.innerHTML = "\u91cd\u65b0\u53d1\u9001\u624b\u673a\u9a8c\u8bc1\u7801";
					sendCodeBtn.disabled = false;
					clearTimeout(timer);					
				}
			}, 1000);
		};
		
		var send = function(){
			countDown();
			data=jQuery.ajax({
				   async:false,
				   type: "GET",
				   url: "../user/activateCodeSend.do",
				   data: "action=noUser"+v_1_code
				}).responseText; 
			if(data!="-1")alert("验证码已发送！");			
		}
		
		window.onload=function(){  
		sendCodeBtn = document.getElementById("J_ReSendCode");
		countDown();
		}; 
		
		Event.on("J_ReSendCode", "click", send,"button");


})();

		function check_vcode(){
				var v_1_code = document.getElementById("J_Code").value;
				if(v_1_code == ""){
					alert("请输入发送到您手机上的验证码");
					return false;
				}
				return true;
			}
		function taSubmit(){
			if(check_vcode()){
				var v_1_code = document.getElementById("J_Code").value;
				data=jQuery.ajax({
				   async:false,
				   type: "GET",
				   url: "orderCommitValidate.do",
				   data: "J_Code="+v_1_code
				}).responseText; 
				if(data=="-1"){
					alert("验证码错误！");
					return;	
				}
				if(data=="-2"){
					alert("系统错误！");
					return ;
				}
				else if(data=="1"){
					alert('您的订单已成功发出，请坐等美食！');
					parent.window.location.href="../index.jsp";
				}
			}
		}
</script>


<style type="text/css">

#phone_validate_main{
	 margin:0 auto;width:454px;height:277px;background:url(../image/shop/validate.png);padding-top:30px
}

#phone_validate_main .content{
	width:230px;height:250px;margin-left:200px;
}

#phone_validate_main h3{
	font-size:27px;
}

#phone_validate_main span{
	line-height:32px;
	font-size:16px;
}

#phone_validate_main input{
	line-height:27px;
	font-size:14px;
	width:90px;
}

#phone_validate_main button{
	margin-left:8px;
}

#phone_validate_main a{
	text-decoration:underline;
}

</style>

</head>


<body>
	<div id="wrapper" style="width:454px;">

<div id="header" style="width:454px;">
        	
    <div id="logo">
        <img  title="歪麦001" height="80px" src="../image/logo.png"/>
        <img  title="歪麦001" height="80px"  style="margin-left:20px;" src="../image/slogan.png"/>
    </div>
            

</div><div class="clear"></div>
        
        <div id="s_ibody">
        	
            
       <div id="phone_validate_main">
             <form method="post" name="toActivate">
             	<div class="content">
               		<h3><img src="../image/shop/shoujihaomayanzheng.png" width="169" height="27" alt="手机号码验证" style="margin-bottom:16px !important;"/> </h3>
                	<span>验证码已经发送!</span><br/>
                    <span>请输入您接受到的验证码</span><br/>
                    <span style="margin-top:8px;margin-bottom:8px;">验证码：</span><input id="J_Code" name="J_Code" type="text"/><button onclick="taSubmit()">完成</button><br />                    
                <button disabled="disabled" id="J_ReSendCode">在60秒后点此重发</button><br/>
                </div>
    	</form>
             
             </div>
            
            
            <div class="clear"></div>
        </div>
<div id="footer" style="width:454px;">
            
            <p class="cp">饭快快&#169;2010&nbsp;FanKK.com&nbsp;&nbsp;&nbsp;
                
            </p>
</div>

</div>
</body>
</html>

