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
        <div class="col-md-10">
          <table border="1">

            <tr>
              <td colspan="4" class="title">基本信息</td>
            </tr>
            <tr>
              <td >姓名</td>
              <td >${user.username}</td>
              <td >性别</td>
              <td >${user.gender}</td>
            </tr>
            <tr>
              <td >民族</td>
              <td>${user.nation}</td>
              <td >政治面貌</td>
              <td >${user.role.name}</td>
            </tr>
            <tr>
              <td >户籍</td>
              <td >${user.addrress}</td>
              <td >出生年月</td>
              <td >${user.birthday}</td>
            </tr>
            <tr>
              <td >身份证号</td>
              <td colspan="3">${user.id}</td>
            </tr>
            <tr>
              <td >学位</td>
              <td >学士</td>
              <td >学历</td>
              <td >本科</td>
            </tr>
            <tr>
              <td >工作单位</td>
              <td colspan="3"></td>
            </tr>
            <tr>
              <td >联系方式</td>
              <td colspan="3">${user.phone}</td>
            </tr>
            <tr>
              <td >地址</td>
              <td colspan="3">四川农业大学</td>
            </tr>
          </table>
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



