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
    <jsp:include page="../../include/commonHtml.jsp" />

    <div class="container">
        <div class="h1">DataTables Grid</div>

        <div id="allertMessages"></div>

        <div class="row-fluid">
            <div class="span12">

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
                                <a class="localDeleteAction btn btn-mini" title="Remove" deleteId="${department.id}" ><span class="glyphicon glyphicon-trash"></span></a>
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


            removeDepartmentObg = null;
            $('#confirmDeleteModal').on('click', '#confirmDelete', deleteDepartment);
            $('#departments tbody').on('click', '.localDeleteAction', function () {
                removeDepartmentObg = $(this);
                var id = removeDepartmentObg.attr('deleteId');
                var confirmDeleteModalObj = $('#confirmDeleteModal');
                confirmDeleteModalObj.find('.modal-body span').text(id);
                confirmDeleteModalObj.modal('show');
            });

            function deleteDepartment (event){
                var id = $('#confirmDeleteModal').find('.modal-body span').text();
                $.ajax({
                    type: 'GET',
                    url: "${baseUrl}api/department/" + id + "/delete",
                    async: 'false',
                    cache: 'false',
                    success: function (result) {
                        table
                                .row(removeDepartmentObg.parents('tr')).remove()
                                .draw();
                        $('#confirmDeleteModal').modal('hide')
                    },
                    error: function (jqXHR) {
                        var dangerBlock = $("#localAlertDangerBlock").clone().attr('id', '');
                        dangerBlock.find('.localMessageDanger').text(jqXHR.responseText);
                        dangerBlock.appendTo("#allertMessages");
                        dangerBlock.show();
                        $('#confirmDeleteModal').modal('hide');
                        $("html, body").animate({ scrollTop: 0 }, "slow");
                    }
                })
            };

        });

    </script>

    <!-- Modal -->
    <div class="modal fade bs-example-modal-sm" id="confirmDeleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                    <button id="close" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button id="confirmDelete" type="button" class="btn btn-primary">Delete</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</body>
</html>
