/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Pelicula;

import Entidades.Alquiler;
import Entidades.Pelicula;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class peliculaAlquilerConfirmadoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true); 
        RequestDispatcher rd =null;
        BaseDeDatos.Peliculas.PeliculasFunc peliculasFunciones = new BaseDeDatos.Peliculas.PeliculasFunc();
        BaseDeDatos.Alquileres.AlquileresFunc alquileresFunciones = new BaseDeDatos.Alquileres.AlquileresFunc();
        String pagina = "";
        try{ 
            if(session.getAttribute("nombre")==null)
            {
                pagina = "/pages/usuarioRequiereLogeo.jsp";
            } else {
                Pelicula pelicula = peliculasFunciones.getOne((String) session.getAttribute("peliculaInteresada"));
                if(pelicula.getDisponibilidad() == 0)
                {
                     pagina = "pages/peliculaNoDisponible.jsp";
                     
                } else {
                    String email = (String) session.getAttribute("email");
                    
                    
                    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String ahora = formatter.format(new Date());
                    int estado = 1;
                    
                    Alquiler alquiler = new Alquiler(email, ahora, pelicula.getPrecio(), pelicula.getId(), pelicula.getNombre(),estado);
                    alquileresFunciones.alta(alquiler);
                    
                    int disp = (pelicula.getDisponibilidad() - 1);

                    peliculasFunciones.modificarDisponibilidad(pelicula.getId(),disp);
                    pagina = "/pages/alquilerCreadoExito.jsp";
                    
                    session.setAttribute("mensajeExito", "Pelicula alquilada correctamente :) ");
                }
            }    
        } 

        catch (Exception e)
            {
                session.setAttribute("errorCatch", e.toString());
                pagina = "pages/error.jsp";

            } 
        
        response.sendRedirect(pagina);
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