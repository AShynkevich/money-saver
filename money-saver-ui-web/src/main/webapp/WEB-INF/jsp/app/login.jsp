<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Loginform</title>

        <link href="../css/login.css" rel="stylesheet">
        <link href="../css/bootstrap.min.css" rel="stylesheet">


        <div id="nav" class="navbar-default navbar-static-top">
            <div id="dashboard" class="container">
                <a href="dashboard.html" id="logo" class="navbar-brand">Name</a>
            </div>
        </div>
    </head>

    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3"></div>
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                <div class="container-fluid container-login">
                    <div class="panel panel-default" id="panel-login">
                        <div class="panel-body">
                            <c:if test="${not empty param.login_error}">
                                <div class="alert alert-danger" role="alert">
                                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                                </div>
                            </c:if>
                            <h2 id="title-login">Money Saver</h2>
                            <form action="j_spring_security_check.action" method="POST">
                                <div class="form-group">
                                    <input id="username" name="username" size="20" maxlength="50" type="text" class="form-control" placeholder="Username" />
                                </div>
                                <div class="form-group">
                                    <input id="password" name="password" size="20" maxlength="50" type="password" class="form-control" placeholder="Password" />
                                </div>
                                <input name="submit" type="submit" class="btn btn-success btn-sm form-control" value="Sign In" />
                                <!--<button type="register" class="btn btn-default">Register</button>-->
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3"></div>
        </div>
    </div>

    </html>