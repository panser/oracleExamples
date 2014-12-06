<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/" var="baseUrl" />

<html>
    <jsp:include page="../../include/head_datatables.jsp" />

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
                            <th><input type="checkbox" onclick="$('#departments').find(':checkbox').attr('checked', this.checked);" /></th>
                            <th>Department Name</th>
                            <th>Department Manager</th>
                            <th>Department Location</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th></th>
                        <th>Department Name</th>
                        <th>Department Manager</th>
                        <th>Department Location</th>
                        <th>Actions</th>
                    </tr>
                    </tfoot>
                    <tbody/>
                </table>

            </div>
        </div>
    </div>

    <jsp:include page="../../include/foot_datatables.jsp" />

    <script type="text/javascript">
        $(function () {
            var table = $("#departments").dataTable({
                "bServerSide": true
                , "sAjaxSource": "${baseUrl}api/department/"
                , "bProcessing": true
                , "fnServerData":myRequest
                , "aoColumns":[
                    {
                        "mData":"id",
                        "bSortable":false,
                        "mRender":makeInput
                    },
                    {
                        "mData":"name",
                        "sDefaultContent":""
                    },
                    {
                        "mData":"manager.firstName",
                        "sDefaultContent":""
                    },
                    {
                        "mData":"location.city",
                        "sDefaultContent":""
                    },
                    {
                        "mData":"id",
                        "bSortable":false,
                        "mRender":makeActions
                    }

                ]
            });
            table.columnFilter({
                "aoColumns":[
                    {
                        "type":"null"
                    },
                    {
                        "type":"text",
                        "iFilterLength":3
                    },
                    {
                        "type":"text",
                        "iFilterLength":3
                    },
                    {
                        "type":"text",
                        "iFilterLength":3
                    },
                    {
                        "type":"null"
                    }
                ]
            });



        });
    </script>


</body>
</html>
