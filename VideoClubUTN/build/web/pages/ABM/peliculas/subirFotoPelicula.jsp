<%-- 
    Document   : subirfotoPelicula
    Created on : Nov 18, 2016, 10:57:20 PM
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
                <div class="row" style="padding-top: 50px">
                    <form class="col s12"  method="post" action="/peliculaSubirFoto.do" enctype="multipart/form-data">
                        <div class="card blue-grey darken-1">
                            <div class="input-field col s12">
                                <div class="card-content white-text"> 
                                     <span class="card-title">Foto de la pelicula</span>
                                     <p> *La foto debe tener exactamente el mismo nombre que la pelicula y ser del formato " .jpg " </p>
                                </div>
                                </br>
                                <input name="fotoPelicula" id="fotoPelicula" type="file" class="validate">
                                </br>
                                </br>
                            </div>
                            <div class="row">
                                <div class="col s3 offset-s9">
                                    <button class="btn waves-effect waves-light" type="submit" name="action">Enviar
                                        <i class="material-icons right">send</i>
                                    </button>
                                </div>
                            </div>
                            </br>
                        </div>
                    </form>
                 </div>
        <%} 
            else {%> 
                <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                <%}%>
    </div>

    <jsp:include page="/pages/generales/footer.jsp" />
</body>
</html>