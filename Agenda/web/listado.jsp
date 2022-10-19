<%-- 
    Document   : listado.jsp
    Created on : 18 oct. 2022, 17:49:17
    Author     : vecto
--%>

<%@page import="java.util.Collections"%>
<%@page import="servlets.Cita"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body class="container-fluid">

        <%

            ArrayList<Cita> listaCitas = new ArrayList<Cita>();
            listaCitas = (ArrayList) getServletContext().getAttribute("listaCitas");

            String[] cabecera = {"Fecha", "Prioridad", "Persona de contacto", "Teléfono", "Email"};

            Collections.sort(listaCitas);

        %>

        <div class="row justify-content-center mt-5">



            <div class="container">

                <h1 class="text-secondary row justify-content-center">Agenda de tareas</h1>

                <div class="row">
                    <%                    for (int x = 0; x < cabecera.length; x++) {

                    %>

                    <div class="col bg-secondary text-white"><%=cabecera[x]%></div>

                    <%
                        }
                    %>
                </div>

                <%
                    for (Cita cita : listaCitas) {
                %>

                <div class="row bg-info text-white">
                    <div class="col"><%=cita.getFecha()%></div>
                    <div class="col"><%=cita.getPrioridad()%></div>
                    <div class="col"><%=cita.getPersona()%></div>
                    <div class="col"><%=cita.getTelefono()%></div>
                    <div class="col"><%=cita.getEmail()%></div>                
                </div>

                <%
                    }
                %>

            </div>

        </div>

    </body>
</html>
