<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 5/29/2018
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- multistep form -->

<div class="container">
<div class="form-group row">
    <label for="example-text-input" class="col-2 col-form-label">Firstname</label>
    <div class="col-10">
        <input class="form-control" type="text" value="" id="example-text-input">
    </div>
</div>
<div class="form-group row">
    <label for="example-search-input" class="col-2 col-form-label">Lastname</label>
    <div class="col-10">
        <input class="form-control" type="search" value="" id="example-search-input">
    </div>
</div>
<div class="form-group row">
    <label for="example-email-input" class="col-2 col-form-label">Country</label>
    <div class="col-10">
        <input class="form-control" type="email" value="" id="example-email-input">
    </div>
</div>


<div class="form-group row">
    <label for="example-date-input" class="col-2 col-form-label">Birthdate</label>
    <div class="col-10">
        <input class="form-control" type="date" value="2011-08-19" id="example-date-input">
    </div>
</div>
<div class="form-group">
    <label for="exampleSelect2">Skills</label>
    <select multiple class="form-control" id="exampleSelect2">
        <option>C</option>
        <option>C++</option>
        <option>Css</option>
        <option>HTML</option>
        <option>Java</option>
        <option>Javascript</option>
    </select>
</div>

<div class="form-group">
    <label for="exampleSelect1">Marital status</label>
    <select class="form-control" id="exampleSelect1">
        <option>Divorced</option>
        <option>Married</option>
        <option>Single</option>
        <option>Widowed</option>
    </select>
</div>
    <a class="btn btn-primary" href= " <c:url value="#" /> ">Submit</a>
    <a class="btn btn-primary" href="<c:url value="/" />">Cancel</a>
</div>