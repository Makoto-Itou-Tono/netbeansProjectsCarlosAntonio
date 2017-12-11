/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SYM-II
 */
public class Conecction {
    public Connection getConnection() { /*no va a recibir parametros*/
        
      Connection conexion=null;
      /*bloque de instrucciones try-catch instrucciones que cachara los erores */
      try{
          Class.forName("com.mysql.jdbc.Driver").newInstance();/* */
          String serverDb="jdbc:mysql://localhost/mydb";
          String userDb="root";
          String passwordDb="";
          conexion=DriverManager.getConnection(serverDb,userDb,passwordDb);//establce la cadena de coneccion
     
      }catch(ClassNotFoundException e){
          JOptionPane.showMessageDialog(null,"The driver was not Found");//para que sea relativo al padre por eso se le pone null
       
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"There was a problem"+ e.getMessage());
      }finally{
          return conexion;
      }
    }
}
