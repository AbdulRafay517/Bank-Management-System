/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author abdul
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.*;

public class deposit extends JFrame implements ActionListener, Serializable {

    Account acc;
    JButton b1, back;
    JLabel l, l1 ,l2,l3, l4;
    JFrame  frame = new JFrame("Deposit amount");
    JTextField text1;
    public deposit(){

    }
    public deposit(Account a) {
        acc = a;
        displayIcon.Icon(frame);
        addButton();
        setLabels();
        setTextFields();
        frame.setSize(600, 500);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    private void setTextFields() {
        // TODO Auto-generated method stub
        text1 = new JTextField();
        text1.addActionListener(this);
        text1.setFont(new Font("Arial", Font.PLAIN, 12));
        text1.setBounds(300, 240, 140, 30);
        text1.setVisible(true);
        frame.add(text1);

    }
    //method to set labels
    public void setLabels(){
        l = new JLabel("You can deposit Your" );
        l.setFont(new Font("Times new Roman", Font.BOLD, 22));
        l.setBounds(265, 50, 300, 30);
        l.setVisible(true);
        frame.add(l);

        l1 = new JLabel("Amount here" );
        l1.setFont(new Font("Times new Roman", Font.BOLD, 22));
        l1.setBounds(300, 80, 150, 30);
        l1.setVisible(true);
        frame.add(l1);

        l2 = new JLabel("Current Balance: ");
        l2.setBounds(70, 190, 250, 40);
        l2.setFont(new Font("Arial", Font.BOLD, 18));
        l2.setVisible(true);
        frame.add(l2);

        l3 = new JLabel(String.valueOf(acc.getBalance()));
        l3.setFont(new Font("Arial", Font.BOLD, 18));
        l3.setBounds(300, 160, 100, 100);
        l3.setVisible(true);
        frame.add(l3);
        l4 = new JLabel("Amount to be deposited:");
        l4.setFont(new Font("Arial", Font.BOLD, 15));
        l4.setBounds(70, 240, 230, 50);
        l4.setVisible(true);
        frame.add(l4);
    }
    public void addButton(){
        b1 = new JButton("Deposit");
        b1.setBounds(310, 340, 100, 40);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b1.setVisible(true);
        frame.add(b1);
        b1.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(0, 340, 170, 40);
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        back.setVisible(true);
        frame.add(back);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals("Deposit")) {
            int amount = 0;
            boolean n = false;
            try {
                amount = Integer.parseInt(text1.getText());
                n = true;
            } catch (NumberFormatException ex) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please Enter integer amount" + JOptionPane.ERROR_MESSAGE);
            }
            if (n) {
                if (text1.getText().isBlank() || amount == 0) {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Please Enter the amount to deposit" + JOptionPane.ERROR_MESSAGE);
                } else {
                    acc.balance = acc.balance + amount;
                    acc.setBalance(acc.balance);
                    try {
                        BankRecord.saveData();
                    } catch (SQLException ex) {
                        Logger.getLogger(deposit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Your new Balance is: " + acc.getBalance());
                    Sign_In_Menu m = new Sign_In_Menu(acc);
                    frame.dispose();

                }
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("Back")){
            Sign_In_Menu m = new Sign_In_Menu(acc);
            frame.dispose();
        }

    }


}