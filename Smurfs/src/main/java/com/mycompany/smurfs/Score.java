/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smurfs;


public class Score {

    public int point = 20;

    public Score() {
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void getMushroom() {
        point += 50;
    }

    public void getCoin() {
        point += 5;
    }

    public void touchedGargamel() {
        point -= 15;

    }

    public void touchedAzman() {
        point -= 5;
    }
}
