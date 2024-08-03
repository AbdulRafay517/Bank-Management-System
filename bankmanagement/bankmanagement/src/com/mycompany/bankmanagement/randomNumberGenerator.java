/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author abdul
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class randomNumberGenerator implements Serializable{
    static Random random;
    public static final int highest = 99999;
    public static final int lowest = 11111;
    static int accNo;
    static String accNum;
    public randomNumberGenerator() {

    }
    public static String getrandom() {
        random = new Random();
        while(true)
        {
            accNo = random.nextInt((highest - lowest) + lowest);
            accNum = String.valueOf(accNo);
            boolean notValidNum = false;
            for(int i = 0; i<BankRecord.bankRecord.size(); i++)
            {
                if(BankRecord.bankRecord.get(i).getAccountNo().equals(accNum))
                {
                    notValidNum = true;
                    break;
                }
            }
            if(!notValidNum)
                break;
        }
        return String.valueOf(accNum);
    }
}
