/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Component;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class MemberModify {
    
    static String getGenerateId()
            {
                String GenerateIdString = "0123456789QWERTYUIOPASDFGHJKLZXCVBNM";
                StringBuilder sb = new StringBuilder(5);
                for (int i = 0; i < 5; i++) {
                    int index = (int)(GenerateIdString.length() * Math.random());
                    sb.append(GenerateIdString.charAt(index));
                }
                return sb.toString();
            }
    
    public static List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from Member";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Member member = new Member(resultSet.getString("memberId"),
                        resultSet.getString("memberName"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phoneNumber"),
                        resultSet.getInt("age"), resultSet.getFloat("accountBalance"), resultSet.getString("borrow"));
                memberList.add(member);
            }


        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return memberList;
    }

    
    
    public static void insert(Member member) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();

            String sql = "insert into Member(memberId, memberName, gender, email, phoneNumber, age, accountBalance, borrow) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, member.getMemberId());
            statement.setString(2, member.getMemberName());
            statement.setString(3, member.getGender());
            statement.setString(4, member.getEmail());
            statement.setString(5, member.getPhoneNumber());
            statement.setInt(6, member.getAge());
            statement.setFloat(7, member.getAccountBalance());
            statement.setString(8, member.getBorrow());

            statement.execute();
            
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Sign up success");
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void update(String id, String name, String gender, String email, 
            String phone, int age, float money) {
        float updateMoney = money;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Database data = Database.getInstance();
            connection = data.getConnection();
                
                    String sql = "select accountBalance from member where memberId=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                updateMoney += resultSet.getFloat("accountBalance");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        try {
            Database data = Database.getInstance();
            connection = data.getConnection();
                
                    String sql = "update member set memberName=?,gender=?,email=?,phoneNumber=?,age=?,"
                    + "accountBalance=? where memberId = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, name);
            statement.setString(2, gender);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setInt(5, age);
            statement.setFloat(6, updateMoney);           
            statement.setString(7, id);


            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void delete(String memberId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();


            String sql = "delete from Member where memberId=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, memberId);

            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static List<Member> memberSearchName(String memberName) {
        List<Member> memberList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from Member where memberName like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+memberName+"%");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Member member = new Member(resultSet.getString("memberId"),
                        resultSet.getString("memberName"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phoneNumber"),
                        resultSet.getInt("age"),resultSet.getFloat("accountBalance"),resultSet.getString("borrow"));
                memberList.add(member);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return memberList;
    }
    public static List<Member> memberSearchId(String id){
        List<Member> memberList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from member where memberId=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Member member = new Member(resultSet.getString("memberId"),
                        resultSet.getString("memberName"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phoneNumber"),
                        resultSet.getInt("age"), resultSet.getFloat("accountBalance"), resultSet.getString("borrow"));
                memberList.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    return memberList;
    }
            
    
    public static void borrowBook(String memberId, String bookId, float fee){
        Connection connection = null;
        PreparedStatement statement = null;
        String borrow = null;
        float accountBalance = 0;
        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from member where memberId=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, memberId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                borrow = resultSet.getString("borrow");
                accountBalance = resultSet.getFloat("accountBalance");
            }
            borrow = borrow + bookId;
            accountBalance = accountBalance - fee;
            
            sql = "update member set accountBalance=?, borrow=? where memberId=?";
            statement = connection.prepareCall(sql);
            statement.setFloat(1, accountBalance);
            statement.setString(2, borrow);
            statement.setString(3, memberId);
            statement.execute();
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Borrow success");
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static List<Book> borrowList(String id){
        List<Book> bookList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String borrow = null;
            int index = 0;
            String bookid;
            String sql = "select borrow from Member where memberId=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                borrow = resultSet.getString("borrow");
            }
            while(true){
                bookid = borrow.substring(index,index+5);
                sql = "select * from book where id=?";
                statement = connection.prepareCall(sql);
                statement.setString(1, bookid);
                resultSet = statement.executeQuery();
                while(resultSet.next()){
                Book book = new Book(resultSet.getString("id"),
                        resultSet.getString("name"), resultSet.getString("type"),
                        resultSet.getString("Producer"), resultSet.getFloat("borrowFee"),
                        resultSet.getInt("Amount"), resultSet.getString("borrowBy"));
                bookList.add(book);
                }
                index += 5;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
            return bookList;
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return bookList;
        }    
    }
    public static void returnBook(String bookId, String memberId){
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String borrow = null;
            int index = 0;
            String A = "";
            String B = "";
            String sql = "select borrow from member where memberId=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, memberId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                borrow = resultSet.getString("borrow");
            }
            sql = "update member set borrow=? where memberId=?";
                    statement = connection.prepareCall(sql);
                    statement.setString(1, A);
                    statement.setString(2, memberId);
                    statement.execute();
            while(true){
                B = borrow.substring(index,index+5);
                if(!B.equals(bookId)){
                    A = A + B;
                    sql = "update member set borrow=? where memberId=?";
                    statement = connection.prepareCall(sql);
                    statement.setString(1, A);
                    statement.setString(2, memberId);
                    statement.execute();
                }else{
                    
                }
                index += 5; 
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
         return;
        }    
    }
    
}
