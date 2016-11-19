<%-- 
    Document   : altaUsuarios
    Created on : Aug 17, 2016, 11:32:20 PM
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

        <%session.setAttribute("paginaActual", "bajaAdministradores");%>
        
        <script>
            function informar(){
                var msjError = "<%= session.getAttribute("mensajeError")%>";
                var msjExito = "<%= session.getAttribute("mensajeExito")%>";
                
                if (msjError !== "null") {
                    alert(msjError);
                    <%session.setAttribute("mensajeError", null);%>
                }

                if (msjExito !== "null") {
                    alert(msjExito);
                    <%session.setAttribute("mensajeExito", null);%>
                }
            } 
        </script> 

    </head>
  
<body onLoad="informar()">

    <jsp:include page="/pages/generales/header.jsp" />
    <div class="container">
        <% 
            String tipo = (String)session.getAttribute("tipoUsuario");
            
            if(tipo.equals("admin"))
            {%>
            <h2>Baja de Administradores</h2>
            <table class="bordered highlight responsive-table" style="margin-bottom: 350px ">
                <thead>
                    <tr>
                        <th data-field="nombre">Nombre</th>
                        <th data-field="apellido">Apellido</th>
                        <th data-field="email">Email</th>
                        <th data-field="eliminar">Eliminar</th>
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
                        <td> 
                            <form action="/adminEliminarUno.do">
                                <button type="submit" name="btn" value="<%=admin.getEmail()%>" class="btn-floating btn-large waves-effect waves-light red">
                                    <i class="material-icons">delete</i>
                                </button>
                            </form>
                        </td>
                    </tr>

                <%}%>                

                </tbody>
            </table>
            <a href="/pages/ABM/menuAbmAdministradores.jsp" class="waves-effect waves-light btn-large" style="margin-bottom: 30px"><i class="material-icons right">fast_rewind</i>Volver</a>
            <%} 
                else {%> 
                    <h2>Lo sentimos, página sólo habilitada para administradores.</h2>
                <%}%>
    </div>

    <jsp:include page="/pages/generales/footer.jsp" />
</body>
</html>