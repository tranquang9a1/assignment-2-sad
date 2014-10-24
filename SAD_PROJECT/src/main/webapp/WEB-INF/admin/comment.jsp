<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: QuangTV
  Date: 10/23/2014
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="layout/header.jsp"/>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Comment Manage</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">


            <!-- /.panel-heading -->
            <div class="panel-body">
                <a href="listAllComment.do">Show all</a>
                <div class="table-responsive">
                    <table class="table table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>Comment ID</th>
                            <th>Description</th>
                            <th>Create Date</th>
                            <th>User ID</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sessionScope.Comment}" var="comment" varStatus="item" >
                            <tr class="even gradeC">
                                <td>${comment.commentID}</td>
                                <td>${comment.description}</td>
                                <td>
                                    <fmt:formatDate type="date" value="${comment.create_date}" />
                                </td>
                                <td>${comment.user.userID}</td>

                                <td class="center">
                                    <a href="deleteComment.do?commentID=${comment.commentID}" ><i class="glyphicon glyphicon-trash" style="float: left; margin-left: 20px; cursor: pointer;" title="Delete"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->

            </div>
            <!-- /.panel-body -->

            <!-- /.panel -->
        </div>

    </div>
    <!-- /.row -->
    <!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery Version 1.11.0 -->
<jsp:include page="layout/footer.jsp"/>

</body>

</html>

