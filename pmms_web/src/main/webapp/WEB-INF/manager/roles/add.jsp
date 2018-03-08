 <%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
      <div class="right_col" role="main">

          <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                  <div class="x_content">

                    <form class="form-horizontal form-label-left" novalidate action="${path }/role/add.do" method="post">

                    <h1 class="section">添加角色
                    </h1>
                      <hr>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">名称
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="name" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="请输入名称" required="required" type="text">
                        </div>
                      </div>
                     
                      <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">权限</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                            
                              <div id="resources" class="btn-group" data-toggle="buttons">
                             
                                <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                  <input type="checkbox"name="resource" value="add"> &nbsp; add&nbsp;
                                </label>
                                <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                  <input type="checkbox"name="resource" value="delete"> &nbsp; delete&nbsp;
                                </label>
                              </div>
                            </div>
                          </div>
                     
                      
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <button type="submit" class="btn btn-primary">取消</button>
                          <button id="send" type="submit" class="btn btn-success">提交</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
            </div>