<%-- 
    Document   : administrarPeliculasMenu
    Created on : Sep 18, 2016, 3:34:55 PM
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

        <%session.setAttribute("paginaActual", "menuAbmPeliculas");%>
        
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
                <H2>ABM Peliculas</H2>

                <div class="collection" style="margin-bottom: 400px">
                    <a href="peliculas/altaPelicula.jsp" class="collection-item">Alta Pelicula <i class="material-icons secondary-content">send</i></a>
                    <a href="/peliculaBaja.do" class="collection-item">Baja Peliculas <i class="material-icons secondary-content">send</i></a>
                    <a href="/peliculasModificacion.do" class="collection-item">Modificar Pelicula <i class="material-icons secondary-content">send</i></a>
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