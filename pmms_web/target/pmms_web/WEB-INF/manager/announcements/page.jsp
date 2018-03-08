 <%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
 <div class="right_col" role="main">
      <div class="row">
           <div class="col-md-12 col-sm-12 col-xs-12">
               <div class="x_panel">
                  <div class="x_title">
                    <h2>公告<small>管理</small>
                      <a href="${path }/announcement/addOrUpdate.do?up_jsp=884588566322452336" class="style"><small><i class="fa fa-plus"></i>添加</small></a>
                    </h2>
                      <ul class="nav navbar-right panel_toolbox">

                          <li><form class="form-inline" action="${path }/announcement/all.do" method="POST">
                              <div class="form-group">
                                  <div class="input-group col-xs-12">
                                      <div class="input-group-btn">
                                          <select name="type" class="form-control" style="width: auto;">
                                              <option value="title">主题</option>
                                              <option value="publisher">上传人</option>
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
          <form class="am-form" id="queryForm" action="${path}/announcement/all.do" >
              <div class="x_content">
                 <div class="table-responsive">
                     <table class="table table-striped jambo_table bulk_action"> <thead>
              <tr class="headings">
                <th class="table-check"><input type="checkbox" /></th>
                <th class="column-title">主题</th>
                <th class="column-title">创建时间</th>
                <th class="column-title">创建人</th>
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
                <td><a href="#">${p.title }</a></td>
                <td class="am-hide-sm-only"><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></td>
                <td>${p.publisher }</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                     <a class="btn btn-success" href="${path}/announcement/addOrUpdate.do?id=${p.id}&up_jsp=65656333684666699">修改</a>
                    <a href="${path }/announcement/delete.do?id=${p.id}"  class="btn btn-success" > 删除</a>
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