/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smurfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Map {

    private Scanner sc;
    public String Map[] = new String[11];
    public String gargamelPos, azmanPos;
    public String harita[][] = new String[11][13];

    public Map() {

        openFile();
        readFile();
        closeFile();
        get_harita();

    }

    public String getMap(int x, int y) {
        String index = Map[y].substring(x, x + 1);
        return index;

    }

    public void openFile() {
        try {
            sc = new Scanner(new File("src\\main\\java\\com\\mycompany\\smurfs\\harita.txt"));
        } catch (Exception e) {
            System.out.println("Dosya Bulunamadı!");
        }

    }

    public void get_harita() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                harita[i][j] = getMap(j, i);

            }
        }
    }

    public String[][] getHarita() {
        return harita;
        
    }
    

    public void setHarita(String[][] harita) {
        this.harita = harita;
    }

    public void readFile() {
        String a = "";
        String [] one = sc.nextLine().split(":");
        String pos = one[2];
        one = one[1].split(",");
        if(one[0].equals("Gargamel")){
            gargamelPos= pos;
        }else{
            azmanPos = pos;
        }
        one = sc.nextLine().split(":");
        pos = one[2];
        one = one[1].split(",");
        if(one[0].equals("Gargamel")){
            gargamelPos= pos;
        }else{
            azmanPos = pos;
        }

        while (sc.hasNext()) {
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 13; j++) {
                    a = a + sc.next();

                }
                Map[i] = a;
                a = "";

            }
        }
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public String[] getMmap() {
        return Map;
    }

    public void setMmap(String[] Map) {
        this.Map = Map;
    }

    public String getGargamelPos() {
        return gargamelPos;
    }

    public void setGargamelPos(String gargamelPos) {
        this.gargamelPos = gargamelPos;
    }

    public String getAzmanPos() {
        return azmanPos;
    }

    public void setAzmanPos(String azmanPos) {
        this.azmanPos = azmanPos;
    }

    public void closeFile() {
        sc.close();
    }

}
