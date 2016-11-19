/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Alquileres;

import BaseDeDatos.Conexion;
import Entidades.Alquiler;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author MiLaptop
 */
public class AlquileresFunc {
    public boolean alta(Alquiler alquiler) throws Exception
     {     boolean status = false;  
        
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        try { 
            pst = con.prepareStatement("INSERT INTO `alquileres` (email, fecha, monto, idPelicula, nombrePelicula, pendiente)"+"values(?,?,?,?,?,?) ");
            pst.setString(1, alquiler.getEmail());
            pst.setString(2, alquiler.getFecha());
            pst.setFloat(3, alquiler.getMonto());
            pst.setInt(4, alquiler.getIdPelicula());
            pst.setString(5, alquiler.getNombrePelicula());
            pst.setInt(6, alquiler.getEstado());
            pst.executeUpdate();  
          } 
        catch (Exception e) {  
            System.out.println(e);
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
    public void baja (String email, Date fecha) throws Exception
    {
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
          try { 
            pst = con.prepareStatement("delete from alquileres where email=? and fecha=? ");  
            pst.setString(1, email);
            pst.setDate(2, (java.sql.Date) fecha);
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
                    //e.printStackTrace();  
                }  
            }
            // </editor-fold>
        
        } 
    }
    public Alquiler getOne (String nombrePelicula, String email) throws Exception
    {
        
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         Alquiler alquiler = new Alquiler();
          
          try {  
             
            pst = con.prepareStatement("select * from alquileres where nombrePelicula=? and email=? and pendiente=?");  
            pst.setString(1, nombrePelicula);
            pst.setString(2, email);
            pst.setInt(3, 1);
            
            rs = pst.executeQuery();  
            if(rs.next()){
            alquiler.setDatos(rs.getInt("id"), rs.getString("email"), rs.getString("fecha"), rs.getFloat("monto"),rs.getInt("idPelicula"),rs.getString("nombrePelicula"));
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
                    //e.printStackTrace();  
                }  
            }
          }
         // </editor-fold>
        
         return alquiler; 
    }
    public ArrayList<Alquiler>  getAll () throws Exception
    {
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        ArrayList<Alquiler> listaAlquileres = new ArrayList<Alquiler>();
         
        try { 
            pst = con.prepareStatement("SELECT * FROM peliculas");  
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                Alquiler alquiler = new Alquiler();
                alquiler.setDatos(rs.getString("email"), rs.getString("fecha"),rs.getFloat("monto"),rs.getInt("idPelicula"), rs.getString("nombrePelicula"));
                listaAlquileres.add(alquiler);
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
          return listaAlquileres;
       // </editor-fold>   
    }
    public ArrayList<Alquiler>  getAll (String email) throws Exception
    {
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        ArrayList<Alquiler> listaAlquileres = new ArrayList<Alquiler>();
         
        try { 
            pst = con.prepareStatement("SELECT * FROM alquileres WHERE email = ? ORDER BY email");  
            pst.setString(1, email);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                Alquiler alquiler = new Alquiler();
                alquiler.setDatos(rs.getString("email"), rs.getString("fecha"),rs.getFloat("monto"),rs.getInt("idPelicula"), rs.getString("nombrePelicula"));
                listaAlquileres.add(alquiler);
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
          return listaAlquileres;
       // </editor-fold>   
    }  
    public ArrayList<Alquiler>  getAllgetAllPendientes (String email) throws Exception
    {
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        ArrayList<Alquiler> listaAlquileres = new ArrayList<Alquiler>();
         
        try { 
            pst = con.prepareStatement("SELECT * FROM alquileres WHERE email = ? AND pendiente = ? ORDER BY email");  
            pst.setString(1, email);
            pst.setInt(2, 1);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                Alquiler alquiler = new Alquiler();
                alquiler.setDatos(rs.getString("email"), rs.getString("fecha"),rs.getFloat("monto"),rs.getInt("idPelicula"), rs.getString("nombrePelicula"));
                listaAlquileres.add(alquiler);
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
          return listaAlquileres;
       // </editor-fold>   
    } 
    public void setEstado(String nombrePelicula, String email, String fecha, int estado) throws Exception
{
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  

          try {
                pst = con.prepareStatement("UPDATE `alquileres` SET pendiente=? WHERE email=? and nombrePelicula=? and fecha=?");  
                pst.setInt(1, estado); 
                pst.setString(2, email); 
                pst.setString(3, nombrePelicula); 
                pst.setString(4, fecha); 
                
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
}
