var ltop=$('#list').offset().top;

$(window).scroll(function(){
    if(ltop<$(document).scrollTop()){
        $('#list').addClass("list");
    }else{
        $('#list').removeClass("list");
    }

});
function getInFo() {
    var formData = new FormData();
    formData.append("inputPhone", $('#inputPhone').val());
    formData.append("inputPassword", $('#inputPassword').val());
    formData.append("inputCord1", $('#inputCord1').val());
    $.ajax({
        type: 'post',        //数据提交的方式
        url: "/user/getInFo",//数据提交的路径
        data: formData,
        cache: false,
        processData: false,
        contentType: false,
        success: function (data) {
            var json = eval('(' + data + ')');
            $('#ziliao .dropdown-toggle').html("<img src=\"../img/user/"+json.user_id+"/"+json.user_picture+"\" height=\"35px\"  width=\"35px\" style=\"border-radius:20px;\"/> "+json.user_name);
            $('#myModal').modal('hide');
        },
        // }
        error: function (XMLHttpRequest, textStatus, error) {
            alert("数据错误！");
        }
    })
}