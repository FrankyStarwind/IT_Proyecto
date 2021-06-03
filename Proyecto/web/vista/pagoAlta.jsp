<%-- 
    Document   : pagoAlta
    Created on : 03-jun-2021, 11:57:20
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alta Usuario</title>
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
                    <h1>Alta Pago</h1>
                    <s:form action="altaPago">
                        <s:textfield name="metodoPago" label="MÉTODO PAGO" />
                        <s:textfield name="importe" label="IMPORTE" />
                        <s:textfield name="pagadoS" label="PAGADO (Si/No)" />
                        <s:textfield name="fecha" label="FECHA Y HORA (yyyy-MM-dd HH:mm:ss)" />
                        <s:submit value="Guardar"></s:submit>
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



