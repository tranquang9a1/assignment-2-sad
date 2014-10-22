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

<body>

<!-- the top head -->
<jsp:include page="layout/header.jsp"/>
<!-- the middle contents -->
<div class="contents">
    <section class="access">
        <br>
        <div class="container">
            <div class="content-inner-detail">
                <form role="form" action="/login.do" method="post" enctype="application/x-www-form-urlencoded">
                    <legend>Sign in</legend>
                    <div class="form-group">
                        <label for="exampleInputUsername1">Username</label>
                        <input type="text" name="username" maxlength="25" required="true" class="form-control input-lg" id="exampleInputUsername1" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" name="password" maxlength="20" required="true" class="form-control input-lg" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary input-lg btn-block">Submit</button>
                </form>
            </div>
        </div>
    </section>
</div><!-- /.contents -->

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
