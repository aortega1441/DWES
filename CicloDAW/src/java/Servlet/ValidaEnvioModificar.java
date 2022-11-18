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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static modelo.DB.CrearConexion;

/**
 *
 * @author vecto
 */
public class ValidaEnvioModificar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = getServletContext();

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");

        contexto.setAttribute("nombre", nombre);
        contexto.setAttribute("apellidos", apellidos);

        Connection conn = null;

        try {

            conn = CrearConexion();
            String sql = "select * from alumnos where alumnos.nombre = '" + nombre + "' and alumnos.apellidos = '" + apellidos + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();
            
            while(rs.next()){
                
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String dawes = rs.getString(4);
                String dawec = rs.getString(5);
                String diw = rs.getString(6);
                String daw = rs.getString(7);
                String fct = rs.getString(8);
                String proyecto = rs.getString(9);
                                
                contexto.setAttribute("name", name);
                contexto.setAttribute("surname", surname);
                contexto.setAttribute("dawes", dawes);
                contexto.setAttribute("dawec", dawec);
                contexto.setAttribute("diw", diw);
                contexto.setAttribute("daw", daw);
                contexto.setAttribute("fct", fct);
                contexto.setAttribute("proyecto", proyecto);
                
            }

        } catch (SQLException e) {

        } catch (Exception e) {

        }

        request.getRequestDispatcher("Editar.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
