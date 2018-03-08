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
  <style>
    .ood{
      width: 400px;
    }
  </style>
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
          <table class="table table-hover" >
            <tr>
              <th>学号</th>
              <th>上传人</th>
              <th>上传时间</th>
              <th>描述</th>
              <th>操作</th>
            </tr>

            <c:forEach var="p" items="${docs.list}">
              <tr>
                <td>${user.sno}</td>
                <td ><a href="${p.path}">${p.publisher.username}</a></td>
                <td><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/> </td>
                <td >${p.description}</td>
                <td><a href="${path}/front/document/index.do" class="btn btn-danger"  >重交</a></td>
              </tr>
            </c:forEach>

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


