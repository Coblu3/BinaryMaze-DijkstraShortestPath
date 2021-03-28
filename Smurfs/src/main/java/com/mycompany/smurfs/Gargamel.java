/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smurfs;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Gargamel extends Enemy {

    private int x, y;
    private Image Gargamel;
    public int locx = Integer.MAX_VALUE, locy = Integer.MAX_VALUE;
    private final int mapSize = 64;
    private Map map;

    public Gargamel() {
        map = new Map();
        String pos = map.getGargamelPos();
        ImageIcon img = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\kisspng-gargamel-the-smurfs-azrael-smurfette-brainy-smurf-smurfs-5b0ba7504a1fe4.1878365315274903843036 (1).png");
        Gargamel = img.getImage();
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

    public int getX() {
        return x;
    }

    public void setStart() {
        String pos = map.getGargamelPos();
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

    public Image getGargamel() {
        return Gargamel;
    }

    public void setGargamel(Image Gargamel) {
        this.Gargamel = Gargamel;
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

    public void move(int dx, int dy) {

        locx = dx;
        locy = dy;
        x = locx * mapSize;
        y = locy * mapSize;
    }
}
