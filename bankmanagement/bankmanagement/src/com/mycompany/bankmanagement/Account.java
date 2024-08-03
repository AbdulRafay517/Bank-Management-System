/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author abdul
 */

import java.io.*;

public class Account implements Serializable {
    private String name;
    private String email;
    private String CNIC;
    private boolean isActive;
    private String password;
    public String accountNo;
    private String phoneNo;
    public double balance;
    private String gender;
    private String maritalStatus;
    
    public Account() {
        isActive = false;
        password = null;
    }
    public Account(String name, String email, String cnic, String phoneNumber, double balance, String gender, String maritalStatus) {
        this.name = name;
        this.email = email;
        this.CNIC = cnic;
        this.phoneNo = phoneNumber;
        this.isActive = false;
        this.balance = balance;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.accountNo = randomNumberGenerator.getrandom();
        this.password = "";
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public static boolean ValidCnic(String cnic) {
        if (cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))
            return true;
        else
            return false;
    }
    
    //Check for mail
    static boolean ValidEmail(String email) {
        if(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z-]+\\.)+[a-z" +
                "A-Z]{2,7}$"))
            return true;
        else
            return false;
    }
    
    //Check for name
    static boolean ValidName(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z' || ch == ' ')) {
                return false;
            }
        }
        return true;
    }
    
    static boolean ValidNumber(String number) {
        if(number.matches("^03[0-4][0-9]-[0-9]{7}$"))
            return true;
        else
            return false;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCNIC() {
        return CNIC;
    }
    
    public void setCNIC(String cNIC) {

        CNIC = cNIC;
    }
    
    public String getAccountNo() {
        return accountNo;
    }
    
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    
    public String getPhoneNo() {
        return phoneNo;
    }
    
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public boolean getisActive() {
        return isActive;
    }
    
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getMaritalStatus(){
        return maritalStatus;
    }
    
    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }

    public String ToString() {
        return "Name: " + this.name +  "\nGender: " + getGender() + "\nAccount Number: " + getAccountNo() + "\nPhone Number: " + this.phoneNo + "\nEmail: " + getEmail() + "\nCNIC: " + getCNIC() + "\nBalance: " + getBalance();
    }
    
    @Override
    public String toString() {
        return "Account [name=" + name + ", email=" + email + ", CNIC=" + CNIC + ", isActive=" + isActive
                +  ", accountNo=" + accountNo + ", phoneNo=" + phoneNo + ", balance="
                + balance + ", gender=" + gender + ", maritalStatus=" + maritalStatus + "]";
    }
}

