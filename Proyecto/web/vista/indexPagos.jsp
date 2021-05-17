<%-- 
    Document   : indexPagos
    Created on : 16-may-2021, 21:02:22
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
        <h1>Listado de Pagos</h1>
        <!-- Terminar tabla con operaciones CRUD de Usuario -->
        <!-- Insertar, Borrar, Editar y Buscar-->

        <table border="2">
            <tr align="center">
                <td>Método Pago</td>
                <td>Importe</td>
                <td>Pagado</td> 
                <td>Fecha</td>                         
            </tr>   
            <s:iterator value="lista">
                <tr align="center">
                    <td><s:property value="metodoPago"></s:property></td>
                    <td><s:property value="importe"></s:property></td>
                    <s:if test="pagado != 0">
                        <td>Sí</td>                              
                    </s:if>
                    <s:else>
                        <td>No</td>
                    </s:else>   
                    <td><s:property value="fecha"></s:property></td>
                    </tr>
            </s:iterator>
        </table>
    </body>
</html>

