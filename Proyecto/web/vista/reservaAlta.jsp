<%-- 
    Document   : login
    Created on : 16-may-2021, 10:45:07
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Alta Reserva</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/vista/assets/css/main.css" type="text/css"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/vista/images/icono.ico" />    
        <sx:head  />  
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
                    <h1>Alta Reserva</h1>
                    <s:form action="altaReserva">

                        <s:textfield name="fecha" label="Fecha y Hora (yyyy-MM-dd HH:mm:ss)" />


                        <s:select label="ACTIVIDADES" 
                                  headerValue="Seleccione ..." 
                                  name="idActividad"   listKey="id" listValue="nombre+': '+precio+' €'" 
                                  list="listaAc" />
                        

                        <s:select label="EQUIPO 1" 
                                  headerValue="Seleccione ..." 
                                  name="idEq1"   listKey="id" listValue="nombre" 
                                  list="listaEq1" />

                        <s:select label="EQUIPO 2" 
                                  headerValue="Seleccione ..." 
                                  name="idEq2"   listKey="id" listValue="nombre" 
                                  list="listaEq2" />

                        <s:select label="TIPO PAGO" 
                                  headerValue="Seleccione ..."
                                  list="listaPago" 
                                  name="tipoPago" 
                                  />




                        <s:submit value="Guardar"></s:submit>
                    </s:form>

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

