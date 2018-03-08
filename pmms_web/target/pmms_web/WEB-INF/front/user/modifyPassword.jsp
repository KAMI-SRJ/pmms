<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>党员管理系统</title>
  <link href="${path}/css/bootstrap/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${path}/css/style.css">
  <link rel="stylesheet" href="${path}/css/user.css">

</head>
<body class="body">
<div class="boom">
  <div class="row" >
    <div class="col-md-12 col-sm-12 col-xs-12" >
      <div class="item">
        <img src="${path}/images/2.jpg" alt=背景图 style="width: 100%;height: 140px;">
        <div class="carousel-caption ">
          <h1 class="h1">党员管理系统</h1>
        </div>
      </div>
    </div>
  </div>



  <nav  class="navbar1">
    <div class="collapse navbar-collapse" >
      <ul class="nav ">
        <li >个人中心</li>
      </ul>
    </div>
  </nav>


  <div class="navbar navbar-duomi navbar-static-top" role="navigation">
    <div class="container-fluid">
      <div class="row">
       <%@include file="../common/sidebar.jsp"%>
        <div class="col-md-9">
          <p class="h2">
            密码修改
          </p>
          <form class="form-horizontal" method="post" action="${path}/front/user/modifyPassword.do">
            <div class="form-group">
              <label for="" class="col-sm-3 control-label">初始密码</label>
              <div class="col-sm-5">
                <input type="text" class="form-control" name="prePsw"  placeholder="初始密码">
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-3 control-label">修改密码</label>
              <div class="col-sm-5">
                <input type="password" class="form-control" name="newPsw" id="inputPassword3" placeholder="新密码">
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-3 control-label">再次输入</label>
              <div class="col-sm-5">
                <input type="password" class="form-control" id="inputPassword3" placeholder="再次确认">
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-offset-4 col-sm-8">
                <button type="submit" class="btn btn-default" style="margin-top: 15px;margin-left: 25px;">确认修改</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>


</div>
</body>
<script src="${path}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${path}/js/bootstrap.min.js"></script>
</html>


