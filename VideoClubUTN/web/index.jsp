<%-- 
    Document   : index
    Created on : Aug 15, 2016, 1:57:42 PM
    Author     : MiLaptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        
    </head>
    <body>
        <div>
            <jsp:include page="/pages/generales/header.jsp" />
            <jsp:include page="/mostrarPelicula.do" />     
            <jsp:include page="/pages/generales/footer.jsp" />
        </div>
    </body>
</html>
