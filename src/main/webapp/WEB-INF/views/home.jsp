<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
    function myfunction(valore){
        var favDialog = document.getElementById("favDialog");
        var cancelButton = document.getElementById("cancel");
        var confirmButton = document.getElementById("confirm");
        favDialog.showModal();
        cancelButton.addEventListener('click', function(){
            favDialog.close();
        })

        confirmButton.addEventListener('click',function(){
            window.location="/delete/"+valore;
            favDialog.close();
        });

    }

</script>

<form class="col-lg-offset-4" role="search">
    <div class="form-inline">
        <input type="text" class="form-control" placeholder="Search" id="searchHome" style="width: 30em">
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
        <c:set var="value" value=""></c:set>
        <td>
            <a href="/edit/${user.id}" class="btn btn-primary" >Edit</a>
            <a onclick="myfunction(<c:out value="${user.id}"/>)" class="btn btn-danger" >Delete</a>

        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<dialog id="favDialog">
    <label>Confermi di voler eliminare?</label>
    <menu>
        <button id="cancel" type="reset">Cancel</button>
        <button id="confirm" type="submit">Confirm</button>
    </menu>
</dialog>


