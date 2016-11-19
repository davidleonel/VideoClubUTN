<%-- 
    Document   : index
    Created on : Aug 15, 2016, 1:57:42 PM
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

        <%session.setAttribute("paginaActual", "adminBienvenida");%>
    </head>
  
<body>
    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        <H2>Bienvenido, <%= session.getAttribute( "nombre" ) %>!</H2>
    
        <div class="collection" style="margin-bottom: 460px">
            <a href="ABM/menuAbmPeliculas.jsp" class="collection-item">Administrar Peliculas <i class="material-icons secondary-content">send</i></a>
            <a href="ABM/menuAbmAdministradores.jsp" class="collection-item">Administrar Administradores <i class="material-icons secondary-content">send</i></a>
            <a href="ABM/menuAbmUsuarios.jsp" class="collection-item">Administrar Usuarios <i class="material-icons secondary-content">send</i></a>
            <a href="reportes/menuReportes.jsp" class="collection-item">Reportes <i class="material-icons secondary-content">send</i></a>
        </div>
    
    </div>
    <jsp:include page="/pages/generales/footer.jsp" />
</body>
</html>