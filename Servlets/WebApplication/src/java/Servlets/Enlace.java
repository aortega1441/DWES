/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class Enlace extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title<ServletEnlace</title></head>");
        out.println("<body bgcolor=\"cyan\">");
        out.println("<h2>Vienes de pulsar el enlace \"Púlsame\"</h2>");
        System.out.println("<img src=\"https://localhost:8080/WebApplication/alien.jpg\">");
        out.println("</body>");
        out.println("</html>");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}