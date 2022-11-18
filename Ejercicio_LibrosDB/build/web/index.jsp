<%-- 
    Document   : index.jsp
    Created on : 28 oct. 2022, 12:24:21
    Author     : vecto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <h1>Biblioteca del departamento de informática</h1>

            <br><br><br><br>

            <form action="ServletControlador" method="post">

                <label >Título del libro</label>
                &nbsp;&nbsp;
                <input id="titulo" name="titulo" type="text">
                &nbsp;&nbsp;
                <button type="submit" id="acceder">Acceder</button>

            </form>
        </div>
    </body>
</html>
