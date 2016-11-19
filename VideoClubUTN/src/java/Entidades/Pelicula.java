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
public class Pelicula {
     
   // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private int id;
    private String nombre;
    private String genero;
    private float precio;
    private int disponibilidad;
    private float duracion;
    private String descripcion;
    private int estreno;
    
    
    // <editor-fold desc="CONSTRUCTORES">
     public Pelicula()
     { }
    
     public Pelicula(String nombre, String genero, float precio, int disponibilidad, float duracion, String descripcion)
     {
     this.nombre=nombre;
     this.genero=genero;
     this.precio=precio;
     this.disponibilidad=disponibilidad;
     this.duracion=duracion;
     this.descripcion=descripcion;
     }
    
    // <editor-fold desc="SET DE DATOS ">
     
     //SET DE DATOS PARA LA BASE DE DATOS
    public void setDatos(int id, String nombre, String genero, float precio, int disponibilidad, float duracion, String descripcion)
    {
        this.id=id;
        this.nombre=nombre;
        this.genero=genero;
        this.precio=precio;
        this.disponibilidad=disponibilidad;
        this.duracion=duracion;
        this.descripcion=descripcion;
     
    }
    public void setDatos(String nombre, String genero, float precio, int disponibilidad, float duracion, String descripcion)
    {
        this.nombre=nombre;
        this.genero=genero;
        this.precio=precio;
        this.disponibilidad=disponibilidad;
        this.duracion=duracion;
        this.descripcion=descripcion;
    }
    
    public void setDatos(String nombre, String genero, float precio, int disponibilidad, float duracion, String descripcion, int estreno)
    {System.out.println("entro al setdatos");
        this.nombre=nombre;
        this.genero=genero;
        this.precio=precio;
        this.disponibilidad=disponibilidad;
        this.duracion=duracion;
        this.descripcion=descripcion;
        this.estreno=estreno;
    }
     
    // </editor-fold>
    public String getNombre()
    {
        return this.nombre;
    }
    public String getGenero()
    {
        return this.genero;
    }       
    public float getPrecio()
    {
        return this.precio;
    }
    public float getDuracion()
    {
        return this.duracion;
    }
    public int getDisponibilidad()
    {
    return this.disponibilidad;
    }
    public String getDescripcion()
    {
    return this.descripcion;
    }
    public int getId()
    {
    return this.id;
    }
    public int getEstreno()
    {
    return this.estreno;
    }
    // </editor-fold>
    
    
}
