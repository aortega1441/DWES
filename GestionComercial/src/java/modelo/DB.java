/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vecto
 */
public class DB {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String bd = "ventas_comerciales";

    public static Connection CreaConexion() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + servidor + "/" + bd;
            conn = (Connection) DriverManager.getConnection(url, usuario, password);

        } catch (ClassNotFoundException c) {
            System.out.println("Controlador JDBC no encontrado " + c.toString());
        } catch (Exception c) {
            System.out.println("Exception " + c.toString());
        }

        return conn;

    }

    public static boolean validaLogin(String usuario, String contrasena) {

        Connection conn = null;
        boolean correcto = false;

        try {
            conn = CreaConexion();
            String sql = "SELECT usuario.usuario, usuario.password from usuario where usuario.usuario like '" + usuario + "' and usuario.password like '" + contrasena + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {
                if (rs.getString(1).equals(usuario) && rs.getString(2).equals(contrasena)) {
                    correcto = true;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return correcto;

    }

}
