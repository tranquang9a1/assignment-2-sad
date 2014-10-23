<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <form role="form" action="/changePass.do" method="post" enctype="application/x-www-form-urlencoded">
                    <legend style="color: green"><strong>Change password</strong></legend>
                        <c:if test="${requestScope.ERROR}">
                            <label id="txtError" style="color: red">Password is wrong or mismatch!</label>
                        </c:if>
                    <div class="form-group">
                        <label for="txtCurrentPass">Current password</label>
                        <input type="password" value="" autofocus="true" maxlength="20" required="true" class="form-control input-lg" id="txtCurrentPass" placeholder="Current password" name="txtCurrentPass">
                    </div>
                    <div class="form-group">
                        <label for="txtNewPass">New password</label>
                        <input type="password" value="" maxlength="20" required="true" class="form-control input-lg" id="txtNewPass" placeholder="New password" name="txtNewPass">
                    </div>
                    <div class="form-group">
                        <label for="txtConfirmNewPass">Confirm new password</label>
                        <input type="password" maxlength="20" required="true" class="form-control input-lg" id="txtConfirmNewPass" placeholder="Confirm new password" name="txtConfirmNewPass">
                    </div>
                    <button type="submit" class="btn btn-primary input-lg btn-block">Submit</button>
                </form>
            </div>
        </div>
    </section>
</div><!-- /.contents -->

<!-- the botom client image -->

<!-- the footer -->
<jsp:include page="layout/footer.jsp"/>
</body>
</html>

