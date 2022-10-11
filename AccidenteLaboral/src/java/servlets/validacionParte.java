/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import excepciones.campoIncorrectoException;
import excepciones.cccException;
import excepciones.cifException;
import excepciones.fechaException;
import excepciones.numeroSSException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vecto
 */
public class validacionParte extends HttpServlet {

    ArrayList<Partes> listaPartes = new ArrayList<Partes>();

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
            out.println("<title>Servlet validacionParte</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validacionParte at " + request.getContextPath() + "</h1>");
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

        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String nombre = request.getParameter("nombre");
        String NSS = request.getParameter("SS");
        String fIngreso = request.getParameter("fIngreso");
        String fNacimiento = request.getParameter("fNacimiento");
        System.out.println(fIngreso);
        System.out.println(fNacimiento);
        String cif = request.getParameter("cif");
        String nombreEmpresa = request.getParameter("nombreEmpresa");
        String ccc = request.getParameter("ccc");
        String descripcion = request.getParameter("descripcion");

        try {

            Partes parte = new Partes(apellido1, apellido2, nombre, NSS, fIngreso, fNacimiento, cif, nombreEmpresa, ccc, descripcion);

            System.out.println(parte);
            listaPartes.add(parte);

            contexto.setAttribute("lista", listaPartes);
            rd = request.getRequestDispatcher("/formularioParte.jsp");
            rd.forward(request, response);

        } catch (cccException e) {
            rd = request.getRequestDispatcher("/errorCCC.html");
            rd.forward(request, response);
        } catch (cifException e) {
            rd = request.getRequestDispatcher("/errorCIF.html");
            rd.forward(request, response);
        } catch (numeroSSException e) {
            rd = request.getRequestDispatcher("/errorSS.html");
            rd.forward(request, response);
        } catch (campoIncorrectoException e) {
            rd = request.getRequestDispatcher("/errorCampo.html");
            rd.forward(request, response);
        } catch (fechaException e) {
            rd = request.getRequestDispatcher("/errorFecha.html");
            rd.forward(request, response);
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
