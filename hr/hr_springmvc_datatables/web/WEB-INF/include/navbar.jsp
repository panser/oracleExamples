<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/" var="baseUrl" />

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Java + JavaScript</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${baseUrl}department/DataTablesList">Main</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">DataTables<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${baseUrl}department/DataTablesList">DOM</a></li>
                        <li><a href="${baseUrl}department/DataTablesListAjax">AJAX</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dandelion DataTables<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${baseUrl}department/DandelionList">DOM</a></li>
                        <li><a href="${baseUrl}department/DandelionListAjax">AJAX</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">jTable<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${baseUrl}department/jTableAjax">jTable + jQueryValidationEngine over AJAX</a></li>
                        <li><a href="${baseUrl}department/jTableAjaxWithjqBootstrapValidation">jTable + jqBootstrapValidation over AJAX</a></li>
                        <li><a href="${baseUrl}department/jTableAjaxWithjQueryValidation">jTable + jQueryValidation over AJAX</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">User Menu<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Sign In</a></li>
                        <li><a href="#">Sign up</a></li>
                        <li class="divider"></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">About</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>