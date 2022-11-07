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
    public static String db = "ciclodaw";

    public static Connection CrearConexion() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + servidor + "/" + db;
            conn = DriverManager.getConnection(url, usuario, password);

        } catch (ClassNotFoundException e) {
            System.out.println("Controlador JDBC no encontrado" + e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return conn;

    }

    public static boolean compruebaLogin(String usuario, String contrasena) {

        Connection conn = null;
        boolean correcto = false;

        try {

            conn = CrearConexion();
            System.out.println(conn);
            String sql = "select profesores.usuario, profesores.password from profesores where profesores.usuario = '" + usuario + "' and profesores.password = '" + contrasena + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();
            
            while(rs.next()){
                correcto = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return correcto;

    }
    
    

}
