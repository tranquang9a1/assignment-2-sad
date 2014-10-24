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
                    <a href="adminjob.do">Today</a>
                    <form action="searchjob.do" method="post">
                        <input type="text" name="txtJobName" placeholder="Search..."/>
                        <button type="submit" name="btnSearch">Search</button>
                    </form>
                    <div class="table-responsive">
                        <table class="table table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>Job ID</th>
                                <th>Job Name</th>
                                <th >Job Description</th>
                                <th >Jop Requirement</th>
                                <th >Address</th>
                                <th >Salary</th>
                                <th >Number Recruit</th>
                                <th >Status</th>
                                <th >Create Date</th>
                                <th >Deadline</th>
                                <th >User ID</th>
                                <th >User name</th>
                                <th >Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.Job}" var="job" varStatus="item" >
                                <tr class="even gradeC">
                                    <td  >${job.jobID}</td>
                                    <td  >${job.jobName}</td>
                                    <td  >${job.jobDescription}</td>
                                    <td  >${job.jobRequirement}</td>
                                    <td  >${job.address}</td>
                                    <td  >${job.salary}</td>
                                    <td  >${job.numberUser}</td>
                                    <td  >
                                        <c:choose>
                                            <c:when test="${job.status}">
                                                Approved
                                            </c:when>
                                            <c:otherwise>
                                                <a href="changeStatus.do?jobID=${job.jobID}">Approve</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td  >
                                        <fmt:formatDate type="date" value="${job.create_date}" />
                                    </td  >
                                    <td  >
                                        <fmt:formatDate type="date" value="${job.deadline}" />
                                    </td>
                                    <td  >${job.userID}</td>
                                    <td  >${job.username}</td>
                                    <td class="center">
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

