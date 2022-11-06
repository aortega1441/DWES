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

        <header style="background-color: darkkhaki; padding-bottom: 1em; padding-top: 1em; margin-bottom: 2em"><h1 style="color: white; text-align: center">Listado de películas</h1></header>

        <div class="container">                       

            <div class="text-center">

                <div class="row">
                    <div class="col-sm"><form method="post" action="ValidaTodas"><button type="submit">Todas las películas</button></form></div>                           

                    <div class="col-sm"><button onclick="location.href = 'BuscaTitulo.jsp'">Buscar por título</button></div>              

                    <div class="col-sm"><button onclick="location.href = 'BuscaDirector.jsp'">Buscar por director</button></div>   
                </div>                            

                <br><br><br>

                <a href="GestionVideoclub.jsp">Volver a la gestión de películas</a>

            </div>
        </div>

        <footer style="background-color: darkkhaki; margin-top: 2em; padding-top: 2em"></footer>

    </body>
</html>
