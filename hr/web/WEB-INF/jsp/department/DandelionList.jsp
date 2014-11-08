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
                    <%--<datatables:column title="Department Name" property="name" />--%>
                    <datatables:column title="Department Name">
                        ${department.name}
                    </datatables:column>
                    <datatables:column title="Department Manager">
                        ${department.manager.firstName} ${department.manager.lastName}
                    </datatables:column>
                    <datatables:column title="Department Location">
                        ${department.location.city}, ${department.location.country.name}
                    </datatables:column>
                </datatables:table>

            </div>
        </div>
    </div>

    <jsp:include page="../../include/foot.jsp" />

</body>
</html>
