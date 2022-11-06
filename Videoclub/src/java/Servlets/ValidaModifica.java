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
public class ValidaModifica extends HttpServlet {

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

        String pelicula = (String) getServletContext().getAttribute("peliculaModificar");
        String nombreNuevo = request.getParameter("pelicula");
        String director = request.getParameter("director");
        String fecha = request.getParameter("fecha");

        if (nombreNuevo.length() != 0 && fecha.length() != 0) {

            try {
                                
                modelo.DB.ModificaPelicula(pelicula, nombreNuevo, director, fecha);
                request.getRequestDispatcher("/PeliculaModificada.html").forward(request, response);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                request.getRequestDispatcher("/ERRORES/ErrorParametrosModificar.html").forward(request, response);
            }

        } else {
            request.getRequestDispatcher("/ERRORES/ErrorParametrosModificar.html").forward(request, response);
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
