<%-- 
    Document   : visualizarPagoUsuario
    Created on : 03-jun-2021, 11:05:03
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><%@taglib prefix="s" uri="/struts-tags"%>
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
                    <h1>MIS PAGOS</h1>
                    <table border="2">
                        <tr align="center">
                            <td>ID</td>
                            <td>MÉTODO PAGO</td>
                            <td>IMPORTE</td>
                            <td>PAGADO</td> 
                            <td>FECHA</td>  
                            <td>USUARIO</td>
                           
                        </tr>   
                        <s:iterator value="lista">
                            <tr align="center">
                                <td><s:property value="id"></s:property></td>
                                <td><s:property value="metodoPago"></s:property></td>
                                <td><s:property value="importe"></s:property></td>
                                <s:if test="pagado != 0">
                                    <td>Sí</td>                              
                                </s:if>
                                <s:else>
                                    <td>No</td>
                                </s:else> 
                                <td><s:property value="fecha.toString()"></s:property></td>
                                <td><s:property value="reserva.usuario.nombre"></s:property></td>

                                </tr>
                        </s:iterator>
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