/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author vecto
 */
public class Formulario1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        //Captura de parametros
        String nom = request.getParameter("nombre");
        String tef = request.getParameter("telefono");
        String lugNaci = request.getParameter("lugar de nacimiento");

        //Asignacion a la respuesta html que va a generarse, del tipo MINE
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
        out.println("</body>");
        out.println("</html>");
    }

}
