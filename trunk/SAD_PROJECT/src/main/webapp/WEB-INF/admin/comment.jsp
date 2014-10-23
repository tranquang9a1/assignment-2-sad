<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QuangTV
  Date: 10/23/2014
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
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
                    <div class="table-responsive">
                        <table class="table table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Job Name</th>
                                <th>Comment</th>
                                <th>User</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.Comment}" var="comment" varStatus="item">

                                <tr class="even gradeC">
                                    <td>${comment.commentID}</td>
                                    <td></td>
                                    <td>${comment.description}</td>
                                    <td class="center">${comment.user.username}</td>
                                    <td class="center">
                                        <a href="#" ><i class="glyphicon glyphicon-ok-sign" style="float: left; margin-left: 10px; cursor: pointer;" title="Approve"></i></a>
                                        <a href="#" ><i class="glyphicon glyphicon-trash" style="float: left; margin-left: 20px; cursor: pointer;" title="Delete"></i></a>
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
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <jsp:include page="layout/footer.jsp"/>
</div>
</body>

</html>

