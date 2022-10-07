<%-- 
    Document   : formulario.jsp
    Created on : 6 oct. 2022, 20:17:00
    Author     : vecto
--%>

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
            String usuario = (String) getServletContext().getAttribute("usuario");
        %>


        <header style="padding-bottom: 2em; margin-bottom: 2em; background-color: grey"></header>

        <div>
            <div style="margin: 0 auto;height: auto; width: 50em">
                <form action="/Ejercicio_Extraescolares/Validacion" method="post" style="display: inline-block">

                    <table>
                        <tr>

                            <td><label>Nombre de la actividad:  </label></td>
                            <td><input type="text" name="nombre" value="" required/></td>

                        </tr>

                        <tr>

                            <td><label>Lugar de celebración:  </label></td>
                            <td><input type="text" name="lugar" value="" required/></td>

                        </tr>

                        <tr>

                            <td><label>Fecha:   </label></td>
                            <td><input type="text" name="fecha" pattern="^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$" placeholder="dd/mm/yyyy" required/></td>

                        </tr>

                        <tr>

                            <td><label>Hora:   </label></td>
                            <td><input type="time" name="hora" value="" required/></td>

                        </tr>

                        <tr>

                            <td><label>Destinada a:    </label></td>
                            <td><input type="radio" name="destino" value="alumnado" checked="checked" /><label>alumnado</label></td>
                            <td><input type="radio" name="destino" value="profesorado" /><label>profesorado</label></td>

                        </tr>

                        <tr>

                            <td><label>Tipo de actividad:    </label></td>
                            <td>
                                <div class="tipo">
                                    <input type="checkbox" name="tipo" value="academica" />
                                    <label>academica</label>
                                    <br>
                                    <input type="checkbox" name="tipo" value="deportiva" />
                                    <label>deportiva</label>
                                    <br>
                                    <input type="checkbox" name="tipo" value="cultural" />
                                    <label>cultural</label>
                                    <br>
                                    <input type="checkbox" name="tipo" value="convivencia" />
                                    <label>convivencia</label>
                                </div>
                            </td>

                        </tr>

                        <tr>
                            <td><label>Curso destinado: </label></td>
                            <%
                                if (usuario.equals("eso")) {
                            %>
                            <td><select name="curso" required>
                                    <option>Primero ESO</option>
                                    <option>Segundo ESO</option>
                                    <option>Tercero ESO</option>
                                    <option>Cuarto ESO</option>
                                </select></td>
                                <%
                                } else {
                                %>
                            <td><select name="curso" required>
                                    <option>Primero</option>
                                    <option>Segundo</option>                                    
                                </select></td>
                                <%
                                    }
                                %>
                        </tr>

                        <tr>
                            <td><label>Profesor responsable: </label></td>
                            <td><input type="text" name="profesor" value="" required/></td>
                        </tr>

                        <tr>
                            <td><label>Observaciones: </label></td>
                            <td><textarea name="observaciones" rows="5" cols="30">
                                </textarea></td>
                        </tr>

                        <tr>
                            <td><br><input type="submit" value="Añadir actividad" name="anadir" /></td>
                            <td><br><input type="reset" value="Borrar actividad" name="borrar" /></td>
                            <td><br><button type="button" name="listado" onClick="location.href = 'listado.jsp';">Listado de actividaddes</button></td>
                        </tr>

                    </table>

                    <br>

                </form>

                <img style="margin-left: 5em" src="logo_cdp_jose_cabrera.png" alt="alt"/>
            </div>
        </div>

        <footer style="padding-top: 2em;margin-top: 2em; background-color: grey"></footer>
    </body>
</html>
