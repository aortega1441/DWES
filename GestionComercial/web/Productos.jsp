<%-- 
    Document   : Gestion.jsp
    Created on : 2 nov. 2022, 10:03:16
    Author     : vecto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>

        <header style="background-color: #757575; padding-bottom: 2em"></header>

        <h1 style="background-color: lightgray; padding: 1em; text-align: center; margin-bottom: 1em">APLICACIÓN DE GESTIÓN COMERCIAL</h1>


        <div class="container text-center" style="margin-bottom: 1em">
            <div class="row" style="margin-bottom: 1em">
                <div class="col"><button onclick="location.href = 'Ventas.jsp'"><img src="imagenes/ventas.jpg" alt="ventas"/></button></div>
                <div class="col"><button onclick="location.href='Productos.jsp'"><img src="imagenes/productos.jpg" alt="productos"/></button></div>
                <div class="col"><button onclick="location.href='Comerciales.jsp'"><img src="imagenes/comerciales.jpg" alt="comerciales"/></button></div>
            </div>
            <div class="row">
                <div class="col"></div>
                <form method="post" action="ListaProductos"><div class="col"><button type="submit">Listado de productos</button></form>
                <br><br>
                <form method="post" action="NuevoProducto.jsp"><button type="submit">Nuevo producto</button></form><br><br>
                <form method="post" action="ModificarProducto.jsp"><button onclick="location.href = ''">Modificar producto</button></form></div>
            <div class="col"></div>

        </div>
    </div>



    <div style="background-color: #757575; padding-bottom: 2em; margin-bottom: 2em"></div>

    <div class="text-center">


    </div>
    <footer style="background-color: #757575; margin-top: 2em; padding-top: 2em"></footer>
</body>
</html>
