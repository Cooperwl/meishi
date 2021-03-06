<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">
    <link href="css/charisma-app.css" rel="stylesheet">

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <%--<link rel="shortcut icon" href="img/favicon.ico">--%>

    <script src="easyui/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>

</head>

<body>
    <div class="ch-container">
        <div class="row">

            <div class="row">
                <div class="col-md-12 center login-header">
                    <h1>后台管理系统</h1>
                </div>
                <!--/span-->
            </div><!--/row-->

            <div class="row">
                <div class="well col-md-5 center login-box">
                    <div class="blb-message">
                        <%--<div class="alert alert-info">--%>

                        <%--</div>--%>
                    </div>
                    <form id="loginForm" class="form-horizontal">
                        <fieldset>
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                                <input type="text" class="form-control" placeholder="请输入用户名" id="username">
                            </div>
                            <div class="clearfix"></div>
                            <br>

                            <div class="input-group input-group-lg">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                                <input type="password" class="form-control" placeholder="请输入密码" id="password">
                            </div>
                            <div class="clearfix"></div>

                            <div class="login-box pull-left">
                                <label class="remember" for="remember"><input type="checkbox" id="remember"> 记住我</label>
                            </div>
                            <div class="clearfix"></div>

                            <p class="center col-md-5">
                                <button class="btn btn-primary" id="login_btn">Login</button>
                            </p>
                        </fieldset>
                    </form>
                </div>
                <!--/span-->
            </div><!--/row-->
        </div><!--/fluid-row-->

    </div><!--/.fluid-container-->

    <!-- external javascript -->

<script type="text/javascript">

//    action="authority/check" method="post"
    $(function(){
        var oErrorbox = $('.blb-message');
        oErrorbox.hide();

        var oName = $('#username');
        var oPassword = $('#password');

        //表单提交
        $('#login_btn').click( function(e) {
            e.preventDefault();
            oErrorbox.hide();
            var bErrorStatus = true;
            var sErrorInfo = '';

            if ($.trim(oName.val()) === '' || $.trim(oPassword.val()) === '') {
                sErrorInfo = '请填写用户名和密码。';
                bErrorStatus = false;
                oErrorbox.show();
                oErrorbox.html('<div class="alert alert-info">'+sErrorInfo+'</div>');
            }

            if (bErrorStatus) {
                $.post('login/check', {
                    username : oName.val(),
                    password : oPassword.val()
                }, function(res) {
                    if (res.success) {
                        location.href = res.data.forwardUrl;
                    } else {
                        oErrorbox.show();
                        oErrorbox.html('<div class="alert alert-info">'+res.errors[0]+'</div>');
                    }
                });
            }
        });
    });
</script>

</body>
</html>
