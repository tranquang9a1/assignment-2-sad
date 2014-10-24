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
                <div class="col-xs-12 col-md-1">
                </div>
                <c:set var="user" value="${requestScope.USER_INFO}"/>
                <div class="col-xs-12 col-md-9">
                    <h2 class="sub-heading" style="color: green">User's information<span class="pull-right"><small><a
                            href="/index.do">&larr;
                        Back</a></small></span></h2>
                    <div class="form-group">

                        <h1 class="sub-heading"><strong style="color: #222222"><img src="${user.avatar}"
                                                                                    style="height: 100px; width: 100px"> ${user.username}
                        </strong></h1>

                        <p><i class="glyphicon glyphicon-calendar"></i> ${user.create_date}</p>
                        <hr>
                        <h3 style="color: #222222"><strong>Age</strong></h3>
                        ${user.age}
                        </br>
                        <h3 style="color: #222222"><strong>Sex</strong></h3>
                        <c:choose>
                            <c:when test="${user.sex}">Male</c:when>
                            <c:otherwise>Female</c:otherwise>
                        </c:choose>
                        </br>
                        <h3 style="color: #222222"><strong>Email</strong></h3>
                        ${user.email}
                        </br>
                        <h3 style="color: #222222"><strong>Description</strong></h3>
                        ${user.description}
                        </br>
                        <h3 style="color: #222222"><strong>Skill</strong></h3>
                        <%--<c:set var="listSkill" value="${user.skills}"/>
                        <<c:if test="${listSkill.size() > 0}">
                        <c:forEach var="skill" items="${user.skills}">${skill.skillName},&nbsp</c:forEach>
                        <</c:if>--%>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- /.contents -->

<jsp:include page="layout/footer.jsp"/>


</body>
</html>


