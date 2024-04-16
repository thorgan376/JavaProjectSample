/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author admin
 */
public class Employee {
        String employeeId;
	String name;
	String gender;
	String address;
	String phoneNumber;
	String username;
	String password;
	int accountProvideType;

    public Employee(String employeeId, String name, String gender, String address, String phoneNumber, String username, String password, int accountProvideType) {
        this.employeeId = employeeId;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.accountProvideType = accountProvideType;
    }
    
    public Employee(String name, String gender, String address, String phoneNumber, String username, String password, int accountProvideType) {
        this.employeeId = EmployeeModify.getGenerateId();
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.accountProvideType = accountProvideType;
    }

        
        
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountProvideType() {
        return accountProvideType;
    }

    public void setAccountProvideType(int accountProvideType) {
        this.accountProvideType = accountProvideType;
    }
        
    
}
