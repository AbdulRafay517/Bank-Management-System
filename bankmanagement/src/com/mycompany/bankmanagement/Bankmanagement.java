/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankmanagement;

/**
 *
 * @author abdul
 */

import com.mycompany.bankmanagement.BankRecord;

public class Bankmanagement {
    public static void main(String[] args) {
        try {
            BankRecord.loadData();
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        MainMenu m = new MainMenu();
    }
}