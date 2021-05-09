<%-- 
    Document   : indexUsuarios
    Created on : 09-may-2021, 9:42:59
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
        <h1>Visualizar Usuarios</h1>

        <a href="<s:url action="volverIndex"/>">Principal</a></br>

        <!-- Terminar tabla con operaciones CRUD de Usuario -->

        <table border="2">
            <tr align="center">
                <td>Username</td>
                <td>Password</td>
                <td>Nombre</td>
                <td>Apellidos</td>
                <td>Dni</td>
                <td>Email</td>
                <td>Telefono</td>
                <td>Administrador</td>
                
            </tr>
            <s:if test="%{lista.size()!=0}">    
                <s:iterator value="lista">
                    <tr>
                        <td><s:property value="userName"></s:property></td>
                        <td><s:property value="password"></s:property></td>
                        <td><s:property value="nombre"></s:property></td>
                        <td><s:property value="apellidos"></s:property></td>
                        <td><s:property value="dni"></s:property></td>
                        <td><s:property value="email"></s:property></td>
                        <td><s:property value="tlf"></s:property></td>
                        <td><s:property value="admin"></s:property></td>
                                                   
                        </tr>
                </s:iterator>
            </s:if>
        </table>
    </body>
</html>
