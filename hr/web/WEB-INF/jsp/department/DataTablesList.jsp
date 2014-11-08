<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/" var="baseUrl" />

<!DOCTYPE html>
<html lang="en">
    <jsp:include page="../../include/head.jsp" />

<body>
    <jsp:include page="../../include/navbar.jsp" />

    <div class="container">
        <div class="row-fluid">
            <div class="span12">

                <div class="h1">DataTables Grid</div>

                <table id="departments" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Department Name</th>
                        <th>Department Manager</th>
                        <th>Department Location</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${departments}" var="department">
                        <tr>
                            <td>${department.name}</td>
                            <td>${department.manager.firstName} ${department.manager.lastName}</td>
                            <td>${department.location.city}, ${department.location.country.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>


    <jsp:include page="../../include/foot.jsp" />
    <script type="text/javascript">
        $(function () {
            $("#departments").DataTable({
            });

        });
    </script>


</body>
</html>
