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
<%@include file="../common/nav.jsp"%>
<ol class="breadcrumb">
    <li><a href="${path}/front/user/index.do">首页</a></li>
    <li><a href="${path}/front/BBS/getAllTopic.do">话题讨论</a></li>
    <li class="active">详情</li>
</ol>


<div class="row">
    <div class="col-md-8" style="padding-left:2%; ">
        <div>
            <h2>${topic.title}</h2>
            <span >${topic.publisher.username}</span>
            <c:if test="${topic.publisher.id eq user.id}" >
            <span class="line">|</span>
            <span><a href="${path}/front/BBS/deleteTopic.do?id=${topic.id}">删除</a>&nbsp;&nbsp;</span>
            </c:if>
            <span class="line">|</span>
            <span ><fmt:formatDate value="${topic.createDate}" pattern="yyyy-MM-dd"/></span>
            <span class="line">|</span>
            <span>浏览量：${topic.readers}</span>
            <span class="line">|</span>
            <span><a href="${path}/front/BBS/clickGood.do?id=${topic.id}">点赞</a>&nbsp;&nbsp;(${topic.goods.size()})</span>
            <c:forEach var="g" items="${topic.goods}">
                <span><a href="${path}/front/user/userDetails.do?id=${g.id}">${g.username}</a>&nbsp;&nbsp;</span>
            </c:forEach>
            <form action="${path}/front/BBS/addComment.do?id=${topic.id}" method="post">
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">×</span></button>
                                <h4 class="modal-title" id="exampleModalLabel">评论${c.id}</h4>
                            </div>
                            <div class="modal-body">
                                  <%--  <div class="form-group">
                                        <label for="recipient-name" class="control-label">标题：</label>
                                        <input type="text" class="form-control" id="recipient-name">
                                    </div>--%>
                                    <div class="form-group">
                                        <label for="message-text" class="control-label">详情：</label>
                                        <textarea class="form-control" id="message-text" name="content"></textarea>
                                    </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <input class="btn btn-primary" type="submit"></input>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <hr>
        <div >
            <p class="pt">${topic.content}</p>

            <img src="${path}${topic.path}" alt="" class="img">
        </div>
        <div>
            <p style="float: right;"><a href="${path}/front/BBS/clickGood.do?id=${topic.id}">
                <img src="${path}/images/c.png" alt="" style="margin-right: 10px"> </a>(${topic.goods.size()})

                <a  data-toggle="modal" data-target="#myModal">
                    <img src="${path}/images/a.png" alt=""></a>
                (${topic.comments.size()})
            </p>

        </div>
    <%--    <div>
            <a href="${path}/front/BBS/addComment.do?id=${topic.id}">评论${topic.comments.size()}</a>
        </div>--%>

        <c:forEach items="${topic.comments}" var="c">
            <hr>
        <div>
            <img src="http://jiaowu.sicau.edu.cn/photo/${c.publisher.sno}.jpg" alt="" class="images">
            <span>${c.publisher.username}</span>
            <c:if test="${c.publisher.id eq user.id}" ><span><a href="${path}/front/BBS/deleteComment.do?id=${c.id}&topicId=${topic.id}">删除</a></span></c:if>
            <span class="pull-right"><fmt:formatDate value="${c.createDate}" pattern="yyyy-MM-dd"/></span>
            <p class="pt"><a href="${path}/front/BBS/getCommentDetail.do?id=${c.id}">${c.content}</a></p>
            <%--<span><a href="${path}/front/BBS/addChildComment.do?parentCommentId=${c.id}">评论</a>(${c.sets.size()})</span>
            <span><a href="${path}/front/BBS/commentClickGood.do?id=${c.id}&topicId=${topic.id}">赞</a>(${c.goods.size()})</span>
            --%><div>
                <p style="float: right;"><a href="${path}/front/BBS/commentClickGood.do?id=${c.id}&topicId=${topic.id}">
                    <img src="${path}/images/c.png" alt="" style="margin-right: 10px"></a>(${c.goods.size()})
                    <a  data-toggle="modal" data-target="#myModal" name="${c.id}">
                        <img src="${path}/images/a.png" alt=""> </a>
                    (${c.sets.size()})

                </p>

            </div>
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

<script src="">
    $(".btn").bind('click',function(){
        console.log($("input[id='title']").val());
        console.log($(".note-editable")[0].innerText);
        $.ajax({
            type:'post',
            url:'${path}/front/BBS/addOrUpdate.do',
            data:{
                content:$(".note-editable")[0].innerText,
                title:$("input[name='title']").val(),
                publisher:$("input[name='publisher']").val(),
                id:$("input[name='id']").val()
            },
            success:function(){
                alert("succ")
                //
            },error:function(){
                alert("fail")
                //
            }
        })
    })
</script>
</html>