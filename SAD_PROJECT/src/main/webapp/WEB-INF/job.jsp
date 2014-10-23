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
                <div class="col-xs-12 col-md-3">
                    <h3 class="sub-heading">About Google</h3>
                    <p><strong>Google Enterprises</strong></p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum at augue metus, at aliquam leo. Nam ac justo nisl. Ut non orci odio. Praesent lobortis blandit lacus et consectetur. Etiam ac sagittis tortor. Vestibulum vestibulum sem nec purus congue cursus. Sed bibendum lectus id tellus egestas sit amet interdum leo fringilla. Fusce dictum neque ut massa facilisis nec mattis erat blandit. In vel vestibulum massa.</p>
                    <p><a href="">company website &rarr;</a></p>
                </div>
                <c:set var="job" value="${sessionScope.SINGLEJOB}" />
                <div class="col-xs-12 col-md-9">
                    <h3 class="sub-heading">Job detail <span class="pull-right"><small><a href="index.jsp">&larr; All Jobs</a></small></span></h3>
                    <div class="content-inner-detail">
                        <h1 class="sub-heading">${job.jobName}</h1>
                        <p><i class="glyphicon glyphicon-calendar"></i> ${job.create_date} | <i class="glyphicon glyphicon-map-marker"></i> ${job.address} | <span class="label label-success">Freelance</span></p>
                        <hr>
                        <legend>Overview</legend>
                        ${job.jobDescription}
                        <legend>Requirement</legend>
                        ${job.jobRequirement}
                        <legend>Comment</legend>
                        <c:if test="${not empty sessionScope.LISTCOMMENT}">
                            <c:forEach var="comment" items="${sessionScope.LISTCOMMENT}" varStatus="item">
                                <h3>User:</h3> ${comment.user.username}<br./>
                                <h4>Content: </h4>${comment.description}<br/>
                                <h5>At: </h5>${comment.create_date}

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


