/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

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
public class MuestraSolucion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String importe = (String) getServletContext().getAttribute("importe_valido");
            String cantidad = (String) getServletContext().getAttribute("cantidad_valida");
            String billetes = (String) getServletContext().getAttribute("billetes");
            String centimos = (String) getServletContext().getAttribute("centimos");
            String euros = (String) getServletContext().getAttribute("euros");
            String cantBilletes = (String) getServletContext().getAttribute("cantBilletes");
            String cantCentimos = (String) getServletContext().getAttribute("cantCentimos");
            String cantEuros = (String) getServletContext().getAttribute("cantEuros");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MuestraSolucion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Datos de entrada</h2>");
            out.println("Importe de venta: " + importe + " euros<br>");
            out.println("Cantidad entregada: " + cantidad + " euros"
            );
            out.println("<h2>Datos de salida</h2>");

            if (billetes != null) {
                out.println("Hay " + cantBilletes + " billetes de " + billetes + " euros.<br>");
            }

            if (centimos != null) {
                out.println("Hay " + cantCentimos + " billetes de " + centimos + " euros.<br>");
            }

            if (euros != null) {
                out.println("Hay " + cantEuros + " billetes de " + euros + " euros.");
            }

            out.println("</body>");
            out.println("</html>");
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
