<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
<html lang="en">
<jsp:include page="./common/header.jsp"></jsp:include>
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
			<jsp:include page="./common/sidebar.jsp"></jsp:include>
            <!-- /sidebar menu -->
          </div>
        </div>
        <!-- top navigation -->
		<jsp:include page="./common/nav.jsp"></jsp:include>
        <!-- /top navigation -->
        <!-- page content -->
     	<jsp:include page="${half_path}/${jsp_name }.jsp"></jsp:include><%--
          <jsp:include page="../public/document/upload.jsp"></jsp:include>--%>
        <!-- /page content -->
        <!-- 分页标签 start-->
        <%-- <jsp:include page="/common/pager.jsp"></jsp:include> --%>
        <!-- 分页标签  end -->
        <!-- footer content -->
     	<jsp:include page="./common/footer.jsp"></jsp:include>
        <!-- /footer content -->
</div>
</div>
    <script src="${path}/js/jquery.min.js"></script>
    <script>
    $(document).ready(function() {
    //限制字符个数
    $(".hids").each(function() {
    var maxwidth = 13;
    if ($(this).text().length > maxwidth) {
    $(this).text($(this).text().substring(0, maxwidth));
    $(this).html($(this).html() + '...');
    }
    });
    });

    </script>
    <!-- jQuery -->

    <!-- Bootstrap -->
    <script src="${path}/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${path}/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${path}/js/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="${path}/js/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="${path}/js/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="${path}/js/moment.min.js"></script>
    <script src="${path}/js/daterangepicker.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="${path}/js/bootstrap-wysiwyg.min.js"></script>
    <script src="${path}/js/jquery.hotkeys.js"></script>
    <script src="${path}/js/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="${path}/js/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="${path}/js/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="${path}/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="${path}/js/parsley.min.js"></script>
    <!-- Autosize -->
    <script src="${path}/js/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="${path}/js/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <!-- Custom Theme Scripts -->
    <script src="${path}/js/custom.min.js"></script>
  </body>
</html>

