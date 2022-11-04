/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static modelo.DB.CreaConexion;

/**
 *
 * @author vecto
 */
public class ValidaComercial extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaComercial</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaComercial at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String salario = request.getParameter("salario");
        String fecha = request.getParameter("fecha");
        String hijos = request.getParameter("hijos");

        System.out.println("codigo: " + codigo);
        System.out.println("nombre: " + nombre);
        System.out.println("salario: " + salario);
        System.out.println("fecha: " + fecha);
        System.out.println("hijos: " + hijos);

        Connection conn = null;

        try {

            double sal = Double.parseDouble(salario);
            int hij = Integer.parseInt(hijos);

            conn = CreaConexion();
            String sql = "insert into comerciales values('" + codigo + "','" + nombre + "'," + sal + "," + hij + ",'" + fecha + "')";
            System.out.println(sql);
            PreparedStatement smt = conn.prepareCall(sql);
            smt.executeUpdate();

            request.getRequestDispatcher("/NuevoComercial.jsp").forward(request, response);

        } catch (SQLException e) {
            System.out.println(e.toString());
            request.getRequestDispatcher("/Error5.html").forward(request, response);
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
            request.getRequestDispatcher("/Error5.html").forward(request, response);
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
