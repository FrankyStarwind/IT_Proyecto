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
                <h1>Listado de Equipos</h1>

                <table border="2">
                    <tr align="center">
                        <td>ID</td>
                        <td>NOMBRE</td>
                             <td>ACTIVO</td>
                        
                        <td colspan="2">OPCIONES</td>
                        
                    </tr>   
                    <s:iterator value="listaEquipos">
                        <tr align="center">

                            <td><s:property value="id"></s:property></td>
                            <td><s:property value="nombre"></s:property></td>
                               <td><s:property value="activo"></s:property></td>
                                <td>
                                <s:form action="eliminarEquipo">
                                    <s:submit value="Eliminar"></s:submit>
                                    <s:hidden name="id" value="%{id}"/>
                                </s:form>
                            </td>
                            <td>
                                <s:form action="editEquipo">
                                    <s:submit value="Editar"></s:submit>
                                    <s:hidden name="id" value="%{id}"/>
                                </s:form>
                            </td> 
                        </tr>
                    </s:iterator>
                </table>
                <table border='1' style="text-align: center">
                    <tr>
                        <td>
                            <s:form action="altaEquipo">
                                <s:submit value="Crear Equipo"></s:submit>
                            </s:form>
                        </td>
                                  <td>
                                <s:form action="indexEquipo">
                                    <s:submit value="Restablecer Búsqueda"></s:submit>
                                </s:form>
                            </td>
                    </tr>
                     <tr>
                            <td>
                                <s:form action="buscarEquipo" >                    
                                    <s:textfield name="nombre" value="%{nombre}" label="Buscar Equipo"></s:textfield>
                                    <s:submit value="Buscar Equipo"></s:submit>
                                </s:form> 
                            </td>
                        </tr>
                </table>
                <%@include file="/vista/includes/volver_index.jsp" %>
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
