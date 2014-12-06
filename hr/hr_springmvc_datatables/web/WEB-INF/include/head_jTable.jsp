<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false" %>
<spring:url value="/" var="baseUrl" />

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/bootstrap/3.3.0/css/bootstrap.css'>
    <link rel='stylesheet' type='text/css' href='${baseUrl}webjars/jquery-ui/1.11.1/jquery-ui.css'>
    <link rel='stylesheet' type='text/css' href='${baseUrl}static/custom.css'>

    <title></title>
</head>