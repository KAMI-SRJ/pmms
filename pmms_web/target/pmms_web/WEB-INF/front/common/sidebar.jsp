  <%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
  <div class="col-md-2">
      <div class="img">
          <img src="http://jiaowu.sicau.edu.cn/photo/${user.sno}.jpg" width="150px" height="150px" alt="">
      </div>
      <div class="text">
          <a href="#">修改头像</a>
      </div>
      <ul id="main-nav" class="nav nav-stacked" >
          <li >
              <a href="${path}/front/user/userDetails.do">基本信息</a>
          </li>
          <li>
              <a href="${path}/front/document/documentAllPage.do?publisher=${user.username}&type=心得体会"></i>
                  心得体会</a>
          </li>
          <li>
              <a href="${path}/front/document/documentAllPage.do?publisher=${user.username}&type=思想汇报"></i>
                  思想汇报</a>
          </li>
          <li>
              <a href="${path}/front/user/modifyPassword.do"></i>
                  密码修改</a>
          </li>
          <li>
              <a href="${path}/front/BBS/getAllTopic.do?publisher=${user.sno}"></i>
                  参与话题</a>
          </li>
          <li>
              <a href="${path}/user/all.do"></i>
                  管理</a>
          </li>
          <li>
              <a href="${path}/login/logout.do"></i>
                  退出登录</a>
          </li>
      </ul>
  </div>