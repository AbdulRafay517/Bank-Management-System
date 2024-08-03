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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Rectangle_set extends JPanel{
    BufferedImage imag;

    Rectangle_set(String name) {
        name = "D:\\Study\\Work\\Aneeza Bank Management (SE) Project\\BankManagement\\bankmanagement\\bankmanagement\\src\\com\\mycompany\\bankmanagement\\orange.png";
        try {
            imag = ImageIO.read(new File(name));
            this.setPreferredSize(new Dimension(
                    imag.getWidth(), imag.getHeight()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g);
        g.drawImage(imag, 190, 40, 520, 90, this);
        g.drawImage(imag, 0, 40, 520, 45, this);
        
    }
}
