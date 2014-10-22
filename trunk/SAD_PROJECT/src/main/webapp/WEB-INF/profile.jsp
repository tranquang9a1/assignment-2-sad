<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<body>

<!-- the top head -->
<jsp:include page="layout/header.jsp"/>

<!-- the middle contents -->
<div class="contents">
    <section class="access">
        <br>

        <div class="container">
            <div class="container-fluid">
                <form role="form" action="/editProfile.do" method="post" enctype="application/x-www-form-urlencoded">
                    <legend style="color: green"><strong>User's information</strong></legend>
                    <div class="col-lg-12">
                        <div class="col-lg-4 form-group">
                            <c:if test="${requestScope.CHANGE_SUCCESS}">
                                <label id="txtSuccess" style="color: green">Your password is changed
                                    successfully!</label>
                            </c:if>
                            <c:if test="${requestScope.EDIT_SUCCESS}">
                                <label id="txtSuccess" style="color: green">Your profile is changed
                                    successfully!</label>
                            </c:if>
                            <div class="col-lg-12 form-group">
                                <div class="col-lg-3">
                                </div>
                                <img src="${sessionScope.user.avatar}" id="imgAvatar" name="imgAvatar"
                                     style="width: 150px; height: 150px" class="img-rounded">
                            </div>
                            <label for="txtImg">Avatar's link: </label>
                            <input type="text" value="${sessionScope.user.avatar}" maxlength="100"
                                   class="form-control input-lg" id="txtImg" placeholder="Image's link" name="txtImg">
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-4 form-group">
                            <label for="txtUser">Username: </label>
                            <input type="text" value="${sessionScope.user.username}" disabled="true" maxlength="25"
                                   required="true" class="form-control input-lg" id="txtUser" placeholder="Username"
                                   name="txtUsername">
                        </div>
                        <div class="col-lg-1">
                        </div>
                        <div class="col-lg-4 form-group">
                            <label for="sbAge">Age: </label>
                            <input type="number" class="form-control input-lg" value="${sessionScope.user.age}"
                                   name="sbAge" max="65" min="18" id="sbAge">
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-4">
                            <label for="txtEmail">Email address: </label>
                            <input type="email" value="${sessionScope.user.email}" maxlength="30" required="true"
                                   class="form-control input-lg" id="txtEmail" placeholder="Your email" name="txtEmail">
                        </div>
                        <div class="col-lg-1"></div>
                        <div class="col-lg-4 form-group">
                            <label for="cbbSex">Sex:</label>
                            <select class="form-control input-lg" id="cbbSex" name="cbbSex">
                                <c:choose>
                                    <c:when test="${sessionScope.user.sex}">
                                        <option selected=selected value="true">Male</option>
                                        <option value="false">Female</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="true">Male</option>
                                        <option selected=selected value="false">Female</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-4 form-group">
                            <label for="txtAddress">Address:</label>
                            <textarea name="txtAddress" id="txtAddress" maxlength="150" class="form-control input-lg"
                                      placeholder="Your address">${sessionScope.user.address}</textarea>
                        </div>
                        <div class="col-lg-1">
                        </div>
                        <div class="col-lg-7 form-group">
                            <label for="txtDescription">Description:</label>
                            <textarea name="txtDescription" id="txtDescription" maxlength="2000"
                                      class="form-control input-lg"
                                      placeholder="Description about yourself">${sessionScope.user.description}</textarea>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-4 form-group">
                            <label for="txtCreateDate">Create date:</label>
                            <input type="datetime" value="${sessionScope.user.create_date}" disabled="true"
                                   class="form-control input-lg" id="txtCreateDate" name="txtCreateDate">
                        </div>
                        <div class="col-lg-1">
                        </div>
                        <div class="col-lg-7 form-group">
                            <label id="lbSkill">Skill:</label></br>
                            <c:set var="flag1" value=""></c:set>
                            <c:set var="flag2" value=""></c:set>
                            <c:set var="flag3" value=""></c:set>
                            <c:set var="flag4" value=""></c:set>
                            <c:set var="flag5" value=""></c:set>
                            <c:forEach items="${sessionScope.user.skills}" var="skill">
                                <c:if test="${skill.skillID == 1}">
                                    <c:set var="flag1" value="checked"></c:set>
                                </c:if>
                                <c:if test="${skill.skillID == 2}">
                                    <c:set var="flag2" value="checked"></c:set>
                                </c:if>
                                <c:if test="${skill.skillID == 3}">
                                    <c:set var="flag3" value="checked"></c:set>
                                </c:if>
                                <c:if test="${skill.skillID == 4}">
                                    <c:set var="flag4" value="checked"></c:set>
                                </c:if>
                                <c:if test="${skill.skillID == 5}">
                                    <c:set var="flag5" value="checked"></c:set>
                                </c:if>
                            </c:forEach>
                            <input type="checkbox" id="cbSkill1" name="cbSkill" value="1" ${flag1}>Java &nbsp;&nbsp;
                            <input type="checkbox" id="cbSkill2" name="cbSkill" value="2" ${flag2}>.Net &nbsp;&nbsp;
                            <input type="checkbox" id="cbSkill3" name="cbSkill" value="3" ${flag3}>PHP &nbsp;&nbsp;
                            <input type="checkbox" id="cbSkill4" name="cbSkill" value="4" ${flag4}>Javascript & css
                            &nbsp;&nbsp;
                            <input type="checkbox" id="cbSkill5" name="cbSkill" value="5" ${flag5}>Mobile
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-9"></div>
                        <div class="col-lg-3 form-group">
                            <a href="/changePassPage.do" style="font-size: 20pt"><strong>Change password</strong></a>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary input-lg btn-block">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>
<!-- /.contents -->

<!-- the botom client image -->
<div class="clients">
    <div class="container">
        <img src="../img/clients.png" alt="clients" class="img-responsive">
    </div>
</div>

<!-- the footer -->
<jsp:include page="layout/footer.jsp"/>
</body>
</html>

