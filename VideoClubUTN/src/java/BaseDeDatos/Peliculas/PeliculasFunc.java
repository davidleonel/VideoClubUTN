/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos.Peliculas;

import BaseDeDatos.Conexion;
import Entidades.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author MiLaptop
 */
public class PeliculasFunc {
   
// <editor-fold desc="FUNCIONES: ALTA BAJA MODIFICAR">
          
    public boolean alta(Pelicula pelicula) throws Exception
     {     boolean status = false;  
        
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        try { // <editor-fold desc="QUERY Y RESULTADO">
            System.out.println("esta en el funciones peliculas");
            pst = con.prepareStatement("INSERT INTO `peliculas` (nombre, genero, precio, disponibilidad, duracion, descripcion, estreno)"+"values(?,?,?,?,?,?,?) ");
            pst.setString(1, pelicula.getNombre());
            pst.setString(2, pelicula.getGenero());
            pst.setFloat(3, pelicula.getPrecio());
            pst.setInt(4, pelicula.getDisponibilidad());
            pst.setFloat(5, pelicula.getDuracion());
            pst.setString(6, pelicula.getDescripcion());
            pst.setInt(7, pelicula.getEstreno());
            System.out.println("esta por ejecutar la query en la DB");
            pst.executeUpdate();  
            System.out.println("termino el query ");
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
    public void baja (String nombre) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("delete from peliculas where nombre=?");  
            pst.setString(1, nombre);
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
            // </editor-fold>
        
        } 
    }
    public void modificar (String nombreOriginal, String nombre, String genero, float precio, int disponibilidad, float duracion, String descripcion) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
        // </editor-fold>
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `peliculas` SET nombre='"+ nombre +"', genero='"+ genero +"', precio='"+ precio +"', disponibilidad='"+ disponibilidad +"', duracion='"+ duracion +"' , descripcion='"+ descripcion +"' WHERE nombre='"+ nombreOriginal +"' ");
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
            // </editor-fold>
        
        } 
    }
    
// <editor-fold desc="FUNCIONES: GETS">  
    public Pelicula getOne (String nombre) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         Pelicula pelicula = new Pelicula();
          
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from peliculas where nombre=?");  
            pst.setString(1, nombre);
            rs = pst.executeQuery();  
            if(rs.next()){
            pelicula.setDatos(rs.getInt("id"), rs.getString("nombre"), rs.getString("genero"),rs.getFloat("precio"), rs.getInt("disponibilidad"),rs.getLong("duracion"),rs.getString("descripcion"));
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
        
         return pelicula; 
    }
    
    public ArrayList<Pelicula>  getAll (String genero) throws Exception
    {
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
         
        try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("SELECT * FROM peliculas WHERE genero = ? AND disponibilidad <> 0 ORDER BY nombre");  
            pst.setString(1, genero);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                Pelicula pelicula = new Pelicula();
                pelicula.setDatos(rs.getInt("id"), rs.getString("nombre"), rs.getString("genero"),rs.getFloat("precio"), rs.getInt("disponibilidad"),rs.getLong("duracion"),rs.getString("nombre"));
                listaPeliculas.add(pelicula);
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
          return listaPeliculas;
       // </editor-fold>   
    }  
    public ArrayList<Pelicula>  getEstrenos () throws Exception
    {
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
         
        try { // <editor-fold desc="QUERY Y RESULTADO">
            int estreno = 1;
            pst = con.prepareStatement("SELECT * FROM peliculas WHERE estreno = ? ORDER BY nombre");  
            pst.setInt(1, estreno);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                Pelicula pelicula = new Pelicula();
                pelicula.setDatos(rs.getInt("id"), rs.getString("nombre"), rs.getString("genero"),rs.getFloat("precio"), rs.getInt("disponibilidad"),rs.getLong("duracion"),rs.getString("nombre"));
                listaPeliculas.add(pelicula);
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
          return listaPeliculas;
       // </editor-fold>   
    }  
    public ArrayList<Pelicula>  getAll () throws Exception
    {
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
         
        try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("SELECT * FROM peliculas");  
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                Pelicula pelicula = new Pelicula();
                pelicula.setDatos(rs.getInt("id"), rs.getString("nombre"), rs.getString("genero"),rs.getFloat("precio"), rs.getInt("disponibilidad"),rs.getLong("duracion"), rs.getString("descripcion"));
                listaPeliculas.add(pelicula);
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
          return listaPeliculas;
       // </editor-fold>   
    } 
    public ArrayList<Pelicula>  getAllDisponibles () throws Exception
    {
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
         
        try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("SELECT * FROM peliculas WHERE disponibilidad <> 0 ORDER BY nombre");  
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                Pelicula pelicula = new Pelicula();
                pelicula.setDatos(rs.getInt("id"), rs.getString("nombre"), rs.getString("genero"),rs.getFloat("precio"), rs.getInt("disponibilidad"),rs.getLong("duracion"), rs.getString("descripcion"));
                listaPeliculas.add(pelicula);
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
          return listaPeliculas;
       // </editor-fold>   
    }  

    
// <editor-fold desc="FUNCIONES: OTRAS">
    public boolean buscar(String nombre, String genero) throws Exception
    {     boolean status = false;  
        
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
          try { 
                pst = con.prepareStatement("select * from peliculas where nombre=? and genero=? ");  
                pst.setString(1, nombre);
                pst.setString(2, nombre);
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
    
    public void bajaAll (long UPC) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("delete from peliculas where upc=? ");  
            pst.setLong(1, UPC);
           
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
            // </editor-fold>
        
        } 
    }
    
    public void modificarDisponibilidad (int id, int disponibilidad) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `peliculas` SET disponibilidad=? WHERE id=? ");
            
            pst.setFloat(1, disponibilidad);
            pst.setLong(2, id);
            
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
            // </editor-fold>
        
        } 
    }
    
    
    // </editor-fold>
    
}
