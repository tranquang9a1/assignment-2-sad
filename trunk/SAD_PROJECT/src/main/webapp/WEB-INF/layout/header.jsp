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
            <a class="navbar-brand" href="../index.jsp">Job Portal</a>
        </div>

        <!-- post or upload cv -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <div class="navbar-left">
                <a href="jobs.html" class="btn btn-default navbar-btn">Browse all jobs &raquo;</a>
                <a href="post.html" class="btn btn-warning navbar-btn">Post a job &raquo;</a>
            </div>
            <!-- the menu -->

            <div class="navbar-right">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <a href="#" class="navbar-brand"><strong>Wellcome ${sessionScope.user.username}</strong></a>
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