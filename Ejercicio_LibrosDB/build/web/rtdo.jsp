<%-- 
    Document   : rtdo.jsp
    Created on : 28 oct. 2022, 12:24:33
    Author     : vecto
--%>

<%@page import="modelo.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#e2e3f8">

        <%

            String dato = request.getParameter("titulo");
            ArrayList<Libro> lista = modelo.DB.consultaTitulos(dato);

        %>

        <h1>Consulta de los títulos disponibles:</h1>

        <div align="center">

            <table border="1" align="center">

                <tr>

                    <td>TITULO</td>
                    <td>ISBN</td>
                    <td>AUTOR</td>
                    <td>EDITORIAL</td>
                    <td>DESCRIPCION</td>

                </tr>

                <%                    for (int x = 0; x < lista.size(); x++) {

                %>

                <tr>
                    <td><%=lista.get(x).getTitulo()%></td>
                    <td><%=lista.get(x).getIsbn()%></td>
                    <td><%=lista.get(x).getAutor()%></td>
                    <td><%=lista.get(x).getEditorial()%></td>
                    <td><%=lista.get(x).getDescripcion()%></td>                        

                </tr>

                <%

                    }

                %>               

            </table>

            <a href="index.jsp">Volver a la página principal</a>

        </div>

    </body>
</html>
