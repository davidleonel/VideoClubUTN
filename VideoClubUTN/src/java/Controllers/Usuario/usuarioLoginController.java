/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Usuario;

import Entidades.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MiLaptop
 */
public class usuarioLoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            HttpSession session = request.getSession(true); 
            BaseDeDatos.Usuarios.UsuariosFunc funciones = new BaseDeDatos.Usuarios.UsuariosFunc();
            
            try{      
                session.setAttribute("mensajeExito", null);
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                
                if(funciones.buscar(email))
                    {   
                        Usuario user = funciones.getOne(email);
                       
                        if(user.getPass().equals(pass)) 
                        {
                            session.setAttribute("email", user.getEmail());
                            session.setAttribute("nombre", user.getNombre());
                            session.setAttribute("tipoUsuario", user.getTipo());
                            if(user.getTipo().equals("admin"))
                            {
                                response.sendRedirect("pages/administradorBienvenida.jsp");
                            }else{
                                response.sendRedirect("index.jsp");
                            }
                        } else {
                                    session.setAttribute("mensajeExito", "Usuario no habilitado");
                                    response.sendRedirect("index.jsp");
                                }
                    }else{  
                            session.setAttribute("mensajeExito", "Usuario o contraseña incorrecta.");
                            response.sendRedirect("pages/usuarioNoEncontrado.jsp");

                    }


                }
            catch (Exception e)
                {                  
                    System.out.println("usuariologincontroller");
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
