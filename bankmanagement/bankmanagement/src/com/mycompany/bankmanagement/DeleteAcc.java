/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author abdul
 */

import com.sun.tools.javac.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class DeleteAcc extends JFrame implements ActionListener, Serializable {
    JLabel l1,l2 ,l3;
    JButton Del, back;
    JPasswordField pass;
    JFrame frame = new JFrame();
    JTextField text1;
    public DeleteAcc() {
        displayIcon.Icon(frame);
        addButtons();
        setTextFields();
        setLabels();
        frame.setSize(550, 460);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.setTitle("Delete Your account");
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void setTextFields(){
        text1 = new JTextField();
        text1.addActionListener(this);
        text1.setFont(new Font("Arial", Font.PLAIN, 15));
        text1.setBounds(230, 190, 180, 40);
        text1.setVisible(true);
        frame.add(text1);

        pass = new JPasswordField();
        pass.addActionListener(this);
        pass.setFont(new Font("Arial", Font.PLAIN, 15));
        pass.setBounds(230, 260, 180, 40);
        pass.setVisible(true);
        frame.add(pass);

    }

    public void addButtons(){
        Del = new JButton("Delete");
        Del.setBounds(230, 340, 120, 40);
        Del.setFont(new Font("Arial", Font.BOLD, 15));
        Del.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        Del.setVisible(true);
        frame.add(Del);
        Del.addActionListener(this);

        back = new JButton("Back to User Menu");
        back.setBounds(0, 340, 180, 40);
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        back.setVisible(true);
        frame.add(back);
        back.addActionListener(this);
    }
    //method to set labels
    public void setLabels(){
        l3 = new JLabel("Delete Your Account");
        l3.setFont(new Font("Times new Roman", Font.BOLD, 28));
        l3.setBounds(210, 70, 400, 40);
        l3.setBackground(Color.lightGray);
        l3.setVisible(true);
        frame.add(l3);
        l1 = new JLabel("Account No:");
        l1.setFont(new Font("Arial", Font.ITALIC, 20));
        l1.setBounds(90, 190, 150, 40);
        l1.setVisible(true);
        frame.add(l1);
        l2 = new JLabel("Password:");
        l2.setFont(new Font("Arial", Font.ITALIC, 20));
        l2.setBounds(90, 260, 150, 40);
        l2.setVisible(true);
        frame.add(l2);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Account account = BankRecord.accountSearch(text1.getText());
        if(e.getActionCommand().equals("Delete") && account != null && pass.getText().equals(account.getPassword())) {
            BankRecord.DeleteAccount(account.accountNo);
            String ac = account.getAccountNo();
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Account " +ac+ " is successfully deleted ");
            try {
                BankRecord.saveData();
            } catch (SQLException ex) {
                Logger.getLogger(DeleteAcc.class.getName()).log(Level.SEVERE, null, ex);
            }
            MainMenu m = new MainMenu();
            frame.dispose();
        }
        else if(e.getActionCommand().equals("Delete") && account == null) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Account doesn't exist"+ JOptionPane.ERROR_MESSAGE);
        }
        else if(e.getActionCommand().equals("Delete") && account != null && !pass.getText().equals(account.getPassword())){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Enter right password"+ JOptionPane.ERROR_MESSAGE);
        }
        if(e.getActionCommand().equalsIgnoreCase("Back to User Menu")){
            UserMenu u = new UserMenu();
            frame.dispose();
        }
    }

}