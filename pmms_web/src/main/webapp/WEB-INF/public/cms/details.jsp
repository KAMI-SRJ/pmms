<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/22
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- page content -->
<div class="right_col" role="main">
    <ol class="breadcrumb">
        <li><a href="${path}/front/user/index.do">首页</a></li>
        <li><a href="${path}/announcement/all.do">通知公告</a></li>
        <li class="active">正文</li>
    </ol>

    <div class="row">
        <div class="col-md-8">

            <h3  style="text-align: center;color: red;">${article.title}</h3>
            <div style="margin:20px 185px;">
                <span >作者：${article.publisher}</span>
                <span class="pull-right">发布日期：<fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></span>
                <span class="pull-right">浏览量：${article.viewCount}</span>
            </div>
            <img src="${path}${article.coverImageUrl}" alt="" class="img">
            <p class="pt">${article.content}</p>
            <div class="page">
                <ul>
                    <c:if test="${pre!=null}"><li>
                        <span>上一篇:</span>
                        <a href="${path}/article/articleDetails.do?id=${pre.id}">${pre.title}</a>
                    </li></c:if>
                        <c:if test="${next!=null}"><li>
                        <span>下一篇:</span>
                        <a href="${path}/article/articleDetails.do?id=${next.id}">${next.title}</a>
                        </li></c:if>
                </ul>
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
</div>
    <!-- /page content -->