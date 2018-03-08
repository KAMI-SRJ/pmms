<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
<html lang="en">
<%@include file="common/header.jsp"%>
<body style="overflow-x: hidden;background-color:#e3dec1;padding:0  7%;">
<%@include file="common/nav.jsp"%>
<div class="row" style="margin-bottom: 20px;">
    <div class="col-md-12 col-sm-12 col-xs-12">
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
</div>


<div class="row">
    <div class="col-md-6 col-sm-6 col-xs-12">
        <div class="list-group">
			  <span class="list-group-item  list-group-item-warning ">
			    通知公告<a href="${path}/front/announcement/all.do" style="float: right;">浏览更多</a>
			  </span>
            <c:forEach var="p" items="${announcementpage.list}" >
            <div class="row list-group-item1">
                <div class="col-md-8 ">
                    <a href="${path}/front/announcement/details.do?id=${p.id}" class="list-group-item hh hidens">${p.title}</a>
                </div>
                <div class="col-md-4">
                    <p class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></p>
                </div>
            </div> </c:forEach>
        </div>
    </div>

        <div class="col-md-6 col-sm-6 col-xs-12">
        <div class="list-group">

			  <span class="list-group-item  list-group-item-warning ">
			    时事新闻 <a href="${path}/front/article/articleAllByPage.do" style="float: right;">浏览更多</a>
			  </span>
            <c:forEach var="p" items="${page.list}" >
            <div class="row list-group-item1">
                <div class="col-md-8 ">
                <a href="${path}/front/article/articleDetails.do?id=${p.id}" class="list-group-item hh hidens">${p.title}</a>
                </div>
                <div class="col-md-4">
                <p class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></p>
                </div>
           </div> </c:forEach>
        </div>
    </div>
    </div>
    <div class="row">

        <div class="col-md-6 col-sm-6 col-xs-12">
            <div class="list-group">
			  <span class="list-group-item  list-group-item-warning ">
			    话题讨论 <a href="${path}/front/BBS/getAllTopic.do" style="float: right;">浏览更多</a>
			  </span>
                <c:forEach var="p" items="${topicPage.list}" >
                    <div class="row list-group-item1">
                        <div class="col-md-8 ">
                            <a href="${path}/front/BBS/getTopicDetail.do?id=${p.id}" class="list-group-item hh hidens">${p.title}</a>
                        </div>
                        <div class="col-md-4">
                            <p class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <div class="list-group">
			  <span class="list-group-item  list-group-item-warning ">
			   资料下载 <a href="${path}/front/document/documentAllPage.do" style="float: right;">浏览更多</a>
			  </span>
            <c:forEach var="p" items="${documentPage.list}" >
                <div class="row list-group-item1">
                    <div class="col-md-8 ">
                        <a href="${p.path}" class="list-group-item hh hidens">${p.name}</a>
                    </div>
                    <div class="col-md-4">
                        <p class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></p>
                     </div>
            </div>
            </c:forEach>
        </div>
        </div>
    </div>
<%@include file="common/footer.jsp"%>
</body>
<script src="${path}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${path}/js/bootstrap.min.js"></script>
</html>


