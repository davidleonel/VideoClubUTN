<%-- 
    Document   : devolverPelicula
    Created on : Nov 9, 2016, 6:33:58 PM
    Author     : MiLaptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="BaseDeDatos.Alquileres.AlquileresFunc"%>
<%@page import="Entidades.Alquiler"%>
<%@page import="java.util.ArrayList"%>

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
        
        <script>
            function informar(){
                var msjError = "<%= session.getAttribute("mensajeError")%>";
                
                if (msjError !== "null") {
                    alert(msjError);
                    <%session.setAttribute("mensajeError", null);%>
                }

            } 
        </script> 
        
        <%session.setAttribute("paginaActual", "devolverPelicula");%>
  </head>
  <body onLoad="informar()">
    <div class="container-fluid">
        <jsp:include page="generales/header.jsp"/>
        
        <div class="container">
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            
            if(tipo.equals("usuario"))
            {%>
            <h2>Alquileres pendientes</h2>
            <table class="bordered highlight responsive-table" style="margin-bottom: 350px;">
                <thead>
                    <tr>
                        <th data-field="idPelicual">Id</th>
                        <th data-field="nombre">Nombre</th>
                        <th data-field="fecha">Fecha</th>
                        <th data-field="devolver">Devolver</th>
                    </tr>
                </thead>

                <tbody>
                <% 
                ArrayList<Alquiler> listaAlquileres = (ArrayList)request.getAttribute("listaAlquileres");

                for (Alquiler alquiler : listaAlquileres) {
                %> 


                    <tr>
                        <td><%=alquiler.getIdPelicula()%></td>
                        <td><%=alquiler.getNombrePelicula()%></td>
                        <td><%=alquiler.getFecha()%></td>
                        <td> 
                            <form action="/devolverAlquilerUno.do">
                                <button type="submit" name="btn" value="<%=alquiler.getNombrePelicula()%>" class="btn-floating btn-large waves-effect waves-light red">
                                    <i class="material-icons">supervisor_account</i>
                                </button>
                            </form>
                        </td>
                    </tr>

                <%}%>                

                </tbody>
            </table>
                
            <%} 
                else {%> 
                    <h2>Lo sentimos, página sólo habilitada para usuarios.</h2>
                <%}%>
    </div>
        
        <jsp:include page="generales/footer.jsp" />
        
    </div>  
</body>
</html>
