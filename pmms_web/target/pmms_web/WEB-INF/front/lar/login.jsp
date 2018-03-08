<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>党员管理系统 |登录 </title>

    <!-- Bootstrap -->
    <link href="${path }/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${path }/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${path }/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="${path }/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${path }/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="${path }/login/login.do" method="post">
              <h1>登 录</h1>
              <div>
                <input type="text" name="sno" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="password" name="password"class="form-control" placeholder="Password" required="" />
              </div>
              <div>
                <input class="btn btn-default submit" type="submit" value="登录">
                <a class="reset_pass" href="#">忘记密码？</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> 四川农业大学</h1>
                  <p>©2017 DUG Studio工作室. 四川农业大学</p>
                </div>
              </div>
            </form>
          </section>
        </div>  
      </div>
    </div>
  </body>
</html>



