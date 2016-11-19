<%-- 
    Document   : altaUsuarios
    Created on : Aug 17, 2016, 11:32:20 PM
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

        <%session.setAttribute("paginaActual", "altaPelicula");%>
    </head>
  
<body>
    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            
           if(tipo.equals("admin"))
            {%>
                <div class="row">
                    <form class="col s12" action="/peliculaAlta.do">
                      <div class="card blue-grey darken-1">
                          <div class="card-content white-text">
                              <span class="card-title">Alta Pelicula</span>
                              <div class="row">
                                <div class="input-field col s6">
                                  <input name="nombre" type="text" class="validate">
                                  <label for="nombre">Nombre</label>
                                </div>
                                <div class="input-field col s6">
                                  <input name="genero" id="last_name" type="text" class="validate">
                                  <label for="genero">Genero</label>
                                </div>
                              </div>
                              <div class="row">
                                <div class="input-field col s12">
                                  <input name="precio" id="precio" type="text" class="validate">
                                  <label for="precio">Precio</label>
                                </div>
                              </div>
                              <div class="row">
                                <div class="input-field col s12">
                                  <input name="disponibilidad" id="disponibilidad" type="text" class="validate">
                                  <label for="disponibilidad">Disponibilidad</label>
                                </div>
                              </div>
                              <div class="row">
                                <div class="input-field col s12">
                                  <input name="duracion" id="duracion" type="text" class="validate">
                                  <label for="duracion">Duracion</label>
                                </div>
                              </div>
                            <div class="row">
                                <div class="input-field col s12">
                                  <textarea name="descripcion" id="descripcion" class="materialize-textarea"></textarea>
                                  <label for="descripcion">Descripcion</label>
                                </div>
                            </div>
                            <div class="row">
                                <p>
                                    <input name="estado" type="radio" id="ficcion" value="1"/>
                                    <label for="ficcion">Estreno</label>
                                </p>
                                <p>
                                    <input name="estado" type="radio" id="drama" value="0" />
                                    <label for="drama">No Estreno</label>
                                </p>
                            </div>
                            <div class="row">
                                <div class="col s3 offset-s9">
                                    <button class="btn waves-effect waves-light right-align" type="submit" name="action">Agregar foto
                                        <i class="material-icons right">send</i>
                                    </button>
                                </div> 
                            </div>
                            </div>
                        </div>
                    </form>
                 </div>
            <a href="/pages/ABM/menuAbmPeliculas.jsp" class="waves-effect waves-light btn-large" style="margin-bottom: 30px"><i class="material-icons right">fast_rewind</i>Volver</a>

        <%} 
            else {%> 
                <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                <%}%>
    </div>

    <jsp:include page="/pages/generales/footer.jsp" />
</body>
</html>