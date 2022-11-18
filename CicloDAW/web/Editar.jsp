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
        
        <%
        
            String nombre = (String) getServletContext().getAttribute("name");
            String apellidos = (String) getServletContext().getAttribute("surname");
            String dawes = (String) getServletContext().getAttribute("dawes");
            String dawec = (String) getServletContext().getAttribute("dawec");
            String diw = (String) getServletContext().getAttribute("diw");
            String daw = (String) getServletContext().getAttribute("daw");
            String fct = (String) getServletContext().getAttribute("fct");
            String proyecto = (String) getServletContext().getAttribute("proyecto");
        
        %>
        
        <h1 class="text-center alert-primary" style="padding-bottom: 0.5em; padding-top: 0.5em">Consulta de alumno</h1>
        
        <br><br>
        
        <form action="ValidaModificar" method="post" class="text-center"> 
            
            <table style="margin: auto">
                
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="<%=nombre%>" /></td>
                </tr>
                
                <tr>
                    <td>Apellidos:</td>
                    <td><input type="text" name="apellidos" value="<%=apellidos%>" /></td>
                </tr>
                
                <tr>
                    <td>DAWES:</td>
                    <td><input type="text" name="dawes" value="<%=dawes%>" /></td>
                </tr>
                
                <tr>
                    <td>DAWEC:</td>
                    <td><input type="text" name="dawec" value="<%=dawec%>" /></td>
                </tr>
                
                <tr>
                    <td>DIW:</td>
                    <td><input type="text" name="diw" value="<%=diw%>" /></td>
                </tr>
                
                <tr>
                    <td>DAW:</td>
                    <td><input type="text" name="daw" value="<%=daw%>" /></td>
                </tr>
                
                <tr>
                    <td>FCT:</td>
                    <td><input type="text" name="fct" value="<%=fct%>" /></td>
                </tr>
                
                <tr>
                    <td>proyecto:</td>
                    <td><input type="text" name="proyecto" value="<%=proyecto%>" /></td>
                </tr>
                
            </table>
            
            <br>
            
            <input class="btn btn-primary" type="submit" value="Actualizar datos del alumno" />
                    
        </form>
        
    </body>
</html>
