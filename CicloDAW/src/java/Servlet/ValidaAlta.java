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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vecto
 */
public class ValidaAlta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dawes = request.getParameter("dawes");
        String dawec = request.getParameter("dawec");
        String diw = request.getParameter("diw");
        String daw = request.getParameter("daw");
        String fct = request.getParameter("fct");
        String proyecto = request.getParameter("proyecto");
        
        if(nombre.length()!=0&&apellidos.length()!=0&&dawes.length()!=0&&dawec.length()!=0&&diw.length()!=0&&daw.length()!=0&&fct.length()!=0&&proyecto.length()!=0){
            Connection conn = null;

        try {

            conn = modelo.DB.CrearConexion();
            String sql = "insert into alumnos values('" + nombre + "', '" + apellidos + "', '" + dawes + "', '" + dawec + "', '" + diw + "', '" + daw + "', '" + fct + "', '" + proyecto + "')";
            PreparedStatement smt = conn.prepareCall(sql);
            smt.executeUpdate();
            
            request.getRequestDispatcher("ValidaListadoTodos").forward(request, response);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            request.getRequestDispatcher("/ERRORES/ErrorAlta.html").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            request.getRequestDispatcher("/ERRORES/ErrorAlta.html").forward(request, response);
        }
        }else{
            request.getRequestDispatcher("/ERRORES/ErrorAltaVacio.html").forward(request, response);
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
