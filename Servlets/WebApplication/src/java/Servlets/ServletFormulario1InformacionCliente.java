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
public class ServletFormulario1InformacionCliente extends HttpServlet {

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
            out.println("<title>Servlet ServletFormulario1InformacionCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletFormulario1InformacionCliente at " + request.getContextPath() + "</h1>");
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

        String nom = request.getParameter("nombre");
        String tef = request.getParameter("telefono");
        String lugNaci = request.getParameter("lugar de nacimiento");

        String protocolo = request.getProtocol();

        response.setContentType("text/html");

        //Obtención del objeto que escribe la respuesta. Pertenece a java.io
        PrintWriter out = response.getWriter();

        //Generacion de la respuesta html
        out.println("<html>");
        out.println("<head><title>Datos introducidos por Formulario1</title></head>");
        out.println("<body>");
        out.println("<h1>DATOS INTRODUCIDOS</h1>");
        out.println("<table border=\"5\">");
        out.println("<tr><td><b>NOMBRE:</b></td><td><i>" + nom + "</i></td></tr>");
        out.println("<tr><td><b>TELEFONO:</b></td><td><i>" + tef + "</i></td></tr>");
        out.println("<tr><td><b>LUGAR NACIMIENTO:</b></td><td><i>" + lugNaci + "</i></td></tr>");
        out.println("</table><p>");

        out.println("<h2>Información sobre la petición: </h2>");
        out.println("<table>");
        out.println("<tr><td><b>Protocolo de la petición: </b></td><td><i>" + request.getProtocol() + "</i></td></tr>");
        out.println("<tr><td><b>Nombre del cliente:</b></td><td><i>" + request.getRemoteAddr() + "</i></td></tr>");
        out.println("<tr><td><b>Dirección IP del cliente:</b></td><td><i>" + request.getRemoteHost() + "</i></td></tr>");
        out.println("<tr><td><b>Clave del usuario que realiza la petición:</b></td><td><i>" + request.getRemoteUser() + "</i></td></tr>");
        out.println("<tr><td><b>Tipo de petición:</b></td><td><i>" + request.getMethod() + "</i></td></tr>");
        out.println("<tr><td><b>Tipo MIME usado por el cliente:</b></td><td><i>" + request.getContentType() + "</i></td></tr>");
        out.println("<tr><td><b>Cadena de parámetros de la petición:</b></td><td><i>" + request.getParameterNames() + "</i></td></tr>");
        out.println("<tr><td><b>URI de la petición:</b></td><td><i>" + request.getRequestURI() + "</i></td></tr>");
        out.println("<tr><td><b>URL de la petición:</b></td><td><i>" + request.getRequestURL() + "</i></td></tr>");
        out.println("<tr><td><b>Ruta URI del servlet:</b></td><td><i>" + request.getServletPath() + "</i></td></tr>");
        out.println("<tr><td><b>Nombre del servidor web que recibe la petición:</b></td><td><i></i></td></tr>");
        out.println("<tr><td><b>Número del puerto por el que el servidor acepta la conexión del cliente:</b></td><td><i>" + request.getRemotePort() + "</i></td></tr>");

        out.println("</table><p>");

        out.println("<h2>Encabezados o headers asociados a la petición: </h2>");
        out.println("<table border=\"5\">");
        out.println("<tr><td><b>host</b></td><td><i>" + request.getHeader("host") + "</i></td></tr>");
        out.println("<tr><td><b>user-agent</b></td><td><i>" + request.getHeader("user-agent") + "</i></td></tr>");
        out.println("<tr><td><b>accept</b></td><td><i>" + request.getHeader("accept") + "</i></td></tr>");
        out.println("<tr><td><b>accept-language</b></td><td><i>" + request.getHeader("acept-language") + "</i></td></tr>");
        out.println("<tr><td><b>accept-encoding</b></td><td><i>" + request.getHeader("accept-encoding") + "</i></td></tr>");
        out.println("<tr><td><b>accept-charset</b></td><td><i>" + request.getHeader("accept-charset") + "</i></td></tr>");
        out.println("<tr><td><b>keep-alive</b></td><td><i>" + request.getHeader("keep-alive") + "</i></td></tr>");
        out.println("<tr><td><b>connection</b></td><td><i>" + request.getHeader("connection") + "</i></td></tr>");
        out.println("<tr><td><b>referer</b></td><td><i>" + request.getHeader("referer") + "</i></td></tr>");
        out.println("<tr><td><b>content-type</b></td><td><i>" + request.getHeader("content-type") + "</i></td></tr>");
        out.println("<tr><td><b>content-length</b></td><td><i>" + request.getHeader("content-length") + "</i></td></tr>");
        out.println("</table><p>");

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
