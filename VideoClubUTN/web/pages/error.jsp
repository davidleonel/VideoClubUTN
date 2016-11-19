<!DOCTYPE html>


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

        <!--MI PROPIA CSS-->
        <link href="/css/globalStyles.css" rel="stylesheet">
        
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
        <title> Error! </title>

        <%session.setAttribute("paginaActual", "error");%>
  </head>
  <body>
      
    <div class="container-fluid">
        <div class="row">
            <div class="col s8 offset-s2"  style="margin-top: 20px; margin-bottom: 100px">
                 <div class="card center-align " style="border: 2px black solid">
                    <div class="card-image">
                        <img src="graficos/sad.jpg" style="height: 200px; width: auto; margin-top: 10px; margin-left: auto; margin-right: auto;">
                    </div>
                    <div class="card-content">
                        <span class="card-title black-text">Occurio un error!</span>
                    </div>
                    <div class="card-action">
                        <p>Lo sentimos muchisimo pero occurrio un error inesperado.</p>
                    </div>
                </div>   
            </div>
        </div>
    </div>
    </body>
</html>