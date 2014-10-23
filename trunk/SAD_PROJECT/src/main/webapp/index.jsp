<<<<<<< .mine
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
=======
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
>>>>>>> .r24
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
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/custom.css" rel="stylesheet"/>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5shiv.js"></script>
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
<jsp:include page="WEB-INF/layout/header.jsp"/>

<!-- the middle contents -->
<div class="contents">
<section id="search-container">
    <div class="container">
        <div id="search-box">
            <h1>We currently have <strong>25,011</strong> job posts but only <strong>10,111</strong> applicants</h1>
            <form class="form-inline" action="search.do" method="GET" accept-charset="UTF-8">
                <input type="text" class="btn-block" name="search" autofocus="autofocus" placeholder="Example: Software developer">
            </form>
        </div>
    </div>
</section>
<section id="featured">
<div class="container">
<div class="row">
<div class="col-xs-12 col-md-3">
    <h3 class="sub-heading">Advance search</h3>

    <form role="form" action="/advanceSearchJob.do" method="post" enctype="application/x-www-form-urlencoded">
        <div class="form-group">
            <label>Job category</label>
            <select class="form-control input-lg" name="cbbCategory" id="cbbCategory">
                <option></option>
                <option value="1">Networking</option>
                <option value="2">Sales & Marketing</option>
                <option value="3">Teaching</option>
                <option value="4">Programming</option>
            </select>
        </div>
        <div class="form-group">
            <label>Location</label>
            <select class="form-control input-lg" id="cbbLocation" name="cbbLocation">
                <option></option>
                <option value="America">America</option>
                <option value="Europe">Europe</option>
                <option value="Africa">Africa</option>
                <option value="Asia">Asia</option>
                <option value="Oceanic">Oceanic</option>
            </select>
        </div>
        <div class="form-group">
            <label>Salary</label>
            <select class="form-control input-lg" id="cbbSalary" name="cbbSalary">
                <option></option>
                <option value="1">$500 - $2000</option>
                <option value="2">$2000 - $5000</option>
                <option value="3">$5000+</option>
            </select>
        </div>
        <br>
        <button type="submit" class="btn btn-primary input-lg btn-block">Search</button>
    </form>
</div>
<div class="col-xs-12 col-md-9">
<h3 class="sub-heading">
    Featured jobs
    <c:choose>
        <c:when test="${requestScope.LIST_JOB.size() == 0}">
            <span class="pull-right"><small>0 results</small></span>
        </c:when>
        <c:when test="${requestScope.LIST_JOB.size() < 20}">
            <span class="pull-right"><small>1 - ${requestScope.LIST_JOB.size()} results</small></span>
        </c:when>
        <c:otherwise>
            <span class="pull-right"><small>1 - 20 results</small></span>
        </c:otherwise>
    </c:choose>
</h3>
<table id="tblData" class="table table-striped">
    <tbody>
    <c:set var="list" value="${requestScope.LIST_JOB}"></c:set>
    <c:set var="i" value="1"></c:set>
    <c:forEach var="job" items="${list}">
        <c:if test="${i%3 == 0}">
            <tr>
                <td>
                    <p><a href="WEB-INF/job.html">${job.jobName}</a>
                        <small class="label label-success">Full time</small>
                    </p>
                    <p>${job.username}</p>
                </td>
                <td class="job-location">
                    <p><i class="glyphicon glyphicon-calendar"></i>${job.deadline}</p>
                    <p><i class="glyphicon glyphicon-map-marker"></i>${job.address}</p>
                </td>
            </tr>
        </c:if>
        <c:if test="${i%3 == 1}">
            <tr>
                <td>
                    <p><a href="WEB-INF/job.html">${job.jobName}</a>
                        <small class="label label-warning">Part time</small>
                    </p>
                    <p>${job.username}</p>
                </td>
                <td class="job-location">
                    <p><i class="glyphicon glyphicon-calendar"></i>${job.deadline}</p>

                    <p><i class="glyphicon glyphicon-map-marker"></i>${job.address}</p>
                </td>
            </tr>
        </c:if>
        <c:if test="${i%3 == 2}">
            <tr>
                <td>
                    <p><a href="WEB-INF/job.html">${job.jobName}</a>
                        <small class="label label-info">Freelance</small>
                    </p>
                    <p>${job.username}</p>
                </td>
                <td class="job-location">
                    <p><i class="glyphicon glyphicon-calendar"></i>${job.deadline}</p>
                    <p><i class="glyphicon glyphicon-map-marker"></i>${job.address}</p>
                </td>
            </tr>
        </c:if>
        <c:set var="i" value="${i+1}"></c:set>
    </c:forEach>
    </tbody>
</table>
<div class="pull-right">
    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>
        <li class="active"><span>1</span></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
    </ul>
</div>
</div>
</div>
</div>
</section>
</div>
<!-- /.contents -->

<!-- the botom client image -->

<!-- the footer -->

<jsp:include page="WEB-INF/layout/footer.jsp"/>
<script type="text/javascript" src="js/index/index.js"></script>
</body>
</html>

