<%-- 
    Document   : crearEquipo
    Created on : 23-may-2021, 12:51:42
    Author     : frank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ACTIVIDADES DEPORTIVAS</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/vista/assets/css/main.css" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/vista/images/icono.ico" />      
    </head> 
    <!-- Wrapper -->
    <div id="wrapper">

        <!-- Main -->
        <div id="main">
            <div class="inner">

                <!-- Header -->
                <%@include file="../includes/include_header.jsp" %>                  

                <!-- Section --> 
                <h1>Listado de Jugadores</h1>
                <!-- Terminar tabla con operaciones CRUD de Usuario -->
                <!-- Insertar, Borrar, Editar y Buscar-->

                <table border="2">
                    <tr align="center">
                        <td>id</td>
                        <td>Nombre</td>
                        <td>Edad</td>
                        <td>Dorsal</td>
                        <td>Equipo al que pertenece</td>
                    </tr>   
                    <s:iterator value="listaJugadores">
                        <tr align="center">
                            
                            <td><s:property value="id"></s:property></td>
                            <td><s:property value="nombre"></s:property></td>
                            <td><s:property value="edad"></s:property></td>
                            <td><s:property value="dorsal"></s:property></td>
                            
                            <td><s:property value="idEquipoFK"></s:property></td>
                            
                                                                               
                        </tr>
                    </s:iterator>
                </table>
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
