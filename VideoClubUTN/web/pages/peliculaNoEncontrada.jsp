<%-- 
    Document   : peliculaNoEncontrada
    Created on : Aug 15, 2016, 1:57:42 PM
    Author     : MiLaptop
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        
        <%session.setAttribute("paginaActual", "peliculaNoEncontrada");%>
  </head>
  <body>
    <div class="container-fluid">
        <jsp:include page="generales/header.jsp"/>

        <div class="row">
            <div class="col s6 offset-s3" style="margin-top: 100px; margin-bottom: 100px">
                <div class="card center-align " style="border: 2px black solid">
                    <div class="card-image">
                        <img src="graficos/sad.jpg" style="height: 300px; width: auto; margin-top: 10px; margin-left: auto; margin-right: auto;">
                    </div>
                    <div class="card-content">
                        <span class="card-title black-text">Pelicula no encontrada!</span>
                    </div>
                    <div class="card-action">
                        <p>Lo sentimos, no tenemos la pelicula que usted busca. Por favor vuelva a intentarlo!</p>
                    </div>
                  </div>
            
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text">
                      <span class="card-title">Buscar Pelicula por Titulo</span>
                        <div class="row">
                            <form action="/buscarPelicula.do">
                                <nav>
                                  <div class="nav-wrapper">
                                      <div class="input-field">
                                        <input name="peliculaBuscada" id="nombrePelicula" type="search" required>
                                        <label for="search"><i class="material-icons">search</i></label>
                                        <i class="material-icons">close</i>
                                      </div>
                                  </div>
                                </nav>
                                <button class="btn waves-effect waves-light right" type="submit" name="action" style="margin-top: 15px">Enviar
                                    <i class="material-icons right">send</i>
                                </button>
                            </form>
                            </br>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="generales/footer.jsp" />
        
    </div>  
</body>
</html>