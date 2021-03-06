package Controllers.Usuario;

import Entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class usuarioBajaController extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession(true); 
        BaseDeDatos.Usuarios.UsuariosFunc funciones = new BaseDeDatos.Usuarios.UsuariosFunc();
        
        try{
            ArrayList<Usuario> listaUsuarios = funciones.getAllUsuariosHabilitados();

            request.setAttribute("listaUsuarios", listaUsuarios);
            RequestDispatcher rd = request.getRequestDispatcher("/pages/ABM/usuarios/bajaUsuarios.jsp");
            rd.forward(request, response);

            }
        catch (Exception e)
            {
                sesion.setAttribute("errorCatch", e.toString());
                RequestDispatcher rd =null;
                   response.sendRedirect("error.jsp");
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
