<%-- 
    Document   : indexUsuarios
    Created on : 16-may-2021, 10:45:22
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
                    <h1>Listado de Sedes</h1>

                    <table border="2">
                        <tr align="center">
                            <td>NOMBRE</td>
                            <td>DIRECCIÓN</td>
                            <td>TELÉFONO</td>
                            <td>CP</td>
                            <td>EMAIL</td>
                            <td>PROVINCIA</td>
                            <td colspan="2">OPCIONES</td>

                        </tr>   
                        <s:iterator value="listaSede">
                            <tr align="center">
                                <td><s:property value="nombre"></s:property></td>
                                <td><s:property value="direccion"></s:property></td>
                                <td><s:property value="tlf"></s:property></td>
                                <td><s:property value="cp"></s:property></td>
                                <td><s:property value="email"></s:property></td>
                                <td><s:property value="provincia"></s:property></td>

                                    <td>
                                    <s:form action="eliminarSede">
                                        <s:submit value="Eliminar"></s:submit>
                                        <s:hidden name="id" value="%{id}"/>
                                    </s:form>
                                </td>
                                <td>
                                    <s:form action="editSede">
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
                                <s:form action="sedeAlta">
                                    <s:submit value="Crear Sede"></s:submit>
                                </s:form>
                            </td>
                        </tr>
                    </table>
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