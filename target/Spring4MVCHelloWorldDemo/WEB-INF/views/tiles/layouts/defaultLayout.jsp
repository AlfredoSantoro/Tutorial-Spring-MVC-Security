<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/28/2018
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>
    <link href="http://localhost:8080/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://localhost:8080/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="http://localhost:8080/webjars/jquery/1.9.1/jquery.min.js"></script>
</head>

<body>
<header id="header">
    <tiles:insertAttribute name="header" />
</header>

<section id="sidemenu">
    <tiles:insertAttribute name="menu" />
</section>

<section id="site-content">
    <tiles:insertAttribute name="body"/>
</section>

<footer id="footer">
    <tiles:insertAttribute name="footer" />
</footer>


</body>
</html>
