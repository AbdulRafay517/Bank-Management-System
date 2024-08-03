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

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.*;

public class Transfer extends JFrame implements ActionListener, Serializable {
    Account acc;
    JButton b1, back;
    JLabel l1 ,l2 ,l3 ,l4, l5;
    JFrame  frame = new JFrame("Transfer money");
    JTextField text1,text2;
    public Transfer() {
        addButton();
        setTextFields();
        setLabels();
        frame.setSize(800,600);
        frame.setBackground(Color.WHITE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public Transfer(Account a) {
        acc = a;
        displayIcon.Icon(frame);
        setLabels();
        addButton();
        setTextFields();
        frame.setSize(600,500);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void setTextFields() {

        text1 = new JTextField();
        text1.addActionListener(this);
        text1.setFont(new Font("Arial", Font.PLAIN, 12));
        text1.setBounds(280, 220, 140, 30);
        text1.setVisible(true);
        frame.add(text1);
        text2 = new JTextField();
        text2.addActionListener(this);
        text2.setFont(new Font("Arial", Font.PLAIN, 12));
        text2.setBounds(280, 270, 140, 30);
        text2.setVisible(true);
        frame.add(text2);

    }
    //method to set labels
    public void setLabels(){
        l1 = new JLabel("Transfer" );
        l1.setFont(new Font("Times new Roman", Font.BOLD, 22));
        l1.setBounds(265, 50, 300, 50);
        l1.setVisible(true);
        frame.add(l1);

        l2 = new JLabel("Here:");
        l2.setFont(new Font("Times new Roman", Font.BOLD, 22));
        l2.setBounds(300, 80, 300, 30);
        l2.setVisible(true);
        frame.add(l2);

        l3 = new JLabel("Current Balance is : Rs " + acc.getBalance() +"/-");
        l3.setBounds(70, 150, 450, 40);
        l3.setFont(new Font("Arial", Font.BOLD, 18));
        l3.setVisible(true);
        frame.add(l3);

        l4 = new JLabel("Enter amount to transfer: ");
        l4.setFont(new Font("Arial", Font.BOLD, 15));
        l4.setBounds(70, 220, 200, 30);
        l4.setVisible(true);
        frame.add(l4);

        l5 = new JLabel("Enter account number: ");
        l5.setFont(new Font("Arial", Font.BOLD, 15));
        l5.setBounds(70, 270, 200, 30);
        l5.setVisible(true);
        frame.add(l5);
    }
    public void addButton(){
        b1 = new JButton("Transfer");
        b1.setBounds(260, 360, 150, 40);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b1.setVisible(true);
        frame.add(b1);
        b1.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(0, 360, 150, 40);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        back.setVisible(true);
        frame.add(back);
        back.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Account account = BankRecord.accountSearch(acc.getAccountNo());
        Account a = BankRecord.accountSearch(text2.getText());
        int amount = 0;
        boolean n = false;
        if(e.getActionCommand().equals("Transfer")) {
            if (text1.getText().isBlank() || text2.getText().isBlank()) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please Enter required Credentials" + JOptionPane.ERROR_MESSAGE);
            }

            else if(!text1.getText().isBlank()) {
                try {
                    amount = Integer.parseInt(text1.getText());
                    n = true;
                } catch (NumberFormatException ex) {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Please Enter Valid amount" + JOptionPane.ERROR_MESSAGE);
                }
            }
            if(n) {
                if(amount == 0){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Please Enter Valid amount"+JOptionPane.ERROR_MESSAGE);
                }
                else if (account.getBalance() < amount) {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Amount Exceeds your account limit");
                } else if (a == null && account.getBalance() < amount) {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Your amount exceeds account limit and \nother Account doesn't exists" + JOptionPane.ERROR_MESSAGE);
                } else if (a == null) {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "other Account doesn't exists" + JOptionPane.ERROR_MESSAGE);
                }
                else if(text2.getText().equals(account.getAccountNo())){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Can not transfer amount to your own account" + JOptionPane.ERROR_MESSAGE);
                }
                else if (a != null && account.getBalance() > amount) {
                    Double AmountToSend = Double.parseDouble(text1.getText());
                    account.balance = account.balance - AmountToSend;
                    account.setBalance(account.balance);
                    a.balance = a.balance + AmountToSend;
                    a.setBalance(a.balance);

                    try {
                        BankRecord.saveData();
                    } catch (SQLException ex) {
                        Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Amount " + text1.getText() + " Successfully transferred to Account " + text2.getText() + "\nNew Balance: " + acc.getBalance());
                    Sign_In_Menu s = new Sign_In_Menu(acc);
                    frame.dispose();
                }
            }
        }
        else if(e.getActionCommand().equalsIgnoreCase("back")){
            Sign_In_Menu s = new Sign_In_Menu(acc);
            frame.dispose();
        }

    }

}