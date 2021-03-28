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


public class Mushroom {
     private Image Mushroom;
    private int x, y;
    private int locx , locy;
    private final int mapSize = 64;
    private Map map;
    List<Integer> list;
    List<Integer> list2;

    public Mushroom() {
        list = new ArrayList<Integer>();  
        list2 = new ArrayList<Integer>();  
        ImageIcon img = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\kisspng-mushroom-photography-clip-art-mushroom-5ac9d9ee9a10b2.4622367015231779666311 (1).png");
        Mushroom = img.getImage();
     
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

    public Image getMushroom() {
        return Mushroom;
    }

    public void setMushroom(Image Mushroom) {
        this.Mushroom = Mushroom;
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

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList2() {
        return list2;
    }

    public void setList2(List<Integer> list2) {
        this.list2 = list2;
    }
    
    private void randomCreate(){
        Random rand = new Random();
        int b = rand.nextInt(list.size());
        this.locx = list.get(b);
        this.locy = list2.get(b);


        this.x = this.locx * this.mapSize;
        this.y = this.locy * this.mapSize;
        
    }
}
