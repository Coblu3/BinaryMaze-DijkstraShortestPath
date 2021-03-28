/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smurfs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Stack;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    public Timer timer;
    public java.util.Timer timer1;
    public java.util.Timer timer2;
    public Stack<Cell> path;
    public Stack<Cell> pathAzman;
    private Map map;
    private LazySmurf lazySmurf;
    private BrainySmurf brainySmurf;
    private Gargamel gargamel;
    private CatAzman azman;
    private Coin coin;
    private Coin coin1;
    private Coin coin2;
    private Coin coin3;
    private Coin coin4;
    private Mushroom mushroom;
    private Image brick;
    private Image grass;
    private Score score;

    private Dijkstra dijkstra;

    private Image sirine;
    public String name;

    public Board(String name) {
        this.name = name;
        ImageIcon img = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\smurf_PNG60.png");
        ImageIcon img2 = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\bricksx64.png");
        ImageIcon img3 = new ImageIcon("src\\main\\java\\com\\mycompany\\smurfs\\images\\grass03.png");
        grass = img3.getImage();
        brick = img2.getImage();

        sirine = img.getImage();

        if (name == "gozluklu") {
            brainySmurf = new BrainySmurf();
            addKeyListener(new mv2());
        } else {

            lazySmurf = new LazySmurf();
            addKeyListener(new mv());
        }

        score = new Score();

        gargamel = new Gargamel();

        azman = new CatAzman();
        map = new Map();
        path = new Stack<Cell>();
        pathAzman = new Stack<Cell>();
        setFocusable(true);
        timer = new Timer(25, this);
        timer1 = new java.util.Timer("timer1");
        timer2 = new java.util.Timer("timer2");
        timer.start();
        timer1.schedule(new taskClass(), 0, 5000);
        timer2.schedule(new taskClass2(), 0, 7000);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

    public void paint(Graphics g) {
        super.paint(g);

        Font font = g.getFont().deriveFont(20.0f);
        g.setFont(font);

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 11; j++) {
                if (map.getMap(i, j).equals("0")) {

                    g.drawImage(brick, i * 64, j * 64, this);

                }
                if (map.getMap(i, j).equals("1")) {

                    g.drawImage(grass, i * 64, j * 64, this);

                }

            }
        }

        if (name == "gozluklu") {
            if (!map.gargamelPos.equals("null")) {
                dijkstra = new Dijkstra(gargamel.getLocy(), gargamel.getLocx(), brainySmurf.getLocy(), brainySmurf.getLocx(), path);
            }
            if (!map.azmanPos.equals("null")) {
                dijkstra = new Dijkstra(azman.getLocy(), azman.getLocx(), brainySmurf.getLocy(), brainySmurf.getLocx(), pathAzman);
            }

        } else {
            if (!map.gargamelPos.equals("null")) {
                dijkstra = new Dijkstra(gargamel.getLocy(), gargamel.getLocx(), lazySmurf.getLocy(), lazySmurf.getLocx(), path);
            }

            if (!map.azmanPos.equals("null")) {
                dijkstra = new Dijkstra(azman.getLocy(), azman.getLocx(), lazySmurf.getLocy(), lazySmurf.getLocx(), pathAzman);
            }

        }

        if (!path.isEmpty()) {
            for (Cell cell : path) {
                g.setColor(Color.GREEN);

                g.fillRect(cell.col * 64, cell.row * 64, 64, 64);

            }
        }

        if (!pathAzman.isEmpty()) {
            for (Cell cell : pathAzman) {
                g.setColor(Color.CYAN);

                g.fillRect(cell.col * 64, cell.row * 64, 64, 64);

            }
        }

        g.setColor(java.awt.Color.BLUE);
        g.drawString("A", 224, 30);
        g.drawString("B", 672, 30);
        g.drawString("C", 30, 352);
        g.drawString("D", 224, 672);

        g.drawImage(sirine, 832, 448, this);

        g.drawImage(coin.getCoin(), coin.getX(), coin.getY(), null);
        g.drawImage(coin1.getCoin(), coin1.getX(), coin1.getY(), null);
        g.drawImage(coin2.getCoin(), coin2.getX(), coin2.getY(), null);
        g.drawImage(coin3.getCoin(), coin3.getX(), coin3.getY(), null);
        g.drawImage(coin4.getCoin(), coin4.getX(), coin4.getY(), null);

        g.drawImage(mushroom.getMushroom(), mushroom.getX(), mushroom.getY(), this);

        g.drawImage(gargamel.getGargamel(), gargamel.getX(), gargamel.getY(), this);
        g.drawImage(azman.getAzman(), azman.getX(), azman.getY(), null);

        if (name == "gozluklu") {

            g.drawImage(brainySmurf.getBrainySmurf(), brainySmurf.getX(), brainySmurf.getY(), null);

        } else {
            g.drawImage(lazySmurf.getLazySmurf(), lazySmurf.getX(), lazySmurf.getY(), null);

        }
        g.setFont(font.deriveFont(40));
        g.setColor(java.awt.Color.BLACK);
        g.drawString("Skor: " + Integer.toString(score.getPoint()), 840, 50);

    }

    public class taskClass extends TimerTask {

        public void run() {
            coin = new Coin();
            coin1 = new Coin();
            coin2 = new Coin();
            coin3 = new Coin();
            coin4 = new Coin();

        }

    }

    public class taskClass2 extends TimerTask {

        public void run() {
            mushroom = new Mushroom();
        }
    }

    public class mv extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_UP) {
                if (map.getMap(lazySmurf.getLocx(), lazySmurf.getLocy() - 1).equals("1")) {
                    lazySmurf.move(0, -1);
                    gargamelMove();
                    gargamelMove();
                    azmanMove();
                }

            }
            if (keycode == KeyEvent.VK_DOWN) {
                if (map.getMap(lazySmurf.getLocx(), lazySmurf.getLocy() + 1).equals("1")) {
                    lazySmurf.move(0, 1);
                    gargamelMove();
                    gargamelMove();
                    azmanMove();
                }

            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (map.getMap(lazySmurf.getLocx() - 1, lazySmurf.getLocy()).equals("1")) {
                    lazySmurf.move(-1, 0);
                    gargamelMove();
                    gargamelMove();
                    azmanMove();
                }

            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (map.getMap(lazySmurf.getLocx() + 1, lazySmurf.getLocy()).equals("1")) {
                    lazySmurf.move(1, 0);
                    gargamelMove();
                    gargamelMove();
                    azmanMove();
                }

            }

        }

        public void keyReleased(KeyEvent e) {
            if (lazySmurf.getLocx() == 12 && lazySmurf.getLocy() == 7) {
                showMessageDialog(null, "Şirineye Ulaşıldı");
                setVisible(false);
            }

            if (lazySmurf.getLocx() == gargamel.getLocx() && lazySmurf.getLocy() == gargamel.getLocy()) {
                showMessageDialog(null, "Gargamel Seni Yakaladı!");
                gargamel.setStart();
                score.touchedGargamel();

            }
            if (lazySmurf.getLocx() == azman.getLocx() && lazySmurf.getLocy() == azman.getLocy()) {
                showMessageDialog(null, "Azman Seni Yakaladı!");
                azman.setStart();
                score.touchedAzman();

            }

            if (lazySmurf.getLocx() == coin.getLocx() && lazySmurf.getLocy() == coin.getLocy()) {
                score.getCoin();
                coin.setX(Integer.MAX_VALUE);
                coin.setY(Integer.MAX_VALUE);

            }

            if (lazySmurf.getLocx() == coin1.getLocx() && lazySmurf.getLocy() == coin1.getLocy()) {
                score.getCoin();
                coin1.setX(Integer.MAX_VALUE);
                coin1.setY(Integer.MAX_VALUE);

            }
            if (lazySmurf.getLocx() == coin2.getLocx() && lazySmurf.getLocy() == coin2.getLocy()) {
                score.getCoin();
                coin2.setX(Integer.MAX_VALUE);
                coin2.setY(Integer.MAX_VALUE);

            }
            if (lazySmurf.getLocx() == coin3.getLocx() && lazySmurf.getLocy() == coin3.getLocy()) {
                score.getCoin();
                coin3.setX(Integer.MAX_VALUE);
                coin3.setY(Integer.MAX_VALUE);

            }
            if (lazySmurf.getLocx() == coin4.getLocx() && lazySmurf.getLocy() == coin4.getLocy()) {
                score.getCoin();
                coin4.setX(Integer.MAX_VALUE);
                coin4.setY(Integer.MAX_VALUE);

            }
            if (lazySmurf.getLocx() == mushroom.getLocx() && lazySmurf.getLocy() == mushroom.getLocy()) {
                score.getMushroom();
                mushroom.setX(Integer.MAX_VALUE);
                mushroom.setY(Integer.MAX_VALUE);
                

            }
            if(score.getPoint()<=0){
                showMessageDialog(null, "Puanın tükendi!");
           
                setVisible(false);
                
                
            }

        }

    }

    private void gargamelMove() {

        if (!map.gargamelPos.equals("null")) {
            path.clear();

            if (name == "gozluklu") {

                dijkstra = new Dijkstra(gargamel.getLocy(), gargamel.getLocx(), brainySmurf.getLocy(), brainySmurf.getLocx(), path);

            } else {

                dijkstra = new Dijkstra(gargamel.getLocy(), gargamel.getLocx(), lazySmurf.getLocy(), lazySmurf.getLocx(), path);

            }

            path.pop();

            Cell cell = path.pop();

            gargamel.move(cell.col, cell.row);

        }
    }

    private void azmanMove() {
        if (!map.azmanPos.equals("null")) {
            pathAzman.clear();

            if (name == "gozluklu") {
                dijkstra = new Dijkstra(azman.getLocy(), azman.getLocx(), brainySmurf.getLocy(), brainySmurf.getLocx(), pathAzman);
            } else {

                dijkstra = new Dijkstra(azman.getLocy(), azman.getLocx(), lazySmurf.getLocy(), lazySmurf.getLocx(), pathAzman);
            }

            pathAzman.pop();
            Cell cell = pathAzman.pop();
            azman.move(cell.col, cell.row);

        }
    }

    public class mv2 extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_UP) {
                if (map.getMap(brainySmurf.getLocx(), brainySmurf.getLocy() - 2).equals("1") && map.getMap(brainySmurf.getLocx(), brainySmurf.getLocy() - 1).equals("1")) {
                    brainySmurf.move(0, -2);
                    gargamelMove();
                    gargamelMove();
                    azmanMove();

                }

            }
            if (keycode == KeyEvent.VK_DOWN) {
                if (map.getMap(brainySmurf.getLocx(), brainySmurf.getLocy() + 2).equals("1") && map.getMap(brainySmurf.getLocx(), brainySmurf.getLocy() + 1).equals("1")) {
                    brainySmurf.move(0, 2);
                    gargamelMove();
                    gargamelMove();
                    azmanMove();
                }

            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (map.getMap(brainySmurf.getLocx() - 2, brainySmurf.getLocy()).equals("1") && map.getMap(brainySmurf.getLocx() - 1, brainySmurf.getLocy()).equals("1")) {
                    brainySmurf.move(-2, 0);
                    gargamelMove();
                    gargamelMove();
                    azmanMove();
                }

            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (map.getMap(brainySmurf.getLocx() + 2, brainySmurf.getLocy()).equals("1") && map.getMap(brainySmurf.getLocx() + 1, brainySmurf.getLocy()).equals("1")) {
                    brainySmurf.move(2, 0);
                    gargamelMove();
                    gargamelMove();
                    azmanMove();
                }

            }

        }

        public void keyReleased(KeyEvent e) {
            if (brainySmurf.getLocx() == 12 && brainySmurf.getLocy() == 7) {
                showMessageDialog(null, "Şirineye Ulaşıldı");
                setVisible(false);
            }

            if (brainySmurf.getLocx() == gargamel.getLocx() && brainySmurf.getLocy() == gargamel.getLocy()) {
                showMessageDialog(null, "Gargamel Seni Yakaladı!");
                gargamel.setStart();
                score.touchedGargamel();

            }
            if (brainySmurf.getLocx() == azman.getLocx() && brainySmurf.getLocy() == azman.getLocy()) {
                showMessageDialog(null, "Azman Seni Yakaladı!");
                azman.setStart();
                score.touchedAzman();

            }

            if (brainySmurf.getLocx() == coin.getLocx() && brainySmurf.getLocy() == coin.getLocy()) {
                score.getCoin();
                coin.setX(Integer.MAX_VALUE);
                coin.setY(Integer.MAX_VALUE);

            }

            if (brainySmurf.getLocx() == coin1.getLocx() && brainySmurf.getLocy() == coin1.getLocy()) {
                score.getCoin();
                coin1.setX(Integer.MAX_VALUE);
                coin1.setY(Integer.MAX_VALUE);

            }
            if (brainySmurf.getLocx() == coin2.getLocx() && brainySmurf.getLocy() == coin2.getLocy()) {
                score.getCoin();
                coin2.setX(Integer.MAX_VALUE);
                coin2.setY(Integer.MAX_VALUE);

            }
            if (brainySmurf.getLocx() == coin3.getLocx() && brainySmurf.getLocy() == coin3.getLocy()) {
                score.getCoin();
                coin3.setX(Integer.MAX_VALUE);
                coin3.setY(Integer.MAX_VALUE);

            }
            if (brainySmurf.getLocx() == coin4.getLocx() && brainySmurf.getLocy() == coin4.getLocy()) {
                score.getCoin();
                coin4.setX(Integer.MAX_VALUE);
                coin4.setY(Integer.MAX_VALUE);

            }
            if (brainySmurf.getLocx() == mushroom.getLocx() && brainySmurf.getLocy() == mushroom.getLocy()) {
                score.getMushroom();
                mushroom.setX(Integer.MAX_VALUE);
                mushroom.setY(Integer.MAX_VALUE);

            }
            
            if(score.getPoint()<=0){
                showMessageDialog(null, "Puanın tükendi!");
                setVisible(false);
            }
        }

    }

}
