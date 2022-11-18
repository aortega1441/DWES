/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author vecto
 */
public class ValidaListadoTodos extends HttpServlet {

    ArrayList<Usuario> listaTodos = new ArrayList<Usuario>();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();
        
        Connection conn = null;

        try {

                conn = modelo.DB.CrearConexion();
                String sql = "select * from alumnos";
                PreparedStatement smt = conn.prepareCall(sql);
                ResultSet rs = smt.executeQuery();
                listaTodos.clear();
                
                while(rs.next()){
                    
                    String id = rs.getString(1);
                    String nombre = rs.getString(2);
                    String apellidos = rs.getString(3);
                    String dawes = rs.getString(4);
                    String dawec = rs.getString(5);
                    String diw = rs.getString(6);
                    String daw = rs.getString(7);
                    String fct = rs.getString(8);
                    String proyecto = rs.getString(9);
                    
                    Usuario usuario = new Usuario(nombre, apellidos, dawes, dawec, diw, daw, fct, proyecto, id);
                    listaTodos.add(usuario);
                                                            
                }
                
                contexto.setAttribute("listaTodos", listaTodos);
                request.getRequestDispatcher("ListadoTodos.jsp").forward(request, response);
                
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
