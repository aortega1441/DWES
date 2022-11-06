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
import static modelo.DB.CrearConexion;
import modelo.Peliculas;

/**
 *
 * @author vecto
 */
public class ValidaDirector extends HttpServlet {
 ArrayList<Peliculas> listaDirector = new ArrayList<Peliculas>();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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

        String director = request.getParameter("directorBuscar");
        
        if(director.length()!=0){
            
            Connection conn = null;
            listaDirector.clear();

        try {

            conn = CrearConexion();

            String sql = "select peliculas.titulo, director.nombre, peliculas.fecha_estreno from peliculas, director where director.id = peliculas.director and director.nombre = '" + director + "'";
            PreparedStatement smt = conn.prepareCall(sql);
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {

                Peliculas pelicula = new Peliculas(rs.getString(1), rs.getString(2), rs.getString(3));
                listaDirector.add(pelicula);

            }

            contexto.setAttribute("listaDirector", listaDirector);
            request.getRequestDispatcher("/MuestraListadoDirector.jsp").forward(request, response);

        } catch (SQLException e) {
            System.out.println(e.getMessage());            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        }else{
            request.getRequestDispatcher("/ERRORES/ErrorBuscaVacio.html").forward(request, response);
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
