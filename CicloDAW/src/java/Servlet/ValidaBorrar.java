/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vecto
 */
public class ValidaBorrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] seleccionados = request.getParameterValues("seleccionar");

        Connection conn = null;

        try {

            conn = modelo.DB.CrearConexion();
            for (int x = 0; x < seleccionados.length; x++) {

                String id = seleccionados[x];

                String sql = "delete from alumnos where id='" + id + "'";
                PreparedStatement smt = conn.prepareCall(sql);
                smt.executeUpdate();

            }
            
            request.getRequestDispatcher("ValidaListadoTodos").forward(request, response);

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
