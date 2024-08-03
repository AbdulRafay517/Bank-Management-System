/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author abdul
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Sign_In_Menu implements ActionListener, Serializable {
    Account acc;
    JLabel l1;
    JButton b1, b2, b3, b4 ,b5;
    JFrame frame = new JFrame();
    Sign_In_Menu(){
        displayButtons();
        setLabels();
        displayIcon.Icon(frame);
        frame.setSize(600, 400);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.setTitle("Sign In Menu");
        frame.add(new ImageSet("logo.png", frame));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    Sign_In_Menu(Account a){
        acc = a;
        displayButtons();
        setLabels();
        displayIcon.Icon(frame);
        frame.setSize(580, 400);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.setTitle("Sign In Menu");
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void displayButtons(){
        b1 = new JButton();
        b1.setSize(140,40);
        b1.setText("Deposit");
        b1.setFont(new Font("Arial", Font.ITALIC, 10));
        b1.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b1.setLocation(170, 160);
        b1.setVisible(true);
        b1.addActionListener(this);
        frame.add(b1);

        //button 2
        b2 = new JButton();
        b2.setSize(140,40);
        b2.setText("WithDraw");
        b2.setFont(new Font("Arial", Font.ITALIC, 10));
        b2.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b2.setLocation(360, 220);
        b2.setVisible(true);
        b2.addActionListener(this);
        frame.add(b2);

        //button 3
        b3 = new JButton();
        b3.setSize(140,40);
        b3.setText("Transfer");
        b3.setFont(new Font("Arial", Font.ITALIC, 10));
        b3.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b3.setLocation(360, 160);
        b3.setVisible(true);
        b3.addActionListener(this);
        frame.add(b3);

        //button 4
        b4 = new JButton();
        b4.setSize(140,40);
        b4.setText("Balance");
        b4.setFont(new Font("Arial", Font.ITALIC, 10));
        b4.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b4.setLocation(170, 220);
        b4.setVisible(true);
        b4.addActionListener(this);
        frame.add(b4);
        //button 4
        b5 = new JButton();
        b5.setSize(160,40);
        b5.setText("log Out");
        b5.setFont(new Font("Arial", Font.BOLD, 10));
        b5.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b5.setLocation(0, 300);
        b5.setVisible(true);
        b5.addActionListener(this);
        frame.add(b5);
    }

    public void setLabels(){
        l1 = new JLabel("Welcome " + acc.getName());
        l1.setFont(new Font("Times new Roman", Font.BOLD, 25));
        l1.setBounds(270, 80, 300, 30);
        l1.setVisible(true);
        frame.add(l1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Deposit")){
            deposit d = new deposit(acc);
            frame.dispose();
        }
        else if(e.getActionCommand().equals("WithDraw")){
            WithDraw wd = new WithDraw(acc);
            frame.dispose();
        }
        else if(e.getActionCommand().equals("Transfer")) {
            Transfer t = new Transfer(acc);
            frame.dispose();
        }
        else if(e.getActionCommand().equals("Balance")) {
            BalanceIncquiry b = new BalanceIncquiry(acc);
            frame.dispose();
        }
        else if(e.getActionCommand().equals("log Out")) {
            UserMenu um = new UserMenu();
            frame.dispose();
        }
    }

}
