/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 

public class Conexion {

  static Connection con ;
  
  public static Connection getConexion() throws Exception{

        String host = "mysql111859-videoclub-utn.jelasticlw.com.br";//cambiar por tu host de la base de datos
        String user = "root";//cambiar por tu usuario de la base de datos
        String pass = "ZHRico13053";//cambiar por tu contraseña de la base de datos
        String dtbs = "videoclub";//cambiar por nombre de la base de datos
 
//        String host = "localhost";//cambiar por tu host de la base de datos
//        String user = "root";//cambiar por tu usuario de la base de datos
//        String pass = "root";//cambiar por tu contraseña de la base de datos
//        String dtbs = "videoclub";//cambiar por tu nombre de la base de datos
        
        
        try { // preparamos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            
            con = DriverManager.getConnection(newConnectionURL);
             
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
            return con;
    }
  
   public static void cerrarConexion() throws SQLException{
        try {
                
            con.close();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
