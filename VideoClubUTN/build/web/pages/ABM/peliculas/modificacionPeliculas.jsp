<%-- 
    Document   : modificacionPeliculas
    Created on : Sep 18, 2016, 4:18:56 PM
    Author     : MiLaptop
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="BaseDeDatos.Usuarios.UsuariosFunc"%>
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

        <%session.setAttribute("paginaActual", "modificacionPeliculas");%>
    </head>
  
<body>
    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            
            if(tipo.equals("admin"))
            {%>
            <h2>Modificacion de Peliculas</h2>
            <table class="bordered highlight responsive-table" style="margin-bottom: 350px;">
                <thead>
                    <tr>
                        <th data-field="nombre">Nombre</th>
                        <th data-field="apellido">Genero</th>
                        <th data-field="precio">Precio</th>
                        <th data-field="disponibilidad">Disponibilidad</th>
                        <th data-field="duracion">Duracion</th>
                        <th data-field="duracion">Modificar</th>
                    </tr>
                </thead>

                <tbody>
                <% 
                ArrayList<Pelicula> listaPeliculas = (ArrayList)request.getAttribute("listaPeliculas");

                for (Pelicula pelicula : listaPeliculas) {
                %> 


                    <tr>
                        <td><%=pelicula.getNombre()%></td>
                        <td><%=pelicula.getGenero()%></td>
                        <td><%=pelicula.getPrecio()%></td>
                        <td><%=pelicula.getDisponibilidad()%></td>
                        <td><%=pelicula.getDuracion()%></td>
                        <td> 
                            <form action="/peliculaModificarUna.do">
                                <button type="submit" name="btn" value="<%=pelicula.getNombre()%>" class="btn-floating btn-large waves-effect waves-light red">
                                    <i class="material-icons">supervisor_account</i>
                                </button>
                            </form>
                        </td>
                    </tr>

                <%}%>                

                </tbody>
            </table>
                
            <a href="/pages/ABM/menuAbmPeliculas.jsp" class="waves-effect waves-light btn-large" style="margin-bottom: 110px"><i class="material-icons right">fast_rewind</i>Volver</a>
            <%} 
                else {%> 
                    <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                <%}%>
    </div>

    <jsp:include page="/pages/generales/footer.jsp" />
</body>
</html>
    
    
    
    
    