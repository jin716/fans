// JavaScript Document
(function(){$namespace("PP.head_paipai");window["_PP_head"]={};PP.head_paipai.data={};PP.head_paipai.init=function(){this.bindDownMenus();this.showWelcome();this.showNotic();this.changeType();this.bindSearchTips();this.closeAllTips();this.showMenu();this.showABTest();};PP.head_paipai.showNotic=function(){};PP.head_paipai.changeType=function(){var typeItem,typeTab=$id("searchTab");if(!typeTab)return;var typeNodes=typeTab.getElementsByTagName("p");for(var i=0,len=typeNodes.length;i<len;i++){typeNodes[i].setAttribute("attr",i);typeNodes[i].onclick=changeFun;}
function changeFun(){var typeItem,typeTab=$id("searchTab"),typeNodes=typeTab.getElementsByTagName("p"),t=this.getAttribute("attr");for(var n=0;n<typeNodes.length;n++){if(n==t){typeNodes[n].className="now";$id("searchType").value=t;}else{typeNodes[n].className="";}}};};PP.head_paipai.bindDownMenus=function(){};PP.head_paipai.showWelcome=function(){};
//下段代码在下拉框实时更新搜索值
PP.head_paipai.bindSearchTips=function(){window["_PP_head"].searchValue="";var nowLink=-1,preLink=0,keyNumber=0;$addEvent(document,"click",docclick);function docclick(){if($id("showAutoResult").style.display!="none"){hideResult();}};$id("KeyWord").onkeydown=function(){val=this.value;};$id("KeyWord").onkeyup=function(e){e=e?e:window.event;var keyCode=window.event?e.keyCode:e.which;if(keyCode!=13&keyCode!=38&&keyCode!=40&&this.value!=''){if(this.value!=window["_PP_head"].searchValue){hideResult();showResult(this.value);};}else if(keyCode==13){if(val!=''){submitTo();}}else if(this.value==''){hideResult();};window["_PP_head"].searchValue=this.value;};/*$id("headSubmitBtn").onclick=function(){submitTo();};*/function showKeyDown(code,dataSearch){if(code==38||code==40){preLink=nowLink;if(code==38){nowLink--;}else if(code==40){nowLink++;};if(nowLink<0){nowLink=keyNumber-1;}else if(nowLink>keyNumber-1){nowLink=0;};var objNowLink=$id("showAutoResult").childNodes[0].childNodes[nowLink];if(objNowLink){objNowLink.className="autoResultLink";$id("KeyWord").value=dataSearch[nowLink][0];};if(nowLink!=-1){var objPreLink=$id("showAutoResult").childNodes[0].childNodes[preLink];if(objPreLink){objPreLink.className="";}}}else if(code==13){if(nowLink!=-1){$id("KeyWord").value=dataSearch[nowLink][0];hideResult();};submitTo();}};function submitTo(){};
function showResult(theValue){var searchType=$id("searchType").value;if(searchType!="1"){window['_PP_head_callback']=function(dataSearch){var len=dataSearch.length,arrAuto=[];if(!len)return;arrAuto.push('<ul>');for(var i=0;i<len;i++){arrAuto.push('<li><a href="http://search.paipai.com/cgi-bin/comm_search?keywordtype=goods&KeyWord='+dataSearch[i][0]+'&PTAG=40.1.1"><span>'+dataSearch[i][0]+'</span>');if(dataSearch[i][1]!=0){arrAuto.push('<em>约'+dataSearch[i][1]+'结果</em>');};arrAuto.push('</a></li>');};arrAuto.push('</ul>');$id("showAutoResult").innerHTML=arrAuto.join('');$display("showAutoResult,maskAuto",'block');nowLink=-1;preLink=0;keyNumber=len;$id("KeyWord").onkeydown=function(e){e=e?e:window.event;var keyCode=window.event?e.keyCode:e.which;showKeyDown(keyCode,dataSearch);}};$loadScript("http://search.paipai.com/cgi-bin/isuggest_v3?KeyWord="+theValue);}};function hideResult(){$displayHide("showAutoResult,maskAuto");};};PP.head_paipai.showMenu=function(){var href=window.location.href.replace("http://",""),menu=href.split("/")[1],host=href.split(".")[0],menu=!$id(menu+"Menu")?(("www"==host)?'home':host):menu,oMenu=$id(menu+"Menu");oMenu?$addClass(oMenu,'now'):'';$id("navBar")?$addClass($id("navBar"),menu+"_skin"):'';};PP.head_paipai.init();function $id(id){return document.getElementById(id)};function $namespace(str){var arr=str.split(',');for(var i=0;i<arr.length;i++){arr[i]=arr[i].split(".");str="";var strEval="";for(var j=0;j<arr[i].length;j++){if(j!=0){str+="."};str+=arr[i][j];strEval+="if (typeof("+str+") == 'undefined'){"+str+" = {}};";};if(strEval!=""){eval(strEval)};}};function $loadScript(url,id,obj){setTimeout(function(){var s=document.createElement("script"),charset="gb2312";var o=obj||{};id+=(new Date).getTime();if(o.charset){charset=o.charset};s.charset=charset;s.id=id;document.getElementsByTagName("head")[0].appendChild(s);s.src=url;return s;},0);};function $display(ids,state){var state=state||'';if(typeof(ids)=="string"){var arr=ids.split(',');for(var i=0,len=arr.length;i<len;i++){var o=$id(arr[i]);o?o.style.display=state:'';}}else{ids.style.display=state}};function $displayHide(ids){$display(ids,'none');};function $strTrim(str,code){var argus=code||"\\s";var temp=new RegExp("(^"+argus+"*)|("+argus+"*$)","g");return str.replace(temp,"");}
function $addEvent(obj,type,handle){if(window.addEventListener){obj.addEventListener(type,handle,false);}else if(window.attachEvent){obj.attachEvent("on"+type,handle);}else{obj["on"+type]=handle;}};function $displayShow(ids){$display(ids,'');};function $addClass(ids,cName){$setClass(ids,cName,"add");};function $getCookie(name){var reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)"),val=document.cookie.match(reg);return val?unescape(val[2]):null;};})();