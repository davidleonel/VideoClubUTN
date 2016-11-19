<%-- 
    Document   : peliculaInfo
    Created on : Sep 24, 2016, 5:20:36 PM
    Author     : MiLaptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entidades.Pelicula"%>

<!DOCTYPE html>
<html lang="en">
<head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Compiled and minified JavaScript -->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
      <!-- Compiled and minified CSS -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--MI PROPIA CSS-->
      <link href="/css/globalStyles.css" rel="stylesheet">
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

      <title>Video Club UTN</title>

      <%session.setAttribute("paginaActual", "peliculaAlquilar");%>
</head>
<body>
    <jsp:include page="generales/header.jsp"/>
    
    
    <%
        Pelicula pelicula = (Pelicula) request.getAttribute("peliculaInteresada");
        System.out.println(pelicula.getNombre());
    %>
    
    <div class="container" style="margin-bottom: 50px">
        
        <div class="col s12 m7">
            <h2 class="header"><%=pelicula.getNombre()%></h2>
            <div class="card horizontal">
                <div class="card-image">
                    <img class="activator" src="pages/graficos/<%=pelicula.getNombre()%>.jpg" style="height: 500px">
                </div>
                <div class="card-stacked">
                    <div class="card-content">
                        <p>Titulo: <%=pelicula.getNombre()%></p>
                        <p>Genero: <%=pelicula.getGenero()%></p>
                        <p>Precio: <%=pelicula.getPrecio()%></p>
                        <p>Duracion: <%=pelicula.getDuracion()%></p>
                        <p>Descripcion:</p>
                        <div class="row">
                            <div class="col s12 m">
                              <div class="card-panel teal darken-3">
                                <span class="white-text"><%=pelicula.getDescripcion()%></span>
                              </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a href="index.jsp" class="waves-effect waves-dark btn-large left"><i class="material-icons right">fast_rewind</i>Volver</a>
            <a href="/alquilerConfirmadoPelicula.do" class="waves-effect waves-dark btn-large right"><i class="material-icons right">fast_forward</i>Alquilar</a>
        </div>

    </div>          
    <jsp:include page="generales/footer.jsp" />                
</body>
</html>
