<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="../../include/head.jsp" />

<body>

    <H1>
        DataTables Grid over AJAX
    </H1>

    <table id="departments" class="display">
        <thead>
            <tr>
                <th>Department Name</th>
                <th>Department Manager</th>
                <th>Department Location</th>
            </tr>
        </thead>
        <tbody/>
    </table>

    <jsp:include page="../../include/foot.jsp" />

    <script type="text/javascript">
        $(function () {
            $("#departments").dataTable({
                "bServerSide": true
                , "sAjaxSource": "/${baseUrl}api/department/"
                , "bProcessing": true
                , "sPaginationType": "full_numbers"
                , "bJQueryUI": true
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
