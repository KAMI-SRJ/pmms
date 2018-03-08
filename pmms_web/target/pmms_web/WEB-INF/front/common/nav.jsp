<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>

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
                <li class="style "><a href="${path}/front/document/documentAllPage.do?type=学习资料">资料下载</a></li>
                <c:if test="${user !=null}" > <li class="style "><a href="${path}/front/user/userDetails.do">个人资料</a></li></c:if>
                <c:if test="${user eq null}" ><li class="style "><a href="${path}/front/aboutUs.do">关于我们</a></li></c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
