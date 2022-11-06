package modelo;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vecto
 */
public class DB {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String db = "vidioteca";

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

    public static Boolean compruebaUsuario(String usuario, String contrasena) {

        Connection conn = null;

        boolean correcto = false;

        try {

            conn = CrearConexion();

            String sql = "select * from usuario where usuario.usuario = '" + usuario + "' and usuario.password = '" + contrasena + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {

                correcto = true;

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return correcto;

    }

    public static boolean encuentraPelicula(String pelicula) {

        Connection conn = null;

        boolean correcta = true;

        try {

            conn = CrearConexion();

            String sql = "select * from peliculas where peliculas.titulo = '" + pelicula + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {

                correcta = false;

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return correcta;

    }

    public static void AltaPelicula(String pelicula, String director, String fecha) {

        Connection conn = null;

        try {

            conn = CrearConexion();
            String idDIrector = idDirector(director);
            int id = Integer.parseInt(idDIrector);
            String sql = "insert into peliculas values(null, '" + pelicula + "', " + id + ", '" + fecha + "')";
            PreparedStatement smt = conn.prepareCall(sql);
            smt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static String idDirector(String director) {

        Connection conn = null;
        String id = "";

        try {

            conn = CrearConexion();
            String sql = "select director.id from director where director.nombre = '" + director + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {

                id = rs.getString(1);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return id;

    }

    public static void ModificaPelicula(String pelicula, String nombreNuevo, String director, String fecha) {

        Connection conn = null;

        try {

            conn = CrearConexion();
            String idDIrector = idDirector(director);
            int id = Integer.parseInt(idDIrector);
            String sql = "update peliculas set peliculas.titulo = '" + nombreNuevo + "', peliculas.director = " + id + ", peliculas.fecha_estreno = '" + fecha + "' where peliculas.titulo = '" + pelicula + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            smt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void EliminarPelicula(String pelicula) {

        Connection conn = null;

        try {

            conn = CrearConexion();
            String sql = "delete from peliculas where peliculas.titulo = '" + pelicula + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            smt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
