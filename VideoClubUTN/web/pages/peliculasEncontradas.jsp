<%-- 
    Document   : peliculaEncontrada
    Created on : Sep 17, 2016, 8:07:02 PM
    Author     : MiLaptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="BaseDeDatos.Peliculas.PeliculasFunc"%>
<%@page import="Entidades.Pelicula"%>
<%@page import="java.util.ArrayList"%>


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
        <!--MI PROPIA CSS-->
        <link href="/css/globalStyles.css" rel="stylesheet">

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        
      
        <title>Video Club UTN</title>
        
        <%session.setAttribute("paginaActual", "peliculasEncontrada");%>
        
  </head>
  
  <body>
    <div class="container-fluid">
        <jsp:include page="generales/header.jsp"/>
        
        <H2>Peliculas de <%=request.getParameter("genero")%>.</H2>
        <div class="row">
            <div class="col s10 offset-s1">
            <% 
            ArrayList<Pelicula> listaPeliculas = (ArrayList)request.getAttribute("listaPeliculas");
            for (Pelicula pelicula : listaPeliculas) {
            %>  
                <div class="col s3">
                    <div class="card" style="height: 550px">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="pages/graficos/<%=pelicula.getNombre()%>.jpg" style="height: 450px">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4"><%=pelicula.getNombre()%></span>
                            <form action="/peliculaAlquilar.do">
                                <button class="waves-effect waves-teal btn-flat" type="submit" name="btn" value="<%=pelicula.getNombre()%>" style="margin-left: 140px; margin-top: -4px">Alquilar pelicula</button>
                            </form>
                        </div>
                    </div>
                </div>
            <%}%>
          </div>  
        </div>          
        <jsp:include page="generales/footer.jsp" />
        
    </div>  
</body>
</html>