<%-- 
    Document   : MuestraListadoTodas.jsp
    Created on : 5 nov. 2022, 14:00:45
    Author     : vecto
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Peliculas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>

        <%
            
            ArrayList<Peliculas> listaTitulo = new ArrayList<Peliculas>();
            listaTitulo = (ArrayList) getServletContext().getAttribute("listaTitulo");
            String[] cabecera = {"Película", "Director", "Fecha"};
            
        %>

        <%
        
            if(listaTitulo.size()!=0){
        
        %>
        
        <header style="background-color: darkkhaki; padding-bottom: 1em; padding-top: 1em; margin-bottom: 2em"><h1 style="color: white; text-align: center">Listado de películas</h1></header>
                     
        
        
                <table style="margin:auto" border>
                        
            <tr>
                <%
                
                    for(int x=0; x<cabecera.length;x++){
                                                        
                %>
                
                <th style="background-color: darkgoldenrod; color: white; text-align: center; padding: 0.5em"><%=cabecera[x]%></th>
                
                <%
                    }
                %>
            </tr>
            
            <%
            
                for(Peliculas o:listaTitulo) {
            
            %>
            
            <tr>
                <td style="background-color: darkkhaki; color: white; padding-left: 2em;padding-right: 2em; text-align: center"><%=o.getTitulo()%></td>
                <td style="background-color: darkkhaki; color: white; padding-left: 2em;padding-right: 2em; text-align: center"><%=o.getDirector()%></td>
                <td style="background-color: darkkhaki; color: white; padding-left: 2em;padding-right: 2em; text-align: center"><%=o.getFechaEstreno()%></td>
            </tr>
            
            <%
                }
            %>                                   
                        
        </table>
            
            <br>
            
            <div style="text-align: center"><a href="EligeListado.jsp">Volver</a></div>
            
            <%
            
                }else{               
            
            %>
            
            <header style="background-color: darkkhaki; padding-bottom: 1em; padding-top: 1em; margin-bottom: 2em"><h1 style="color: white; text-align: center">Listado de películas</h1></header>
            
            <h2>La película introducida no existe</h2>
            
            <br>
            
            <div style="text-align: center"><a href="EligeListado.jsp">Volver</a></div>
            
            <%
            
                }
            
            %>
                                       
    </body>
</html>
