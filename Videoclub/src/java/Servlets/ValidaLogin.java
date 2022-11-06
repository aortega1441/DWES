/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vecto
 */
public class ValidaLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        try {

            if (usuario.length() != 0 && contrasena.length() != 0) {
                boolean correcto = modelo.DB.compruebaUsuario(usuario, contrasena);
                
                if (correcto) {
                    request.getRequestDispatcher("/GestionVideoclub.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/ERRORES/ErrorLogin.html").forward(request, response);
                }

            } else {
                request.getRequestDispatcher("/ERRORES/ErrorLogin.html").forward(request, response);
            }

        } catch (Exception e) {
            request.getRequestDispatcher("/ERRORES/ErrorLogin.html").forward(request, response);
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
