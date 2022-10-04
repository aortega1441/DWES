/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Servlet_resultado extends HttpServlet {

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
            out.println("<title>Servlet Servlet_resultado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_resultado at " + request.getContextPath() + "</h1>");
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

        String imp = request.getParameter("importe");
        String cant = request.getParameter("cantidad");
        boolean correcto;
        double importe = 0;
        double cantidad = 0;

        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (imp.equals("") || cant.equals("")) {
            correcto = false;

        } else {
            try {
                correcto = true;
                importe = Double.parseDouble(imp);
                cantidad = Double.parseDouble(cant);

                if (importe < 0 || cantidad < 0) {
                    correcto = false;
                    rd = contexto.getRequestDispatcher("/ErrorNumNeg.html");
                    rd.forward(request, response);
                }
            } catch (NumberFormatException e) {
                correcto = false;
                rd = contexto.getRequestDispatcher("/ErrorCadena.html");
                rd.forward(request, response);
            }
        }

        if (correcto) {

            if (cantidad < importe) {

                rd = contexto.getRequestDispatcher("/ErrorCantIns.html");
                rd.forward(request, response);

            } else if (cantidad > importe) {

                String impo = String.valueOf(importe);
                String canti = String.valueOf(cantidad);
                contexto.setAttribute("importe_valido", impo);
                contexto.setAttribute("cantidad_valida", canti);

                double operacion = cantidad - importe;
                double[] monedas = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.20, 0.10, 0.05, 0.02, 0.01};
                double[] devolver = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

                for (int i = 0; i < monedas.length; i++) {

                    if (operacion >= monedas[i]) {
                        devolver[i] = Math.floor(operacion / monedas[i]);
                        operacion = operacion - (devolver[i] * monedas[i]);
                    }
                }

                for (int i = 0; i < monedas.length; i++) {

                    if (devolver[i] > 0) {
                        if (monedas[i] > 2) {
                            String bill = String.valueOf(monedas[i]);
                            String cBill = String.valueOf(devolver[i]);
                            contexto.setAttribute("billetes", bill);
                            contexto.setAttribute("cantBilletes", cBill);
                            //out.println("<p>Hay " + devolver[i] + " billetes de: " + monedas[i] + " euros");
                        } else {
                            if (monedas[i] < 1) {
                                String cent = String.valueOf(monedas[i]);
                                String cCent = String.valueOf(devolver[i]);
                                contexto.setAttribute("centimos", cent);
                                contexto.setAttribute("cantCentimos", cCent);
                                //out.println("<p>Hay " + devolver[i] + " monedas de: " + monedas[i] + " céntimos");
                            } else {
                                String euro = String.valueOf(monedas[i]);
                                String cEuro = String.valueOf(devolver[i]);
                                contexto.setAttribute("euros", euro);
                                contexto.setAttribute("cantEuros", cEuro);
                                //out.println("<p>Hay " + devolver[i] + " monedas de: " + monedas[i] + " euros");
                            }

                        }
                    }
                }

                rd = contexto.getRequestDispatcher("/MuestraSolucion");
                rd.forward(request, response);

            }

            out.println("</body>");
            out.println("</html>");
        } else {
            rd = contexto.getRequestDispatcher("/ErrorCadenaVacia.html");
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
