/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MiLaptop
 */

public class Alquiler {
     
   // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private int id;
    private String email;
    private String fecha;
    private String nombrePelicula;
    private float monto;
    private int idPelicula;
    private int pendiente;
  
    // <editor-fold desc="CONSTRUCTORES">
     public Alquiler()
     { }
    
     public Alquiler(String email, String fecha, float monto, int idPelicula, String nombrePelicula, int estado)
     {
     this.email=email;
     this.nombrePelicula=nombrePelicula;
     this.fecha=fecha;
     this.monto=monto;
     this.idPelicula=idPelicula;
     this.pendiente=estado;
     
     }
    
    // <editor-fold desc="SET DE DATOS ">
     
     //SET DE DATOS PARA LA BASE DE DATOS
    public void setDatos(String email, String fecha, float monto, int idPelicula, String nombrePelicula)
     {
     this.id=id;
     this.email=email;
     this.nombrePelicula=nombrePelicula;
     this.fecha=fecha;
     this.monto=monto;
     this.idPelicula=idPelicula;
     
     }
     public void setDatos(int id, String email, String fecha, float monto, int idPelicula, String nombrePelicula)
     {
     this.id=id;
     this.email=email;
     this.nombrePelicula=nombrePelicula;
     this.fecha=fecha;
     this.monto=monto;
     this.idPelicula=idPelicula;
     
     }
    public void setEstado(int estado)
     {
     this.pendiente=estado;
    
     }
    // </editor-fold>
    public String getEmail()
    {
        return this.email;
    }
    public String getFecha()
    {
        return this.fecha;
    }       
    public float getMonto()
    {
        return this.monto;
    }
    public int getIdPelicula()
    {
    return this.idPelicula;
    }
    public String getNombrePelicula()
    {
        return this.nombrePelicula;
    }
    public int getEstado()
    {
    return this.pendiente;
    }
    // </editor-fold>
    
    
}
