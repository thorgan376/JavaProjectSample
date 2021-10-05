package Employeee;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

public class conn{
    
    public Connection c;
    public Statement s;
 
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///project3","root","");
            s = c.createStatement();
            JOptionPane.showMessageDialog(null, "Connection to database is successful");
            
        }catch(HeadlessException | ClassNotFoundException | SQLException e) {
        }
    }
}
 
