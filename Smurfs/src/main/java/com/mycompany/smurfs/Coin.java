/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smurfs;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

public class Coin {

    private Image Coin;
    private int x, y;
    private int locx , locy;
    private final int mapSize = 64;
    private Map map;
    List<Integer> list;
    List<Integer> list2;

    public Coin() {
        list = new ArrayList<Integer>();  
        list2 = new ArrayList<Integer>();  
        ImageIcon img = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\coin_PNG36871.png");
        Coin = img.getImage();
     
        map = new Map();
        Loc();
        randomCreate();
    }

    private void Loc() {
        int count =0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 11; j++) {
                if(map.getMap(i, j).equals("1")){
                    
                    list.add(i);
                    list2.add(j);
                    
                }
                
            }
        }
    }

    private void randomCreate(){
        Random rand = new Random();
        int b = rand.nextInt(list.size());
        this.locx = list.get(b);
        this.locy = list2.get(b);


        this.x = this.locx * this.mapSize;
        this.y = this.locy * this.mapSize;
        
    }
    
    
    public Image getCoin() {
        return Coin;
    }

    public void setCoin(Image Coin) {
        this.Coin = Coin;
    }

    public int getX() {
        return x;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    
    
    
}
