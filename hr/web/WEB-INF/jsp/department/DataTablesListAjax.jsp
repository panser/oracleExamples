<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/" var="baseUrl" />

<html>
    <jsp:include page="../../include/head.jsp" />

<body>
    <jsp:include page="../../include/navbar.jsp" />

    <div class="container">
        <div class="row-fluid">
            <div class="span12">

                <div class="h1">DataTables Grid over AJAX</div>

                <div id="status"></div>

                <table id="departments" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Department Name</th>
                            <th>Department Manager</th>
                            <th>Department Location</th>
                        </tr>
                    </thead>
                    <tbody/>
                </table>

            </div>
        </div>
    </div>

    <jsp:include page="../../include/foot.jsp" />

    <script type="text/javascript">
        $(function () {
            $("#departments").DataTable({
                "serverSide": true
                , "ajaxSource": "${baseUrl}api/department/"
                , "processing": true
                , "fnServerData": function ( sSource, aoData, fnCallback ) {
                    $.ajax( {
                        dataType: 'json',
                        contentType: "application/json;charset=UTF-8",
//                        type: 'GET',
                        type: 'POST',
                        url: sSource,
                        data: stringify_aoData(aoData),
                        success: fnCallback,
                        error : function (e) {
                            alert (e);
                        }
                    } );
                }
            });

        });
    </script>


</body>
</html>
