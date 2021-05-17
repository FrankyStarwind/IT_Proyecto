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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ACTIVIDADES DEPORTIVAS</title>
    </head>
    <body>
        <!-- Comprobamos el tipo de usuario-->
        <s:if test="%{#session.usuario != null}">
            <h2>Bienvenido <s:property value="#session.usuario" /></h2>
            <ul>
                <li><a href="<s:url action="pagos"><s:param name="dni" value="%{#session.dni}">
                           </s:param>
                       </s:url>">Ver Pagos</a></li>
                <li><a href="<s:url action="misDatos"><s:param name="dni" value="%{#session.dni}">
                           </s:param>
                       </s:url>">Ver Mis Datos</a></li>
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
                <li><a href="<s:url action="logout"/>">Logout</a></li>
            </ul>
        </s:else>
    </body>
</html>

