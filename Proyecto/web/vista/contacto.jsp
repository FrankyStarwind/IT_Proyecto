<%-- 
    Document   : contacto
    Created on : 16-may-2021, 20:41:35
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
                    <h1>Cotacto</h1>
                    <s:form action="enviarContacto">
                        <s:textfield name="correoMio" label="Correo" />
                        <s:textfield name="asunto" label="Asunto" />
                        <s:textarea name="comentario" label="Comentario"/>
                        <s:submit value="Enviar"></s:submit>
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