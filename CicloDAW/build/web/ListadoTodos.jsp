<%-- 
    Document   : ListadoTodos
    Created on : 7 nov. 2022, 9:56:19
    Author     : vecto
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
        
            ArrayList<Usuario> listaTodos = new ArrayList<Usuario>();
            listaTodos = (ArrayList) getServletContext().getAttribute("listaTodos");
            
            String[] cabecera = {"", "Nombre", "Apellidos", "DAWES", "DAWEC", "DIW", "DAW", "FCT", "Proyecto", "Editar"};
        
        %>
        
        <%
                
            if(listaTodos.size()!=0){

        %>
        
        <h1 class="text-center alert-primary" style="padding-bottom: 0.5em; padding-top: 0.5em">Listado de alumnos 2º de CFDAW</h1>
        
        <br><br>
        
        <form action="ValidaBorrar" method="post" class="text-center">            
                                   
            <table border style="margin: auto" class="text-center">
                
                <tr>
                    <%
                    
                        for(int x=0; x<cabecera.length;x++){
                    
                    %>
                    
                    <th style="padding:1em; background-color: darkturquoise"><%=cabecera[x]%></th>
                    
                    <%
                    
                        }
                    
                    %>
                </tr>
                
                <%
                
                    for(Usuario o:listaTodos){
                                                        
                %>
                
                <tr>
                    <td style="padding:1em; background-color: cyan"><input type="checkbox" name="seleccionar"  value="<%=o.getId()%>"/></td>
                    <td style="padding:1em; background-color: cyan"><%=o.getNombre()%></td>
                    <td style="padding:1em; background-color: cyan"><%=o.getApellidos()%></td>
                    <td style="padding:1em; background-color: cyan"><%=o.getDwes()%></td>
                    <td style="padding:1em; background-color: cyan"><%=o.getDwec()%></td>
                    <td style="padding:1em; background-color: cyan"><%=o.getDiw()%></td>
                    <td style="padding:1em; background-color: cyan"><%=o.getDaw()%></td>
                    <td style="padding:1em; background-color: cyan"><%=o.getFct()%></td>
                    <td style="padding:1em; background-color: cyan"><%=o.getProyecto()%></td>
                    <td style="padding:1em; background-color: cyan"><a href="ValidaEnvioModificar?nombre=<%=o.getNombre()%>&apellidos=<%=o.getApellidos()%>" class="btn" style="background-color: #585858; color: white; padding-bottom: 0.5; padding-top: 0.5">Editar</a></td>
                </tr>
                
                <%                                   
                    
                    }
                
                %>
                
            </table>
                
                <br>
                
                <button type="submit" class="btn btn-danger">Borrar</button>
                                                            
        </form>
                                                
                <div class="text-center" style="margin: auto">
                    <button onclick="location.href='AltaAlumno.jsp'" class="btn btn-primary">Registrar nuevo alumno</button>
                </div>
        
        <%
        
            }else{               
        
        %>
        
        <h1>No hay lista</h1>
        
        <%
        
            }
        
        %>
        
    </body>
</html>
