<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@include file="/common/dtd.jsp"%>
<!DOCTYPE html>
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
<body >
<%@include file="../common/nav.jsp"%>
<!-- page content -->
<ol class="breadcrumb">
    <li><a href="${path}/front/user/index.do">首页</a></li>
    <li><a href="${path}/front/announcement/all.do">通知公告</a></li>
    <li class="active">正文</li>
</ol>

<div class="row">
    <div class="col-md-8">

        <h3  style="text-align: center;color: red;">${announcement.title}</h3>
        <div style="margin:20px 185px;">
            <span >作者：${announcement.publisher}</span>
            <span class="pull-right">发布日期：<fmt:formatDate value="${announcement.createDate}" pattern="yyyy-MM-dd"/></span>
        </div>

        <p class="pt">${announcement.content}</p>
        <div class="page">
            <ul>
                <li>
                    <span>上一篇:</span>
                    <a href="${path}/front/announcement/details.do?id=${pre.id}">${pre.title}</a>
                </li>
                <li>
                    <span>下一篇:</span>
                    <a href="${path}/front/announcement/details.do?id=${next.id}">${next.title}</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="col-md-3" style="margin-left: 5%;">
        <div class="row">
            <div class="col-md-12">
                <div class="list-group">
					  <span class="list-group-item  list-group-item-info ">
					    推荐新闻 <a href="#" style="float: right;">浏览更多</a>
					  </span>
                    <c:forEach var="p" items="${tuijian_page.list}" >
                        <a href="${path}/front/article/articleDetails.do?id=${p.id}" class="list-group-item">${p.title}</a>
                    </c:forEach></div>
            </div>
            <div class="col-md-12">
                <div class="list-group">
					  <span class="list-group-item  list-group-item-info ">
					    热点新闻 <a href="#" style="float: right;">浏览更多</a>
					  </span>
                    <c:forEach var="p" items="${hot_page.list}" >
                        <a href="${path}/front/article/articleDetails.do?id=${p.id}" class="list-group-item">${p.title}</a>
                    </c:forEach>
                </div>
            </div>
        </div>

    </div>
</div>
<div class="text-center">
    <div class="row">
        <div class="col-lg-12">
            <p style="color: #9F9F9F">Copyright © 2017 四川农业大学-党员. SICAU - PMMS.  All Rights Reserved.</p>
        </div>
    </div>
</div>

</body>
<script src="${path}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${path}/js/bootstrap.min.js"></script>
</html>