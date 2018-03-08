  <%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
   <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> 用户信息 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${path }/role/all.do">角色管理</a></li>
                      <li><a href="${path }/resource/all.do">资源管理</a></li>
                      <li><a href="${path }/user/all.do">所有用户</a></li>
                      <li><a href="${path }/user/all.do?type=党员">党员</a></li>
                      <li><a href="${path }/user/all.do?type=预备党员">预备党员</a></li>
                      <li><a href="${path }/user/all.do?type=入党积极分子">入党积极分子</a></li>
                    </ul>
                  </li>
                  <li><a ><i class="fa fa-edit"></i> 成绩管理<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${path }/announcement/all.do">所有公告</a></li>
                      
                    </ul>
                  </li>
                  
                  <li><a><i class="fa fa-table"></i> 心得管理<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="#">心得体会<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                          <li class="sub_menu"><a href="${path}/document/documentAllPage.do?type=心得体会">全部心得体会</a>
                          </li>
                          <li><a href="${path}/upload/index.do?type=心得体会">上传心得</a>
                          </li>
                        </ul>
                      </li>
                        <li><a href="#">思想汇报<span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="${path}/document/documentAllPage.do?type=思想汇报">全部</a>
                                </li>
                                <li><a href="${path}/upload/index.do?type=思想汇报">上传思想汇报</a>
                                </li>
                            </ul>
                        </li>
                        <li><a href="#">学习资料<span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="${path}/document/documentAllPage.do?type=学习资料">全部</a>
                            </li>
                                <li><a href="${path}/upload/index.do?type=学习资料">上传学习资料</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                  </li>
                  
                  
                </ul>
              </div>
              <div class="menu_section">
                
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-bug"></i> 新闻管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${path }/article/articleAllByPage.do">所有新闻</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-windows"></i> 发布讨论 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${path}/BBS/getAllTopic.do">所有话题</a></li>
                      
                    </ul>
                  </li>
                  <li><a><i class="fa fa-sitemap"></i> 公告管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="${path}/announcement/all.do">所有公告</a>
                        <li><a>Level One<span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                            <li class="sub_menu"><a href="level2.html">Level Two</a>
                            </li>
                            <li><a href="#level2_1">Level Two</a>
                            </li>
                            <li><a href="#level2_2">Level Two</a>
                            </li>
                          </ul>
                        </li>
                        <li><a href="${path}/announcement/addOrUpdate.do?up_jsp=6565232398984516126">发布公告</a>
                        </li>
                    </ul>
                  </li>                  
                  
                </ul>
              </div>

            </div>