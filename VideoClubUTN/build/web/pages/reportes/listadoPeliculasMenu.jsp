<%-- 
    Document   : listadoPeliculasMenu
    Created on : Sep 25, 2016, 6:35:45 PM
    Author     : MiLaptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <title>Video Club UTN</title>

        <%session.setAttribute("paginaActual", "listadoPeliculasMenu");%>
    </head>
  
<body>
    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            
            if(tipo.equals("admin"))
            {%>        
                <H2>Bienvenido, <%= session.getAttribute( "nombre" ) %>!</H2>

                <div class="collection" style="margin-bottom: 450px">
                    <a href="/peliculaListado.do" class="collection-item">Listado de todas las peliculas<i class="material-icons secondary-content">send</i></a>
                    <a href="/peliculaListadoDisponibles.do" class="collection-item">Listado de peliculas disponibles<i class="material-icons secondary-content">send</i></a>
                    <a href="listadoPeliculasGeneroMenu.jsp" class="collection-item">Listado por genero<i class="material-icons secondary-content">send</i></a>
                </div>
                <a href="/pages/reportes/menuReportes.jsp" class="waves-effect waves-light btn-large" style="margin-bottom: 30px"><i class="material-icons right">fast_rewind</i>Volver</a>
            <%} 
                else {%> 
                    <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                    <%}%>    
    </div>
    <jsp:include page="/pages/generales/footer.jsp" />
</body>
</html>