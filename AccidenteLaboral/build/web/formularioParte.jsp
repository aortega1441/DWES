<%-- 
    Document   : formularioParte.jsp
    Created on : 10 oct. 2022, 8:55:49
    Author     : vecto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body class="m-0 vh-100 justify-content-center align-items-center">
    <header class="p-3 mb-2 bg-success text-white"></header></header>

    <div class="col-auto p-5 text-center">
        <div>
            <form action="validacionParte" method="post">


                <table>
                    <tr>
                        <th>
                            <h2>Datos del trabajador</h2>
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <label>Apellido1: </label>
                        </td>
                        <td><input type="text" name="apellido1" value="" required />
                        </td>
                        <td>
                            <label>Apellido2: </label>
                        </td>
                        <td><input type="text" name="apellido2" value="" required />
                        </td>
                        <td>
                            <label>Nombre: </label>
                        </td>
                        <td><input type="text" name="nombre" value="" required />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label>Nº SS: </label>
                        </td>
                        <td> <input type="text" name="SS" value="" required />
                        </td>
                        <td>
                            <label>Fecha ingreso en la empresa: </label>
                        <td> <input type="date" name="fIngreso" value="" required /></td>
                        </td>
                        <td>
                            <label>Fecha de nacimiento: </label>
                        </td>
                        <td> <input type="date" name="fNacimiento" value="" required />
                        </td>
                    </tr>

                </table>


                <table>
                    <tr>
                        <th>
                            <h2>Datos de la empresa</h2>
                        </th>
                    </tr>

                    <tr>
                        <td>
                            <label>CIF: </label>
                        </td>
                        <td><input type="text" name="cif" value="" required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Nombre o Razón Social: </label>
                        </td>
                        <td> <input type="text" name="nombreEmpresa" value="" required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>CCC: </label>
                        </td>
                        <td> <input type="text" name="ccc" value="" required />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Descripción del accidente: </label>
                        </td>
                        <td><textarea name="descripcion" rows="4" cols="20" required>
                                </textarea>
                        </td>
                    </tr>

                </table>

                <br>

                <input class="btn btn-success" type="submit" value="Añadir parte" />
                <input class="btn btn-danger" type="reset" value="Borrar parte" />
                <button class="btn btn-warning" type="button" value="" onclick="location.href = 'listadoPartes.jsp'" />Listado de
                partes</button>

            </form>
        </div>
    </div>

    <footer class="p-3 mb-2 bg-success text-white"></footer>></footer>

</body>

</html>
