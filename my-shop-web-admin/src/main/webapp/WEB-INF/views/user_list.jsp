<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 用户管理</title>
    <jsp:include page="../includes/hearder.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">


<div class="wrapper">


    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">

            <div class="col-xs-12">
                <c:if test="${baseResult != null}">
                    <div class="alert alert-${baseResult.code == 200 ? "success":"danger"} alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <h4><i class="icon fa fa-${baseResult.code == 200 ? "check":"ban"}"></i> Alert!</h4>
                            ${baseResult.message}
                    </div>
                </c:if>
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">用户列表</h3>

                        <div class="box-tools" style="padding-top: 10px; padding-right: 12px" align="right">
                            <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i>&nbsp;&nbsp;新增</a>
                            &nbsp;&nbsp;&nbsp;
                            <button  type="button" class="btn btn-sm btn-default" onclick="App.deleteMulti('/user/delete');"><i
                                    class="fa fa-trash"></i>&nbsp;&nbsp;删除</button>
                            &nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i
                                    class="fa fa-sign-in"></i>&nbsp;&nbsp;导入</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i
                                    class="fa fa-sign-out"></i>&nbsp;&nbsp;导出</a>
                        </div>

                        <div class="row" style="margin-top: 40px">
                            <form:form cssClass="form-horizontal" action="/user/search" method="post"
                                       modelAttribute="tbUser">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label for="email" class="col-sm-3 control-label">邮箱</label>
                                            <div class="col-sm-8">
                                                <form:input path="email" cssClass="form-control" placeholder="邮箱"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label for="username" class="col-sm-3 control-label">姓名</label>
                                            <div class="col-sm-8">
                                                <form:input path="username" cssClass="form-control" placeholder="姓名"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-3">
                                        <div class="form-group">
                                            <label for="phone" class="col-sm-3 control-label">手机</label>
                                            <div class="col-sm-8">
                                                <form:input path="phone" cssClass="form-control" placeholder="手机"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-2">
                                        <button type="submit" class="btn btn-info"><i
                                                class="fa fa-search"></i> &nbsp;&nbsp;&nbsp;搜索
                                        </button>
                                    </div>
                                </div>
                            </form:form>
                        </div>

                    </div>
                    <!-- /.box-header -->
                    <div class="box-body table-responsive no-padding" style="text-align: center;">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th style="text-align: center;"><input type="checkbox" class="minimal check_master"/>
                                </th>
                                <th style="text-align: center;">ID</th>
                                <th style="text-align: center;"> 用户名</th>
                                <th style="text-align: center;">邮箱</th>
                                <th style="text-align: center;">手机号</th>
                                <th style="text-align: center;">更新时间</th>
                                <th style="text-align: center;">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td><input id="${user.id}" type="checkbox" class="minimal"/></td>
                                    <td>${user.id}</td>
                                    <td>${user.username}</td>
                                    <td>${user.email}</td>
                                    <td>${user.phone}</td>
                                    <td><fmt:formatDate value="${user.update}" pattern="yyyy-MM-dd"/></td>
                                    <td>
                                        <a href="#" type="button" class="btn btn-sm btn-default"><i
                                                class="fa fa-search"></i>&nbsp;&nbsp;查看</a>&nbsp;&nbsp;&nbsp;
                                        <a href="#" type="button" class="btn btn-sm btn-primary"><i
                                                class="fa fa-edit"></i>&nbsp;&nbsp;编辑</a>&nbsp;&nbsp;&nbsp;
                                        <a href="#" type="button" class="btn btn-sm btn-danger"><i
                                                class="fa fa-trash"></i>&nbsp;&nbsp;删除</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </section>

    </div>
    <jsp:include page="../includes/copyright.jsp"/>

</div>


<jsp:include page="../includes/footer.jsp"/>

<sys:modal/>


<%--<script>--%>
<%--    var idList = new Array();--%>

<%--    /**--%>
<%--     * 批量删除--%>
<%--     */--%>
<%--    function deleteAllCheck() {--%>
<%--        //选中的元素--%>
<%--        var _checkbox = App.getCheckbox();--%>

<%--        _checkbox.each(function () {--%>
<%--            var _id = $(this).attr("id");--%>
<%--            if (_id != null && _id != "undefine" && $(this).is(":checked")) {--%>
<%--                idList.push(_id);--%>
<%--            }--%>
<%--        })--%>
<%--        if (idList.length === 0) {--%>
<%--            $("#modal-message").html("请至少选择一项进行删除...");--%>
<%--        }else{--%>
<%--            $("#modal-message").html("确定删除数据？");--%>
<%--        }--%>
<%--        $("#modal-default").modal("show");--%>
<%--    }--%>

<%--    $(function () {--%>
<%--        $("#btnFalse").bind("click", function () {--%>
<%--            idList = [];--%>
<%--        });--%>

<%--        $("#btnModalOk").bind("click", function () {--%>
<%--            del(idList,"/user/delete");--%>
<%--        });--%>

<%--        function del(params, url) {--%>
<%--            if (params.length === 0) {--%>
<%--                $("#modal-default").modal("hide");--%>
<%--            }else{--%>
<%--               $.ajax({--%>
<%--                   "url":url,--%>
<%--                   "type":"post",--%>
<%--                   "data":{"ids":idList.toString()},--%>
<%--                   "dataType":"json",--%>
<%--                   "success": function (data) {--%>
<%--                       console.log(data);--%>
<%--                   }--%>
<%--               });--%>
<%--            }--%>
<%--        }--%>
<%--    });--%>


<%--</script>--%>

</body>
</html>
