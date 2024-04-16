/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author admin
 */
public class BookModify {
    public static List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from Book";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book(resultSet.getString("id"),
                        resultSet.getString("name"), resultSet.getString("type"),
                        resultSet.getString("Producer"), resultSet.getFloat("borrowFee"),
                        resultSet.getInt("Amount"), resultSet.getString("borrowBy"));
                bookList.add(book);
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

        return bookList;
    }

    public static void insert(Book bok) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();

            String sql = "insert into Book(id, name, type, producer, borrowFee, amount, borrowBy) values(?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, bok.getId());
            statement.setString(2, bok.getName());
            statement.setString(3, bok.getType());
            statement.setString(4, bok.getProducer());
            statement.setFloat(5, bok.getBorrowFee());
            statement.setInt(6, bok.getAmount());
            statement.setString(7, bok.getBorrowBy());

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

    public static void update(String id, String name, String producer, float fee, int amount) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();


            String sql = "update book set name=?, Producer=?, borrowFee=?, Amount=? where id=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, name);
            statement.setString(2, producer);
            statement.setFloat(3, fee);
            statement.setInt(4, amount);
            statement.setString(5, id);


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
    
    
    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "delete from Book where id=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, id);

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
    public static List<BookType> bookType(){
        List<BookType> btype = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from booktype";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                BookType type = new BookType(resultSet.getString("id"),
                        resultSet.getString("type"));
                btype.add(type);
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

        return btype;
    }
    

    public static void insertBookType(BookType bookType) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();

            String sql = "insert into booktype(id, type) values(?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, bookType.getId());
            statement.setString(2, bookType.getType());

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
    public static int checkIdType(String id){
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();

            String sql = "select count(*) from booktype where id=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt("count(*)");
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
        
        return 0;
    }
    public static String getIdHead(String type){
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();

            String sql = "select id from booktype where type=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                return resultSet.getString("id");
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
        return "";
    }
    
    public static int checkIdBook(String id){
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();

            String sql = "select count(*) from book where id=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt("count(*)");
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
    return 0;
    }
    
    public static List<Book> updateMemberBorrow(String memberId, String bookId){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Book> bookList = new ArrayList<>();
        try {          
            
            Database data = Database.getInstance();
            connection = data.getConnection();
            
            String sql = "select * from book where id=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Book book = new Book(resultSet.getString("id"),resultSet.getString("name"),
                        resultSet.getString("type"),resultSet.getString("Producer"), resultSet.getFloat("borrowFee"),
                        resultSet.getInt("Amount"),resultSet.getString("borrowBy"));
                bookList.add(book);
                if(resultSet.getInt("amount") == 0){
                    return bookList;
                }
                int amountUpdate = resultSet.getInt("amount") - 1;
                String updateBorrowBy = resultSet.getString("borrowBy") + memberId;
            sql = "update book set amount=?, borrowBy=? where id=?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, amountUpdate);
            statement.setString(2, updateBorrowBy);
            statement.setString(3, bookId);
            statement.execute();
            return bookList;
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
    return bookList;
    }
    public static List<Book> bookSearchName(String bookName) {
        List<Book> bookList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from book where name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+bookName+"%");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Book book = new Book(resultSet.getString("id"),
                        resultSet.getString("name"), resultSet.getString("type"),
                        resultSet.getString("producer"), resultSet.getFloat("borrowFee"),
                        resultSet.getInt("amount"), resultSet.getString("borrowBy"));
                bookList.add(book);
                
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
        return bookList;
    }
    public static List<Book> bookSearchId(String id){
        List<Book> bookList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from book where id=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book(resultSet.getString("id"),
                        resultSet.getString("name"), resultSet.getString("type"),
                        resultSet.getString("producer"), resultSet.getFloat("borrowFee"),
                        resultSet.getInt("amount"), resultSet.getString("borrowBy"));
                bookList.add(book);
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
    return bookList;
    }
    
    public static List<Member> borrowList(String id){
        List<Member> memberList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String borrow = null;
            int index = 0;
            String memberid;
            String sql = "select borrowBy from book where id=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                borrow = resultSet.getString("borrowBy");
            }
            while(true){
                memberid = borrow.substring(index,index+5);
                sql = "select * from member where memberId=?";
                statement = connection.prepareCall(sql);
                statement.setString(1, memberid);
                resultSet = statement.executeQuery();
                while(resultSet.next()){
                Member member = new Member(resultSet.getString("memberId"),
                        resultSet.getString("memberName"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phoneNumber"),
                        resultSet.getInt("age"), resultSet.getFloat("accountBalance"), resultSet.getString("borrow"));
                memberList.add(member);
                }
                index += 5;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
            return memberList;
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
            return memberList;
        }    
    }

    public static void returnBook(String bookId, String memberId){
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String borrow = null;
            int amount = 0;
            int index = 0;
            String A = "";
            String B = "";
            String sql = "select * from book where id=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                borrow = resultSet.getString("borrowBy");
                amount = resultSet.getInt("amount");
            }
            sql = "update book set borrowBy=? where id=?";
                    statement = connection.prepareCall(sql);
                    statement.setString(1, A);
                    statement.setString(2, bookId);
                    statement.execute();
            while(true){
                B = borrow.substring(index,index+5);
                if(!B.equals(memberId)){
                    A = A + B;
                    sql = "update book set borrowBy=? where id=?";
                    statement = connection.prepareCall(sql);
                    statement.setString(1, A);
                    statement.setString(2, bookId);
                    statement.execute();
                }else{
                    amount += 1;
                    sql = "update book set amount=? where id=?";
                    statement = connection.prepareCall(sql);
                    statement.setInt(1, amount);
                    statement.setString(2, bookId);
                    statement.execute();
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
    public static int typeCount() {
        Connection connection = null;
        Statement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select count(*) from booktype";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return resultSet.getInt("count(*)");
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

        return 0;
    }

}
