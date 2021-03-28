package com.mycompany.smurfs;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu {
    public static void main(String[] args) {
        Menu menu = new Menu();
        
        
        
    }
    
    public Menu(){
        ImageIcon img = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\brainy_smurf.png");
        ImageIcon img2 = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\Lazycomics.PNG.png");
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton buton1 = new JButton();
        JButton buton2 = new JButton();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel labelBas = new JLabel();

        
        
        label1.setText("Gözlüklü Şirin");
        label2.setText("Tembel Şirin");
        labelBas.setForeground(Color.red);
        labelBas.setText("Kahramanını Seç:");
        

        
        panel.setLayout(null);
        buton1.setIcon(img);
        buton1.setBounds(450, 300 , 100, 100);
        label1.setBounds(450, 360 , 100, 100);
        buton2.setIcon(img2);
        buton2.setBounds(300, 300 , 100, 100);
        label2.setBounds(300, 360 , 100, 100);
        
        labelBas.setBounds(300,180,200,200);
        
        panel.setBackground(Color.BLUE);
        
        
        panel.add(buton1);
        panel.add(label1);
        panel.add(label2);
        panel.add(labelBas);
        panel.add(buton2);
        frame.add(panel);
        
        frame.setTitle("Smurfs");
        frame.setSize(896,768);
        frame.setLocation(500,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                main m = new main("gozluklu");
                
            }
        });
        
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                main m = new main("tembel");
            }
        });
        
    }
}
