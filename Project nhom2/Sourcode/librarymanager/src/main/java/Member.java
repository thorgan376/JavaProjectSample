/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Member {
    String memberId;
    String memberName;
    String gender;
    String email;
    String phoneNumber;
    int age;
    float accountBalance;
    String borrow;

    public Member(){
    }

    public Member(String memberId, String memberName, String gender, String email, String phoneNumber, int age, float accountBalance, String borrow) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.accountBalance = accountBalance;
        this.borrow = "";
    }
    public Member(String memberName, String gender, String email, String phoneNumber, int age) {
        this.memberId = MemberModify.getGenerateId();
        this.memberName = memberName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.accountBalance = 100000.00f;
        this.borrow = "";
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getBorrow() {
        return borrow;
    }

    public void setBorrow(String borrow) {
        this.borrow = borrow;
    }
    
    

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
