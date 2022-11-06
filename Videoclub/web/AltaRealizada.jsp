<%-- 
    Document   : AltaRealizada.jsp
    Created on : 5 nov. 2022, 12:51:01
    Author     : vecto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>

        <%

            String pelicula = (String) getServletContext().getAttribute("pelicula");

        %>

        <h1 style="color: green; background-color: lightgreen; text-align: center; padding: 0.5em">Alta película</h1>
        <div class="text-center">
        <h2>La película <%=pelicula%> se ha dado de alta correctamente</h2>
        <br>
        
        <button onclick="location.href = 'AltaPelicula.jsp'">Volver a alta de películas</button>
        </div>
    </body>
</html>

