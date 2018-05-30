<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/29/2018
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- multistep form -->


<form:form method="post" modelAttribute="user"  class="form-horizontal" action="/">

<div class="container">
<div class="form-group row">
    <label for="example-text-input" class="col-2 col-form-label">Firstname</label>
    <div class="col-10">
        <form:input class="form-control input-sm" type="text" path="firstname" value="" id="example-text-input"/>
        <div class="has-error" style="color: red">
            <form:errors path="firstname" class="help-inline"/>
        </div>
    </div>
</div>
<div class="form-group row">
    <label for="example-search-input" class="col-2 col-form-label">Lastname</label>
    <div class="col-10">
        <form:input class="form-control input-sm" type="search" path="lastname" value="" id="example-search-input"/>
        <div class="has-error" style="color: red">
        <form:errors path="lastname" class="help-inline"/>
        </div>
    </div>
</div>
<div class="form-group row">
    <label for="example-text-input" class="col-2 col-form-label">Country</label>
    <div class="col-10">
        <form:input class="form-control input-sm" path="country" type="text" value="" id=""/>
        <div class="has-error" style="color: red">
        <form:errors path="country" class="help-inline"/>
        </div>
    </div>
</div>


<div class="form-group row">
    <label for="example-date-input" class="col-2 col-form-label">Birthdate</label>
    <div class="col-10">
        <form:input class="form-control input-sm" type="date" path="birthDate" value="" id="example-date-input"/>
        <div class="has-error" style="color: red">
        <form:errors path="birthDate" class="help-inline"/>
        </div>
    </div>
</div>
<div class="form-group">
    <label for="exampleSelect2">Skills</label>
    <form:select multiple="true" class="form-control" path="skills" id="exampleSelect2">
        <form:options items="${skillsAttribute}" itemValue="name" itemLabel="name"/>
    </form:select>
</div>

<div class="form-group">
    <label for="exampleSelect1">Marital status</label>
     <form:select class="form-control input-sm" id="exampleSelect1" path="status">
        <form:options items="${statusAttribute}" itemValue="status" itemLabel="status"/>
    </form:select>
</div>
    <input type="submit" value="Register" class="btn btn-primary btn-sm">
</div>

</form:form>