<%-- 
    Document   : modificarUnaPelicula
    Created on : Oct 1, 2016, 6:35:34 PM
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

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <title>Video Club UTN</title>

        <%session.setAttribute("paginaActual", "modificarUnaPelicula");%>

    </head>
    
    <body>
    
    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            
           if(tipo.equals("admin"))
            {
                Pelicula peliAModif = (Pelicula) request.getAttribute("peliAModif");
                session.setAttribute("nombreOriginal", peliAModif.getNombre());
                
        %>
            
            <div class="row">
                      <form class="col s12" action="/peliculaGuardarModificacion.do" style="margin-top: 50px">
                        <div class="card blue-grey darken-1">
                            <div class="card-content white-text">
                              <span class="card-title">Modificar Administrador</span>
                                <div class="row">
                                  <div class="input-field col s6">
                                      <input name="nombre" type="text" class="validate" placeholder="<%=peliAModif.getNombre()%>" value="<%=peliAModif.getNombre()%>">
                                    <label for="nombre">Nombre</label>
                                  </div>
                                  <div class="input-field col s6">
                                      <input name="genero" id="last_name" type="text" class="validate" placeholder="<%=peliAModif.getGenero()%>" value="<%=peliAModif.getGenero()%>">
                                    <label for="genero">Genero</label>
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="input-field col s12">
                                      <input name="precio" id="precio" type="text" class="validate" placeholder="<%=peliAModif.getPrecio()%>" value="<%=peliAModif.getPrecio()%>">
                                    <label for="precio">Precio</label>
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="input-field col s12">
                                    <input name="disponibilidad" id="disponibilidad" type="text" class="validate" placeholder="<%=peliAModif.getDisponibilidad()%>" value="<%=peliAModif.getDisponibilidad()%>">
                                    <label for="disponibilidad">Disponibilidad</label>
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="input-field col s12">
                                      <input name="duracion" id="duracion" type="text" class="validate" placeholder="<%=peliAModif.getDuracion()%>" value="<%=peliAModif.getDuracion()%>">
                                    <label for="duracion">Duracion</label>
                                  </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                      <textarea id="descripcion" class="materialize-textarea" placeholder="<%=peliAModif.getDescripcion()%>" value="<%=peliAModif.getDescripcion()%>"></textarea>
                                      <label for="descripcion">Descripcion</label>
                                  </div>
                                </div>
                                <button class="btn waves-effect waves-light" type="submit" name="action">Enviar
                                    <i class="material-icons right">send</i>
                                </button>
                            </div>
                        </div>
                    </form>
                <a href="/peliculaModificacion.do" class="waves-effect waves-light btn-large" style="margin: 11px"><i class="material-icons right">fast_rewind</i>Volver</a>

                </div>
            <%} 
                else {%> 
                    <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                <%}%>
        
        </div>

        <jsp:include page="/pages/generales/footer.jsp" />
    </body>
</html>