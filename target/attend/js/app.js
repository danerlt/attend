/**
 * Created by tao on 2017/4/5 0005.
 */
function getCookie(Name) {
    var search = Name + "="//查询检索的值
    var returnvalue = "";//返回值
    if (document.cookie.length > 0) {
        sd = document.cookie.indexOf(search);
        if (sd!= -1) {
            sd += search.length;
            end = document.cookie.indexOf(";", sd);
            if (end == -1)
                end = document.cookie.length;
            //unescape() 函数可对通过 escape() 编码的字符串进行解码。
            returnvalue=unescape(document.cookie.substring(sd, end))
        }
    }
    return returnvalue;
}
    function findLog(uid) {
        $.ajax({
                type:"POST",
                url:"/attend/findlog",
                dataType:"json",
                data:{
                    uid:getCookie("Id")
                },
                success:function (data) {
                    var d = data;
                    console.log(d[0]);
                    $('#table').bootstrapTable({
                        data: data
                    })
                }
            }
        );
    }


$('#datetimepicker').datetimepicker({
    format: 'MM/dd/yyyy',
    language: 'en',
    pickDate: true,
    pickTime: true,
    hourStep: 1,
    minuteStep: 15,
    secondStep: 30,
    inputMask: true
});
