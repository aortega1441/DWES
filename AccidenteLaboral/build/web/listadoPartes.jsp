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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            ArrayList<Partes> lista = new ArrayList<Partes>();
            lista = (ArrayList) getServletContext().getAttribute("lista");

            String[] cabecera = {"Nº SS", "Apellido1, Apellido2", "Nombre", "CIF", "Empresa", "Descripción"};

            Collections.sort(lista);

        %>

        <form action="">

            <%if (lista != null) {%>

            <table>

                <tr>
                    <%
                        for (int x = 0; x < cabecera.length; x++) {
                    %>

                    <th style="background-color: grey">
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

                <tr style="background-color: lightgreen">

                    <td>
                        <%=parte.getNss()%>
                    </td>
                    <td>
                        <%=apellidos%>
                    </td>
                    <td><%=parte.getNombre()%>

                    </td>
                    <td>
                        <%=parte.getCif()%>
                    </td>
                    <td>
                        <%=parte.getNombreEmpresa()%>
                    </td>
                    <td>
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
            <h1 style="color: red">No hay ninguna lista de actividades actualmente<h1>

                    <%
                        }
                    %>

                    </tbody>
                    </table>

                    <br>
                    <button type="button" name="anadir" onClick="location.href = 'formularioParte.jsp';">Seguir añadiendo actividades</button>

                    </form>

                    </body>
                    </html>
