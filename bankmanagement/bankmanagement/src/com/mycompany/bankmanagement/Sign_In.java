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

public class Sign_In extends JFrame implements ActionListener, Serializable {
    Account account;
    JLabel l1, l2, l3, l4;
    JButton signIn, Back;
    JTextField text1;
    JPasswordField pass;
    JFrame frame = new JFrame();
    Sign_In(){
        addButtons();
        setTextFields();
        addLabels();
        displayIcon.Icon(frame);
        frame.setSize(600, 470);
        frame.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.5f));
        frame.setTitle("Sign In to your Account");
        frame.add(new ImageSet("logo.png", frame));
        frame.add(new Rectangle_set("orange.png"));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void addLabels(){
        l1 = new JLabel("Sign In to Your Account");
        l1.setFont(new Font("Times new Roman", Font.ITALIC, 26));
        l1.setBounds(210, 70, 400, 40);
        l1.setBackground(Color.GREEN);
        l1.setVisible(true);
        frame.add(l1);
        l2 = new JLabel("Account No");
        l2.setFont(new Font("Arial", Font.ITALIC, 20));
        l2.setBounds(80, 205, 150, 40);
        l2.setVisible(true);
        l3 = new JLabel("Password");
        l3.setFont(new Font("Arial", Font.ITALIC, 20));
        l3.setBounds(80, 270, 150, 40);
        l3.setVisible(true);
        l4 = new JLabel();
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
    }

    public void setTextFields(){
        text1 = new JTextField();
        text1.addActionListener(this);
        text1.setFont(new Font("Arial", Font.PLAIN, 15));
        text1.setBounds(230, 205, 180, 40);
        text1.setVisible(true);
        frame.add(text1);

        pass = new JPasswordField();
        pass.addActionListener(this);
        pass.setFont(new Font("Arial", Font.PLAIN, 15));
        pass.setBounds(230, 275, 180, 40);
        pass.setVisible(true);
        frame.add(pass);

    }

    public void addButtons(){
        signIn = new JButton("Sign In");
        signIn.setBounds(230, 345, 120, 35);
        signIn.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        signIn.setFont(new Font("Arial", Font.BOLD, 15));
        signIn.setVisible(true);
        signIn.addActionListener(this);
        frame.add(signIn);

        Back = new JButton("Back to User Menu");
        Back.setBounds(0, 345, 160, 35);
        Back.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
        Back.setFont(new Font("Arial", Font.PLAIN, 13));
        Back.setVisible(true);
        frame.add(Back);
        Back.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Sign In")){

            String accNo = text1.getText();
            if(text1.getText().isBlank() && pass.getText().equals("")){
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, Enter Required information"+ JOptionPane.ERROR_MESSAGE);
            }
            else if(text1.getText().isBlank()){
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, Enter Account No"+ JOptionPane.ERROR_MESSAGE);
            }
            else if(!text1.getText().isBlank() && BankRecord.searchAcc(text1.getText()) && pass.getText().equals("")){
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Please, Enter Password"+ JOptionPane.ERROR_MESSAGE);
            }
            else {
                if (!BankRecord.searchAcc(text1.getText())) {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Do you have a Account?" + JOptionPane.ERROR_MESSAGE);
                }
                else {
                    Account acc = BankRecord.accountSearch(text1.getText());
                    String ps = acc.getPassword();
                    if (!acc.getisActive()) {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Account not Active" + JOptionPane.ERROR_MESSAGE);
                        UserMenu u = new UserMenu();
                        frame.dispose();
                    } else if (acc.getAccountNo().equals(accNo) && ps.equals(pass.getText()) && !acc.getisActive()) {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Account not Active" + JOptionPane.ERROR_MESSAGE);
                    }
                    else if (acc.getAccountNo().equals(accNo) && ps.equals(pass.getText()) && acc.getisActive()) {
                        this.account = acc;
                        Sign_In_Menu signedIn = new Sign_In_Menu(acc);
                        frame.dispose();
                    } else if (acc.getAccountNo().equals(accNo) && !ps.equals(pass.getText())) {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Wrong Password" + JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }


        else if(e.getActionCommand().equals("Back to User Menu")){
            UserMenu m = new UserMenu();
            frame.dispose();
        }


    }

    //getter for account
    public Account getAccount(){
        return account;
    }


}