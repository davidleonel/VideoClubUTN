<%-- 
    Document   : index
    Created on : Aug 15, 2016, 1:57:42 PM
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

        <!--MI PROPIA CSS-->
        <link href="/css/globalStyles.css" rel="stylesheet">
        
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
        <title>Video Club UTN</title>
        
        <%session.setAttribute("paginaActual", "usuarioLogin");%>
  </head>
  <body>
    
    <jsp:include page="generales/header.jsp"/>
    <div class="container">
        <%try{%>
            <div class="row">
                <div class="col s8 offset-s2"  style="margin-top: 20px;">
                    <div class="card blue-grey darken-1">
                        <div class="card-content white-text">

                            <!-- CONTROL DE USUARIO LOGUEADO -->
                            <%if(session.getAttribute("nombre")==null)
                            {%>

                            <span class="card-title">Login</span>
                            <div class="row">
                                <form class="col s12" action="/usuarioLogin.do" method="POST">
                                    <div class="row">
                                        
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">account_circle</i>
                                            <input name="email" id="icon_prefix" type="text" class="validate">
                                        </div>
                                        
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix">vpn_key</i>
                                            <input name="pass" id="icon_telephone" type="password" class="validate">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-default right">Enviar
                                        <i class="material-icons right">send</i>
                                    </button>
                                        <!-- USUARIO NO ENCONTRADO-->
                                        <%if(session.getAttribute("mensajeExito")!=null)
                                            {%>
                                                <br><br><br>        
                                                <div class="alert alert-danger" id="divErrorServlet">
                                                    <% out.print((String)session.getAttribute("mensajeExito"));
                                                        session.setAttribute("mensajeExito", null);
                                                        %>
                                                </div>
                                         <%}%>

                                    <div>
                                        <!--DIV PARA MOSTRAR ERRORES-->
                                        <div id="divError" class="alert alert-danger hidden"></div>
                                    </div>


                                </form>

                            <!-- USUARIO YA LOGUEADO -->
                            <%}else{%>
                            <h3> No puede acceder a este sitio, aún se encuentra logueado en el sistema.</h3>
                            <%}%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
               
             <div class="row">
                <div class="col s8 offset-s2"  style="margin-top: 20px; margin-bottom: 100px">
                     <div class="card center-align " style="border: 2px black solid">
                        <div class="card-image">
                            <img src="graficos/happy.jpg" style="height: 200px; width: auto; margin-top: 10px; margin-left: auto; margin-right: auto;">
                        </div>
                        <div class="card-content">
                            <span class="card-title black-text">Debe logearse antes de poder continuar!</span>
                        </div>
                        <div class="card-action">
                            <p>Si no tiene una cuenta aun, puede registrarse usando el formulario de abajo.</p>
                        </div>
                    </div>       
                    <div class="card blue-grey darken-1">
                        <div class="card-content white-text">
                            <span class="card-title">Registrarme</span>
                            <form action="/usuarioRegister.do" method="POST">
                                <div class="row">
                                    <div class="input-field col s6">
                                        <input name="nombre" type="text" class="validate">
                                        <label for="nombre">Nombre</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <input name="apellido" id="last_name" type="text" class="validate">
                                        <label for="apellido">apellido</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input name="email1" id="email1" type="text" class="validate">
                                        <label for="email1">Email</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input name="email2" id="email2" type="text" class="validate">
                                        <label for="email2">Email</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input name="pass1" id="pass1" type="password" class="validate">
                                        <label for="pass1">Contraseña</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input name="pass2" id="pass2" type="password" class="validate">
                                        <label for="pass2">Contraseña</label>
                                    </div>
                                    <button class="btn waves-effect waves-light right" type="submit" name="action" style="margin-top: 15px; margin-right: 10px">Enviar
                                        <i class="material-icons right">send</i>
                                    </button>
                                </div>
                                
                            </form>
                        </div>
                    </div>
                </div>
            </div>                
        <%}catch (Exception e)
        {
            session.setAttribute("errorCatch", e.toString());
            RequestDispatcher rd =null;

            rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
        }%>
    
    </div>
    
    <jsp:include page="generales/footer.jsp" />
        
      
</body>
</html>