/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smurfs;

import java.awt.Image;
import javax.swing.ImageIcon;


public class LazySmurf extends Player{

    private int x,y;
    private Image lazySmurf;
    private int locx = 6 , locy = 5;
    private final int mapSize = 64;
    
    
    
    public LazySmurf() {
        ImageIcon img = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\Lazycomics.PNG.png");
        lazySmurf = img.getImage();
        
        x = locx*mapSize;
        y = locy*mapSize;
    }

    public int getX() {
        return x;
    }

    public int getLocx() {
        return locx;
    }

    public void setLocx(int locx) {
        this.locx = locx;
    }

    public int getLocy() {
        return locy;
    }

    public void setLocy(int locy) {
        this.locy = locy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getLazySmurf() {
        return lazySmurf;
    }

    public void setLazySmurf(Image lazySmurf) {
        this.lazySmurf = lazySmurf;
    }
    
    public void move(int dx , int dy){
        x += dx*mapSize;
        y += dy*mapSize;
        
        locx += dx;
        locy += dy;
    }
}
