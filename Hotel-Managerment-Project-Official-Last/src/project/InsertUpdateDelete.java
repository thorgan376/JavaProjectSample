/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Khoa.NL206560
 */
public class InsertUpdateDelete {
    public static void setData(String Query,String msg){    //'msg' = 'message'
    Connection con = null;
    Statement st = null;
    try
    {
    con =  ConnectionProvider.getCon();
    st = con.createStatement();
    st.executeUpdate(Query);
    if(!msg.equals(""))
         JOptionPane.showMessageDialog(null, msg);
    }
    catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, e);
            }
    }
}
