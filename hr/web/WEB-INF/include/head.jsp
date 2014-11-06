<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false" %>
<spring:url value="/" var="baseUrl" />

<head>
    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/bootstrap/3.3.0/css/bootstrap.css'>
    <%--<link rel='stylesheet' type='text/css' href='${baseUrl}webjars/jquery-ui/1.11.1/jquery-ui.css'>--%>
    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/datatables/1.10.2/css/jquery.dataTables.css'>
    <link rel='stylesheet' type='text/css' href='http://cdn.datatables.net/plug-ins/380cb78f450/integration/bootstrap/3/dataTables.bootstrap.css'>
    <link rel='stylesheet' type='text/css' href='${baseUrl}static/custom.css'>

    <title></title>
</head>