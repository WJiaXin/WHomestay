var ltop=$('#list').offset().top;

$(window).scroll(function(){
    if(ltop<$(document).scrollTop()){
        $('#list').addClass("list");
    }else{
        $('#list').removeClass("list");
    }

});
$("#shangchuan").click(function () {
    $("#file").click();
})
function pimg(id,img){
    var formData = new FormData();
    formData.append("file",$('#'+id+'')[0].files[0]);
    $.ajax({
        type: 'post',
        url:"/img/pimg",
        data: formData,
        cache: false,
        processData: false,
        contentType: false,
        success: function (data) {
            $("#img").attr('src',"../img/space/"+data);
        },
        error: function (XMLHttpRequest, textStatus, error) {
            alert('照片名含有非法字符，请重新上传！');
        }
    });
};
$('#cordZ').click(function () {
    $('#cordZ').attr('src',"/user/createImg?time="+ new Date().getTime());
})