<%-- 
    Document   : listadoAdministradores
    Created on : Sep 25, 2016, 6:08:50 PM
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
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <title>Video Club UTN</title>

        <%session.setAttribute("paginaActual", "listadoAdministradores");%>

    </head>
  
<body>

    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            
            if(tipo.equals("admin"))
            {%>
                <h2>Reporte de Aministradores</h2>

                <table class="bordered highlight responsive-table" style="margin-bottom: 400px">
                    <thead>
                        <tr>
                            <th data-field="nombre">Nombre</th>
                            <th data-field="apellido">Apellido</th>
                            <th data-field="email">Email</th>
                            <th data-field="eliminar">Estado</th>
                        </tr>
                    </thead>

                    <tbody>
                    <% 
                    ArrayList<Usuario> listaAdmins = (ArrayList)request.getAttribute("listaAdmins");

                    for (Usuario admin : listaAdmins) {
                    %> 

                        <tr>
                            <td><%=admin.getNombre()%></td>
                            <td><%=admin.getApellido()%></td>
                            <td><%=admin.getEmail()%></td>
                            <td><%=admin.getEstado()%></td>
                        </tr>

                    <%}%>                

                    </tbody>
                </table>
                <a href="/pages/reportes/menuReportes.jsp" class="waves-effect waves-light btn-large" style="margin-bottom: 30px"><i class="material-icons right">fast_rewind</i>Volver</a>
            <%} 
                else {%> 
                    <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                    <%}%>   
    
    </div>

    <jsp:include page="/pages/generales/footer.jsp" />
</body>
</html>