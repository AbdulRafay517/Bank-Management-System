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
import java.io.Serializable;
import javax.swing.*;

public class UserMenu extends JFrame implements ActionListener, Serializable {
    JLabel l1, l2;
    JButton b1, b2, b3, b5, b6;
    static JFrame frame = new JFrame();
    UserMenu(){
        display();
    }
    public void display(){
        setLayout(null);
        displayButtons();
        setLabels();
        displayIcon.Icon(frame);
        frame.setSize(600,400);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.setTitle("ATM menu");
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Log In")){
            Sign_In  s = new Sign_In();
            frame.dispose();
        }
        else if(e.getActionCommand().equals("Sign Up")){
            CreateAccount acc = new CreateAccount();
            frame.dispose();
        }
        else if(e.getActionCommand().equals("Card Activation")){
            CardActivation c = new CardActivation();
            frame.dispose();
        }
        else if(e.getActionCommand().equals("Delete Account")){
            DeleteAcc d = new DeleteAcc();
            frame.dispose();
        }
        else if(e.getActionCommand().equalsIgnoreCase("back to main menu")){
            MainMenu m = new MainMenu();
            frame.dispose();
        }
    }
    public void displayButtons(){
        b1 = new JButton();
        b1.setSize(140,40);
        b1.setText("Log In");
        b1.setFont(new Font("Arial", Font.ITALIC, 12));
        b1.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b1.setLocation(195, 160);
        b1.setVisible(true);
        b1.addActionListener(this);
        frame.add(b1);

        //button 2
        b2 = new JButton();
        b2.setSize(140,40);
        b2.setText("Card Activation");
        b2.setFont(new Font("Arial", Font.ITALIC, 12));
        b2.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b2.setLocation(195, 220);
        b2.setVisible(true);
        b2.addActionListener(this);
        frame.add(b2);

        //button 3
        b3 = new JButton();
        b3.setSize(140,40);
        b3.setText("Sign Up");
        b3.setFont(new Font("Arial", Font.ITALIC, 12));
        b3.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b3.setLocation(360, 160);
        b3.setVisible(true);
        b3.addActionListener(this);
        frame.add(b3);

        //button 5
        b5 = new JButton();
        b5.setBounds(360, 220,140,40);
        b5.setText("Delete Account");
        b5.setFont(new Font("Arial", Font.ITALIC , 12));
        b5.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b5.setVisible(true);
        b5.addActionListener(this);
        frame.add(b5);

        b6 = new JButton("Back to Main Menu");
        b6.setBounds(0, 300, 170, 40);
        b6.setFont(new Font("Arial", Font.PLAIN, 13));
        b6.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        b6.setVisible(true);
        b6.addActionListener(this);
        frame.add(b6);


    }

    //method to set labels
    public void setLabels(){
        l1 = new JLabel("Welcome to Habib Bank Limited");
        l1.setFont(new Font("Times new Roman", Font.BOLD, 20));
        l1.setBounds(250, 50, 300, 30);
        l1.setVisible(true);
        frame.add(l1);
        l2 = new JLabel("How can we Help you?");
        l2.setFont(new Font("Arial", Font.ITALIC, 14));
        l2.setBounds(250, 70, 340, 50);
        l2.setVisible(true);
        frame.add(l2);
    }

}


