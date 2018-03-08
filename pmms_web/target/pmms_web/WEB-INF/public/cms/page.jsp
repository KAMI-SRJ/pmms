 <%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
 <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
 <div class="right_col" role="main">
      <div class="row">
           <div class="col-md-12 col-sm-12 col-xs-12">
               <div class="x_panel">
                  <div class="x_title">
                    <h2>
                    <a href="${path }/article/addOrUpdate.do?type=add" class="style"><small><i class="fa fa-plus"></i>添加</small></a>
                    </h2>
                    <ul class="nav navbar-right panel_toolbox">

                    <li><form class="form-inline" action="${path }/article/articleAllByPage.do" method="POST">
    					<div class="form-group">
						    <div class="input-group col-xs-12">
						        <div class="input-group-btn">
						            <select name="query_type" class="form-control" style="width: auto;">
						                <option value="主题">名称</option>
						                <option value="上传人">上传人</option>
						                <option value="类型">类型</option>
						            </select>
						        </div>
						        <input type="text" name="keyword" id="keyword" class="form-control" placeholder="请您输入关键词">
						        <span class="input-group-btn">
						            <button class="btn btn-success" id="search_submit" type="submit">查询</button>
						        </span>
						    </div>
						</div>
						</form></li>

						</ul>
                    <div class="clearfix"></div>
                  </div>
          <form class="am-form"id="queryForm"  action="${path}/article/articleAllByPage.do">
              <div class="x_content">
                 <div class="table-responsive">
                     <table class="table table-striped jambo_table bulk_action"> <thead>
              <tr class="headings">
                <th class="table-check"><input type="checkbox" /></th>
                <th class="column-title hids">主题</th>
                <th class="column-title">作者</th>
                <th class="column-title">上传时间</th>
                  <th class="column-title">审核通过</th>
                  <th class="column-title">置顶</th>
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
                <td><a class="hids" href="${path}/article/articleDetails.do?id=${p.id}">${p.title }</a></td>
                <td><a href="#"> ${p.publisher }</a></td>
                <td><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></td>
                <td class="am-hide-sm-only">${ p.isAudit}</td>
                  <td class="even pointer">${ p.isTop}</td>
                  <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                        <c:if test="${p.isAudit ==0}">
                        <a class="btn btn-success" href="${path}/article/audit.do?id=${p.id}&auditFlag=1" >审核通过</a>
                        </c:if>
                        <c:if test="${p.isAudit ==1}">
                            <a class="btn btn-success" href="${path}/article/audit.do?id=${p.id}&auditFlag=0" >审核不通过</a>
                        </c:if>
                        <c:if test="${p.isTop ==1}">
                        <a class="btn btn-success" href="${path}/article/top.do?id=${p.id}&topFlag=1" >置顶</a>
                        </c:if>
                        <c:if test="${p.isTop ==1}">
                            <a class="btn btn-success" href="${path}/article/top.do?id=${p.id}&topFlag=0" >取消置顶</a>
                        </c:if>
                        <a  class="btn btn-success" href="${path}/article/addOrUpdate.do?id=${p.id}&update=79898++5+582587446" >修改</a>
                        <a class="btn btn-success"  href="${path}/article/delete.do?id=${p.id}" >删除</a>
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