/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudtienda;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author yulia
 */
public class conexion {
    
    Connection con;
    String bd="bdtienda";
    String url="jdbc:mysql://127.0.0.1/"+bd;
    String user="root";
    String pass="";
    
    public Connection conectar(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
        }
        return con;
    }
            
}
