<%-- 
    Document   : home
    Created on : 16-may-2021, 10:44:05
    Author     : Laura
--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPO-Deporte</title>
        <s:head/>

    </head>  

    <body>
        <h1>Bienvenido a Actividades Deportivas<br>
            la mejor página para realizar competiciones.</h1>


        <p>En Actividades Deportivas podrás gestionar tus competiciones de forma cómoda y 
            en cualquier lugar.</p>      

        <!-- Menu -->
        <%@include file="includes/include_menu.jsp" %>
        <!-- Información -->
        <%@include file="includes/include_section.jsp" %>

    </body>
</html>
