<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
<!-- page content -->
<div class="right_col" role="main">
    <ol class="breadcrumb">
        <li><a href="${path}/front/index.do">首页</a></li>
        <li><a href="${path}/announcement/all.do">通知公告</a></li>
        <li class="active">正文</li>
    </ol>

    <div class="row">
        <div class="col-md-8">

            <h3  style="text-align: center;color: red;">${topic.title}</h3>
            <div style="margin:20px 185px;">
                <span >作者：${topic.publisher.username}</span>
                <span class="pull-right">发布日期：<fmt:formatDate value="${topic.createDate}" pattern="yyyy-MM-dd"/></span>
            </div>

            <p class="pt">${topic.content}</p>
            评论：<a href="${path }/BBS/addOrUpdate.do?type=add" class="style"><small><i class="fa fa-plus"></i>添加</small></a>
            <table>
                    <c:forEach  items="${topic.comments}" var="c"><tr>
                       <td> 评论人：${c.publisher.username} 时间:<fmt:formatDate value="${c.createDate}" pattern="yyyy-MM-dd"/></td>
                        <hr/>
                        <td>${c.content}</td></tr>
                    </c:forEach>
            </table>

            <div class="page">
                <ul>
                    <li>
                        <span>上一篇:</span>
                        <a href="#">通过PPT将论文各个部分的填写要求，需要注意的细节</a>
                    </li>
                    <li>
                        <span>下一篇:</span>
                        <a href="#">在成都校区二教报告厅，借全院毕业生大会召开之际</a>
                    </li>
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
    <script src="../js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../js/bootstrap.min.js"></script>
</div>
    <!-- /page content -->