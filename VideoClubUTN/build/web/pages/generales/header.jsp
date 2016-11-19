<%-- 
    Document   : header
    Created on : Aug 20, 2016, 5:18:16 PM
    Author     : MiLaptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%if(session.getAttribute("nombre")==null)
{%>
    <jsp:include page="/pages/generales/menu/menuNoLogeado.jsp"/>
<% }
else { 
    if(session.getAttribute("tipoUsuario").equals("admin"))
    {%>
        <jsp:include page="/pages/generales/menu/menuAdmin.jsp"/>
    <%}
    else {%>
        <jsp:include page="/pages/generales/menu/menuLogeado.jsp"/>
    <%}%>

    
<%}%>    
