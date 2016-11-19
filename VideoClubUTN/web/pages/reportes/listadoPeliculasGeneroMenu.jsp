<%-- 
    Document   : listadoPeliculasGeneroMenu
    Created on : Sep 25, 2016, 6:59:29 PM
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

        <%session.setAttribute("paginaActual", "listadoPeliculasGeneroMenu");%>
    </head>
  
<body>
    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            
            if(tipo.equals("admin"))
            {%> 
                <H2>Seleccione el genero a listar.</H2>

                <div style="margin-bottom: 300px; margin-top: 100px">
                    <form action="/peliculaListadoGenero.do">

                        <div class="row">

                            <div class="col s4 offset-s2">
                                <div class="col s12">
                                    <button type="submit" name="btn" value="accion" class="waves-effect waves-light btn-large" style="width: 100%; padding: 50px">Accion</button>
                                </div>
                            </div>
                            <div class="col s4">
                                <div class="col s12">
                                    <button type="submit" name="btn" value="ficcion" class="waves-effect waves-light btn-large" style="width: 100%; padding: 50px">Ficcion</button>
                                </div>
                            </div>

                        </div>
                        <div class="row">

                            <div class="col s4 offset-s2">
                                <div class="col s12">
                                    <button type="submit" name="btn" value="drama" class="waves-effect waves-light btn-large" style="width: 100%; padding: 50px">Drama</button>
                                </div>
                            </div>
                            <div class="col s4">
                                <div class="col s12">
                                    <button type="submit" name="btn" value="suspenso" class="waves-effect waves-light btn-large" style="width: 100%; padding: 50px">Suspenso</button>
                                </div>
                            </div>

                        </div>


                    </form>
                </div>
                <a href="/pages/reportes/listadoPeliculasMenu.jsp" class="waves-effect waves-light btn-large" style="margin-bottom: 30px"><i class="material-icons right">fast_rewind</i>Volver</a>
             <%} 
                else {%> 
                    <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                    <%}%>   
    </div>
    <jsp:include page="/pages/generales/footer.jsp" />
</body>
</html>