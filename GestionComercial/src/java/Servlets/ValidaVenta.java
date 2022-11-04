/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static modelo.DB.CreaConexion;
import modelo.Producto;
import java.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author vecto
 */
public class ValidaVenta extends HttpServlet {

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
            out.println("<title>Servlet ValidaVenta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaVenta at " + request.getContextPath() + "</h1>");
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

        //ServletContext contexto = getServletContext();
        //RequestDispatcher rd;

        String comercial = request.getParameter("comercial");
        String producto = request.getParameter("producto");
        String cantidad = request.getParameter("cantidad");
        String fecha = request.getParameter("fecha");

        //LocalDate fecha = LocalDate.parse(fech);

        Connection conn = null;

        try {

            int cant = Integer.parseInt(cantidad);
            String codigoComercial = codigoComercial(comercial);
            String referenciaProducto = referenciaProducto(producto);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Fecha: " + fecha);
            System.out.println("CodigoCom: " + codigoComercial);
            System.out.println("Referencia: " + referenciaProducto);

            conn = CreaConexion();
            String sql = "insert into ventas values(" + codigoComercial + ",'" + referenciaProducto + "'," + cantidad + ",'" + fecha + "')";
            System.out.println(sql);
            PreparedStatement smt = conn.prepareCall(sql);
            smt.executeUpdate();

            request.getRequestDispatcher("/NuevaVenta.jsp").forward(request, response);

        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
            request.getRequestDispatcher("/Error2.html").forward(request, response);
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

    public String codigoComercial(String comercial) {

        Connection conn = null;
        String codigoCom = "";

        try {
            conn = CreaConexion();
            String sql = "SELECT comerciales.codigo from comerciales where comerciales.nombre like '" + comercial + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {
                codigoCom = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return codigoCom;

    }

    public String referenciaProducto(String producto) {

        Connection conn = null;
        String referencia = "";

        try {
            conn = CreaConexion();
            String sql = "SELECT productos.referencia from productos where productos.nombre like '" + producto + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {
                referencia = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return referencia;

    }

}
