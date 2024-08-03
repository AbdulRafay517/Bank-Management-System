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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminEnd extends JFrame implements ActionListener{
    JLabel l1, l3;
    JButton signIn, back;
    JPasswordField pass;
    JFrame frame = new JFrame();
    AdminEnd(){
        displayIcon.Icon(frame);
        addButtons();
        setTextFields();
        addLabels();
        frame.setSize(600, 400);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.setTitle("Admin End");
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void addLabels(){
        l1 = new JLabel("Admin");
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        l1.setBounds(250, 70, 200, 40);
        l1.setBackground(Color.lightGray);
        l1.setVisible(true);
        frame.add(l1);
        l3 = new JLabel("Enter Password");
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setBounds(20, 160, 200, 40);
        l3.setVisible(true);
        frame.add(l3);
    }

    public void setTextFields(){
        pass = new JPasswordField();
        pass.addActionListener(this);
        pass.setFont(new Font("Arial", Font.PLAIN, 15));
        pass.setBounds(230, 160, 180, 40);
        pass.setVisible(true);
        frame.add(pass);

    }
    /*public void setTextFieldsMouseClicked(java.awt.event.MouseEvent evt)
    {
        if(pass.getText().equalsIgnoreCase("Invalid"));
        pass.setText("In");
    }*/
    public void addButtons(){
        signIn = new JButton("Log In");
        signIn.setBounds(230, 240, 100, 40);
        signIn.setFont(new Font("Arial", Font.BOLD, 15));
        signIn.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        signIn.setVisible(true);
        frame.add(signIn);
        signIn.addActionListener(this);

        back = new JButton("Back to Main Menu");
        back.setBounds(0, 300, 200, 40);
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        back.setVisible(true);
        back.addActionListener(this);
        frame.add(back);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Log In")){
            String password = pass.getText();
            if(pass.getText().isBlank()){
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, Enter Password"+ JOptionPane.ERROR_MESSAGE);
            }
            else {
                String passInField = pass.getText();

                if(passInField.equalsIgnoreCase("cui12")) {
                    AllData read = new AllData();
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Data Displayed");
                    
                    
                    MainMenu m = new MainMenu();
                    frame.dispose();
                }
                else
                {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Incorrect Password"+ JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(e.getActionCommand().equalsIgnoreCase("back to main menu")){
            MainMenu m = new MainMenu();
            frame.dispose();
        }
    }

}

