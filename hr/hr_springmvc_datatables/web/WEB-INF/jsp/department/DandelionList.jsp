<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>

<dandelion:bundle excludes="jquery" />
<dandelion:bundle excludes="datatables" />
<%--
<dandelion:bundle includes="jquery.local" />
<dandelion:bundle includes="bootstrap3.local" />
<dandelion:bundle includes="datatables.local" />
<dandelion:bundle includes="datatables.bootstrap3.local" />
<dandelion:bundle includes="local" />
--%>

<spring:url value="/" var="baseUrl" />

<html>
    <jsp:include page="../../include/head.jsp" />

<body>
    <jsp:include page="../../include/navbar.jsp" />

    <div class="container">
        <div class="row-fluid">
            <div class="span12">

                <div class="h1">Dandelion Grid</div>

                <datatables:table id="myTableId" data="${departments}" row="department">
                    <datatables:column sortable="false" cssCellStyle="text-align:center;">
                        <datatables:columnHead>
                            <input type="checkbox" onclick="$('#myTableId').find(':checkbox').attr('checked', this.checked);" />
                        </datatables:columnHead>
                        <input type="checkbox" value="${department.id}" />
                    </datatables:column>
                    <%--<datatables:column title="Department Name" property="name" />--%>
                    <datatables:column title="Department Name" filterable="true" filterMinLength="3">
                        ${department.name}
                    </datatables:column>
                    <datatables:column title="Department Manager" filterable="true" filterMinLength="3">
                        ${department.manager.firstName} ${department.manager.lastName}
                    </datatables:column>
                    <datatables:column title="Department Location" filterable="true" filterMinLength="3">
                        ${department.location.city}, ${department.location.country.name}
                    </datatables:column>
                    <datatables:column title="Actions" sortable="false">
                        <a onclick="alert('Department ' + ${department.id} + ' deleted !');" class="btn btn-mini" title="Remove"><span class="glyphicon glyphicon-trash"></span></a>
                        <a onclick="alert('Department ' + ${department.id} + ' edited !');" class="btn btn-mini" title="Edit"><span class="glyphicon glyphicon-edit"></span></a>
                    </datatables:column>
                </datatables:table>

            </div>
        </div>
    </div>

    <jsp:include page="../../include/foot.jsp" />

</body>
</html>
