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
<jsp:include page="../../include/head_datatables.jsp" />

<body>
<jsp:include page="../../include/navbar.jsp" />

<div class="container">
    <div class="row-fluid">
        <div class="span12">

            <div class="h1">Dandelion Grid AJAX</div>

            <datatables:table id="myTableId" url='${baseUrl}api/department/' serverSide="true" processing="true">
                <datatables:column title="Department Name" property="name" filterable="true" filterMinLength="3"/>
                <datatables:column title="Department Manager" property="manager.firstName" filterable="true" filterMinLength="3"/>
                <datatables:column title="Department Location" property="location.city" filterable="true" filterMinLength="3"/>
                <datatables:column title="Actions" sortable="false">
                    <a onclick="alert('Department ' + ${department.id} + ' deleted !');" class="btn btn-mini" title="Remove"><span class="glyphicon glyphicon-trash"></span></a>
                    <a onclick="alert('Department ' + ${department.id} + ' edited !');" class="btn btn-mini" title="Edit"><span class="glyphicon glyphicon-edit"></span></a>
                </datatables:column>
            </datatables:table>

        </div>
    </div>
</div>

<jsp:include page="../../include/foot_datatables.jsp" />

</body>
</html>
