<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@page import="Entidades.Pelicula"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
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
        
        <%session.setAttribute("paginaActual", "index");%>
        
        <script>
            function informar(){
                var msjError = "<%= session.getAttribute("mensajeError")%>";
                
                if (msjError !== "null") {
                    alert(msjError);
                    <%session.setAttribute("mensajeError", null);%>
                }
            } 
        </script> 
        
    </head>
    <body onLoad="informar()">
        
        <jsp:include page="/pages/generales/header.jsp" />
        
        <div class="row" >
            
            <div class="col s2 teal darken-3" style="margin-bottom: -5000px; padding-bottom: 7500px;">
                <div class="collection">
                <a href="/buscarPeliculaEstreno.do" class="collection-item">Estrenos del mes</a>
                <a href="#!" class="collection-item">Mejor puntuacion [NO DISP]</a>
                <a href="#!" class="collection-item">Reviews [NO DISP]</a>
                <a href="#!" class="collection-item">Contactanos [NO DISP]</a>
              </div>
            </div>

            <div class="col s10">
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text" style="padding-top: 10px; padding-bottom: 10px">
                        <H2 style="margin: 0;">Peliculas disponibles:</H2>
                    </div>                
                </div>

                        <% 
                        ArrayList<Pelicula> listaPeliculas = (ArrayList)request.getAttribute("estrenos");
                        for (Pelicula pelicula : listaPeliculas) {
                        %>  
                        <div class="col s3">
                                <div class="card" style="height: 550px">
                                    <div class="card-image waves-effect waves-block waves-light">
                                        <img class="activator" src="pages/graficos/<%=pelicula.getNombre()%>.jpg" style="height: 450px">
                                    </div>
                                    <div class="card-content">
                                        <span class="card-title activator grey-text text-darken-4"><%=pelicula.getNombre()%></span>
                                        <form action="/peliculaAlquilar.do" style="position: relative;">
                                            <button class="waves-effect waves-teal btn-flat" type="submit" name="btn" value="<%=pelicula.getNombre()%>" style="margin-left: 140px; margin-top: -4px">Alquilar</button>
                                        </form>
                                    </div>
                                </div>
                            </div>     

                        <%}%>                
            </div>
        
        </div>
     
        <jsp:include page="/pages/generales/footer.jsp" />         
    </body>
</html>