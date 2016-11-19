/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Usuarios;

import Entidades.Usuario;
import BaseDeDatos.Conexion;
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.util.ArrayList;

/**
 *
 * @author MiLaptop
 */

public class UsuariosFunc {
  

public void alta (Usuario user) throws Exception
    {    

         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  


        try { 
            pst = con.prepareStatement("INSERT INTO `usuarios` (nombre, apellido, email, password, tipo, estado)"+"values(?,?,?,?,?,?) ");
            pst.setString(1, user.getNombre());
            pst.setString(2, user.getApellido());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPass());
            pst.setString(5, user.getTipo());
            pst.setInt(6,  user.getEstado());

            pst.executeUpdate();
            } 
          catch (Exception e) {
                throw e;  
              } 
          finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e); 
                }  
            }
        }  
    }

public void baja (Usuario user) throws Exception
    {   

         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         String email = user.getEmail();
          try { 
            pst = con.prepareStatement("UPDATE usuarios SET estado=0 WHERE email=?");  
            pst.setString(1, email);
            pst.executeUpdate();  
              } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e);
                }  
            }
        }  
    }

public void modificar (String emailOriginal, String email, String pass, String nombre, String apellido, String tipo, int estado ) throws Exception
    {    

         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  


          try {

            //COMPLETAR LA CONSULTA UPDATE
            pst = con.prepareStatement("UPDATE `usuarios` SET nombre='"+ nombre +"', apellido='"+ apellido +"', email='"+ email +"', password='"+ pass +"', tipo='"+ tipo +"', estado='"+ estado +"' WHERE email='"+ emailOriginal +"' ");
            pst.executeUpdate();

            } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e); 
                }  
            } 
        }  
    }


public Usuario getOne (String email) throws Exception
    {  
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        Usuario user = new Usuario();


        try { 
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from usuarios where email=?");  

            pst.setString(1, email);
            rs = pst.executeQuery();  

            if(rs.next()){
                user.setDatos(rs.getString("email"), rs.getString("password"),rs.getString("nombre"),rs.getString("apellido"), 
                rs.getString("tipo"), rs.getInt("estado"));
            }


        } 
        catch (Exception e) {  
              throw e;  
        } 
        finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                } catch (Exception e) {  
                 System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                     pst.close();  
                } catch (Exception e) {  
                 System.out.println(e);  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e);
                }  
            }
        }
    return user;    
}

public ArrayList<Usuario>  getAll () throws Exception
    {    
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         ArrayList<Usuario> lista = new ArrayList<Usuario>();


        try {
            pst = con.prepareStatement("SELECT * FROM usuarios WHERE tipo = ? ORDER BY nombre");  
            pst.setString(1, "usuario");
            rs = pst.executeQuery();  
            

            while(rs.next())
            {
                Usuario usuario = new Usuario();
                usuario.setDatos(rs.getString("email"), rs.getString("password"),rs.getString("nombre"),rs.getString("apellido"), 
                rs.getString("tipo"), rs.getInt("estado"));
                lista.add(usuario);
            }

        } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  

        }  
          return lista;
   }

public ArrayList<Usuario>  getAllAdminsHabilitados () throws Exception
    {    
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         ArrayList<Usuario> lista = new ArrayList<Usuario>();


          try {
            pst = con.prepareStatement("SELECT * FROM usuarios WHERE tipo = ? and estado=? ORDER BY nombre");  
            pst.setString(1, "admin");
            pst.setInt(2, 1);
            rs = pst.executeQuery();  
            

            while(rs.next())
            {
                Usuario admin = new Usuario();
                admin.setDatos(rs.getString("email"), rs.getString("password"),rs.getString("nombre"),rs.getString("apellido"), 
                rs.getString("tipo"), rs.getInt("estado"));
                lista.add(admin);
            }

              } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  

        }  
          return lista;
   }
