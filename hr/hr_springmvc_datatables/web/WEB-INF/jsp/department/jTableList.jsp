<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/" var="baseUrl" />

<!DOCTYPE html>
<html lang="en">
    <jsp:include page="../../include/head_jTable.jsp" />

<body>
    <jsp:include page="../../include/navbar.jsp" />
    <jsp:include page="../../include/commonHtml.jsp" />

    <div class="container">
        <div class="h1">jTable Grid</div>

        <div id="allertMessages"></div>

        <div class="row-fluid">
            <div class="span12">

                <div id="departments"></div>

            </div>
        </div>
    </div>


    <jsp:include page="../../include/foot_jTable.jsp" />
    <script type="text/javascript">
        $(function () {

        });

    </script>

</body>
</html>
