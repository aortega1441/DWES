/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

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
public class Validacion extends HttpServlet {

    ArrayList<Cita> listaCitas = new ArrayList<Cita>();

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
            out.println("<title>Servlet Validacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validacion at " + request.getContextPath() + "</h1>");
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

        String persona = request.getParameter("persona");
        String dni = request.getParameter("dni");
        String fecha = request.getParameter("fecha");
        String telefono = request.getParameter("tel");
        String email = request.getParameter("email");
        String asunto = request.getParameter("asunto");
        String prioridad = request.getParameter("prioridad");

        boolean correcto = compruebaDni(dni);

        if (correcto) {

            Cita cita = new Cita(persona, dni, fecha, telefono, email, asunto, prioridad);
            System.out.println(cita);
            listaCitas.add(cita);
            
            contexto.setAttribute("listaCitas", listaCitas);
            
            rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);

        } else {
            rd = request.getRequestDispatcher("/errorDNI.html");
            rd.forward(request, response);
        }

    }

    private boolean compruebaDni(String dni) {

        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'};
        char letra = dni.charAt(8);
        int numeros = Integer.parseInt(dni.substring(0, 8));
        boolean correcto = false;

        int resto = numeros % 23;

        if (letras[resto] == letra) {
            correcto = true;
        }

        return correcto;

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
