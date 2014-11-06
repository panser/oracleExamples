<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/" var="baseUrl" />

<html>
    <jsp:include page="../../include/head.jsp" />

<body>

    <H1>
        DataTables Grid
    </H1>

    <table id="departments" class="display">
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

    <jsp:include page="../../include/foot.jsp" />
    <script type="text/javascript">
        $(function () {
            $("#departments").dataTable({
                "sPaginationType": "full_numbers"
                , "bJQueryUI": true
            });
        });
    </script>


</body>
</html>
