/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vecto
 */
public class DB {

    public static String usuario = "root";
    public static String password = "";
    public static String servidor = "localhost:3306";
    public static String bd = "books";

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

    public static ArrayList<Libro> consultaTitulos(String dato) {

        ArrayList<Libro> lista = new ArrayList<Libro>();
        Libro ebook;
        Connection conn = null;

        try {

            conn = CreaConexion();
            String sql = "SELECT titulos.titulo, titulos.ISBN, autor.nombre, Editorial.NameEditorial, titulos.Descripcion from titulos, autor, editorial where (titulos.IDautor=autor.idautor) and (titulos.IDeditorial=editorial.ideditorial) and (titulos.Titulo like ?)";
            PreparedStatement smt = conn.prepareCall(sql);
            smt.setString(1, "%" + dato + "%");
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {
                ebook = new Libro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                lista.add(ebook);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return lista;

    }

}
