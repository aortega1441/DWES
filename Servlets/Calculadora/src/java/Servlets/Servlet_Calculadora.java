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
public class Servlet_Calculadora extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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

        String prim = request.getParameter("primero");
        int primero = Integer.parseInt(prim);
        String segun = request.getParameter("segundo");
        int segundo = Integer.parseInt(segun);
        String operacion = request.getParameter("operacion");

        int res = 0;

        if (operacion.equals("suma")) {
            res = primero + segundo;
        } else if (operacion.equals("resta")) {
            res = primero - segundo;
        } else if (operacion.equals("producto")) {
            res = primero * segundo;
        } else if (operacion.equals("division")) {
            res = primero / segundo;
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Calculadora</title></head>");
        out.println("<body>");

        out.println("Primer operando: " + primero + "<br>");
        out.println("Segundo operando: " + segundo + "<br>");
        out.println("Operación: " + operacion + "<br>");
        out.println("Resultado: " + res);

        out.println("</body>");
        out.println("</html>");

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
