/*
 * search detector
 * monitor.js
 * @author yunqian@taobao.com
 */
(function(){if(document.domain.indexOf("go.taobao.com")>-1){return}var b="http://www.atpanel.com/jsclick",g={"\u5b9d\u8d1d":"item","\u5e97\u94fa":"shop","\u5546\u57ce":"b2citem","\u62cd\u5356":"bid","\u5168\u7403\u8d2d":"global","\u6253\u542c":"dating","\u5e16\u5b50":"forum","\u8d44\u8baf":"info","\u5168\u7ad9":"yahoo","\u641c\u7d22\u5b9d\u8d1d":"item","\u641c\u7d22\u5e97\u94fa":"shop","\u641c\u7d22\u638c\u67dc":"seller","\u8d27\u5230\u4ed8\u6b3e":"cod","\u5168\u90e8":"favorite"},l=["cat","catId","c1","path"],f=["search_type"],k=false;var c=function(o){return typeof o==="string"?document.getElementById(o):o};var d=function(o){return o.replace(/^\s+|\s+$/g,"")};var i=function(p){return Object.prototype.toString.call(p)==="[object Array]"};var a=function(p){return Object.prototype.toString.call(p)==="[object Function]"};var h=function(p,o){p=c(p);if(!p||!o||!p.className){return false}return p.className.indexOf(o)>-1};var n=function(p,t,o){var q=[],s=c(o).getElementsByTagName(t),r=0;for(;r<s.length;r++){if(h(s[r],p)){q[q.length]=s[r]}}return q};var e=function(p,o,q){if(window.attachEvent){p.attachEvent("on"+o,function(){q.call(p)})}else{p.addEventListener(o,q,false)}};var m=function(o){return(Math.random()+"").substring(2,2+o)};var j=function(o,p){if(!(this instanceof arguments.callee)){return new arguments.callee(o,p)}this.container=c(o);this.textField=this.container.q||this.container.keyword||this.container.p||this.container.searchWord;this.config=p;this._init()};j.prototype={_init:function(){var o=this;try{e(this.container,"submit",function(){if(!k){o._sendData();k=true}})}catch(p){}},_sendData:function(){var s=this.container,u=this.textField.value,r="",o=this.config.loc||"",q=(this.config.cont&&typeof this.config.cont==="string")?this.config.cont:"",p;if(!r){for(p=0;p<l.length;p++){if(s[l[p]]){r=s[l[p]].value;break}}}if(!q){for(p=0;p<f.length;p++){var t=s[f[p]];if(t&&t.nodeName==="SELECT"){q=g[d(t.options[t.selectedIndex].innerHTML)];break}}}if(!q&&this.config.cont&&a(this.config.cont)){q=this.config.cont(s)}new Image().src=[b,"?class=","zhudong","&squery=",u,"&scategory=",r,"&slocation=",o,"&scontent=",q,"&cache=",m(7)].join("")}};(function(){var o=document.forms,s=location.href,p,r="unavailable",q=[{el:function(){if(o.search){if(s==="http://www.taobao.com/"||s==="http://test.ued.taobao.net/index_inc/2010/index.php"){this.loc="3";this.cont=function(){if(c("J_SiteSearchTab")){var t=n("selected","li","J_SiteSearchTab")[0];if(t&&t.getElementsByTagName("a")[0]){var u=t.getElementsByTagName("a")[0].innerHTML.replace(/<\/?strong>/g,"");return g[d(u).replace(/<\/?[^>]+>/g,"")]}}}}else{if(s==="http://list.taobao.com/browse/cat-0.htm"){this.loc="4"}else{if(s.indexOf("list.taobao")>-1||s.indexOf("search1.taobao")>-1){this.loc="5"}else{if(s.indexOf("shopsearch.taobao")>-1){this.loc="6"}else{if(s.indexOf("item.taobao")>-1){this.loc="7"}else{if(s.indexOf("search8.taobao")>-1){this.loc="10";this.cont="S8item"}else{this.loc="1"}}}}}}return o.search}else{return null}}},{el:function(){if(s.indexOf("search8.taobao.com")>-1){if(c("searchFormTop")){var u=n("btn_search","input","searchFormTop")[0],t=function(){var w=c("keyword_q").value,v=c("searchFormTop")["cat"]?c("searchFormTop")["cat"].value:"";new Image().src=[b,"?class=","zhudong","&squery=",w,"&scategory=",v,"&slocation=","10","&scontent=","item","&cache=",m(7)].join("")};if(u){e(u,"click",t)}return c("searchFormTop")}else{return null}}else{return r}},loc:"10",cont:"S8item"},{el:function(){return c("QuickSearch")&&c("QuickSearch").getElementsByTagName("form")[0]},loc:"2"},{el:function(){if(!c("bd")||!c("ft")&&!c("searchBottom")){return null}var v=c("bd").getElementsByTagName("form"),t=[];for(var u=0;u<v.length;u++){if(v[u].parentNode.className.indexOf("search-form")>-1){t.push(v[u])}}if(t.length>0){if(c("searchbar")){this.loc="23";this.cont="b2cinshop"}else{this.loc="8";this.cont="inshop"}}else{t=null}return t}},{el:function(){return o.SearchForm},loc:"8",cont:"inshop"},{el:function(){return c("J_searchForm")},loc:"9",cont:"S0item"},{el:function(){if(s.indexOf("http://search1.taobao.com/browse/ad_search")>-1){var t=n("Selected","li","Content")[0];if(t&&t.getElementsByTagName("a")[0]){this.cont=g[d(t.getElementsByTagName("a")[0].innerHTML.replace("\u641c\u7d22",""))]}return o.mainform||o.mainform1}else{return r}},loc:"11"},{el:function(){if(!c("MainContainer")){return null}return n("re-search","form","MainContainer")[0]},loc:"12",cont:"item"},{el:function(){if(s.indexOf("http://shouji.taobao.com")>-1){return[c("keyword-search"),c("bottomQS")]}else{return r}},loc:"13",cont:"item"},{el:function(){return o["tms-search"]},loc:"14",cont:"item"},{el:function(){if(/search_shop\.htm/.test(s)||/\/shop\//.test(s)){this.loc="21"}else{if(/search_product\.htm/.test(s)||/\.mall\.taobao\.com\/\d+\//.test(s)){this.loc="17"}else{if(/http:\/\/mall\.taobao\.com\//.test(s)){this.loc="15"}else{if(/item\.taobao\.com/.test(s)){this.loc="19"}else{this.loc="16"}}}}this.cont=function(t){if(t.type){return{p:"b2citem",s:"b2cshop"}[t.type.value]}};return o.searchTop}},{el:function(){if(/search_shop\.htm/.test(s)||/\/shop\//.test(s)){this.loc="22"}else{if(/search_product\.htm/.test(s)||/\.mall\.taobao\.com\/\d+\//.test(s)){this.loc="18"}else{this.loc="20"}}return o.searchBottom},cont:"b2citem"},{el:function(){if(s.indexOf("http://dating.taobao.com")>-1){return c("search-here")}else{return r}},loc:"24",cont:"dating"},{el:function(){if(s.indexOf("http://site.taobao.com")>-1){if(c("content")){var v=c("content").getElementsByTagName("form"),u=[c("search-here")];for(var t=0;t<v.length;t++){if(v[t].action==="http://site.taobao.com/spu_search.htm"){u.push(v[t])}}return u}else{return null}}else{return r}},loc:"25",cont:"site"},{el:function(){if(s.indexOf("http://bangpai.taobao.com")>-1){return o.g_search_form}else{return r}},loc:"26",cont:"forum"},{el:function(){if(s.indexOf("http://www.taobao.com/forum.php")>-1){return c("search-here")}else{return r}},loc:"27",cont:"forum"},{el:function(){if(s.indexOf("http://forum.taobao.com")>-1){return o.mainform1}else{return r}},loc:"28",cont:"title"},{el:function(){if(c("FavoritesScrech")){this.cont=function(){if(c("FavorListMenu")){var t=n("Selected","li","FavorListMenu")[0];if(t&&t.getElementsByTagName("a")[0]){return g[d(t.getElementsByTagName("a")[0].innerHTML)]}return""}};return c("FavoritesScrech").getElementsByTagName("form")[0]}else{return null}},loc:"29"},{el:function(){if(s.indexOf("http://favorite.taobao.com/collect_item_relation")>-1){return o.mainform1}else{return r}},loc:"30",cont:"forum"},{el:function(){if(s.indexOf("http://favorite.taobao.com/collect_channel")>-1){this.cont=function(u){if(u.type){var t=u.type;for(p=0;p<t.length;p++){if(t[p].checked){return{treasure:"item",shop:"shop",blog:"space"}[t[p].value]}}}};return o.favform}else{return r}},loc:"31"},{el:function(){if(s.indexOf("info.taobao.com")>-1){if(c("infosearch")){var u=c("infosearch").getElementsByTagName("button"),t=function(v){var w=c("str").value;new Image().src=[b,"?class=","zhudong","&squery=",w,"&slocation=","32","&scontent=",v,"&cache=",m(7)].join("")};for(p=0;p<u.length;p++){(function(){var v=p;e(u[v],"click",function(){t(["info","item"][v])})})()}return 1}else{return null}}else{return r}},loc:"32"},{el:function(){if(!c("ark:noResultProductList")){return null}return c("ark:noResultProductList").parentNode.getElementsByTagName("form")[0]},loc:"33",cont:"b2citem"},{el:function(){if(s.indexOf("shopsearch.taobao.com")>-1){return o.researchForm}else{return null}},loc:"34",cont:"shop"}];for(p=0;p<q.length;p++){(function(){var u=q[p],v,w=0;setTimeout(function(){w++;v=u.el();if(v===r){return}if(!v){if(w>8){return}setTimeout(arguments.callee,1000)}else{if(u.loc==="32"){return}if(!i(v)){v=[v]}for(var t=0;t<v.length;t++){if(v[t]){new j(v[t],{loc:u.loc,cont:u.cont})}}}},200)})()}})()})();
