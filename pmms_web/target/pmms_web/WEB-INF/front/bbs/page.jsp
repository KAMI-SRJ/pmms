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
     <link rel="stylesheet" href="${path}/css/topic.css">
     <style>

         .hids{
             width: auto;
             overflow: hidden;
             white-space: nowrap;
             text-overflow: ellipsis;

         }
         .hhs{
             border: 0px solid #ddd;
         }


         .list-group-item2 {
             position: relative;
             display: block;
             padding: 0px 0px;
             margin: 0px 0px;
             background-color: #fff;
             border: 1px solid #ddd;
         }
         .pull-right{
             float: right;
             padding: 0px 15px;
         }
         .aa{
             padding: 0px 15px;
         }
         .list-group-item2 a:hover,.list-group-item2 a:focus {
             color: #EE5023;
             text-decoration: none;
             background-color: white;
         }
         .col-md-11,.col-md-8,.col-md-4{
             padding-left: 0px;

         }

         .list-group-item3{
             position: relative;
             display: block;
             padding: 0px 0px;
             margin: 0px 0px;
             background-color: #fff;
             border: 1px solid #fff;
         }
         .list-group-item3 a:hover, .list-group-item3 a:focus{
             color: #EE5023;
             text-decoration: none;
             background-color: white;
         }

     </style>
 </head>
 <body >
 <jsp:include page="../common/nav.jsp"/>
 <div class="row">
 <ol class="breadcrumb">
     <li><a href="${path}/front/user/index.do">首页</a></li>
     <li class="active">话题讨论</li>
 </ol>

    <div class="row">
        <div class="col-md-8" style="padding-left:2%; ">
            <form action="${path}/front/BBS/getAllTopic.do" id="queryForm">
            <section ><!--${path}/front/BBS/getAllTopic.do?type=hot  http://127.0.0.1:8080/front/BBS/getAllTopic.do  http://127.0.0.1:8080/front/BBS/getAllTopic.do-->
                <ul class="nav nav-tabs">
                    <li class="active tli"><a href="#noticeView" data-toggle="tab">热门</a></li>
                    <li class="tli"><a href="#noticeDocument" data-toggle="tab">精选22</a></li>
                    <li class="tli"><a href="#noticeTender" data-toggle="tab">最近</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane in active" id="noticeView">
                        <ul class=" clearfix bli" >
                            <c:forEach var="p" items="${hot_page.list}">
                                <li class="bli"><a  href="${path}/front/BBS/getTopicDetail.do?id=${p.id}">
                                    <img src="http://jiaowu.sicau.edu.cn/photo/${p.publisher.sno}.jpg" alt="头像" class="images">${p.title}</a>
                                    <span class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></span>
                                </li>
                            </c:forEach>
                        </ul>
                         <%@include file="/common/pager.jsp"%>
                    </div>

                    <div class="tab-pane" id="noticeDocument">
                        <ul class=" clearfix bli" >
                            <c:forEach var="p" items="${most_page.list}">
                                <li class="bli">
                                    <a  href="${path}/front/BBS/getTopicDetail.do?id=${p.id}">
                                        <img src="http://jiaowu.sicau.edu.cn/photo/${p.publisher.sno}.jpg" alt="头像" class="images">
                                        ${p.title}
                                    </a>
                                    <span class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></span>
                                </li>
                            </c:forEach>
                        </ul>
                        <%@include file="/common/pager.jsp"%>
                    </div>

                    <div class="tab-pane" id="noticeTender">
                        <ul class=" clearfix bli" >
                            <c:forEach var="p" items="${page.list}">
                                <li class="bli">
                                    <a src="${path}/front/BBS/getTopicDetail.do?id=${p.id}">
                                        <img src="http://jiaowu.sicau.edu.cn/photo/${p.publisher.sno}.jpg" alt="头像" class="images">
                                        ${p.title}
                                    </a>
                                    <span class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></span>
                                </li>
                            </c:forEach>
                        </ul>
                         <%@include file="/common/pager.jsp"%>
                    </div>
                </div>
            </section>
            </form>
        </div>

        <div class="col-md-4">
            <div class="con">
                <a href="${path}/front/BBS/addOrUpdate.do?type=add" class="btn btn-lg btn-danger"><span class="glyphicon glyphicon-plus" aria-hidden="true">我要发表</span></a>
            </div>

            <div class="hot-question">
                <h3>热门问答${topicPage.list.size()}</h3>
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