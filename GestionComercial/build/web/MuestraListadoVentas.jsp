<%-- 
    Document   : Gestion.jsp
    Created on : 2 nov. 2022, 10:03:16
    Author     : vecto
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Producto"%>
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

            ArrayList<Producto> lista = new ArrayList<Producto>();
            lista = (ArrayList) getServletContext().getAttribute("lista");
            System.out.println(lista);

            String[] cabecera = {"Fecha", "Comercial", "Cantidad", "Precio", "Total", "Descuento", "TotalDescuento"};

        %>

        <header style="background-color: #757575; padding-bottom: 2em"></header>

        <h1 style="background-color: lightgray; padding: 1em; text-align: center; margin-bottom: 1em">APLICACIÓN DE GESTIÓN COMERCIAL</h1>

        <div class="container text-center" style="margin-bottom: 1em">
            <div class="row" style="margin-bottom: 1em">
                <div class="col"><button onclick="location.href = 'Ventas.jsp'"><img src="imagenes/ventas.jpg" alt="ventas"/></button></div>
                <div class="col"><button ><img src="imagenes/productos.jpg" alt="productos"/></button></div>
                <div class="col"><button ><img src="imagenes/comerciales.jpg" alt="comerciales"/></button></div>
            </div>
            <div class="row">
                <div class="col"><button onclick="location.href = 'EligeLista.jsp'">Listado de ventas</button><br><br>
                    <button onclick="location.href = 'NuevaVenta.jsp'">Nueva venta</button></div>
                <div class="col"></div>
                <div class="col"></div>

            </div>
        </div>

        <div style="background-color: #757575; padding-bottom: 2em; margin-bottom: 2em"></div>

        <div>


            <%if (lista != null) {%>

            <table class="border border-dark rounded" style="margin: auto">



                <tr class="border border-dark">
                    <%
                        for (int x = 0; x < cabecera.length; x++) {
                    %>

                    <th class="p-3 mb-2 bg-secondary text-white border border-dark">
                        <%=cabecera[x]%>
                    </th>
                    <%
                        }
                    %>
                </tr>

                <%
                    for (Producto o : lista) {


                %>

                <tr class="p-3 mb-2 bg-success text-white">

                    <td class="border border-dark">
                        <%=o.getFecha()%>
                    </td>
                    <td class="border border-dark">
                        <%=o.getComercial()%>
                    </td>
                    <td class="border border-dark">
                        <%=o.getCantidad()%>

                    </td>
                    <td class="border border-dark">
                        <%=o.getPrecio()%>
                    </td>
                    <td class="border border-dark">
                        <%=o.getTotal()%>
                    </td>
                    <td class="border border-dark">
                        <%=o.getDescuento()%>
                    </td>
                    <td class="border border-dark">
                        <%=o.getTotalConDescuento()%>
                    </td>

                </tr>

                <%
                    }
                %>

            </table>

            <%
            } else {
            %>
            <h1 class="text-danger">No hay ninguna lista de productos<h1>

                    <%
                        }
                    %>

                    
                    </table>


                    </div>
                    <footer style="background-color: #757575; margin-top: 2em; padding-top: 2em"></footer>
                    </body>
                    </html>
