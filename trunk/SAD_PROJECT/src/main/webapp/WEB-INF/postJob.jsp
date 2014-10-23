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
                <form role="form" action="/postJob.do" method="post" enctype="application/x-www-form-urlencoded">
                    <legend style="color: green"><strong>New vacancy's information</strong></legend>
                    <div class="col-lg-12">
                        <div class="col-lg-4 form-group">
                            <label for="txtJobTitle">Job title: </label>
                            <input type="text" maxlength="50"
                                   required="true" class="form-control input-lg" id="txtJobTitle"
                                   placeholder="Job title"
                                   name="txtJobTitle">
                        </div>
                        <div class="col-lg-1">
                        </div>
                        <div class="col-lg-4 form-group">
                            <label for="sbNumber">Number of employee: </label>
                            <input type="number" class="form-control input-lg" value="1"
                                   name="sbNumber" min="1" id="sbNumber">
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-4 form-group">
                            <label for="cbbCategory">Category: </label>
                            <select class="form-control input-lg" id="cbbCategory" name="cbbCategory">
                                <option selected=selected value="1">Networking</option>
                                <option value="2">Sales & marketing</option>
                                <option value="3">Teaching</option>
                                <option value="4">Programming</option>
                            </select>
                        </div>
                        <div class="col-lg-1"></div>
                        <div class="col-lg-4 form-group">
                            <label for="sbSalary">Salary($): </label>
                            <input type="number" class="form-control input-lg" step="100" value="500"
                                   name="sbSalary" min="500" id="sbSalary">
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-4 form-group">
                            <label for="cbbLocation">Location: </label>
                            <select class="form-control input-lg" id="cbbLocation" name="cbbLocation">
                                <option selected=selected value="America">America</option>
                                <option value="Europe">Europe</option>
                                <option value="Africa">Africa</option>
                                <option value="Asia">Asia</option>
                                <option value="Oceanic">Oceanic</option>
                            </select>
                        </div>
                        <div class="col-lg-1">
                        </div>
                        <div class="col-lg-4 form-group">
                            <label for="txtDeadline">Deadline:</label>
                            <input type="date"
                                   class="form-control input-lg" id="txtDeadline" name="txtDeadline">
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-4 form-group">
                            <label for="txtRequirement">Requirement:</label>
                            <textarea name="txtRequirement" id="txtRequirement" maxlength="2000"
                                      class="form-control input-lg"
                                      placeholder="Job's requirement"></textarea>
                        </div>
                        <div class="col-lg-1">
                        </div>
                        <div class="col-lg-4 form-group">
                            <label for="txtDescription">Description:</label>
                            <textarea name="txtDescription" id="txtDescription" maxlength="2000"
                                      class="form-control input-lg"
                                      placeholder="Job's description"></textarea>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary input-lg btn-block">Submit</button>
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

