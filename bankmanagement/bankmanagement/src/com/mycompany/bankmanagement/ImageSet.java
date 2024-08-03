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

//class created to set HBL image
public class ImageSet extends JPanel {

    BufferedImage img;

    ImageSet(String name, JFrame f) {
        name = "D:\\Study\\Work\\Aneeza Bank Management (SE) Project\\BankManagement\\bankmanagement\\bankmanagement\\src\\com\\mycompany\\bankmanagement\\logo.png";
        this.setBounds(0, 0, 200, 140);
        f.getContentPane().add(this);
        try {
            img = ImageIO.read(new File(name));
            this.setPreferredSize(new Dimension(
                    img.getWidth(), img.getHeight()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, 200, 140, this);
    }
}

