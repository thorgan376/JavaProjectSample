/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class tables {
    public static void main(String[] args){
       Connection con = null;
       Statement st = null;
       try{
          con = ConnectionProvider.getCon();
          st = con.createStatement();
          st.executeUpdate("create table users(name varchar(200), email varchar(200), password varchar(50), securityQuestion varchar(500), answer varchar(200), address varchar(400), status varchar(20));");
          st.executeUpdate("create table room(roomNo int(10) primary key, roomType varchar(200), bed varchar(200), price int, status varchar(20));");
          st.executeUpdate("create table customer(id int, name varchar(50), mobileNumber int(10), nationality varchar(50), gender varchar(20), email varchar(100), idProof varchar(50), address varchar(100), checkIn varchar(50), roomNo varchar(10), bed varchar(10), roomType varchar(20), pricePerDay int(10), numberOfDaysStay int(10), totalAmount varchar(100), checkOut varchar(50));");
          JOptionPane.showMessageDialog(null, "Table Created Successfully");
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
    finally{
        try{
            con.close();
            st.close();
        }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "hahaha");
        }
    }
    }
}
