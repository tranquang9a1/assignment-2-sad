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
<jsp:include page="WEB-INF/layout/header.jsp"/>

<!-- the middle contents -->
<div class="contents">
<section id="search-container">
    <div class="container">
        <div id="search-box">
            <h1>We currently have <strong>25,011</strong> job posts but only <strong>10,111</strong> applicants</h1>
            <form class="form-inline">
                <input type="text" class="btn-block" autofocus="autofocus" placeholder="Example: Software developer">
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
                            <option>€1000 - €5000</option>
                            <option>€5000 - €10000</option>
                            <option>€10000+</option>
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
                <table class="table table-striped">
                    <tbody>
                    <tr>
                        <td>
                            <p><a href="WEB-INF/job.html">Junior Applications Engineer</a> <small class="label label-success">Full time</small></p>
                            <p>Google Enterprises</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 20 Jan 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Berlin, Germany</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p><a href="WEB-INF/job.html">Senior Applications Engineer</a> <small class="label label-info">Freelance</small></p>
                            <p>Youtube</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 22 Jun 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Dresden, Germany</p>
                        </td>
                    </tr>
                    <tr class="featured">
                        <td>
                            <p><a href="WEB-INF/job.html">Software Engineer</a> <small class="label label-warning">Part time</small></p>
                            <p>Tesco Mall</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 01 Feb 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Amsterdam, Holland</p>
                        </td>
                    </tr>
                    <tr class="featured">
                        <td>
                            <p><a href="WEB-INF/job.html">Front-end Developer</a> <small class="label label-success">Full time</small></p>
                            <p>Apple inc.</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 15 May 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Bruge, Belgium</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p><a href="WEB-INF/job.html">Back-end Developer</a> <small class="label label-success">Full time</small></p>
                            <p>Air France</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 10 May 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Paris, France</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p><a href="WEB-INF/job.html">PHP Programmer</a> <small class="label label-warning">Part time</small></p>
                            <p>Wizz Air</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 25 Jan 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Oslo, Norway</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p><a href="WEB-INF/job.html">HMTL5/CSS3/JavaScript Coder</a> <small class="label label-info">Freelance</small></p>
                            <p>Small Agency</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 19 Mar 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Califonia, USA</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p><a href="WEB-INF/job.html">Java Programmer</a> <small class="label label-info">Freelance</small></p>
                            <p>Google Enterprises</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 08 Jul 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Berlin, Germany</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p><a href="WEB-INF/job.html">IOS Developer</a> <small class="label label-info">Freelance</small></p>
                            <p>6wunderers</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 11 Feb 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Frankfurt, Germany</p>
                        </td>
                    </tr>
                    <tr class="featured">
                        <td>
                            <p><a href="WEB-INF/job.html">C# .NET Developer</a> <small class="label label-info">Freelance</small></p>
                            <p>Microsoft Corp.</p>
                        </td>
                        <td class="job-location">
                            <p><i class="glyphicon glyphicon-calendar"></i> 22 Dec 2013</p>
                            <p><i class="glyphicon glyphicon-map-marker"></i> Cape Town, South Africa</p>
                        </td>
                    </tr>
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
<div class="clients">
    <div class="container">
        <img src="img/clients.png" alt="clients" class="img-responsive">
    </div>
</div>

<!-- the footer -->
<jsp:include page="WEB-INF/layout/footer.jsp"/>

</body>
</html>

