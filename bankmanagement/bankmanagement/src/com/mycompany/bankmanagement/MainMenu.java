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
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class MainMenu extends JFrame implements ActionListener {
    UserMenu user;
    JLabel l1, l2,I3;
    JFrame frame = new JFrame();
    JButton b1, b2;

    MainMenu() {
        setLabels();
        displayButtons();
        frame.setSize(600, 400);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        displayIcon(frame);
        frame.setTitle("ATM");
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void displayIcon(JFrame frame) {
        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        frame.setIconImage(icon);

    }

    //method to set labels
    public void setLabels() {
        l1 = new JLabel("Habib Bank Limited");
        l1.setFont(new Font("Times new Roman", Font.BOLD, 24));
        l1.setBounds(250, 50, 300, 40);
        l1.setVisible(true);
        frame.add(l1);
        l2 = new JLabel("Internet Banking");
        l2.setFont(new Font("Times new Roman", Font.ITALIC, 14));
        l2.setBounds(250, 70, 340, 50);
        l2.setVisible(true);
        frame.add(l2);
        
    }

    public void displayButtons() {
        b1 = new JButton();
        b1.setSize(180, 70);
        b1.setText("Account Holder");
        b1.setFont(new Font("Arial", Font.ITALIC, 14));
        b1.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b1.setLocation(200,160);
        b1.setVisible(true);
        b1.addActionListener(this);
        
        frame.add(b1);

        b2 = new JButton();
        b2.setSize(180, 70);
        b2.setText("Admin");
        b2.setFont(new Font("Arial", Font.ITALIC, 14));
        b2.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b2.setLocation(200, 240);
        b2.setVisible(true);
        b2.addActionListener(this);
        
        frame.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Account Holder")) {
            user = new UserMenu();
            frame.dispose();
        }
        else if (e.getActionCommand().equalsIgnoreCase("admin")) {
            AdminEnd admin = new AdminEnd();
            frame.dispose();
        }
    }

}

