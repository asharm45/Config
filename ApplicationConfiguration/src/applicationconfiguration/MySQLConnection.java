/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationconfiguration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author home
 */
public class MySQLConnection {
    
   
    
    public static Connection getConnection() throws Exception{
         Class.forName("com.mysql.jdbc.Driver");
        
        System.out.println("Driver loaded");
        
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","amit1234");
        
        System.out.println("Connected to MySQL DB");
        
        return con;
    }
    
}
