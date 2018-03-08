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
    <style type="text/css">

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

        .pageLink {
            border: 1px solid #dddddd;
            padding: 4px 12px;
            text-decoration: none;
            border-radius: 2px;
        }

        .selectPageLink {
            border: 1px solid #0088cc;
            padding: 4px 12px;
            color: #0088cc;
            background-color: #dddddd;
            text-decoration: none;
            border-radius: 2px;
        }
        .tel{
            text-align: center;
            border: 0;
            padding: 4px 12px;
            margin-top: 30px;
            font-size: 18px;
            font-family:'Trebuchet MS', Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body >
<%@include file="../common/nav.jsp"%>
<ol class="breadcrumb">
    <li><a href="${path}/front/user/index.do">首页</a></li>
    <li class="active">通知公告</li>
</ol>

<div class="row">
    <form action="${path}/front/announcement/all.do" id="queryForm">
    <div class="col-md-8">
        <div class="list-group">
            <c:forEach items="${announcementpage.list}" var="p">
                <div class="row list-group-item3">
                    <div class="col-md-8">
                        <a  class="list-group-item hhs hids aa" href="${path}/front/announcement/details.do?id=${p.id}">${p.title}</a>
                    </div>
                    <div class="col-md-4">
                        <p class="pull-right"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></p>
                    </div>
                </div>
            </c:forEach>
        <input type="hidden" name="currentPage" id="currentPage">
        <!-- 分页标签 -->
        <div style="text-align: center; border: 0; padding: 4px 12px;"
             class="pageDiv mt20 tel">
            <pg:pager url="#" items="${announcementpage.totalCount}"
                      maxPageItems="${announcementpage.pageSize}" maxIndexPages="1000"
                      isOffset="true">
                总共：${announcementpage.totalCount}条,共:${announcementpage.totalPage}页
                <pg:first>
                    <a id="first" href="#" class="pageLink">首页</a>
                </pg:first>
                <c:if test="${announcementpage.currentPage != 1 && announcementpage.totalPage > 0 }">
                    <a id="prev" href="#" class="pageLink">上一页</a>
                </c:if>
                <pg:pages>
                    <c:choose>
                        <c:when test="${announcementpage.currentPage==pageNumber}">
                            <span class="selectPageLink">${pageNumber}</span>
                        </c:when>
                        <c:otherwise>
                            <c:if
                                    test="${(pageNumber-announcementpage.currentPage lt 5) and (pageNumber-announcementpage.currentPage gt -5)}">
                                <a href="javascript:pageAction('${pageNumber}')"
                                   class="pageLink">${pageNumber}</a>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </pg:pages>
                <c:if
                        test="${announcementpage.currentPage != announcementpage.totalPage  && announcementpage.totalPage > 0 }">
                    <a id="next" href="#" class="pageLink">下一页</a>
                </c:if>
                <pg:last>
                    <a id="last" href="#" class="pageLink">尾页</a>
                </pg:last>
            </pg:pager>
        </div>
    </div>
    </div>
    </form>
    <div class="col-md-3" style="margin-left: 5%;">
        <div class="row">
            <div class="col-md-12">
                <div class="list-group">
					  <span class="list-group-item  list-group-item-info ">
					    推荐新闻 <a href="" style="float: right;">浏览更多</a>
					  </span>
                    <c:forEach var="p" items="${tuijian_page.list}">
                        <a href="${path}/front/article/articleDetails.do?id=${p.id}" class="list-group-item hhs hids">${p.title}</a>
                    </c:forEach>
                </div>
            </div>
            <div class="col-md-12">
                <div class="list-group">
					  <span class="list-group-item  list-group-item-info ">
					    热点新闻 <a href="#" style="float: right;">浏览更多</a>
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


</body>

<script src="${path}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript">

    $(function(){
        var currentPage = ${announcementpage.currentPage};
        var totalPage = ${announcementpage.totalPage };
        $("#first").bind("click",function(event){
            pageAction(1);
        });
        $("#prev").bind("click",function(event){
            if(currentPage>1){
                currentPage--;
            }else{
                currentPage = 1;
            }
            pageAction(currentPage);
        });
        $("#next").bind("click",function(event){
            if(totalPage>currentPage){
                currentPage++;
            }else{
                currentPage=totalPage;
            }
            pageAction(currentPage);
        });
        $("a[name='doNumberPage']").bind("click",function(event){
            pageAction(currentPage);
        });
        $("#last").bind("click",function(event){
            pageAction(totalPage);
        });
    });
    function pageAction(currentPage){
        $("#currentPage").val(currentPage);
        $('#queryForm').submit();

    }
</script>
</html>