<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/31/2018
  Time: 12:41 PM
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
    <link href="/static/css/login.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script src="http://localhost:8080/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="http://localhost:8080/webjars/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
<section id="site-content">
    <tiles:insertAttribute name="body"/>
</section>
</body>
</html>
