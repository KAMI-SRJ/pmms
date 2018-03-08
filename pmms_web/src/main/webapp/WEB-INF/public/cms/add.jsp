<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>党员管理系统 | ${type} </title>

    <!-- Bootstrap -->
    <link href="${path }/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${path }/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${path }/css/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="${path }/css/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="${path }/css/bootstrap/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${path }/css/custom.min.css" rel="stylesheet">
    

    <!-- include summernote css/js-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
    

    <link rel="stylesheet" href="${path}/css/topic.css">

    <style>
        h3{
            margin-left: 7%;
        }
    </style>
</head>


<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>信息管理</span></a>
                </div>

                <div class="clearfix"></div>


                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> 用户信息 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${path }/role/all.do">角色管理</a></li>
                                    <li><a href="${path }/resource/all.do">资源管理</a></li>
                                    <li><a href="${path }/user/all.do">所有用户</a></li>
                                    <li><a href="${path }/user/all.do?type=党员">党员</a></li>
                                    <li><a href="${path }/user/all.do?type=预备党员">预备党员</a></li>
                                    <li><a href="${path }/user/all.do?type=入党积极分子">入党积极分子</a></li>
                                    <li><a href="${path }/user/all.do?type=共青团员">共青团员</a></li>
                                </ul>
                            </li>
                            <li><a ><i class="fa fa-edit"></i> 成绩管理<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${path }/announcement/all.do">所有公告</a></li>

                                </ul>
                            </li>

                            <li><a><i class="fa fa-table"></i> 心得管理<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="#">心得体会<span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li class="sub_menu"><a href="${path}/document/documentAllPage.do?type=心得体会">所有心得体会</a>
                                            </li>
                                            <li><a href="#level2_1">Level Two</a>
                                            </li>
                                            <li><a href="${path}/upload/index.do?type=心得体会">上传心得</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="${path}/upload/index.do?type=思想汇报">思想汇报<span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li class="sub_menu"><a href="level2.html">Level Two</a>
                                            </li>
                                            <li><a href="${path}/document/documentAllPage.do?type=思想汇报">全部</a>
                                            </li>
                                            <li><a href="${path}/upload/index.do?type=思想汇报">上传思想汇报</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="${path}/upload/index.do?type=学习资料">学习资料<span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="${path}/document/documentAllPage.do?type=学习资料">全部</a>
                                            </li>
                                            <li class="sub_menu"><a href="level2.html">Level Two</a>
                                            </li>

                                            <li><a href="${path}/upload/index.do?type=学习资料">上传学习资料</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>


                        </ul>
                    </div>
                    <div class="menu_section">

                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-bug"></i> 新闻管理 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${path }/article/articleAllByPage.do">所有新闻</a></li>
                                    <li><a href="${path }/article/index.do">所有新闻</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-windows"></i> 发布讨论 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${path}/BBS/getAllTopic.do">所有话题</a></li>

                                </ul>
                            </li>
                            <li><a><i class="fa fa-sitemap"></i> 公告管理 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="${path}/announcement/all.do">所有公告</a>
                                    <li><a>Level One<span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li class="sub_menu"><a href="level2.html">Level Two</a>
                                            </li>
                                            <li><a href="#level2_1">Level Two</a>
                                            </li>
                                            <li><a href="#level2_2">Level Two</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="${path}/announcement/addOrUpdate.do?up_jsp=6565232398984516126">发布公告</a>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->


            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <img src="http://jiaowu.sicau.edu.cn/photo/${user.sno}.jpg" alt=""> ${user.username}
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="${path}/user/userDetails.do?id=${user.id}"> 个人信息</a></li>
                                <li><a href="${path }/login/logout.do">退出</a></li>
                                <li><a href="${path }/login/index.do"><i class="fa fa-sign-out pull-right"></i> 登录</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">

            <div class="row">
                <div class="col-md-10" style="margin-left: 7%;">
                    <form action="${path}/article/addOrUpdate.do">
                        <div class="form-group">
                            <label >标题</label>
                            <input type="text" name="title" class="form-control" placeholder="请输入标题" value="${article.title}">
                        </div>
                        <div class="form-group">
                            <label for="" >${doc_name}问题描述</label>
                            <div id="summernote" >
                                <p class="contentValue">
                                    <c:if test="${article eq null}">
                                    </c:if>
                                    <c:if test="${article != null}">${article.content}</c:if>
                                </p>
                            </div>
                        </div>
                        <input type="hidden" name="id" value="${article.id}"/>
                        <input type="hidden" name="publisher" value="${user.username}"/>
                        <input type="hidden" name="publisherId" value="${user.id}"/>
                        <button type="button" class="btn btn-danger btn-lg">发表</button>
                </form>
                </div>
            </div>
        </div>

        <!-- /page content -->

        <!-- footer content -->
        <footer style="margin-left: -20px;margin-right:-20px;margin-top: 15px">
            <div class="pull-right">
                by <a href="https://DUGStudio.org">DUG Studio</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>
</div>

</body>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <script src="${path }/js/jquery.min.js"></script>

    <script>
    $(document).ready(function() {

         $('#summernote').summernote(
          {
            height:300,
            minHeight:200,
            maxHeight:400,
            focus:false,
            lang:'zh-CN',
            placeholder:'请输入你的问题',
            onImageUpload:function(files,editor,$editable){
              sendFile(files[0],editor,$editable);
            }
          });

        $('#summernote').summernote({
            callbacks: {
                onImageUpload: function(files) {
                    //上传图片到服务器，使用了formData对象，至于兼容性...据说对低版本IE不太友好
                    var formData = new FormData();
                    formData.append('file',files[0]);
                    formData.append('id',$("input[name='publisherId']").val());
                    formData.append('type','4')
                    $.ajax({
                        url : '${path}/front/upload/save.do',//后台文件上传接口
                        type : 'POST',
                        data : formData,
                        processData : false,
                        contentType : false,
                        success : function(data) {
                            alert("success upload picture:"+data+"${doc_name}");
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
            url:'${path}/article/addOrUpdate.do',
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
    <!-- Bootstrap -->
    <script src="${path }/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${path }/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${path }/js/nprogress.js"></script>
    <!-- DateJS -->
    <script src="${path }/js/date.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${path }/js/custom.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
</html>