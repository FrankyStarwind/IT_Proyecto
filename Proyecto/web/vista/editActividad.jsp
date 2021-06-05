<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Editar Reserva</title>
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
                    <h1>Edici&oacute;n de Actividad</h1>
                    <s:form action="editActividadF">
                        <s:iterator value="lista">                        
                           
                              <s:textfield name="nombre" label="NOMBRE" value="%{nombre}" />
                                <s:textfield name="precio" label="PRECIO" value="%{precio}" />
                    
                        <s:select label="SEDE" 
                                  headerValue="Seleccione ..." 
                                  name="idSede"   listKey="id" listValue="nombre" value="sede.id"
                                  list="listaSede" />

                 

                 
                            
                            <s:hidden name="id" value="%{id}" />
                            <s:submit value="Guardar"/>
                        </s:iterator>
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