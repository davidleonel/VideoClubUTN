<%-- 
    Document   : modificarUnAdministrador
    Created on : Oct 1, 2016, 3:47:00 PM
    Author     : MiLaptop
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="BaseDeDatos.Usuarios.UsuariosFunc"%>
<%@page import="Entidades.Usuario"%>
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

        <%session.setAttribute("paginaActual", "modificarUnAdministrador");%>

    </head>
    
    <body>
    
    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            
           if(tipo.equals("admin"))
            {
                Usuario adminAModif = (Usuario) request.getAttribute("adminAModif");
                session.setAttribute("emailOriginal", adminAModif.getEmail());
                
        %>
            
            <div class="row">
                      <form class="col s12" action="/adminGuardarModificacion.do" style="margin-top: 50px">
                        <div class="card blue-grey darken-1">
                            <div class="card-content white-text">
                              <span class="card-title">Modificar Administrador</span>
                                <div class="row">
                                  <div class="input-field col s6">
                                      <input name="nombre" type="text" class="validate" placeholder="<%=adminAModif.getNombre()%>" value="<%=adminAModif.getNombre()%>">
                                    <label for="nombre">Nombre</label>
                                  </div>
                                  <div class="input-field col s6">
                                      <input name="apellido" id="last_name" type="text" class="validate" placeholder="<%=adminAModif.getApellido()%>" value="<%=adminAModif.getApellido()%>">
                                    <label for="apellido">Apellido</label>
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="input-field col s12">
                                      <input name="email1" id="email1" type="text" class="validate" placeholder="<%=adminAModif.getEmail()%>" value="<%=adminAModif.getEmail()%>">
                                    <label for="email1">Email</label>
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="input-field col s12">
                                    <input name="email2" id="email2" type="text" class="validate" placeholder="<%=adminAModif.getEmail()%>" value="<%=adminAModif.getEmail()%>">
                                    <label for="email2">Email</label>
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="input-field col s12">
                                      <input name="pass1" id="password" type="text" class="validate" placeholder="<%=adminAModif.getPass()%>" value="<%=adminAModif.getPass()%>">
                                    <label for="pass1">Contraseña</label>
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="input-field col s12">
                                      <input name="pass2" id="password" type="text" class="validate" placeholder="<%=adminAModif.getPass()%>" value="<%=adminAModif.getPass()%>"
                                    <label for="pass2">Contraseña</label>
                                  </div>
                                </div>
                                <div class="row">
                                    <p>
                                        <input name="estado" type="radio" id="ficcion" value="1" <% if (adminAModif.getEstado() == 1) {%> checked <%}%>/>
                                        <label for="ficcion">Habilitado</label>
                                    </p>
                                    <p>
                                        <input name="estado" type="radio" id="drama" value="0" <% if (adminAModif.getEstado() == 0) {%> checked <%}%>/>
                                        <label for="drama">No Habilitado</label>
                                    </p>
                                </div>
                                <button class="btn waves-effect waves-light" type="submit" name="action">Enviar
                                    <i class="material-icons right">send</i>
                                </button>
                            </div>
                        </div>
                    </form>
                <a href="/adminModificacion.do" class="waves-effect waves-light btn-large" style="margin: 11px"><i class="material-icons right">fast_rewind</i>Volver</a>

                </div>
            <%} 
                else {%> 
                    <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                <%}%>
        
        </div>

        <jsp:include page="/pages/generales/footer.jsp" />
    </body>
</html>