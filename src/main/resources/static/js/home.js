$(function () {

    'use strict';


    var $citypicker1 = $('#city-picker1');

    $citypicker1.citypicker();

    var $citypicker2 = $('#city-picker2');

    $citypicker2.citypicker({
        province: '江苏省',
        city: '常州市',
        district: '溧阳市'
    });

    var $citypicker3 = $('#city-picker3');

    $('#reset').click(function () {
        $citypicker3.citypicker('reset');
    });

    $('#destroy').click(function () {
        $citypicker3.citypicker('destroy');
    });
    //
    //$('#distpicker1').distpicker();
    //
    //$('#distpicker2').distpicker({
    //  province: '---- 所在省 ----',
    //  city: '---- 所在市 ----',
    //  district: '---- 所在区 ----'
    //});
    //
    //$('#distpicker3').distpicker({
    //  province: '浙江省',
    //  city: '杭州市',
    //  district: '西湖区'
    //});
    //
    //$('#distpicker4').distpicker({
    //  placeholder: false
    //});
    //
    //$('#distpicker5').distpicker({
    //  autoSelect: false
    //});

});
function init() {
    //定义locale汉化插件
    var locale = {
        "format": 'YYYY-MM-DD',
        "separator": " 至 ",
        "applyLabel": "确定",
        "cancelLabel": "取消",
        "fromLabel": "起始时间",
        "toLabel": "结束时间'",
        "weekLabel": "W",
        "daysOfWeek": ["日", "一", "二", "三", "四", "五", "六"],
        "monthNames": ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        "firstDay": 1
    };
    //日期控件初始化
    $('#daterange').daterangepicker(
        {
            'locale': locale,
            startDate: moment().subtract(29, 'days'),
            endDate: moment(),
            autoUpdateInput: false
        },
        function (start, end) {
            $('#daterangeC').val(start.format('YYYY-MM-DD') + ' 至 ' + end.format('YYYY-MM-DD'));
        }
    );
};
$(document).ready(function() {
    init();
});
$('#cord').click(function () {                  //验证码更换
    $('#cord').attr('src', "/user/createImg?time=" + new Date().getTime());
})
$('#cordZ').click(function () {
    $('#cordZ').attr('src',"/user/createImg?time="+ new Date().getTime());
})
$(function () {

    $.ajax({
        type: 'post',
        url:"/homestay/home",
        cache: false,
        processData: false,
        contentType: false,
        success: function (data) {
            for(i in data){
                var str="";
                str+=" <div class=\"col-md-3\">\n" +
                    "                 <div class=\"thumbnail\">\n" +
                    "           <img class=\"img-responsive\" src=\"../img/space/"+$.parseJSON(data[i].picture).封面+"\" />\n" +
                    "            <div class=\"caption\"><h5>"+data[i].h_name+"</h5>";
                for(j in data[i].roomType){
                    if(data[i].roomType[j]==0){str+=" <span class=\"label label-default mr-2\">单间</span>";}
                    else{str+="<span class=\"label label-default mr-2\">整套</span>";}
                }
                str+=" <h6>"+$.parseJSON(data[i].h_address).addressName+"</h6>\n" +
                    "                             <h4 style=\"color:#F00;\">￥"+data[i].price+"起</h4></div></div></div>";

                $('#content').append(str);

            }
        },
        error: function (XMLHttpRequest, textStatus, error) {
            alert(error);
        }
    })
})