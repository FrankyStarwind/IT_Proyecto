<%-- 
    Document   : login
    Created on : 08-may-2021, 10:56:12
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
        <h1>Login</h1>
        <s:form action="login">
            <s:textfield name="dni" label="DNI" />
            <s:password name="password" label="PASSWORD" />
            <s:submit value="Entrar"></s:submit>
        </s:form>
    </body>
</html>