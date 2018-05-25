<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Hello world page</title>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>


<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Country</th>
        <th scope="col">BirthDate</th>
        <th scope="col">Skills</th>
        <th scope="col">Marital Status</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>Salerno</td>
        <td>22/2/1994</td>
        <td>Java</td>
        <td>Single</td>
        <td><button type="button" class="btn btn-primary">Edit</button> <button type="button" class="btn btn-secondary">Delete</button></td>
    </tr>

    <tr>
        <th scope="row">2</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>Salerno</td>
        <td>22/2/1994</td>
        <td>Java</td>
        <td>Single</td>
        <td><button type="button" class="btn btn-primary">Edit</button> <button type="button" class="btn btn-secondary">Delete</button></td>
    </tr>

    <tr>
        <th scope="row">3</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>Salerno</td>
        <td>22/2/1994</td>
        <td>Java</td>
        <td>Single</td>
        <td><button type="button" class="btn btn-primary">Edit</button> <button type="button" class="btn btn-secondary">Delete</button></td>
    </tr>
    </tbody>
</table>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>
