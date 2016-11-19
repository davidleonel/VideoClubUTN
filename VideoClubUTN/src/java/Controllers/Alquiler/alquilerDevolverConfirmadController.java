/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Alquiler;

import Entidades.Alquiler;
import Entidades.Pelicula;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MiLaptop
 */
public class alquilerDevolverConfirmadController extends HttpServlet {
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        HttpSession session = request.getSession(true); 
        BaseDeDatos.Alquileres.AlquileresFunc funciones = new BaseDeDatos.Alquileres.AlquileresFunc();
        BaseDeDatos.Peliculas.PeliculasFunc funcionesPelicula = new BaseDeDatos.Peliculas.PeliculasFunc();
            
            try{
                String peliculaADevolver = request.getParameter("btn");
                String email = (String) session.getAttribute("email");
                Alquiler alquiler = funciones.getOne(peliculaADevolver, email);
                Pelicula pelicula = funcionesPelicula.getOne(peliculaADevolver);
                
                funciones.setEstado(alquiler.getNombrePelicula(), alquiler.getEmail(), alquiler.getFecha(), 0);
                funcionesPelicula.modificarDisponibilidad(pelicula.getId(), (pelicula.getDisponibilidad()+1) );
                session.setAttribute("mensajeExito", "Pelicula devuelta con exito!.");
                RequestDispatcher rd = request.getRequestDispatcher("/pages/alquilerDevueltoExito.jsp");
                rd.forward(request, response);
                
                }
            catch (Exception e)
                {
                response.getWriter().print("EL ERROR OCURRIDO ES:"+e);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
