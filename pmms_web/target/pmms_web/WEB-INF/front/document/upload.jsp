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
    <form action="${path}/front/upload/save.do?id=${user.id}" method="post" enctype="multipart/form-data">
        <div class="col-md-10">
            <div class="x_panel">
                <div class="x_title">
                    <h2>文件上传</h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>

                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <select name="type">
                    <option >心得体会</option>
                    <option >思想汇报</option>
                    <option >学习资料</option>
                </select>
                简单描述：<input name="description" id="" cols="30" rows="10"></input>
                <input type="file" name="file" value="上传文件"  >
                <input type="submit" value="上传">
            </div>
        </div>
    </form>
</div>
        </div>
    </div>
</div>
</body></html>