<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=utf-8"%>
<%@ include file="/common/dtd.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>党员管理系统</title>
    <link href="${path}/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/css/style.css">
    <link rel="stylesheet" href="${path}/css/download.css">
</head>
<body >
<%@include file="../common/nav.jsp"%>

<div class="row">
    <div class="col-md-11" style="margin-left: 3%">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                    <input type="checkbox"  name="allChecked" onchange="Do_Check()" class="flat">
                </th>
                <th >资料内容</th>
                <th >上传人 </th>
                <th >上传日期</th>
                <th ><span class="nobr">操作</span>
                </th>

            </tr>
            </thead>

            <tbody>
            <c:forEach var="p" items="${docs.list}" >
            <tr >
                <td >
                    <input type="checkbox" class="flat" name="table_records">
                </td>
                <td class=" "><a href="#">${p.name}</a></td>
                <td class=" ">${p.publisher.username}</td>
                <td class=" "><fmt:formatDate value="${p.createDate}" pattern="yyyy-MM-dd"/></td>
                <td class=" "><button class="btn btn-danger"><a href="${path}/uploads/study/${p.name}" >下载</a></button>
                </td>
            </tr></c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
<script>
    function Do_Check()
    {
        var ch=document.getElementsByName("table_records");
        console.log(document.getElementsByName("allChecked")[0].checked);
        if(document.getElementsByName("allChecked")[0].checked==true)
        {
            for(var i=0;i<ch.length;i++)
            {
                ch[i].checked=true;
            }
        }
        else{
            for(var i=0;i<ch.length;i++)
            {
                ch[i].checked=false;
            }
        }
    }
</script>
<script src="${path}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${path}/js/bootstrap.min.js"></script>
</html>