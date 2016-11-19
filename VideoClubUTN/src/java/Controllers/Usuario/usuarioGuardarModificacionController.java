/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Usuario;

import BaseDeDatos.Util;
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

public class usuarioGuardarModificacionController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Util validar = new Util();
        HttpSession session = request.getSession(true); 
        RequestDispatcher rd =null;
        BaseDeDatos.Usuarios.UsuariosFunc funciones = new BaseDeDatos.Usuarios.UsuariosFunc();
       
        try{
                String email1 = request.getParameter("email1");
                String email2 = request.getParameter("email2");
                String pass1  = request.getParameter("pass1");
                String pass2  = request.getParameter("pass2");
                
                if(validar.esIgual(email1, email2) && !validar.estaVacio(email1) && !validar.estaVacio(email2))
                {
                  if(validar.esIgual(pass1, pass2)&& !validar.estaVacio(pass1) && !validar.estaVacio(pass2))
                    {
                        String nombre = request.getParameter("nombre");
                        String apellido = request.getParameter("apellido");
                        String tipo = "usuario";
                        int estado = Integer.parseInt(request.getParameter("estado"));
                        String emailOriginal = (String) session.getAttribute("emailOriginal");
                        
                        funciones.modificar(emailOriginal, email1, pass1, nombre, apellido, tipo, estado);

                        session.setAttribute("mensajeExito", "Usuario modificado correctamente.");
                        response.sendRedirect("/pages/ABM/menuAbmUsuarios.jsp");
                        
                      }
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