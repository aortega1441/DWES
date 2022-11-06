<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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

        <header style="background-color: darkkhaki; padding-bottom: 1em; padding-top: 1em; margin-bottom: 2em"><h1 style="color: white; text-align: center">Modificar una película</h1></header>

        <div class="container">

            <div class="text-center">            

                <form method="post" action="ModificaParametrosPelicula.jsp">

                    Seleccione la película que desea consultar
                    <select name="peliculaModificar">
                        <%                           

                            Connection conn = null;

                            try {

                                conn = modelo.DB.CrearConexion();

                                String sql = "select * from peliculas";
                                PreparedStatement smt = conn.prepareCall(sql);
                                ResultSet rs = smt.executeQuery();

                                while (rs.next()) {

                        %>
                        <option value="<%=rs.getString(2)%>"><%=rs.getString(2)%></option>
                        <%

                                }
                                                                
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                        %>
                    </select>

                    <br><br>

                    <input type="submit" value="Modificar película" />

                </form>

                <br><br><br>
                <a href="GestionVideoclub.jsp">Volver a la gestión de películas</a>


            </div>

        </div>

        <footer style="background-color: darkkhaki; margin-top: 2em; padding-top: 2em"></footer>

    </body>
</html>
