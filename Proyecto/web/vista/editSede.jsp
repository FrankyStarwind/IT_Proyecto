<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Editar Sede</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/vista/assets/css/main.css" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/vista/images/favicon.ico" /> 
        <!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
        <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
    </head>
    <body>

        <!-- Wrapper -->
        <div id="wrapper">

            <!-- Main -->
            <div id="main">
                <div class="inner">

                    <!-- Header -->
                    <%@include file="includes/include_header.jsp" %>

                    <!-- Section -->
                    <h1>Edici&oacute;n de Sede</h1>
                    <s:form action="editSedeF">
                        <s:iterator value="listaSede">                        
                            <s:textfield name="nombre" label="NOMBRE" value="%{nombre}" />
                            <s:textfield name="direccion" label="DIRECCIÓN" value="%{direccion}"/>
                            <s:textfield name="tlf" label="TELÉFONO" value="%{tlf}"/>
                            <s:textfield name="cp" label="CP" value="%{cp}"/>
                            <s:textfield name="email" label="EMAIL" value="%{email}"/>
                            <s:textfield name="provincia" label="PROVINCIA" value="%{provincia}"/>
                            <s:hidden name="id" value="%{id}" />
                            <s:submit value="Guardar"/>
                        </s:iterator>
                    </s:form>
                </div>
            </div>

            <!-- Sidebar -->
            <div id="sidebar">
                <div class="inner">
                    <!-- Search -->
                    <%@include file="includes/include_buscar.jsp" %>
                    <!-- Menu -->
                    <%@include file="includes/include_menu.jsp" %>
                    <!-- Section -->
                    <%@include file="includes/include_menu_section.jsp" %>
                    <!-- Footer -->
                    <%@include file="includes/include_footer.jsp" %>
                </div>
            </div>
        </div>
        <!-- Scripts -->
        <%@include file="includes/include_scripts.jsp" %>
    </body>
</html>