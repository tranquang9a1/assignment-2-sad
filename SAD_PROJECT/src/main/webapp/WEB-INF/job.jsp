<%--
  Created by IntelliJ IDEA.
  User: QuangTV
  Date: 10/23/2014
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="layout/header.jsp"/>
<!-- /.navbar -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- the middle contents -->
<div class="contents">
    <section id="job">
        <div class="container">
            <div class="row">
                <c:set var="job" value="${sessionScope.SINGLEJOB}" />
                <div class="col-xs-12 col-md-9">
                    <h3 class="sub-heading">Job detail <span class="pull-right"><small><a href="index.jsp">&larr; All Jobs</a></small></span></h3>
                    <div class="content-inner-detail">
                        <h1 class="sub-heading">${job.jobName}</h1>
                        <p><i class="glyphicon glyphicon-calendar"></i> ${job.create_date} | <i class="glyphicon glyphicon-map-marker"></i> ${job.address} | <span class="label label-success">Freelance</span></p>
                        <hr>
                        <legend>Overview</legend>
                        ${job.jobDescription}
                        <li>
                            <ul>Number: ${job.numberUser}</ul>
                        </li>
                        <li><ul>Salary: ${job.salary}</ul></li>
                        <li><ul>Deadline: ${job.deadline}</ul></li>
                        <legend>Requirement</legend>
                        ${job.jobRequirement}
                        <legend>Comment</legend>
                        <c:if test="${not empty sessionScope.LISTCOMMENT}">
                            <c:forEach var="comment" items="${sessionScope.LISTCOMMENT}" varStatus="item">

                                <img src="${comment.user.avatar}" style="width: 100px; height: 100px; display: inline;"/>

                                <h5 style="display: inline;">User: ${comment.user.username}<br/>
                                At: ${comment.create_date}<br/>
                                Content: ${comment.description}</h5>
                                <hr/>

                            </c:forEach>

                        </c:if>


                        <legend>Apply</legend>
                        <form action="comment.do" method="POST" accept-charset="UTF-8">
                            <div class="form-group">
                                <label>Message to company</label>
                                <textarea rows="3" name="content" class="form-control"></textarea>
                            </div>
                            <input type="hidden" name="username" id="username" value="${sessionScope.user.username}"/>
                            <input type="hidden" name="userID" id="userID" value="${sessionScope.user.userID}"/>
                            <input type="hidden" name="idtopic" id="idtopic" value="${job.jobID}"/>

                            <br>
                            <button type="submit" class="btn btn-primary input-lg">Submit</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </section>
</div><!-- /.contents -->

<jsp:include page="layout/footer.jsp"/>


</body>
</html>


