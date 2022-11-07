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

        <header style="background-color: activeborder; padding-bottom: 1em; padding-top: 1em"><h1 style="color: white; text-align: center">Acceso</h1></header>

        <div class="container">

            <div class="text-center">            

                <form action="ValidaLogin" method="post">

                    <h3 style="margin-top: 1em; color: blueviolet">Introduzca el usuario y la clave autorizada</h3>
                    <br>

                    Usuario:
                    <input type="text" name="usuario" value="" />

                    <br>
                    <br>

                    Contraseña: 
                    <input type="text" name="contrasena" value="" />

                    <br>
                    <br>

                    <input type="submit" value="Aceptar" />
                    
                </form>

            </div>
        </div>

        <footer style="background-color: activeborder; margin-top: 2em; padding-top: 2em"></footer>

    </body>
</html>
