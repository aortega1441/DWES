/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static modelo.DB.CreaConexion;
import modelo.Producto;

/**
 *
 * @author vecto
 */
public class ValidaLista extends HttpServlet {

    ArrayList<Producto> lista = new ArrayList<Producto>();

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
            out.println("<title>Servlet ValidaLista</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaLista at " + request.getContextPath() + "</h1>");
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

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        String seleccionado = request.getParameter("producto");

        Connection conn = null;

        try {
            conn = CreaConexion();
            String sql = "select ventas.fecha, comerciales.nombre, ventas.cantidad, productos.precio, productos.descuento from comerciales, productos, ventas where ventas.codComercial = comerciales.codigo and productos.nombre like '" + seleccionado + "' and ventas.refProducto = productos.referencia";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), "0", rs.getString(5), "0");
                lista.add(producto);

                contexto.setAttribute("lista", lista);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }

        request.getRequestDispatcher("/MuestraListadoVentas.jsp").forward(request, response);

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
