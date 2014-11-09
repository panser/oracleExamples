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
                    <tfoot>
                    <tr>
                        <th>Department Name</th>
                        <th>Department Manager</th>
                        <th>Department Location</th>
                    </tr>
                    </tfoot>
                    <tbody/>
                </table>

            </div>
        </div>
    </div>

    <jsp:include page="../../include/foot.jsp" />

    <script type="text/javascript">
        $(function () {
            // Setup - add a text input to each footer cell
            $('#departments tfoot th').each( function () {
                var title = $('#departments thead th').eq( $(this).index() ).text();
                $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
            } );

            var table = $("#departments").DataTable({
                "bServerSide": true
                , "sAjaxSource": "${baseUrl}api/department/"
                , "bProcessing": true
                , "fnServerData":myRequest
                , "aoColumns":[
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
                    }
                ]
            });
//            table.columnFilter();

            // Apply the search
            table.columns().eq( 0 ).each( function ( colIdx ) {
                $( 'input', table.column( colIdx ).footer() ).on( 'keyup change', function () {
                    table
                            .column( colIdx )
                            .search( this.value )
                            .draw();
                } );
            } );


        });
    </script>


</body>
</html>
