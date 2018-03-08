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
    <form action="${path}/front/upload/save.do?id=${user.id}" method="post" enctype="multipart/form-data">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>文件上传</h2><input type="hidden" value="${type}" name="type"/>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>

                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <select name="type">
                    <option value="心得体会">心得体会</option>
                    <option value="思想汇报">思想汇报</option>
                    <option value="学习资料">学习资料</option>
                </select>
                <input type="file" name="file" value="上传文件"  >
                <input type="submit" value="上传">
            </div>
        </div>
    </div>
    </form>
</div>
    <!-- /page content -->