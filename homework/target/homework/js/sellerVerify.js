$(document).ready(function(){


    $("#login-button").click(function(){
        //获取用户输入信息
        var nickName=$("#nickname").val();
        var password=$("#password").val();
        if(nickName==""|password==""){
            //alert("用户名或密码不能为空！");
            $("#loginMessageBox").html("用户名或密码不能为空！");
            return false;
        }else{
            $.ajax({
                type:'POST',
                url:'http://localhost:8080/homework/sellerLoginValidation.action',
                data: "nickname="+nickName+"&password="+password,
                success:function(data){
                    if(data.nickname==null){
                        //alert("您输入的用户名或密码有错！");
                        $("#loginMessageBox").html("您输入的用户名或密码有错！");
                        return false;
                    }
                    else{
                        //进入主页面
                        window.location.href = "http://localhost:8080/homework/sellerManage.action?pageNow=1";
                    }
                }
            });
        }

    });


    //
    $("#register").click(function(){
        var username_register=$("#username_register").val();
        var password_register=$("#password_register").val();
        var password_register_again=$("#password_register_again").val();
        if(username_register==""|| password_register==""|| password_register_again==""){

            $("#registerMessageBox").html("请填入完整注册信息！");
        }else if(password_register==password_register_again){
            //alert("enter。。。");
            $.ajax({
                type:'POST',
                url:'http://localhost:8080/homework/sellerRegister.action',
                data: "nickname="+username_register+"&password="+password_register,
                success:function(data){
                    //给出注册结果提示
                    $("#registerMessageBox").html(data.register_prompt_info);
                }
            });


        }else{
            $("#registerMessageBox").html("两次输入密码不一致！");
        }

    });
});

