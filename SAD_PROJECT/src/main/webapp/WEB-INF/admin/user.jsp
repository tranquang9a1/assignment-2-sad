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
            <h1 class="page-header">User Manage</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">


            <!-- /.panel-heading -->
            <div class="panel-body">
                <a href="listAllUser.do">Show all</a>
                <a href="adminuser.do">Today</a>

                <div class="table-responsive">
                    <table class="table table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>Age</th>
                            <th>Sex</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Avatar</th>
                            <th>Description</th>
                            <th>Create Date</th>
                            <th>Admin</th>
                            <th>Password</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.User}" var="userInfo" varStatus="item" >
                                <tr class="even gradeC">
                                    <td>${userInfo.userID}</td>
                                    <td>${userInfo.username}</td>
                                    <td>${userInfo.age}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${userInfo.sex == true}">
                                                Nam
                                            </c:when>
                                            <c:otherwise>
                                                Nu
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${userInfo.email}</td>
                                    <td>${userInfo.address}</td>
                                    <td>${userInfo.avatar}</td>
                                    <td>${userInfo.description}</td>
                                    <td>
                                        <fmt:formatDate type="date" value="${userInfo.create_date}" />
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${userInfo.isAdmin == true}">
                                                Admin
                                            </c:when>
                                            <c:otherwise>
                                                User
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${userInfo.password}</td>
                                    <td class="center">
                                        <c:if test="${userInfo.isAdmin == false}">
                                            <a href="changeRole.do?userID=${userInfo.userID}">Set Admin</a>
                                            <a href="deleteUser.do?userID=${userInfo.userID}"><i class="glyphicon glyphicon-trash" style="float: left; margin-left: 20px; cursor: pointer;" title="Delete"></i></a>
                                        </c:if>
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

