<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>党员管理系统</title>
    <link href="${path}/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/css/style.css">
    <link rel="stylesheet" href="${path}/css/topic.css">
    <link rel="stylesheet" href="${path}/css/notice.css">
    <style>
        .line{
            height: 15px;
            width: 1px;
            margin-left: 5px;
            margin-right: 5px;
        }
        .img{
            width: 420px;
            height: 240px;
            margin-left: 35px;
            margin-bottom: 10px;
        }
        .pt{
            text-indent: 25px;
            line-height: 1.5em;
            padding: 25px 5px;
            font-size: 16px;
            font-family: Arial,Helvetica,sans-serif;

        }
    </style>
</head>
<body >

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12" >
        <div class="item">
            <img src="${path}/images/2.jpg" alt=背景图 style="width: 100%;height: 140px;">
            <div class="carousel-caption ">
                <h1 class="h1">党员管理系统</h1>
            </div>
        </div>
    </div>
</div>


<nav class="navbar navbar-default" class="nav">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand " href="${path}/" >首页</a>
        </div>


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
            <ul class="nav navbar-nav" >

                <li class="style "><a href="${path}/front/article/articleAllByPage.do">新闻 <span class="sr-only">(current)</span></a></li>
                <li class="style "><a href="${path}/front/announcement/all.do">公告</a></li>
                <li class="style "><a href="${path}/front/BBS/getAllTopic.do">话题讨论</a></li>
                <li class="style "><a href="${path}/front/document/documentAllPage.do">资料下载</a></li>
                <li class="style "><a href="${path}/front/aboutUs.do">关于我们</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<ol class="breadcrumb">
    <li><a href="${path}/front/user/index.do">首页</a></li>
    <li><a href="${path}/front/BBS/getAllTopic.do">话题讨论</a></li>
    <li class="active">详情</li>
</ol>


<div class="row">
    <div class="col-md-8" style="padding-left:2%; ">
        <div>
            <span >${comment.publisher.username}</span>
            <span class="line">  |  </span>
            <span ><fmt:formatDate value="${comment.createDate}" pattern="yyyy-MM-dd"/></span>
            <span class="line">  |  </span>
            <span><a href="${path}/front/BBS/commentClickGood.do?id=${comment.id}">赞</a>&nbsp;&nbsp;(${comment.goods.size()})</span>
            <c:if test="${comment.publisher.id eq user.id}" >
                <span class="line">  |  </span>
                <span><a href="${path}/front/BBS/deleteComment.do?id=${comment.id}">删除</a>&nbsp;&nbsp;</span>
            </c:if>
        </div>
        <hr>
        <div >
            <p class="pt">${comment.content}</p>
        </div>
        <div>
            <a href="${path}/front/BBS/addChildComment.do?parentCommentId=${comment.id}">
                评论(${comment.sets.size()})
            </a>
        </div>

        <c:forEach items="${comment.sets}" var="c">
            <hr>
        <div>
            <span>${c.publisher.username}</span>
            <c:if test="${c.publisher.id eq user.id}" >
                <span><a href="${path}/front/BBS/deleteChildComment.do?id=${c.id}&parenId=${comment.id}">删除</a></span>
            </c:if>
            <span class="pull-right"><fmt:formatDate value="${c.createDate}" pattern="yyyy-MM-dd"/></span>
            <p class="pt">${c.content}</p>
            <c:if test="${c.topic.publisher.id eq user.id}" >
            <span><a href="${path}/front/BBS/addChildComment.do?parentCommentId=${c.id}">回复</a>(${c.sets.size()})</span>
            </c:if>
            <span><a href="${path}/front/BBS/commentClickGood.do?id=${c.id}">赞</a>(${c.goods.size()})</span>
        </div>
        </c:forEach>

    </div>


    <div class="col-md-4">
        <div class="con">
            <a href="${path}/front/BBS/addOrUpdate.do?type=add" class="btn btn-lg btn-danger"><span class="glyphicon glyphicon-plus" aria-hidden="true">我要发表</span></a>
        </div>

        <div class="hot-question">
            <h3>热门问答</h3>
            <ul class="hot-question-list">
                <c:forEach items="${topicPage.list}" var="p">
                    <li><a class="list-group-item hhs hids" href="${path}/front/BBS/getTopicDetail.do?id=${p.id}">${p.title}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div style="margin-top: 10px;background-color: #eee">
    <footer id="footer" class="animate-onscroll" >
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-sm-4 col-xs-4">
                    <h4><i class="iconfont icon-xuexiaoguanli"></i> 雅安校区</h4>
                    <address>雅安市雨城区新康路46号 邮编:625014</address>
                    <address>电话:0835-2882232 传真:0835-2883153</address>
                </div>
                <div class="col-lg-4 col-sm-4 col-xs-4">
                    <h4><i class="iconfont icon-xuexiaoguanli"></i> 成都校区</h4>
                    <address>成都市温江区惠民路211号 邮编:611130</address>
                    <address>电话:028-86290111 传真:028-82652669</address>
                </div>
                <div class="col-lg-4 col-sm-4 col-xs-4">
                    <h4><i class="iconfont icon-xuexiaoguanli"></i> 都江堰校区</h4>
                    <address>都江堰市建设路288号 邮编:611830</address>
                    <address>电话:028-87133509 传真:028-87133366</address>
                </div>
            </div>
        </div>
    </footer>

    <br>

    <div class="text-center">
        <div class="row">
            <div class="col-lg-12">
                <p style="color: #9F9F9F">Copyright © 2017 四川农业大学-党员. SICAU - PMMS.  All Rights Reserved.</p>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${path}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${path}/js/bootstrap.min.js"></script>
</html>