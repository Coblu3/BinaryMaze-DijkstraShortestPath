/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smurfs;

import java.awt.Image;
import javax.swing.ImageIcon;


public class CatAzman extends Enemy{
    private int x,y;
    private Image azman;
    private int locx = Integer.MAX_VALUE , locy = Integer.MAX_VALUE;
    private final int mapSize = 64;
    private Map map;
    
    
    public CatAzman() {
        map = new Map();
        String pos = map.getAzmanPos();
        if(pos.equals("A")){
            locx = 3;
            locy = 0;
        }
        if(pos.equals("B")){
            locx = 10;
            locy = 0;
        }
        if(pos.equals("C")){
            locx = 0;
            locy = 5;
        }
        if(pos.equals("D")){
            locx = 3;
            locy = 10;
        }
        ImageIcon img = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\kisspng-cat-gargamel-hefty-smurf-azrael-poussy-carton-5ac8670dbf5894.9317032515230830217838 (1).png");
        azman = img.getImage();
        
        x = locx*mapSize;
        y = locy*mapSize;
    }

    public int getX() {
        return x;
    }
    
        public void setStart() {
        String pos = map.getAzmanPos();
        if (pos.equals("A")) {
            locx = 3;
            locy = 0;
        }
        if (pos.equals("B")) {
            locx = 10;
            locy = 0;
        }
        if (pos.equals("C")) {
            locx = 0;
            locy = 5;
        }
        if (pos.equals("D")) {
            locx = 3;
            locy = 10;
        }
        x = locx * mapSize;
        y = locy * mapSize;

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

    public Image getAzman() {
        return azman;
    }

    public void setAzman(Image azman) {
        this.azman = azman;
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


    public void move(int dx , int dy){
        locx = dx;
        locy = dy;
        x = locx*mapSize;
        y = locy*mapSize;
    }
    
}