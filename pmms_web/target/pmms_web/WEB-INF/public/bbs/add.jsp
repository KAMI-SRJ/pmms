<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/22
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
 <style>
        h3{
            margin-left: 7%;
        }
    </style>
</head>
<body >
<div class="right_col" role="main">
<h3 class="">我要发表</h3>
<div class="row">
    <div class="col-md-10" style="margin-left: 7%;">
        <form>
            <div class="form-group">
                <label >标题</label>
                <input type="txt" class="form-control" placeholder="请输入标题">
            </div>
            <div class="form-group">
                <label >标签</label>
                <input type="password" class="form-control"  placeholder="如php">
            </div>
            <div class="form-group">
                <label  >问题描述</label>
                <div id="summernote" >
                <p>请输入你的问题</p>
            </div>
    </div>

    <button type="submit" class="btn btn-danger btn-lg">发表</button>
    </form>
</div>
</div>



<div style="margin-top: 10px;background-color: #eee">
    <br>
    <div class="text-center">
        <div class="row">
            <div class="col-lg-12">
                <p style="color: #9F9F9F">Copyright © 2017 四川农业大学-党员. SICAU - PMMS.  All Rights Reserved.</p>
            </div>
        </div>
    </div>
</div>
</div>
</body>

<script>
    $(document).ready(function() {
        $('#summernote').summernote();
    });
</script>
    <!-- /page content -->