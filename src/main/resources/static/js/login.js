$(function (){
    login.app.btn_1();
});

var login = {};

login.app = {};

login.app.btn_1 = function (){
    var reg = /^1[0-9]{10}$/;

    $('.div_3 .btn_z').on('touchstart', function (){
        var val = $('.div_1 .tel').val();
        console.log(val);
        var pass = $('.div_2 .pass_1').val();
        console.log(pass);
        if(reg.test(val)){
            $.ajax({
                url:"http://www.baidu.com",
                type:'POST',
                data:{
                    'phone':val,
                    'password':pass
                },
                dataType:'json',
                success:function (d){

                },
                error:function (d){

                }
            });
        }
    });
};