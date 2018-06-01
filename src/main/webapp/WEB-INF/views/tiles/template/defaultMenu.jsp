<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/28/2018
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">App MVC</a>
        </div>


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home<span class="sr-only">(current)</span></a></li>
                <li><a href="/create">Register</a></li>
                <c:choose>
                    <c:when test="${User != null}">
                        <li><a class="disabled" href="#">Accedi</a></li>
                    </c:when>
                </c:choose>
                <c:otherwise>
                    <li><a href="/login">Accedi</a></li>
                </c:otherwise>
                <c:choose>
                    <c:when test="${User != null}">
                        <form id="myHiddenFormId" action="/login/form?logout" method="post" style="display: none">
                            <input type="hidden" name="logout" value="${User}">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <li><a href="" onclick="${'myHiddenFormId'}.submit(); return false;" title="Logout">Logout ${User}</a></li>
                    </c:when>
                    <c:otherwise>
                        <a class="disabled" href="#">Logout</a>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>

</nav>

