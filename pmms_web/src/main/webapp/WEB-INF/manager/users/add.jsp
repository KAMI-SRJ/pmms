 <%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
      <div class="right_col" role="main">

          <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                  <div class="x_content">

                    <form class="form-horizontal form-label-left" novalidate action="${path }/user/addOrUpdate.do" method="post">

                    <h1 class="section">个人信息
                    </h1>
                      <hr>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="sno">学号
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="sno" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="sno"value="${user.sno}" placeholder="${user.sno}" required="required" type="text">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">姓名 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="name" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="username" value="${user.username}" placeholder="${user.username}" required="required" type="text">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">专业</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="form-control" name="profession">
                            <option>计算机科学与技术</option>
                            <option>信管</option>
                            <option>物联网工程</option>
                            <option>计算机（教育）</option>
                          </select>
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">班级(eg：201506) 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="email" id="clazz" name="clazz" value="${user.clazz}" placeholder="${user.clazz}" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">性别</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <div id="gender" class="btn-group" data-toggle="buttons">
                                <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">

                                  <input type="radio" <c:if test="${user.gender eq '男'}">checked="checked"</c:if> name="gender" value="男"> &nbsp; Male &nbsp;
                                </label>
                                <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                  <input type="radio"<c:if test="${user.gender eq '女'}">checked="checked"</c:if>  name="gender" value="女"> Female
                                </label>
                              </div>
                            </div>

                          </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">民族</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="nation" value="${user.nation}" class="form-control col-md-7 col-xs-12" placeholder="${user.nation}">
                        </div>
                      </div>
                       <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">角色</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="form-control" name="role">
                            <option>预备党员</option>
                            <option>党员</option>
                          </select>
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">邮箱 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="email" id="email" value="${user.email}" name="email" placeholder="${user.email}" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">电话 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="tel" id="telephone" value="${user.phone}" placeholder="${user.phone}" name="phone" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
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