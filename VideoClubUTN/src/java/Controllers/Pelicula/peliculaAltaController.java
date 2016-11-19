package Controllers.Pelicula;

import Entidades.Pelicula;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class peliculaAltaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true); 

        BaseDeDatos.Peliculas.PeliculasFunc funciones = new BaseDeDatos.Peliculas.PeliculasFunc();
       
        try{ 
                String nombre = request.getParameter("nombre");
                String genero = request.getParameter("genero");

                if(funciones.buscar(nombre, genero))
                    { 
                        session.setAttribute("mensajeError", "La pelicula ya se encuentra registrada. Por favor ingrese otra.");
                        response.sendRedirect("altaPelicula.jsp");
                    }else{

                        float precio  = Float.valueOf(request.getParameter("precio"));
                        int disponibilidad  =  Integer.parseInt(request.getParameter("disponibilidad"));
                        float duracion  = Float.valueOf(request.getParameter("duracion"));
                        String desc = request.getParameter("descripcion");
                        int estreno = Integer.parseInt(request.getParameter("estado"));
                        
                        Pelicula pelicula = new Pelicula();
                        System.out.println("esta por hacer el set datos");
                        pelicula.setDatos(nombre, genero, precio, disponibilidad, duracion, desc, estreno);
                        System.out.println("esta por entrar al funciones peliculas");
                        funciones.alta(pelicula);

                        session.setAttribute("mensajeExito", "Pelicula añadida correctamente.");
                        response.sendRedirect("/pages/ABM/peliculas/subirFotoPelicula.jsp");
                }
        } 

        catch (Exception e)
            {
                session.setAttribute("errorCatch", e.toString());
                response.sendRedirect("pages/error.jsp");

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



