<%-- 
    Document   : editUsuario
    Created on : 25-may-2021, 19:40:56
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Editar Usuario</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/vista/assets/css/main.css" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/vista/images/favicon.ico" /> 
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
                    <h1>Edici&oacute;n de Usuario</h1>
                    <s:form action="editUsuarioF">
                        <s:iterator value="lista">   
                            <s:textfield name="userName" label="USERNAME" value="%{userName}" />
                            <s:textfield name="password" label="DIRECCIÓN" value="%{password}" />
                            <s:textfield name="nombre" label="NOMBRE" value="%{nombre}" />
                            <s:textfield name="apellidos" label="APELLIDOS" value="%{apellidos}" />
                            <s:textfield name="dni" label="DNI" value="%{dni}" />
                            <s:textfield name="email" label="EMAIL" value="%{email}" />
                            <s:textfield name="tlf" label="TELÉFONO" value="%{tlf}" />
                            <s:textfield name="adminS" label="ADMINISTRADOR (Si/No)" value="%{admin}" />                         
                            <s:submit value="Guardar"/>
                        </s:iterator>
                    </s:form>
                    <%@include file="includes/volver_index.jsp" %>
                </div>
            </div>

            <!-- Sidebar -->
            <div id="sidebar">
                <div class="inner">

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