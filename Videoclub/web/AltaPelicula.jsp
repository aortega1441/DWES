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

        <header style="background-color: darkkhaki; padding-bottom: 1em; padding-top: 1em; margin-bottom: 2em"><h1 style="color: white; text-align: center">Alta pel�cula</h1></header>

        <div class="container">

            <div class="text-center">            

                <form action="ValidaPelicula" method="post">

                    Pel�cula
                    <input type="text" name="pelicula" value="" />
                    <br><br>

                    Director
                    <select name="director">
                        <%
                        
                        Connection conn = null;
                        
                        try{
                        
                            conn = modelo.DB.CrearConexion();
                            
                            String sql = "select * from director";
                            PreparedStatement smt = conn.prepareCall(sql);
                            ResultSet rs = smt.executeQuery();
                            
                            while(rs.next()){                                                                    
                        
                        %>
                        <option><%=rs.getString(2)%></option>
                        <%
                        
                            }

                            }catch(SQLException e){
                            System.out.println(e.getMessage());
                            }catch(Exception e){
                            System.out.println(e.getMessage());
                            }
                        
                        %>
                    </select>
                    <br><br>

                    Fecha
                    <input type="date" name="fecha" value="" />
                    <br><br>

                    <input type="submit" value="Aceptar" />
                    <input type="reset" value="Cancelar" />

                </form>
                    
                    <br><br>

                <a href="GestionVideoclub.jsp">Volver a la gesti�n de pel�culas</a>

            </div>

        </div>

        <footer style="background-color: darkkhaki; margin-top: 2em; padding-top: 2em"></footer>

    </body>
</html>
