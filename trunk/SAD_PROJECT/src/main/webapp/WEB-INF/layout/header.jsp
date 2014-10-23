<head>
    <meta charset="utf-8" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Job Portal</title>

    <!-- styles -->
    <link href="../css/bootstrap.min.css" rel="stylesheet" />
    <link href="../css/custom.css" rel="stylesheet" />

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../js/html5shiv.js"></script>
    <![endif]-->

    <!-- fav and touch icons -->
    <link rel="shortcut icon" href="#" />
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="#" />
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="#" />
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="#" />
    <link rel="apple-touch-icon-precomposed" href="#" />

</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- the top head -->
<div class="navbar navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- Be sure to leave the brand out there if you want it shown -->
            <a class="navbar-brand" href="/index.do">Job Portal</a>
        </div>

        <!-- post or upload cv -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <div class="navbar-left">
                <a href="/findAllJob.do" class="btn btn-default navbar-btn">Browse all jobs &raquo;</a>
                <a href="/addJob.do" class="btn btn-warning navbar-btn">Post a job &raquo;</a>
            </div>
            <!-- the menu -->

            <div class="navbar-right">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <a href="/profile.do" class="navbar-header" style="padding-top: 8px;padding-right: 15px;font-size: 20px;color: white;">
                            <strong>Welcome "${sessionScope.user.username}" <img src="${sessionScope.user.avatar}" style="height: 30px; width: 30px"> </strong></a>
                        <a href="/logout.do" class="btn btn-warning navbar-btn">Log out</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/signin.do" class="btn btn-default navbar-btn">Sign in</a>
                        <a href="/signup.do" class="btn btn-warning navbar-btn">Sign up</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div><!-- /.container -->
</div>
<!-- /.navbar -->