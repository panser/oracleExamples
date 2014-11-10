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
                                <a onclick="alert('Department ' + ${department.id} + ' deleted !');" class="btn btn-mini" title="Remove"><span class="glyphicon glyphicon-trash"></span></a>
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
            var table = $("#departments").dataTable({
                "aoColumns":[
                    {
                        "sDefaultContent":"",
                        "bSortable":false
                    },
                    {
                        "sDefaultContent":""
                    },
                    {
                        "sDefaultContent":""
                    },
                    {
                        "sDefaultContent":""
                    },
                    {
                        "sDefaultContent":"",
                        "bSortable":false
                    }
                ]
            })
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
