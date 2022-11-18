/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vecto
 */
public class DatosEncuesta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String cNac = request.getParameter("ciudad");
        String sexo = request.getParameter("sexo");
        String pais = request.getParameter("pais");
        String comentario = request.getParameter("comentarios");

        Enumeration parametros = request.getParameterNames();
        String nombreParametro;
        String valorParam;

        String enlace = "";
        if (sexo.equals("hombre")) {
            enlace = "<a href='Hombres.html'>Sorpresa</a>";
        } else if (sexo.equals("mujer")) {
            enlace = "<a href='Mujeres.html'>Sorpresa</a>";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<table border=\"5\">");
        out.println("<html>");
        out.println("<head><title>Datos encuesta</title></head>");
        out.println("<body>");
        out.println("<h1>DATOS ENCUESTA</h1>");
        out.println("<h2 style=\"color: red\">Hola " + nombre + "</h2>");
        out.println("<table border=\"5\">");
        out.println("<tr><td><b>Nombre:</b></td><td><i>" + nombre + "</i></td></tr>");
        out.println("<tr><td><b>Apellidos:</b></td><td><i>" + apellidos + "</i></td></tr>");
        out.println("<tr><td><b>Teléfono:</b></td><td><i>" + telefono + "</i></td></tr>");
        out.println("<tr><td><b>Lugar de nacimiento:</b></td><td><i>" + cNac + "</i></td></tr>");
        out.println("<tr><td><b>Sexo:</b></td><td><i>" + sexo + "</i></td></tr>");
        out.println("<tr><td><b>País de origen:</b></td><td><i>" + pais + "</i></td></tr>");
        out.println("<tr><td><b>Area texto:</b></td><td><i>" + comentario + "</i></td></tr>");
        out.println("</table>");

        out.println("<p>" + nombre + " tus actividades de oficio preferidas son: </p>");

        while (parametros.hasMoreElements()) {
            nombreParametro = (String) parametros.nextElement();
            if (!nombreParametro.equals("act")) {
                valorParam = request.getParameter(nombreParametro);
            }
        }

        out.println("<table border=\"5\">");
        String valoresSeleccionados[] = request.getParameterValues("act");

        if (valoresSeleccionados != null) {
            for (int x = 0; x < valoresSeleccionados.length; x++) {
                out.println("<tr>");
                out.println("<td><i>" + valoresSeleccionados[x] + "</i></td>");
                out.println("</tr>");
            }
        }
        out.println("</table><br>");

        out.println(enlace);
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
