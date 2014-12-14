<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/" var="baseUrl" />

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>

    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/bootstrap/3.3.0/css/bootstrap.css'>
    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/jquery-ui/1.11.1/jquery-ui.css'>
    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/jquery-ui-themes/1.11.0/redmond/jquery-ui.css'>
    <link href="${baseUrl}static/jtable.2.4.0/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}static/jtable.2.4.0/themes/jqueryui/jtable_jqueryui.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}static/jQuery-Validation-Engine-master/css/validationEngine.jquery.css" rel="stylesheet" type="text/css" />
    <link rel='stylesheet' type='text/css' href='${baseUrl}static/custom.css'>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <jsp:include page="../../include/navbar.jsp" />
    <%--<jsp:include page="../../include/commonHtml.jsp" />--%>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="h1">jTable Grid</div>
        </div>


        <div class="row-fluid">
            <form class="form-inline" role="form">
                <div class="form-group">
                    <div class="input-group">
                        <label class="sr-only" for="name">Name:</label>
                        <input type="search" class="form-control" id="name" placeholder="Enter name" required />
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <label class="sr-only" for="name">Manager:</label>
                        <input type="search" class="form-control" id="manager" placeholder="Enter manager" required />
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <label class="sr-only" for="name">Location:</label>
                        <input type="search" class="form-control" id="location" placeholder="Enter location" required />
                    </div>
                </div>
                <button type="submit" class="btn btn-default" id="LoadRecordsButton" style="display: none;">Load records</button>
            </form>
        </div>

        <div class="row-fluid">
            <div id="departments"></div>
        </div>
    </div>


    <script src="${baseUrl}webjars/jquery/1.11.1/jquery.js"></script>
    <script src="${baseUrl}webjars/bootstrap/3.3.0/js/bootstrap.js"></script>
    <script src="${baseUrl}webjars/jquery-ui/1.11.1/jquery-ui.js"></script>
    <script src="${baseUrl}static/jtable.2.4.0/jquery.jtable.js"></script>
    <script src="${baseUrl}static/jQuery-Validation-Engine-master/js/languages/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8"></script>
    <script src="${baseUrl}static/jQuery-Validation-Engine-master/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
    <script src="${baseUrl}static/custom.js"></script>

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
                        },
                        inputClass: 'validate[required]'
                    },
                    manager: {
                        title: 'Department Manager',
                        options: '${baseUrl}api/department/jTable/List/Managers',
                        width: '20%'
//                        create: false
//                        edit: false
                        ,inputClass: 'validate[ajax[checkManager]]'
                    },
                    location: {
                        title: 'Department Location',
                        options: '${baseUrl}api/department/jTable/List/Locations',
                        width: '30%'
//                        create: false
//                        edit: false
                    }
                },
                //Initialize validation logic when a form is created
                formCreated: function (event, data) {
//                data.form.validationEngine();
                },
                //Validate form when it is being submitted
                formSubmitting: function (event, data) {
                    return data.form.validationEngine('validate', {
                        ajaxFormValidation: false
                        <%--,ajaxFormValidationURL: "${baseUrl}api/department/jTable/Validate/form"--%>
                    });
                },
                //Dispose validation logic when form is closed
                formClosed: function (event, data) {
                    data.form.validationEngine('hide');
                    data.form.validationEngine('detach');
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
