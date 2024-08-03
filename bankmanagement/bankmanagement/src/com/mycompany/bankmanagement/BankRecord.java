/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author abdul
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankRecord {
    public static ArrayList<Account> bankRecord = new ArrayList<Account>();
    public static Connection conn;
    
     public static void loadData() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/bank_management";
        String user = "root";
        String password = "root";
        conn = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM account";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Account a = new Account(rs.getString("name"), rs.getString("email"), rs.getString("cnic"), rs.getString("phone_number"), rs.getDouble("balance"), rs.getString("gender"), rs.getString("marital_status"));
            a.setAccountNo(rs.getString("account_number"));
            a.setPassword(rs.getString("password"));
            bankRecord.add(a);
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
    
    public static void saveData() throws SQLException {
    String url = "jdbc:mysql://localhost:3307/bank_management";
    String user = "root";
    String password = "root";
    conn = DriverManager.getConnection(url, user, password);
    
    String sql = "INSERT INTO account (name, email, cnic, phone_number, is_active, balance, gender, marital_status, account_number, password) VALUES (?,?,?,?,?,?,?,?,?,?)";
    
    for (Account a : bankRecord) {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, a.getName());
        pstmt.setString(2, a.getEmail());
        pstmt.setString(3, a.getCNIC());
        pstmt.setString(4, a.getPhoneNo());
        pstmt.setBoolean(5, a.getisActive());
        pstmt.setDouble(6, a.getBalance());
        pstmt.setString(7, a.getGender());
        pstmt.setString(8, a.getMaritalStatus());
        pstmt.setString(9, a.getAccountNo());
        pstmt.setString(10, a.getPassword());
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    conn.close();
    }
    
    public static void DeleteAccount(String accNo)
    {
        for(int i = 0; i<bankRecord.size(); i++)
        {
            if(bankRecord.get(i).getAccountNo().equals(accNo))
            {
                bankRecord.remove(i);
                break;
            }
        }

    }
    
    public static Account accountSearch(String accNo) {
        for(int i = 0; i< bankRecord.size(); i++)
        {
            if(accNo.equals(bankRecord.get(i).getAccountNo()))
            {
                return bankRecord.get(i);
            }
        }
        return null;
    }
    
    public static boolean searchAcc(String accNo){
        for(int i = 0; i< bankRecord.size(); i++)
        {
            if(accNo.equals(bankRecord.get(i).getAccountNo()))
            {
                return true;
            }
        }
        return false;
    }
}

