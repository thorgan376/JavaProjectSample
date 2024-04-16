/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","ghjkl;1234");
            return con;
        } 
        catch(ClassNotFoundException | SQLException e) {
        JOptionPane.showMessageDialog(null, e);    
        return null;
        }
    }
}
