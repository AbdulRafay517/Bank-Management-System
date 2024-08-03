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
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceIncquiry extends JFrame implements ActionListener, Serializable {
    Account account;
    JFrame frame;
    JButton b2;
    JLabel l, l1,l2, l3;
    BalanceIncquiry(Account acc){
        this.account = acc;
        frame = new JFrame("Balance Incquiry");
        displayIcon.Icon(frame);
        addButtons();
        addLabels();
        frame.setSize(600, 400);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void addLabels() {
        l = new JLabel(" Details");
        l.setBounds(300, 60, 220, 50);
        l.setFont(new Font("Times new Roman",Font.ITALIC,30));
        l.setVisible(true);
        frame.add(l);

        l1 = new JLabel("Current Balance is: Rs:" + account.getBalance() + "/-");
        l1.setFont(new Font("Arial",Font.ITALIC,18));
        l1.setBounds(50, 220, 350, 30);
        l1.setVisible(true);
        frame.add(l1);

        l2 = new JLabel("Account No: " + account.getAccountNo());
        l2.setFont(new Font("Arial",Font.ITALIC,18));
        l2.setBounds(50, 190, 200, 30);
        l2.setVisible(true);
        frame.add(l2);

        l3 = new JLabel("Account Holder Name: " + account.getName());
        l3.setFont(new Font("Arial",Font.ITALIC,18));
        l3.setBounds(50, 160, 350, 30);
        l3.setVisible(true);
        frame.add(l3);
    }
    public void addButtons() {
       

       b2 = new JButton("Back");
        b2.setFont(new Font("Arial",Font.PLAIN,14));
        b2.setBounds(0, 295, 120, 36);
        b2.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b2.setVisible(true);
        b2.addActionListener(this);
        frame.add(b2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      
        if(e.getActionCommand().equals("Back")) {
            Sign_In_Menu m = new Sign_In_Menu(account);
            frame.dispose();
        }
    }
}