<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<form class="col-lg-offset-4" role="search">
    <div class="form-inline">
        <input type="text" class="form-control" placeholder="Search">
        <button class="btn btn-primary">Search</button>
    </div>
</form>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Country</th>
        <th scope="col">BirthDate</th>
        <th scope="col">Marital Status</th>
        <th scope="col">Skills</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
    <tr>
        <td>${user.firstname}</td>
        <td>${user.lastname}</td>
        <td>${user.country}</td>
        <td>${user.birthDate}</td>
        <td>${user.status.status}</td>
        <c:if test="${not empty user.skills}">
            <c:forEach items="${user.skills}" var="skills">
                <c:set var="value" value="${value} ${skills.name}"></c:set>
            </c:forEach>
        </c:if>
        <td><c:out value="${value}"></c:out></td>
        <td>

            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Edit
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">Delete</a></li>
                </ul>
            </div>

        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

