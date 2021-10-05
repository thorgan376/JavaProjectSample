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
public class EmployeeModify {
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
    
    public static List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from Employee";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString("employeeId"),
                        resultSet.getString("name"), resultSet.getString("gender"),
                        resultSet.getString("address"), resultSet.getString("phoneNumber"),
                        resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("accountProvideType"));
                employeeList.add(employee);
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

        return employeeList;
    }
    
    public static void insert(Employee employee) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();

            String sql = "insert into employee(employeeId, name, gender, address, phoneNumber, username, password, accountProvideType) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, employee.getEmployeeId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getGender());
            statement.setString(4, employee.getAddress());
            statement.setString(5, employee.getPhoneNumber());
            statement.setString(6, employee.getUsername());
            statement.setString(7, employee.getPassword());
            statement.setInt(8, employee.getAccountProvideType());

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
    
    public static void delete(String employeeId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Database data = Database.getInstance();
            connection = data.getConnection();


            String sql = "delete from employee where employeeId=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, employeeId);

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
    
    public static List<Employee> searchEmployee(String employeeName) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            Database data = Database.getInstance();
            connection = data.getConnection();
            String sql = "select * from employee where name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+employeeName+"%");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString("employeeId"),
                        resultSet.getString("name"), resultSet.getString("gender"),
                        resultSet.getString("address"), resultSet.getString("phoneNumber"),
                        resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("accountProvideType"));
                employeeList.add(employee);
                
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
        return employeeList;
    }
    
    public static void update(String id, String name, String gender, String address, String phone, 
            String username, String pass) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Database data = Database.getInstance();
            connection = data.getConnection();
                
                    String sql = "update employee set name=?,gender=?,address=?,phoneNumber=?,username=?,"
                    + "password=? where employeeId = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, name);
            statement.setString(2, gender);
            statement.setString(3, address);
            statement.setString(4, phone);
            statement.setString(5, username);
            statement.setString(6, pass);
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
 
    public static List<Employee> employeeSearchId(String id){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Employee> employeeList = new ArrayList<>();
        
        try {

            Database data = Database.getInstance();
            connection = data.getConnection();


            String sql = "select * from employee where employeeId=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString("employeeId"),
                        resultSet.getString("name"), resultSet.getString("gender"),
                        resultSet.getString("address"), resultSet.getString("phoneNumber"),
                        resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("accountProvideType"));
                employeeList.add(employee);
                
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
        return employeeList;
    }
}
