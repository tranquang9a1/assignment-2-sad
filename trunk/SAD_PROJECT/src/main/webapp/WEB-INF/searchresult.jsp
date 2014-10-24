<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Job Portal</title>

    <!-- styles -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/custom.css" rel="stylesheet" />

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5shiv.js"></script>
    <![endif]-->

    <!-- fav and touch icons -->
    <link rel="shortcut icon" href="#" />
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="#" />
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="#" />
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="#" />
    <link rel="apple-touch-icon-precomposed" href="#" />

</head>

<body>

<!-- the top head -->
<jsp:include page="layout/header.jsp"/>

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
                    <form>
                        <div class="form-group">
                            <label>Job category</label>
                            <select class="form-control input-lg">
                                <option>Networking</option>
                                <option>Sales &amp; Marketing</option>
                                <option>Teaching</option>
                                <option>Programming</option>
                            </select>
                            <small class="help-block">Help text for job seeker.</small>
                        </div>
                        <div class="form-group">
                            <label>Location</label>
                            <select class="form-control input-lg">
                                <option>America</option>
                                <option>Europe</option>
                                <option>Africa</option>
                                <option>Asia</option>
                                <option>Oceanic</option>
                            </select>
                            <small class="help-block"></small>
                        </div>
                        <div class="form-group">
                            <label>Salary</label>
                            <select class="form-control input-lg">
                                <option>$1000 - $5000</option>
                                <option>$5000 - $10000</option>
                                <option>$10000+</option>
                            </select>
                            <small class="help-block"></small>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Freelance
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Contract
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Full time
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Part time
                                    </label>
                                </div>
                            </div>
                        </div>
                        <br>
                        <button type="submit" class="btn btn-primary input-lg btn-block">Search</button>
                    </form>
                </div>
                <div class="col-xs-12 col-md-9">
                    <h3 class="sub-heading">
                        Featured jobs
                        <span class="pull-right"><small>1 - 20 results</small></span>
                    </h3>
                    <table id="tblData" class="table table-striped">
                        <tbody>
                        <c:forEach var="job" items="${requestScope.LISTJOB}" varStatus="item">
                            <tr>
                                <td>
                                    <p><a href="job.do?id=${job.jobID}">${job.jobName}</a> <small class="label label-success">${job.jobName}</small></p>
                                    <p>${job.jobRequirement}</p>
                                </td>
                                <td class="job-location">
                                    <p><i class="glyphicon glyphicon-calendar"></i> ${job.create_date}</p>
                                    <p><i class="glyphicon glyphicon-map-marker"></i> ${job.address}</p>
                                </td>
                            </tr>
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
</div><!-- /.contents -->

<!-- the botom client image -->

<!-- the footer -->

<jsp:include page="layout/footer.jsp"/>
</body>
</html>

