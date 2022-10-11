<%-- 
    Document   : formularioParte.jsp
    Created on : 10 oct. 2022, 8:55:49
    Author     : vecto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header style="padding-bottom: 2em; margin-bottom: 2em; background-color: grey"></header>

        <div>
            <div style="margin: 0px auto;height: auto; width: 40em">
                <form action="validacionParte" method="post">

                    <h2>Datos del trabajador</h2>
                    <table>
                        <tr>
                            <td>
                                <label>Apellido1: </label></td>
                            <td><input type="text" name="apellido1" value="" required/>
                            </td>
                            <td>
                                <label>Apellido2: </label></td>
                            <td><input type="text" name="apellido2" value="" required/>
                            </td>
                            <td>
                                <label>Nombre: </label></td>
                            <td><input type="text" name="nombre" value="" required/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label>Nº SS: </label></td>
                            <td> <input type="text" name="SS" value="" required/>
                            </td>
                            <td>
                                <label>Fecha ingreso en la empresa: </label>
                            <td> <input type="date" name="fIngreso" value="" required/></td>
                            </td>
                            <td>
                                <label>Fecha de nacimiento: </label></td>
                            <td> <input type="date" name="fNacimiento" value="" required/>
                            </td>
                        </tr>

                    </table>

                    <h2>Datos de la empresa</h2>
                    <table>

                        <tr>
                            <td>
                                <label>CIF: </label></td>
                            <td><input type="text" name="cif" value="" required/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Nombre o Razón Social: </label> </td>
                            <td> <input type="text" name="nombreEmpresa" value="" required/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>CCC: </label></td>
                            <td> <input type="text" name="ccc" value="" required/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label style="font-weight: bold">Descripción del accidente: </label></td>
                            <td><textarea name="descripcion" rows="4" cols="20" required>
                                </textarea> 
                            </td>
                        </tr>

                    </table>

                    <br>

                    <input type="submit" value="Añadir parte" />
                    <input type="reset" value="Borrar parte" />
                    <button type="button" value="" onclick="location.href = 'listadoPartes.jsp'"/>Listado de partes</button>

                </form>
            </div>
        </div>

        <footer style="padding-top: 2em;margin-top: 2em; background-color: grey"></footer>

    </body>
</html>
