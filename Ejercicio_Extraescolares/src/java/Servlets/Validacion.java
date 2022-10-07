/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.digester.ArrayStack;

/**
 *
 * @author vecto
 */
public class Validacion extends HttpServlet {

    ArrayList<ActividadExtraescolar> listaActividades = new ArrayStack<ActividadExtraescolar>();

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
            out.println("<title>Servlet Redireccion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Redireccion at " + request.getContextPath() + "</h1>");
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

        String usuario = (String) getServletContext().getAttribute("usuario");
        String nombre = request.getParameter("nombre");
        String lugar = request.getParameter("lugar");
        String fecha = request.getParameter(String.valueOf("fecha"));
        String hora = request.getParameter(String.valueOf("hora"));
        String destino = request.getParameter("destino");
        String valores[] = request.getParameterValues("tipo");
        int tam = 0;

        if (valores != null) {

            for (int x = 0; x < valores.length; x++) {
                tam++;
            }
            String tipos[] = new String[tam];
            String valor = "";
            for (int x = 0; x < valores.length; x++) {
                tipos[x] = valores[x];
            }

            String curso = request.getParameter("curso");
            String profesor = request.getParameter("profesor");
            String observaciones = request.getParameter("observaciones");

            try {
                ActividadExtraescolar actividad = new ActividadExtraescolar(nombre, lugar, fecha, hora, destino, valores, curso, profesor, observaciones, usuario);
                System.out.println(actividad);
                listaActividades.add(actividad);

                contexto.setAttribute("lista", listaActividades);

                rd = request.getRequestDispatcher("/formulario.jsp");
                rd.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            rd = contexto.getRequestDispatcher("/datosIncorrectos.html");
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
