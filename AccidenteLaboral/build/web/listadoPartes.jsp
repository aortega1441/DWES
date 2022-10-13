<%-- 
    Document   : listadoPartes.jsp
    Created on : 10 oct. 2022, 14:01:42
    Author     : vecto
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="servlets.Partes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="m-0 vh-50 row justify-content-center align-items-center">

        <%
            ArrayList<Partes> lista = new ArrayList<Partes>();
            lista = (ArrayList) getServletContext().getAttribute("lista");

            String[] cabecera = {"Nº SS", "Apellido1, Apellido2", "Nombre", "CIF", "Empresa", "Descripción"};

            Collections.sort(lista);

        %>

        <form action="">

            <%if (lista != null) {%>

            <table class="border border-dark rounded">
                
                

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
                    for (Partes parte : lista) {

                        String apellidos = parte.getApellido1() + ", " + parte.getApellido2();
                %>

                <tr class="p-3 mb-2 bg-success text-white">

                    <td class="border border-dark">
                        <%=parte.getNss()%>
                    </td>
                    <td class="border border-dark">
                        <%=apellidos%>
                    </td>
                    <td class="border border-dark"><%=parte.getNombre()%>

                    </td>
                    <td class="border border-dark">
                        <%=parte.getCif()%>
                    </td>
                    <td class="border border-dark">
                        <%=parte.getNombreEmpresa()%>
                    </td>
                    <td class="border border-dark">
                        <%=parte.getDescripcion()%>
                    </td>

                </tr>

                <%
                    }
                %>

            </table>

            <%
            } else {
            %>
            <h1 class="text-danger">No hay ninguna lista de actividades actualmente<h1>

                    <%
                        }
                    %>

                    </tbody>
                    </table>

                    <br>
                    <button class="btn btn-danger" type="button" name="anadir" onClick="location.href = 'formularioParte.jsp';">Seguir añadiendo partes</button>

                    </form>

                    </body>
                    </html>
