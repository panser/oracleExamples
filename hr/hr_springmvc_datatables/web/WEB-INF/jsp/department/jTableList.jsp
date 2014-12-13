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
    <%--<jsp:include page="../../include/commonHtml.jsp" />--%>

    <div class="container">
        <div class="h1">jTable Grid</div>

        <div id="allertMessages"></div>

        <div class="row-fluid">
            <div class="span12">

                <div class="filtering">
                    <form>
                        Name: <input type="text" id="name" />
                        Manager: <input type="text" id="manager" />
                        Location: <input type="text" id="location" />
                        <button type="submit" id="LoadRecordsButton" style="display: none;">Load records</button>
                    </form>
                </div>
                <div id="departments"></div>

            </div>
        </div>
    </div>


    <jsp:include page="../../include/foot_jTable.jsp" />
    <script type="text/javascript">
        $(document).ready(function () {
            $('#departments').jtable({
                title: 'Departments from HR table',
                tableId: 'departments',
                jqueryuiTheme: true,
//                showCloseButton: true,
                selecting: true, //Enable selecting
//                multiselect: true,
                selectingCheckboxes: true,
                paging: true, //Enable paging
                pageSize: 10, //Set page size (default: 10)
                pageSizes:[ 10,20,50,100,500],
                sorting: true, //Enable sorting
                defaultSorting: 'Name ASC', //Set default sorting
                multiSorting: true,
                actions: {
                    listAction: '${baseUrl}api/department/jTable/List',
                    createAction: '${baseUrl}api/department/jTable/Create',
                    updateAction: '${baseUrl}api/department/jTable/Update',
                    deleteAction: '${baseUrl}api/department/jTable/Delete'
                },
                toolbar: {
//                    hoverAnimation: true, //Enable/disable small animation on mouse hover to a toolbar item.
//                    hoverAnimationDuration: 60, //Duration of the hover animation.
//                    hoverAnimationEasing: undefined, //Easing of the hover animation. Uses jQuery's default animation ('swing') if set to undefined.
                    items: [{
                        icon: '${baseUrl}static/images/excel.png',
                        text: 'Export to Excel',
                        click: function () {
                            //perform your custom job...
                        }
                    },
                    {
                        icon: '${baseUrl}static/images/pdf.png',
                        text: 'Export to Pdf',
                        click: function () {
                            //perform your custom job...
                        }
                    }]
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
                        width: '40%',
                        display: function (data) {
                            return '<b>' + data.record.name + '</b>';
                        }
                    },
                    manager: {
                        title: 'Department Manager',
                        options: '${baseUrl}api/department/jTable/List/Managers',
                        width: '20%'
//                        create: false
//                        edit: false
                    },
                    location: {
                        title: 'Department Location',
                        options: '${baseUrl}api/department/jTable/List/Locations',
                        width: '30%'
//                        create: false
//                        edit: false
                    }
                }
/*
                //Register to selectionChanged event to hanlde events
                recordAdded: function(event, data){
                    //after record insertion, reload the records
                    $('#departments').jtable('load');
                },
                recordUpdated: function(event, data){
                    //after record updation, reload the records
                    $('#departments').jtable('load');
                }
*/
            });

//            $('#departments').jtable('load');

            //Re-load records when user click 'load records' button.
            $('#LoadRecordsButton').click(function (e) {
                e.preventDefault();
                $('#departments').jtable('load', {
                    name: $('#name').val(),
                    manager: $('#manager').val(),
                    location: $('#location').val()
                });
            });


            $( "#name" ).keyup(function() {
                $('#LoadRecordsButton').click();
            });
            $( "#manager" ).keyup(function() {
                $('#LoadRecordsButton').click();
            });
            $( "#location" ).keyup(function() {
                $('#LoadRecordsButton').click();
            });

            //Load all records when page is first shown
            $('#LoadRecordsButton').click();
        });
    </script>
</body>
</html>
