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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class CardActivation extends JFrame implements ActionListener {
    Account account;
    JLabel l1, l2, l3, l4;
    JButton Activate, Back;
    JTextField text1;
    JPasswordField pass;
    JFrame frame = new JFrame();

    CardActivation() {
        addButtons();
        setTextFields();
        addLabels();
        displayIcon.Icon(frame);
        frame.setSize(600, 450);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.setTitle("Activation");
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void addLabels() {
        l1 = new JLabel("Activation");
        l1.setFont(new Font("Times new Roman", Font.BOLD, 30));
        l1.setBounds(230, 80, 400, 40);
        l1.setBackground(Color.lightGray);
        l1.setVisible(true);
        frame.add(l1);
        l2 = new JLabel("Account No");
        l2.setFont(new Font("Arial", Font.ITALIC, 18));
        l2.setBounds(90, 170, 150, 40);
        l2.setVisible(true);
        l3 = new JLabel("Password");
        l3.setFont(new Font("Arial", Font.ITALIC, 18));
        l3.setBounds(90, 240, 150, 40);
        l3.setVisible(true);
        l4 = new JLabel();
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
    }

    public void setTextFields() {
        text1 = new JTextField();
        text1.addActionListener(this);
        text1.setFont(new Font("Arial", Font.PLAIN, 15));
        text1.setBounds(230, 170, 180, 40);
        text1.setVisible(true);
        frame.add(text1);

        pass = new JPasswordField();
        pass.addActionListener(this);
        pass.setFont(new Font("Arial", Font.PLAIN, 15));
        pass.setBounds(230, 240, 180, 40);
        pass.setVisible(true);
        frame.add(pass);

    }

    public void addButtons() {
        Activate = new JButton("Activate Card");
        Activate.setBounds(230, 310, 150, 40);
        Activate.setFont(new Font("Arial", Font.BOLD, 15));
        Activate.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        Activate.setVisible(true);
        frame.add(Activate);
        Activate.addActionListener(this);

        Back = new JButton("Back to User Menu");
        Back.setBounds(0, 310, 150, 40);
        Back.setFont(new Font("Arial", Font.PLAIN, 13));
        Back.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        Back.setVisible(true);
        frame.add(Back);
        Back.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("activate card")) {
            Account acc = BankRecord.accountSearch(text1.getText());
            if (text1.getText().isBlank() && pass.getText().equals("")) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, Enter Required information " + JOptionPane.ERROR_MESSAGE);
            }
            else if (text1.getText().isBlank()) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, Enter Account No" + JOptionPane.ERROR_MESSAGE);
            }
            else if (acc == null && text1 !=null) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Account not found" + JOptionPane.ERROR_MESSAGE);
            } else if (acc != null && pass.getText().equals("")) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "please enter password" + JOptionPane.ERROR_MESSAGE);
            } else{
                if (acc != null && acc.getisActive()) {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Account is already Active" + JOptionPane.ERROR_MESSAGE);
                    UserMenu Um = new UserMenu();
                    frame.dispose();
                }
                else {
                    acc.setPassword(pass.getText());
                    acc.setActive(true);
                    try {
                        BankRecord.saveData();
                    } catch (SQLException ex) {
                        Logger.getLogger(CardActivation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Card is Activated successfully" + JOptionPane.PLAIN_MESSAGE);
                    UserMenu menu = new UserMenu();
                    frame.dispose();
                }
            }
        }


        if(e.getActionCommand().equals("Back to User Menu")){
            UserMenu u = new UserMenu();
            frame.dispose();
        }

    }
}
