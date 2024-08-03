/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author abdul
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateAccount extends JFrame implements ActionListener, Serializable {
    Account acc;
    String gender = "";
    String ms = "";
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JButton signUp, Back;
    JRadioButton male, female, married, unmarried;
    ButtonGroup combo, combo1;
    JTextField t1, t2, t3, t4, t5;
    JFrame frame = new JFrame();
    CreateAccount() {
        displayIcon(frame);
        setButtons();
        setLables();
        setTextFields();
        frame.setSize(700, 720);
        frame.setTitle(" Details");
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    
    public void displayIcon(JFrame frame){
        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        frame.setIconImage(icon);

    }

    public void setLables(){
        //main label
        l1 = new JLabel("Creating Account");
        l1.setBounds(250, 70, 300, 50);
        l1.setFont(new Font("Times new Roman", Font.BOLD, 30));
        l1.setVisible(true);

        //name
        l2 = new JLabel("Name:");
        l2.setBounds(100, 230, 150, 30);
        l2.setFont(new Font("Arial", Font.ITALIC, 15));
        l2.setVisible(true);

        //CNIC
        l3 = new JLabel("CNIC:");
        l3.setBounds(100, 280, 150, 30);
        l3.setFont(new Font("Arial", Font.ITALIC, 15));
        l3.setVisible(true);

        //Email
        l4 = new JLabel("Email:");
        l4.setBounds(100, 330, 150, 30);
        l4.setFont(new Font("Arial", Font.ITALIC, 15));
        l4.setVisible(true);

        //Gender
        l5 = new JLabel("Gender:");
        l5.setBounds(100, 530, 150, 30);
        l5.setFont(new Font("Arial", Font.ITALIC, 15));
        l5.setVisible(true);

        //Phone
        l6 = new JLabel("Phone:");
        l6.setBounds(100, 430, 150, 30);
        l6.setFont(new Font("Arial", Font.ITALIC, 15));
        l6.setVisible(true);

        //marital Status
        l7 = new JLabel("Marital Status:");
        l7.setBounds(100, 480, 150, 30);
        l7.setFont(new Font("Arial", Font.ITALIC, 15));
        l7.setVisible(true);

        //initial balance
        l8 = new JLabel("Initial Balance:");
        l8.setBounds(100, 380, 150, 30);
        l8.setFont(new Font("Arial", Font.ITALIC, 15));
        l8.setVisible(true);

        //CNIC format
        l9 = new JLabel("format: (XXXXX-XXXXXXX-X)");
        l9.setBounds(230, 265, 200, 15);
        l9.setFont(new Font("Arial", Font.PLAIN, 13));
        l9.setForeground(Color.ORANGE);
        l9.setVisible(true);

        //phone format
        l10 = new JLabel("format: (03XX-XXXXXXX)");
        l10.setBounds(230, 415, 200, 15);
        l10.setFont(new Font("Arial", Font.PLAIN, 13));
        l10.setForeground(Color.ORANGE);
        l10.setVisible(true);

        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.add(l9);
        frame.add(l10);
    }

    public void setTextFields(){
        //name field
        t1 = new JTextField();
        t1.setBounds(230, 225, 218, 35);
        t1.setFont(new Font("Arial", Font.BOLD, 15));
        t1.setVisible(true);

        //CNIC field
        t2 = new JTextField();
        t2.setBounds(230, 280, 218, 35);
        t2.setFont(new Font("Arial", Font.BOLD, 15));
        t2.setVisible(true);

        //Email field
        t3 = new JTextField();
        t3.setBounds(230, 330, 218, 35);
        t3.setFont(new Font("Arial", Font.BOLD, 15));
        t3.setVisible(true);

        //Phone
        t4 = new JTextField();
        t4.setBounds(230, 430, 218, 35);
        t4.setFont(new Font("Arial", Font.BOLD, 15));
        t4.setVisible(true);

        //balance
        t5 = new JTextField();
        t5.setBounds(230, 380, 218, 35);
        t5.setFont(new Font("Arial", Font.BOLD, 15));
        t5.setVisible(true);

        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);

    }

    public void setButtons(){
        signUp = new JButton("Sign Up");
        signUp.setBounds(230, 580, 100, 35);
        signUp.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        signUp.setFont(new Font("Arial", Font.BOLD, 15));
        signUp.setVisible(true);
        signUp.addActionListener(this);

        Back = new JButton("Back to User Menu");
        Back.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        Back.setBounds(0, 580, 160, 35);
        Back.setFont(new Font("Arial", Font.PLAIN, 13));
        Back.setVisible(true);
        Back.addActionListener(this);


        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.BOLD, 15));
        male.setBounds(230, 530, 100, 30);
        male.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        male.setVisible(true);
        male.addActionListener(this);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.BOLD, 15));
        female.setBounds(340, 530, 110, 30);
        female.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        female.setVisible(true);
        female.addActionListener(this);

        married = new JRadioButton("Married");
        married.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        married.setBounds(230, 480, 100, 30);
        married.setFont(new Font("Arial", Font.BOLD, 15));
        married.setVisible(true);
        married.addActionListener(this);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        unmarried.setBounds(340, 480, 110, 30);
        unmarried.setFont(new Font("Arial", Font.BOLD, 15));
        unmarried.setVisible(true);
        unmarried.addActionListener(this);

      
        combo = new ButtonGroup();
        combo.add(male);
        combo.add(female);

        combo1 = new ButtonGroup();
        combo1.add(married);
        combo1.add(unmarried);
        

        frame.add(signUp);
        frame.add(Back);
        frame.add(male);
        frame.add(female);
        frame.add(married);
        frame.add(unmarried);
       
    }

    /**
     *
     * @param e
     * @throws SQLException
     */
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("actionPerformed called");
        if(e.getActionCommand().equals("Sign Up")) {
            if (male.isSelected()) {
                gender = "male";
            } else if (female.isSelected()) {
                gender = "female";
            }

            if (married.isSelected()) {
                ms = "married";
            } else if (unmarried.isSelected()) {
                ms = "unmarried";
            } 
            
            if (t1.getText().isBlank() || t2.getText().isBlank()|| t3.getText().isBlank() || t4.getText().isBlank()) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, Enter the Required Fields" + JOptionPane.WARNING_MESSAGE);

            }
            else if (!Account.ValidName(t1.getText()) && !Account.ValidEmail(t3.getText())) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, write valid email and name" + JOptionPane.WARNING_MESSAGE);

            }
            else if(!Account.ValidName(t1.getText())){
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, write valid Name" + JOptionPane.WARNING_MESSAGE);
            }
            else if (!Account.ValidEmail(t3.getText())) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, write valid email" + JOptionPane.WARNING_MESSAGE);

            }
            //mention format for for cnic and number
            else if (!Account.ValidCnic(t2.getText())) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Not a valid CNIC" + "\nformat(xxxxxxxxxxxx-x)" + JOptionPane.WARNING_MESSAGE);

            } else if (!Account.ValidNumber(t4.getText())) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Not a valid number " + "\nformat(03xx-xxxxxxx)" + JOptionPane.WARNING_MESSAGE);
            }else if (!Account.ValidCnic(t2.getText()) && !Account.ValidNumber(t4.getText())) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Not a valid CNIC and number" + JOptionPane.WARNING_MESSAGE);

            }  else if (!Account.ValidEmail(t3.getText()) || !Account.ValidCnic(t2.getText()) || !Account.ValidNumber(t4.getText())) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Details Missing " + JOptionPane.WARNING_MESSAGE);
            } else if (!male.isSelected() && !female.isSelected()) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, select gender" + JOptionPane.ERROR_MESSAGE);
            }
//else if (!married.isSelected() && !unmarried.isSelected() && !partnerDied.isSelected()) {
//                JFrame f = new JFrame();
//                JOptionPane.showMessageDialog(f, "Please, select marital status" + JOptionPane.ERROR_MESSAGE);
//            }
            else if ( !Account.ValidEmail(t3.getText()) && !Account.ValidCnic(t2.getText()) && !Account.ValidNumber(t4.getText())) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, Enter Valid values" + JOptionPane.ERROR_MESSAGE);
            }

            else{
                acc = new Account(t1.getText(), t3.getText(), t2.getText(), t4.getText(), Double.parseDouble(t5.getText()), gender, ms);
                BankRecord.bankRecord.add(acc);
                try {
                    BankRecord.saveData();
                } catch (SQLException ex) {
                    Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(acc.ToString());
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Account has been created"+"\n"+"Account no: " + acc.getAccountNo());
                frame.dispose();
                UserMenu u = new UserMenu();
            }

        }
        if(e.getActionCommand().equals("Back to User Menu")){
            frame.dispose();
            UserMenu m = new UserMenu();
        }
    }
    public static void main(String[]args){
        CreateAccount c=new CreateAccount();
    }

}

