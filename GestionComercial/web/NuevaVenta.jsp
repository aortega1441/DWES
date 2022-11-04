<%-- 
    Document   : Gestion.jsp
    Created on : 2 nov. 2022, 10:03:16
    Author     : vecto
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
                <div class="col"><button onclick="location.href = 'EligeLista.jsp'">Listado de ventas</button><br><br>
                    <button>Nueva venta</button></div>
                <div class="col"></div>
                <div class="col"></div>

            </div>
        </div>

        <div style="background-color: #757575; padding-bottom: 2em; margin-bottom: 2em"></div>

        <div class="text-center">

            <h3>Añadir una nueva venta</h3>

            <form method="post" action="ValidaVenta">

                Comercial
                <select name = "comercial" required>
                    <%

                        Connection conn = null;

                        try {
                            conn = modelo.DB.CreaConexion();
                            String sql = "select comerciales.nombre from comerciales";
                            PreparedStatement smt = conn.prepareCall(sql);
                            ResultSet rs = smt.executeQuery();

                            while (rs.next()) {%>


                    <option><%=rs.getString(1)%></option>


                    <%}

                        } catch (SQLException e) {
                            System.out.println(e.toString());
                        } catch (Exception e) {
                            System.out.println("Exception " + e.toString());
                        }

                    %>
                </select >
                
                <br>
                <br>
                
                Producto
                <select name = "producto" required>
                    <%
                        
                        try {
                            conn = modelo.DB.CreaConexion();
                            String sql = "select productos.nombre, productos.descripcion from productos";
                            PreparedStatement smt = conn.prepareCall(sql);
                            ResultSet rs = smt.executeQuery();

                            while (rs.next()) {%>


                    <option value="<%=rs.getString(1)%>"><%=rs.getString(1)+" - "+rs.getString(2)%></option>


                    <%}

                        } catch (SQLException e) {
                            System.out.println(e.toString());
                        } catch (Exception e) {
                            System.out.println("Exception " + e.toString());
                        }

                    %>
                </select >
                
                <br>
                <br>
                
                Cantidad
                <input type="text" name="cantidad" value="" required/>
                
                <br>
                <br>
                
                Fecha de vta.
                <input type="date" name="fecha" value="" required/>
                
                <br><br>
                
                <input type="submit" value="Aceptar" name="aceptar" />
                <input type="reset" value="Cancelar" name="cancelar" />

            </form>

        </div>
        <footer style="background-color: #757575; margin-top: 2em; padding-top: 2em"></footer>
    </body>
</html>
