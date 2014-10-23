<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h1 class="page-header">Job Manage</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">


                <!-- /.panel-heading -->
                <div class="panel-body">
                    <a href="listAllJob.do">Show all</a>
                    <div class="table-responsive">
                        <table class="table table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Job Name</th>
                                <th>Job Description</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.Job}" var="job" varStatus="item" >
                                <tr class="even gradeC">
                                    <td>${job.jobID}</td>
                                    <td>${job.jobName}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${job.status}">
                                                da
                                            </c:when>
                                            <c:otherwise>
                                                Chua
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="center">${job.userID}</td>
                                    <td class="center">
                                        <c:if test="${job.status == false}">
                                            <a href="changeStatus.do?jobID=${job.jobID}" ><i class="glyphicon glyphicon-ok-sign" style="float: left; margin-left: 10px; cursor: pointer;" title="Approve"></i></a>
                                        </c:if>
                                        <a href="deleteJob.do?jobID=${job.jobID}" ><i class="glyphicon glyphicon-trash" style="float: left; margin-left: 20px; cursor: pointer;" title="Delete"></i></a>
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

