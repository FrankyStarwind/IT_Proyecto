<%-- 
    Document   : include_menu
    Created on : 16-may-2021, 10:46:44
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<nav id="menu">
    <header class="major">
        <h2>Menu</h2>
    </header>
    <ul>
        <li><a href="<s:url action="home"/>">Inicio</a></li>
        <li><a href="<s:url action="contacto"/>">Contactanos</a></li>
        <li><a href="<s:url action="areaUsuario"/>">Area Usuarios</a></li>
        <li><a href="<s:url action="mostrarActividades"/>">Actividades</a></li>
    </ul>
</nav>