public ArrayList<Usuario>  getAllAdmins () throws Exception
    {    
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         ArrayList<Usuario> lista = new ArrayList<Usuario>();


          try {
            pst = con.prepareStatement("SELECT * FROM usuarios WHERE tipo = ? ORDER BY nombre");  
            pst.setString(1, "admin");
            rs = pst.executeQuery();  
            

            while(rs.next())
            {
                Usuario admin = new Usuario();
                admin.setDatos(rs.getString("email"), rs.getString("password"),rs.getString("nombre"),rs.getString("apellido"), 
                rs.getString("tipo"), rs.getInt("estado"));
                lista.add(admin);
            }

              } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  

        }  
          return lista;
   }
public ArrayList<Usuario>  getAllUsuarios () throws Exception
    {    
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         ArrayList<Usuario> lista = new ArrayList<Usuario>();


          try {
            pst = con.prepareStatement("SELECT * FROM usuarios WHERE tipo = ? ORDER BY nombre");  
            pst.setString(1, "usuario");
            rs = pst.executeQuery();  
            

            while(rs.next())
            {
                Usuario admin = new Usuario();
                admin.setDatos(rs.getString("email"), rs.getString("password"),rs.getString("nombre"),rs.getString("apellido"), 
                rs.getString("tipo"), rs.getInt("estado"));
                lista.add(admin);
            }

              } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  

        }  
          return lista;
   }
public ArrayList<Usuario>  getAllUsuariosHabilitados () throws Exception
    {    
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         ArrayList<Usuario> lista = new ArrayList<Usuario>();


          try {
            pst = con.prepareStatement("SELECT * FROM usuarios WHERE tipo = ? and estado=? ORDER BY nombre");  
            pst.setString(1, "usuario");
            pst.setInt(2, 1);
            rs = pst.executeQuery();  
            

            while(rs.next())
            {
                Usuario admin = new Usuario();
                admin.setDatos(rs.getString("email"), rs.getString("password"),rs.getString("nombre"),rs.getString("apellido"), 
                rs.getString("tipo"), rs.getInt("estado"));
                lista.add(admin);
            }

              } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  

        }  
          return lista;
   }

public void setEstado(String email, int estado) throws Exception
{
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  

          try {
                System.out.println(email + estado);
                pst = con.prepareStatement("UPDATE `usuarios` SET estado=? WHERE email=? ");  
                pst.setInt(1, estado); 
                pst.setString(2, email); 
                
                pst.executeUpdate();     
            } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  

            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e);
                }  
            }
        }

}

public boolean buscar(String email) throws Exception
{        boolean status = false;  

         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  

          try { 
                pst = con.prepareStatement("select * from usuarios where email=?");  
                pst.setString(1, email);  
                rs = pst.executeQuery();  
                status = rs.next();
            } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  

            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e);
                }  
            }

        }  
        return status;  
 }  

public boolean login (Usuario user) throws Exception
    {    boolean status = false;  
System.out.println("usuariosfunc");
         // <editor-foldz desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         String email = user.getEmail();
         String pass = user.getPass();

          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("select * from usuarios where email=? and password=?");  
            pst.setString(1, email);  
            pst.setString(2, pass);  

            rs = pst.executeQuery();  
            status = rs.next();
            System.out.println("usuariosfunc");
            System.out.println(status);
         // </editor-fold>

              } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
               
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e);
                    //e.printStackTrace();  
                }  
            }
            // </editor-fold>

        }  
        return status;  
   }

public void setPass (String email, String nuevapass)throws Exception
{
     // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">

         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  


        // </editor-fold>

          try { // <editor-fold desc="QUERY Y RESULTADO">

              //COMPLETAR LA CONSULTA UPDATE
                pst = con.prepareStatement("UPDATE `usuarios` SET password=? WHERE email=?");
                pst.setString(1,nuevapass);
                pst.setString(2, email);

                pst.executeUpdate();

                 // </editor-fold>

            } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
            if (con != null) {  
                try {  
                    BaseDeDatos.Conexion.cerrarConexion();

                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e);
                    //e.printStackTrace();  
                }  
            }


        }  
}
}

