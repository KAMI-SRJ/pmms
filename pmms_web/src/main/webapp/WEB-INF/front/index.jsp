<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
<html lang="en">
<%@include file="common/header.jsp"%>
<body style="overflow-x: hidden;background-color:#e3dec1;padding:0  7%;">
<%@include file="common/nav.jsp"%>
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

    <div class="col-md-3 col-sm-12 col-xs-12" >
        <form class="form-horizontal" style="margin-top: 35px;" method="post" action="${path}/login/login.do">
            <div class="form-group">
                <label  class="col-sm-3 control-label">7777学号</label>
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
    <div class="col-md-3 col-sm-6 col-xs-12">
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
<div class="row">

    <div class="col-md-9 col-sm-6 col-xs-12">
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

    <div class="col-md-3 col-sm-6 col-xs-12">
        <div class="list-group">
			  <span class="list-group-item  list-group-item-warning ">
			    关于我们 <a href="me.html" style="float: right;">浏览更多</a>
			  </span>
            <a href="#" class="list-group-item hh hidens">Dapibus ac facilisis in</a>
            <a href="#" class="list-group-item">Morbi leo risus</a>
            <a href="#" class="list-group-item">Porta ac consectetur ac</a>
            <a href="#" class="list-group-item">Vestibulum at eros</a>
            <a href="#" class="list-group-item">Vestibulum at eros</a>
        </div>
    </div>

</div>
<%@include file="common/footer.jsp"%>
</body>
<script src="${path}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${path}/js/bootstrap.min.js"></script>
</html>


