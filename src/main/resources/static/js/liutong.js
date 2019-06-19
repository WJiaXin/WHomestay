var formData = new FormData();
formData.append("inputPhone","liutong");
$.ajax({
    type: 'post',        //数据提交的方式
    url: "/user/getInFo",//数据提交的路径
    data: formData,
    cache: false,
    processData: false,
    contentType: false,
    success: function (data) {
        document.getElementById("user_name").innerHTML = data.user_name;
        document.getElementById("user_phone").innerHTML = data.user_id;
        document.getElementById("user_name1").innerHTML = data.user_name;
        document.getElementById("user_IDcard").innerHTML = data.user_IDcard;
        document.getElementById("user_sex").innerHTML = data.user_sex;
        document.getElementById("user_address").innerHTML = data.user_address;
        $('#user_namepicture').html("<img src=\"../img/user/"+data.user_id+"/"+data.user_picture+"\"height=\"35px\"  width=\"35px\" style=\"border-radius:20px;\"/>"+data.user_name);
        $('#user_picture').html("<img src=\"../img/user/"+data.user_id+"/"+data.user_picture+"\" height=\"50px\"  width=\"50px\" class=\"rounded-circle\" id=\"img\"/>");
        $('#myModal').modal('hide');
    },
    // }
    error: function (XMLHttpRequest, textStatus, error) {
        alert("错误！");

    }
})