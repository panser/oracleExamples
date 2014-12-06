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
        $(document).ready(function () {
            $('#departments').jtable({
                title: 'Departments from HR table',
                selecting: true, //Enable selecting
                paging: true, //Enable paging
                pageSize: 10, //Set page size (default: 10)
                sorting: true, //Enable sorting
                actions: {
                    listAction: '/api/department/jTable/List',
                    createAction: '/api/department/jTable/Create',
                    updateAction: '/api/department/jTable/Update',
                    deleteAction: '/api/department/jTable/Delete'
                },
                fields: {
                    id: {
                        title: 'Id',
                        key: true,
                        list: true,
                        create: false,
                        edit: false
                    },
                    name: {
                        title: 'Department Name',
                        width: '40%'
                    },
                    manager: {
                        title: 'Department Manager',
                        options: '/api/department/jTable/List/Managers',
                        width: '20%'
//                        create: false
//                        edit: false
                    },
                    location: {
                        title: 'Department Location',
                        options: '/api/department/jTable/List/Locations',
                        width: '30%'
//                        create: false
//                        edit: false
                    }
                },

                //Register to selectionChanged event to hanlde events
                recordAdded: function(event, data){
                    //after record insertion, reload the records
                    $('#departments').jtable('load');
                },
                recordUpdated: function(event, data){
                    //after record updation, reload the records
                    $('#departments').jtable('load');
                }
            });

            $('#departments').jtable('load');
        });
    </script>
</body>
</html>
