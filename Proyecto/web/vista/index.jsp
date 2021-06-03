<%-- 
    Document   : index
    Created on : 16-may-2021, 10:44:15
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ACTIVIDADES DEPORTIVAS</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/vista/assets/css/main.css" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/vista/images/icono.ico" />      
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

                    <!-- Comprobamos el tipo de usuario-->
                    <s:if test="%{#session.usuario != null}">
                        <h2>Bienvenido <s:property value="#session.usuario" /></h2>
                        <ul>
                            
                            <li><a href="<s:url action="reservas"><s:param name="dni" value="%{#session.dni}">
                                       </s:param>
                                   </s:url>">Reservas</a></li>
                            <li><a href="<s:url action="misPagos"><s:param name="dni" value="%{#session.dni}">
                                       </s:param>
                                   </s:url>">Pagos</a></li>

                            <li><a href="<s:url action="misDatos"><s:param name="dni" value="%{#session.dni}">
                                       </s:param>
                                   </s:url>">Datos personales</a></li>
                            <li><a href="<s:url action="indexJugadores"><s:param name="dni" value="%{#session.dni}">
                                       </s:param>
                                   </s:url>">Mostrar jugadores</a></li>
                            
                            <li><a href="<s:url action="inicio"><s:param name="dni" value="%{#session.dni}">
                                       </s:param>
                                   </s:url>">Logout</a></li>
                            
                            
                        </ul>
                    </s:if>
                    <s:else>
                        <h2>Bienvenido a la Vista de Administrador: <s:property value="#session.administrador" /></h2>
                        <ul>
                            <li><a href="<s:url action="indexPagos"/>">Pagos</a></li>
                            <li><a href="<s:url action="indexUsuarios"/>">Usuarios</a></li>
                            <li><a href="<s:url action="indexSede"/>">Sedes</a></li>
                            <li><a href="<s:url action="indexJugador"/>">Jugadores</a></li>
                            <li><a href="<s:url action="indexEquipo"/>">Equipos</a></li>
                            
                            <li><a href="<s:url action="logout"/>">Logout</a></li>
                        </ul>
                    </s:else>
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
