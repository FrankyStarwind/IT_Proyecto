<%-- 
    Document   : errorLogin
    Created on : 08-may-2021, 11:02:11
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
        <h1>Área Usuarios</h1>
        <b style="color:red;">Usuario o Clave no son correctos</b>
        <s:form action="login">
            <s:textfield name="dni" label="DNI" />
            <s:password name="password" label="PASSWORD" />
            <s:submit value="Entrar"></s:submit>
        </s:form>
    </body>
</html>
