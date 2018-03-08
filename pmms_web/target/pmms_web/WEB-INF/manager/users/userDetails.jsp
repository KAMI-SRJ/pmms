 <%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
      <div class="right_col" role="main">

          <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                  <div class="x_content">

                    <form class="form-horizontal form-label-left" novalidate action="#" method="post">

                    <h1 class="section">个人信息
                    </h1>
                      <hr>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >学号
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <label >${u.sno}</label>
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">姓名
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <label for="">${u.username}</label>                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">专业</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <label for="">${u.profession}</label>
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >班级
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <label for="">${u.clazz}</label>
                        </div>
                      </div>
                      <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">性别</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <label for="">${u.gender}</label>
                            </div>

                          </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">民族</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <label >${u.nation}</label>                        </div>
                      </div>
                       <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">角色</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <label >${u.role.name}</label>
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">邮箱 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <label >${u.email}</label>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">电话 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <label for="">${u.phone}</label>
                        </div>
                      </div>
                      
                      <div class="ln_solid"></div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
            </div>