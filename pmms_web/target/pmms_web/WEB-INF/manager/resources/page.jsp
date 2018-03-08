 <%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
 <div class="right_col" role="main">
      <div class="row">
           <div class="col-md-12 col-sm-12 col-xs-12">
               <div class="x_panel">
                  <div class="x_title">
                    <h2>资源<small>管理</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      
                      <li><a href="#" class="style"><i class="fa fa-plus"></i>添加</a></li>
                      <li><a href="#"><i class="fa fa-search"></i>查询</a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
          <form class="am-form" action="${path}/resource/all.do">
              <div class="x_content">
                 <div class="table-responsive">
                     <table class="table table-striped jambo_table bulk_action"> <thead>
              <tr class="headings">
                <th class="table-check"><input type="checkbox" /></th>
                <th class="column-title">名称</th>
                <th class="column-title">Url</th>
                <th class="column-title">创建日期</th>
                <th class="column-title no-link last">操作</th>
               <th class="bulk-actions" colspan="6">
                    <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
               </th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${page.list }" var="p">
              <tr class="even pointer">
                <td class="a-center "><input type="checkbox" /></td>
                <td><a href="#">${p.name }</a></td>
                <td class="am-hide-sm-only">${ p.url}</td>
                <td class="am-hide-sm-only"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                     <a class="btn btn-success" href="${path }/resource/edit.do?id=${p.id}">修改</a>
                     <a class="btn btn-success" href="${path }/resource/delete.do?id=${p.id}">删除</a>
                     </div>
                  </div>
                </td>
              </tr></c:forEach>
              </tbody>
            </table>
            <div class="am-cf">
                <%@include file="/common/pager.jsp"%>
            </div>
            <hr />
            <p>注：.....</p>
            </div>
            </div>
          </form>
        </div>
</div>
</div>
</div>