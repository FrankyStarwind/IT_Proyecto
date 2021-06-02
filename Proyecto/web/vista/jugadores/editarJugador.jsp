<%--
    Document   : editJugador
    Created on : 02-jun-2021, 16:57:31
    Author     : frank
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Editar Jugador</title>
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


                    <!-- Section -->
                    <h1>Edici&oacute;n de Jugador</h1>
                    <s:form action="editarJugadorF">
                        <s:iterator value="listaJugadores">   
                            <s:textfield name="nombre" label="Nombre" value="%{nombre}" />
                            <s:textfield name="edad" label="Edad" value="%{edad}" />
                            <s:textfield name="dorsal" label="Dorsal" value="%{dorsal}" />
                            <%--<s:textfield name="equipo.nombre" label="Equipo" value="%{equipo.nombre}" />--%>
                            <s:submit value="Guardar"/>
                        </s:iterator>
                    </s:form>
                    <%@include file="../includes/volver_index.jsp" %>
                </div>
            </div>

            <!-- Sidebar -->
            <div id="sidebar">
                <div class="inner">

                    <!-- Menu -->
                    <%@include file="../includes/include_menu.jsp" %>
                    <!-- Section -->
                    <%@include file="../includes/include_menu_section.jsp" %>
                    <!-- Footer -->
                    <%@include file="../includes/include_footer.jsp" %>
                </div>
            </div>
        </div>
        <!-- Scripts -->
        <%@include file="../includes/include_scripts.jsp" %>
    </body>
</html>