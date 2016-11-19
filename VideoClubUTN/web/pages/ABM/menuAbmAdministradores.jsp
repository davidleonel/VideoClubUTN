<%-- 
    Document   : administrarAdministradoresMenu
    Created on : Sep 18, 2016, 3:35:08 PM
    Author     : MiLaptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <title>Video Club UTN</title>

        <%session.setAttribute("paginaActual", "menuAbmAdministradores");%>
        
        <script>
            function informar(){
                var msjError = "<%= session.getAttribute("mensajeError")%>";
                var msjExito = "<%= session.getAttribute("mensajeExito")%>";
                
                if (msjError !== "null") {
                    alert(msjError);
                    <%session.setAttribute("mensajeError", null);%>
                }

                if (msjExito !== "null") {
                    alert(msjExito);
                    <%session.setAttribute("mensajeExito", null);%>
                }
            } 
        </script> 
    </head>
  
<body onLoad="informar()">
    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            if(tipo.equals("admin"))
            {%>

                <H2>ABM Admins</H2>

                <div class="collection" style="margin-bottom: 450px">
                    <a href="administradores/altaAdministrador.jsp" class="collection-item">Alta Admin <i class="material-icons secondary-content">send</i></a>
                    <a href="/adminBaja.do" class="collection-item">Baja Admins <i class="material-icons secondary-content">send</i></a>
                    <a href="/adminModificacion.do" class="collection-item">Modificar Admin <i class="material-icons secondary-content">send</i></a>
                </div>
                    <a href="/pages/administradorBienvenida.jsp" class="waves-effect waves-light btn-large" style="margin-bottom: 30px"><i class="material-icons right">fast_rewind</i>Volver</a>
                
            <%} 
                else {%> 
                    <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                    <%}%>
    </div>  
    <jsp:include page="/pages/generales/footer.jsp" />
    
</body>
</html>
       