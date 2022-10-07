<%-- 
    Document   : listado.jsp
    Created on : 6 oct. 2022, 12:18:20
    Author     : vecto
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Servlets.ActividadExtraescolar"%>
<%@page import="java.io.Console"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <%

            ArrayList<ActividadExtraescolar> lista = new ArrayList<ActividadExtraescolar>();
            lista = (ArrayList) getServletContext().getAttribute("lista");
            
            //Collections.sort(list);

            String[] cabecera = {"Fecha", "Hora", "Nombre", "Lugar", "Destinatario", "Curso", "Tipo", "Departamento", "Responsable", "Observaciones"};

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
                    for (ActividadExtraescolar actividad : lista) {
                %>

                <tr style="background-color: lightgreen">

                    <td>
                        <%=actividad.getFecha()%>
                    </td>
                    <td>
                        <%=actividad.getHora()%>
                    </td>
                    <td><%=actividad.getNombre()%>

                    </td>
                    <td>
                        <%=actividad.getLugar()%>
                    </td>
                    <td>
                        <%=actividad.getDestino()%>
                    </td>
                    <td>
                        <%=actividad.getCurso()%>
                    </td>
                    <td>
                        <%=actividad.getTipo()%>
                    </td>
                    <td>
                        <%=actividad.getDpto()%>
                    </td>
                    <td>
                        <%=actividad.getProfesor()%>
                    </td>
                    <td>
                        <%=actividad.getObservaciones()%>
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
                    <button type="button" name="anadir" onClick="location.href = 'formulario.jsp';">Seguir añadiendo actividades</button>
                    <button type="button" name="alumnado" onClick="location.href = 'listado.jsp';">Ver todas las actividades</button>
                    <button type="button" name="alumnado" onClick="location.href = 'listadoAlumnado.jsp';">Ver actividades del alumnado</button>
                    <button type="button" name="profesorado" onClick="location.href = 'listadoProfesorado.jsp';">Ver actividades del profesorado</button>

                    </form>

                    </body>
                    </html>
