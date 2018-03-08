<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                   <img src="http://jiaowu.sicau.edu.cn/photo/${user.sno}.jpg" alt=""> ${user.username}
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="${path}/user/userDetails.do?id=${user.id}"> 个人信息</a></li>
                      <li><a href="${path }/front/user/userDetails.do">前台</a></li>
                    <li><a href="${path }/login/logout.do">退出</a></li>
                    <li><a href="${path }/login/index.do"><i class="fa fa-sign-out pull-right"></i> 登录</a></li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>