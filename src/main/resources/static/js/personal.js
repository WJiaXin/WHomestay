var ltop=$('#list').offset().top;

$(window).scroll(function(){
    if(ltop<$(document).scrollTop()){
        $('#list').addClass("list");
    }else{
        $('#list').removeClass("list");
    }

});