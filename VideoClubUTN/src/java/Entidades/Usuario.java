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

public class Usuario {
    
    private String email;
    private String pass;
    private String tipo;
    private String nombre;
    private String apellido;
    private int estado;

    
    public Usuario(){}

    public Usuario(String email, String nombre, String apellido) {
        this.email = email;
        this.nombre=nombre;
        this.apellido=apellido;
        this.tipo = "usuario";
        this.estado = 1;
    }
    
    public Usuario(String email, String pass, String nombre, String apellido) {
        this.email = email;
        this.pass = pass; 
        this.nombre=nombre;
        this.apellido=apellido;
        this.tipo = "usuario";
        this.estado = 1;
    }
    
    public Usuario(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
    
    // <editor-fold desc="SET DE DATOS PERSONALES USADO EN EL ALTA DEL USUARIO">
    public void setDatos(String email, String nombre, String apellido,String tipo, int estado)
    {   this.email=email;
        this.nombre=nombre;
        this.apellido=apellido;
        this.tipo = tipo;
        this.estado = 1;
    }
    
    public void setDatos(String email, String pass, String nombre, String apellido, String tipo, int estado)
    {   this.email=email;
        this.setPass(pass);
        this.nombre=nombre;
        this.apellido=apellido;
        this.tipo = tipo;
        this.estado = estado;
    }    
    // </editor-fold>
    
    // <editor-fold desc="SET DE DATOS PERSONALES USADO EN EL ALTA DEL USUARIO">
    public void setEstado(int estado)
    {
        this.estado = estado;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void setDatospersonales(String nombre, String apellido)
    {   
        this.nombre=nombre;
        this.apellido=apellido;
        this.tipo = "usuario";
    }
    
    public void setDatosPersonales(String email, String nombre, String apellido)
    {
        this.email=email;
        this.nombre=nombre;
        this.apellido=apellido;
        this.tipo = "usuario";
    }  
    // </editor-fold>
    
    // <editor-fold desc="GETS DATOS DE SESION">
    public String getEmail()
    {
        return this.email;
    }
   
    public int getEstado()
    {
        return this.estado;
    }
    
    public String getPass()
    {
        return this.pass;
    }
    // </editor-fold>
    
    // <editor-fold desc="GETS DATOS PERSONALES">
    public String getNombre()
    {return this.nombre;
    }
    
    public String getApellido()
    {return this.apellido;
    }
    
    public String getTipo()
    {
        return this.tipo;
    }
    // </editor-fold>
}
