
$('.ui.styled.accordion')
    .accordion({
        selector: {
            trigger: '.title .icon'
        }
    });


$("#registerButton").click(function () {
    var password1=$('#password1').val();
    var password2=$('#password2').val();
    if(password1 == ""){
        alert("密码不能为空！")
        return false;
    }
    if (password1 == password2){
        console.log("相等")
        return true;
    } else {
        alert("两次输入密码不一致！");
        console.log("不相等")
        return false;
    }
});