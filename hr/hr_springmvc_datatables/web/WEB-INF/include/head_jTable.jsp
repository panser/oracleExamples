<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false" %>
<spring:url value="/" var="baseUrl" />

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/bootstrap/3.3.0/css/bootstrap.css'>
    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/jquery-ui/1.11.1/jquery-ui.css'>
    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/jquery-ui-themes/1.11.0/redmond/jquery-ui.css'>
    <link href="${baseUrl}static/jtable.2.4.0/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}static/jtable.2.4.0/themes/jqueryui/jtable_jqueryui.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}static/jQuery-Validation-Engine-master/css/validationEngine.jquery.css" rel="stylesheet" type="text/css" />
    <link rel='stylesheet' type='text/css' href='${baseUrl}static/custom.css'>

    <title></title>
</head>