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
    <link rel="stylesheet" href="${path}/css/detail.css">
</head>
<body style="overflow-x: hidden;background-color:#e3dec1;padding:0  7%;">

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
<div class="row" >
    <div class="col-md-5 col-sm-6 col-xs-12">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox" style="height: 247px;">
                <div class="item active">
                    <img src="${path}/images/01.jpg" alt="...">
                    <div class="carousel-caption">

                    </div>
                </div>
                <div class="item">
                    <img src="${path}/images/02.jpg" alt="...">
                    <div class="carousel-caption">

                    </div>
                </div>
                <div class="item">
                    <img src="${path}/images/03.jpg" alt="...">
                    <div class="carousel-caption">

                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <div class="col-md-4 col-sm-6 col-xs-12">
        <div class="list-group">
			  <span class="list-group-item  list-group-item-warning ">
			    通知公告<a href="${path}/front/announcement/all.do" style="float: right;">浏览更多</a>
			  </span>
            <c:forEach var="p" items="${announcementpage.list}" >
                <a href="${path}/front/announcement/details.do?id=${p.id}" class="list-group-item">${p.title}<span class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></span></a>
            </c:forEach>
        </div>
    </div>

    <div class="col-md-3 col-sm-12 col-xs-12" >
        <form class="form-horizontal" style="margin-top: 35px;" method="post" action="${path}/login/login.do">
            <div class="form-group">
                <label  class="col-sm-3 control-label">学号</label>
                <div class="col-sm-8">
                    <input type="text" name="sno" class="form-control"  placeholder="学号">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-3 control-label">密码</label>
                <div class="col-sm-8">
                    <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> 记住密码
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <button type="submit" class="btn btn-default" >登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="row">
    <div class="col-md-9 col-sm-6 col-xs-12">
        <div class="list-group">

			  <span class="list-group-item  list-group-item-warning ">
			    时事新闻 <a href="${path}/front/article/articleAllByPage.do" style="float: right;">浏览更多</a>
			  </span>
            <c:forEach var="p" items="${page.list}" >
                <a href="${path}/front/article/articleDetails.do?id=${p.id}" class="list-group-item">${p.title}<span class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></span></a>
            </c:forEach></div>
    </div>
    <div class="col-md-3 col-sm-6 col-xs-12">
        <div class="list-group">
			  <span class="list-group-item  list-group-item-warning ">
			   资料下载 <a href="${path}/front/document/documentAllPage.do" style="float: right;">浏览更多</a>
			  </span>
            <c:forEach var="p" items="${documentPage.list}" >
                <a href="${p.path}" class="list-group-item">${p.name}</a>
            </c:forEach></div>
    </div>
</div>
<div class="row">

    <div class="col-md-9 col-sm-6 col-xs-12">
        <div class="list-group">
			  <span class="list-group-item  list-group-item-warning ">
			    话题讨论 <a href="${path}/front/BBS/getAllTopic.do" style="float: right;">浏览更多</a>
			  </span>
            <c:forEach var="p" items="${topicPage.list}" >
                <a href="${path}/front/BBS/getTopicDetail.do?id=${p.id}" class="list-group-item">${p.title}</a>
            </c:forEach></div>
    </div>

    <div class="col-md-3 col-sm-6 col-xs-12">
        <div class="list-group">
			  <span class="list-group-item  list-group-item-warning ">
			    关于我们 <a href="me.html" style="float: right;">浏览更多</a>
			  </span>
            <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
            <a href="#" class="list-group-item">Morbi leo risus</a>
            <a href="#" class="list-group-item">Porta ac consectetur ac</a>
            <a href="#" class="list-group-item">Vestibulum at eros</a>
            <a href="#" class="list-group-item">Vestibulum at eros</a>
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


