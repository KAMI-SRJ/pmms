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
     <link rel="stylesheet" href="${path}/css/notice.css">
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
<%@include file="../common/nav.jsp"%>

 <ol class="breadcrumb">
     <li><a href="${path}/front/user/index.do">首页</a></li>
     <li class="active">时事新闻</li>
 </ol>

 <div class="row">
     <form action="${path}/front/article/articleAllByPage.do" id="queryForm">
         <div class="col-md-8">
         <div class="list-group">
             <c:forEach items="${page.list}" var="p">
                 <div class="row list-group-item3">
                 <div class="col-md-8">
                    <a  class="list-group-item hhs hids aa" href="${path}/front/article/articleDetails.do?id=${p.id}">${p.title}</a>
                 </div>
                 <div class="col-md-4">
                     <p class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></p>
                 </div>
                 </div>
             </c:forEach>
         </div>
            <%@include file="/common/pager.jsp"%>
     </div>

     </form>

     <div class="col-md-3" style="margin-left: 5%;">
         <div class="row">
             <div class="col-md-12">
                 <div class="list-group">
					  <span class="list-group-item  list-group-item-info ">
					    推荐新闻 <a href="${path}/front/article/articleAllByPage.do?type=tuijian" style="float: right;">浏览更多</a>
					  </span>
                     <c:forEach var="p" items="${tuijian_page.list}">
                         <a href="" class="list-group-item hhs hids" id="${p.id}">${p.title}</a>
                     </c:forEach>
                 </div>
             </div>
             <div class="col-md-12">
                 <div class="list-group">
					  <span class="list-group-item  list-group-item-info ">
					    热点新闻 <a href="${path}/front/article/articleAllByPage.do?type=hot" style="float: right;">浏览更多</a>
					  </span>
                     <c:forEach var="p" items="${hot_page.list}">
                     <a href="${path}/front/article/articleDetails.do?id=${p.id}" class="list-group-item hhs hids">${p.title}</a>
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
 <script src="${path}/js/jquery.min.js"></script>
 <!-- Bootstrap -->
 <script src="${path}/js/bootstrap.min.js"></script>

 </body>
 </html>