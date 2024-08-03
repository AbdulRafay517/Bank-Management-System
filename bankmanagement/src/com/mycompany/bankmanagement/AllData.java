/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author abdul
 */


import java.io.Serializable;
import java.util.ArrayList;

public class AllData extends BankRecord implements Serializable{
    public AllData() {
        for (int i = 0; i < bankRecord.size(); i++) {

            System.out.println("Account " + (i+1));
            System.out.println(bankRecord.get(i).toString());
            System.out.println(bankRecord.get(i).ToString());
        }
    }
}

