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
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${departments}" var="department">
                        <tr>
                            <td><input type="checkbox" value="${department.id}" /></td>
                            <td>${department.name}</td>
                            <td>${department.manager.firstName} ${department.manager.lastName}</td>
                            <td>${department.location.city}, ${department.location.country.name}</td>
                            <td>
                                <a id="delete" class="btn btn-mini" title="Remove" deleteId="${department.id}" ><span class="glyphicon glyphicon-trash"></span></a>
                                <%--<a onclick="deleteAction(${department.id})" class="btn btn-mini" title="Remove"><span class="glyphicon glyphicon-trash"></span></a>--%>
                                <a onclick="alert('Department ' + ${department.id} + ' edited !');" class="btn btn-mini" title="Edit"><span class="glyphicon glyphicon-edit"></span></a>
                            </td>
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
            var table = $("#departments").DataTable({
                "aoColumns": [
                    {
                        "sDefaultContent": "",
                        "bSortable": false
                    },
                    {
                        "sDefaultContent": ""
                    },
                    {
                        "sDefaultContent": ""
                    },
                    {
                        "sDefaultContent": ""
                    },
                    {
                        "sDefaultContent": "",
                        "bSortable": false
                    }
                ]
            })


            // Setup - add a text input to each footer cell
            $('#departments tfoot th').each(function () {
                var foot = $('#departments tfoot th').eq($(this).index()).text();
                if (foot.length !== 0) {
                    var title = $('#departments thead th').eq($(this).index()).text();
                    $(this).html('<input type="text" placeholder="Search ' + title + '" />');
                }
            });
            // Apply the search
            table.columns().eq(0).each(function (colIdx) {
                $('input', table.column(colIdx).footer()).on('keyup change', function () {
                    table
                            .column(colIdx)
                            .search(this.value)
                            .draw();
                });
            });


            $('#departments tbody').on('click', '#delete', function () {
                var thisObj = $(this);
                var id = thisObj.attr('deleteId');
                $('#myModal .modal-body span').text(id);
                $('#myModal').modal().on('click', '#confirmDelete', function () {
                    $.ajax({
                        type: 'GET',
                        url: "${baseUrl}api/department/" + id + "/delete",
                        async: 'false',
                        cache: 'false',
                        success: function (result) {
//                            alert('Department ' + id + ' deleted !');
                            table
                                    .row(thisObj.parents('tr'))
                                    .remove()
                                    .draw();
                            $('#myModal').modal('hide')
                        },
                        error: function (jqXHR) {
//                            alert('Department ' + id + ' NOT deleted !');
                            $('#myModal').modal('hide')
                        }
                    });
                });
            });
        });

    </script>

    <!-- Modal -->
    <div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Confirm delete</h4>
                </div>
                <div class="modal-body">
                    <p>You are going to delete item <span></span>. Are you sure?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button id="confirmDelete" type="button" class="btn btn-primary">Delete</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</body>
</html>
