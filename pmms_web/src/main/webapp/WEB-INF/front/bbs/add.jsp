<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

    <!-- include summernote css/js-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
    <style>
        h3{
            margin-left: 7%;
        }
    </style>
</head>
<body >
<div class="row">
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
                <a class="navbar-brand " href="${path}/front/user/index.do" >首页</a>
            </div>


            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
                <ul class="nav navbar-nav" >

                    <li class="style "><a href="${paht}/front/article/articleAllByPage.do">新闻 <span class="sr-only">(current)</span></a></li>
                    <li class="style "><a href="${paht}/front/announcement/all.do">公告</a></li>
                    <li class="style "><a href="${paht}/front/BBS/getAllTopic.do">话题讨论</a></li>
                    <li class="style "><a href="${paht}/front/document/documentAllPage.do?type=学习资料">资料下载</a></li>
                    <li class="style "><a href="${paht}/front/aboutUs.do">关于我们</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
<ol class="breadcrumb">
    <li><a href="${path}/front/user/index.do">首页</a></li>
    <li><a href="${path}/front/BBS/getAllTopic.do">话题讨论</a></li>
    <li class="active">我要发表</li>
</ol>
<h3 class="">我要发表</h3>
<div class="row">
    <div class="col-md-10" style="margin-left: 7%;">

        <form method="post" action="${path}/front/BBS/addOrUpdate.do" enctype="multipart/form-data">
            <!-- action="${path}/front/BBS/addOrUpdate.do"-->
            <div class="form-group">
                <label >标题</label>
                <input type="text" name="title" class="form-control" placeholder="请输入标题" value="${article.title}">
            </div>
            <div class="form-group">
                <label >标签</label>
                <input type="text" class="form-control" name="type"  placeholder="如php" value="${article.type}">
            </div>
            <div class="form-group">
                <label for="" >问题描述</label>
                <div id="summernote" >
                <p class="contentValue" >
                    <c:if test="${article eq null}"> 请输入你的问题
                    </c:if>
                    <c:if test="${article != null}">${article.content}</c:if>
                   </p>
            </div>
            </div>
            <input type="hidden" name="id" value="${user.id}"/>
            <input type="hidden" name="publisher" value="${user.id}"/>
            <button type="button" class="btn btn-danger btn-lg">发表</button>
    </form>
</div>
</div>
</div>
<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            callbacks: {
                onImageUpload: function(files) {
                    //上传图片到服务器，使用了formData对象，至于兼容性...据说对低版本IE不太友好
                    var formData = new FormData();
                    formData.append('file',files[0]);
                    formData.append('id',$("input[name='publisher']").val());
                    formData.append('type','4')
                    $.ajax({
                        url : '${path}/front/upload/save.do',//后台文件上传接口
                        type : 'POST',
                        data : formData,
                        processData : false,
                        contentType : false,
                        success : function(data) {
                            alert("success upload picture:"+data);
                            //$('#summernote').summernote('insertImage',data,'img');
                        },
                        error: function(){
                            alert("error")
                        }
                    });
                }
            }
        });
    });
    $(".btn").bind('click',function(){
        console.log($("input[name='title']").val());
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
</body>


</html>
