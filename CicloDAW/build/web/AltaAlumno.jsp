<%-- 
    Document   : AltaAlumno.jsp
    Created on : 7 nov. 2022, 11:50:19
    Author     : vecto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1 class="text-center alert-primary" style="padding-bottom: 0.5em; padding-top: 0.5em">Alta de alumno</h1>
        
        <br><br>
        
        <form action="ValidaAlta" method="post" class="text-center"> 
            
            <table style="margin: auto">
                
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="" /></td>
                </tr>
                
                <tr>
                    <td>Apellidos:</td>
                    <td><input type="text" name="apellidos" value="" /></td>
                </tr>
                
                <tr>
                    <td>DAWES:</td>
                    <td><input type="text" name="dawes" value="" /></td>
                </tr>
                
                <tr>
                    <td>DAWEC:</td>
                    <td><input type="text" name="dawec" value="" /></td>
                </tr>
                
                <tr>
                    <td>DIW:</td>
                    <td><input type="text" name="diw" value="" /></td>
                </tr>
                
                <tr>
                    <td>DAW:</td>
                    <td><input type="text" name="daw" value="" /></td>
                </tr>
                
                <tr>
                    <td>FCT:</td>
                    <td><input type="text" name="fct" value="" /></td>
                </tr>
                
                <tr>
                    <td>proyecto:</td>
                    <td><input type="text" name="proyecto" value="" /></td>
                </tr>
                
            </table>
            
            <br>
            
            <input class="btn btn-primary" type="submit" value="Añadir" />
                    
        </form>
        
    </body>
</html>
