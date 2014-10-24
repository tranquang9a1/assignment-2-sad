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
<head>
    <meta charset="utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Job Portal</title>

    <!-- styles -->
    <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/custom.css" rel="stylesheet"/>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../js/html5shiv.js"></script>
    <![endif]-->

    <!-- fav and touch icons -->
    <link rel="shortcut icon" href="#"/>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="#"/>
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="#"/>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="#"/>
    <link rel="apple-touch-icon-precomposed" href="#"/>

</head>
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
                <c:set var="userInfo" value="${requestScope.USER_INFO}"/>
                <div class="col-xs-12 col-md-9">
                    <h2 class="sub-heading" style="color: green">User's information<span class="pull-right"><small><a
                            href="/index.do">&larr;
                        Back</a></small></span></h2>
                    <div class="form-group">

                        <h1 class="sub-heading"><strong style="color: #222222"><img src="${userInfo.avatar}"
                                                                                    style="height: 100px; width: 100px"> ${userInfo.username}
                        </strong></h1>

                        <p><i class="glyphicon glyphicon-calendar"></i> ${userInfo.create_date}</p>
                        <hr>
                        <h3 style="color: #222222"><strong>Age</strong></h3>
                        ${userInfo.age}
                        </br>
                        <h3 style="color: #222222"><strong>Sex</strong></h3>
                        <c:choose>
                            <c:when test="${userInfo.sex}">Male</c:when>
                            <c:otherwise>Female</c:otherwise>
                        </c:choose>
                        </br>
                        <h3 style="color: #222222"><strong>Email</strong></h3>
                        ${userInfo.email}
                        </br>
                        <h3 style="color: #222222"><strong>Description</strong></h3>
                        ${userInfo.description}
                        </br>
                        <h3 style="color: #222222"><strong>Skill</strong></h3>
                        <%--<c:set var="listSkill" value="${user.skills}"/>
                        <<c:if test="${listSkill.size() > 0}">
                        <c:forEach var="skill" items="${user.skills}">${skill.skillName},&nbsp</c:forEach>
                        <</c:if>--%>

                        <c:set var="flag1" value=""/>
                        <c:set var="flag2" value=""/>
                        <c:set var="flag3" value=""/>
                        <c:set var="flag4" value=""/>
                        <c:set var="flag5" value=""/>
                        <c:forEach items="${requestScope.USER_INFO.skills}" var="skill">
                            <c:if test="${skill.skillID == 1}">
                                <c:set var="flag1" value="checked"/>
                            </c:if>
                            <c:if test="${skill.skillID == 2}">
                                <c:set var="flag2" value="checked"/>
                            </c:if>
                            <c:if test="${skill.skillID == 3}">
                                <c:set var="flag3" value="checked"/>
                            </c:if>
                            <c:if test="${skill.skillID == 4}">
                                <c:set var="flag4" value="checked"/>
                            </c:if>
                            <c:if test="${skill.skillID == 5}">
                                <c:set var="flag5" value="checked"/>
                            </c:if>
                        </c:forEach>
                        <input type="checkbox" id="cbSkill1" name="cbSkill" disabled="disabled" value="1" ${flag1}>Java &nbsp;&nbsp;
                        <input type="checkbox" id="cbSkill2" name="cbSkill" disabled="disabled" value="2" ${flag2}>.Net &nbsp;&nbsp;
                        <input type="checkbox" id="cbSkill3" name="cbSkill" disabled="disabled" value="3" ${flag3}>PHP &nbsp;&nbsp;
                        <input type="checkbox" id="cbSkill4" name="cbSkill" disabled="disabled" value="4" ${flag4}>Javascript & css
                        &nbsp;&nbsp;
                        <input type="checkbox" id="cbSkill5" name="cbSkill" disabled="disabled" value="5" ${flag5}>Mobile
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


