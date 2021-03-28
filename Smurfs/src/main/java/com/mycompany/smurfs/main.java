/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smurfs;

import javax.swing.*;




public class main {
    public String name;
    
    
    public main(String name){
        this.name = name;
        JFrame frame = new JFrame();
        frame.add(new Board(name));
        frame.setTitle("Smurfs");
        frame.setSize(940,768);
        frame.setLocation(500,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
