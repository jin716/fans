var str = "";
document.writeln("<div id=\"_contents\" style=\"z-index:2;padding:6px; background-color:#E3E3E3; font-size: 12px; border: 1px solid #777777; position:absolute; left:?px; top:?px; width:?px; height:?px; z-index:1; visibility:hidden\">");
str += "\u65f6<select id=\"_hour\">";
for (h = 0; h <= 9; h++) {
    str += "<option value=\"0" + h + "\">0" + h + "</option>";
}
for (h = 10; h <= 23; h++) {
    str += "<option value=\"" + h + "\">" + h + "</option>";
}
str += "</select> \u5206<select id=\"_minute\">";
for (m = 0; m <= 9; m++) {
    str += "<option value=\"0" + m + "\">0" + m + "</option>";
}
for (m = 10; m <= 59; m++) {
    str += "<option value=\"" + m + "\">" + m + "</option>";
}
str += "</select> \u79d2<select id=\"_second\">";
for (s = 0; s <= 9; s++) {
    str += "<option value=\"0" + s + "\">0" + s + "</option>";
}
for (s = 10; s <= 59; s++) {
    str += "<option value=\"" + s + "\">" + s + "</option>";
}
str += "</select> <input name=\"queding\" type=\"button\" onclick=\"_select()\" value=\"\u786e\u5b9a\" style=\"font-size:12px\" /></div>";
document.writeln(str);
var _fieldname;
function _SetTime(tt) {
    _fieldname = tt;
    var ttop = tt.offsetTop;    
    var thei = tt.clientHeight;   
    var tleft = tt.offsetLeft;   
    while (tt = tt.offsetParent) {
        ttop += tt.offsetTop;
        tleft += tt.offsetLeft;
    }
    document.getElementById("_contents").style.top = ttop + thei + 4;
    document.getElementById("_contents").style.left = tleft;
    document.getElementById("_contents").style.visibility = "visible";
}
function _select() {
    _fieldname.value = document.getElementById("_hour").value + ":" + document.getElementById("_minute").value + ":" + document.getElementById("_second").value;
    document.getElementById("_contents").style.visibility = "hidden";
}
