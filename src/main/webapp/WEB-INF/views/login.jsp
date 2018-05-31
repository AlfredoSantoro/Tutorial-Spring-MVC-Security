<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/31/2018
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Login</h4>
                        <c:url var="loginURLPRO" value="/login"></c:url>
                        <form method="POST" action="${loginURLPRO}" class="form-horizontal">

                            <c:if test="${param.forbidden != null}">
                                <div class="alert alert-danger">
                                    <p>Access denied! Authenticate with a different user.</p>
                                </div>
                            </c:if>


                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Username or wrong password</p>
                                </div>
                            </c:if>


                            <c:if test="${param.logout != null}">
                                <div class="alert alert-danger">
                                    <p>Logout successfully performed</p>
                                </div>
                            </c:if>

                            <div class="form-group">
                                <label for="username">Username</label>

                                <input id="username" type="text" class="form-control" name="username" required autofocus>

                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input id="password" type="password" class="form-control" name="password" required data-eye>
                            </div>

                            <div class="form-group">
                                <label>
                                    <input type="checkbox" name="remember"> Remember Me
                                </label>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    Login
                                </button>
                            </div>
                            <div class="margin-top20 text-center">
                                Don't have an account? <a href="/create">Create One</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</div>