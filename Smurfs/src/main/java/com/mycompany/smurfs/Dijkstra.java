/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smurfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Dijkstra {

    private Map map;
    public int result;
    public Stack<Cell> path;
    public Dijkstra(int x, int y, int ex, int ey, Stack <Cell> path) {

        this.path = path;
        map = new Map();
        result = shortestPath(map.getHarita(), new Cell(x,y), new Cell(ex,ey), path);
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Stack<Cell> getPath() {
        return path;
    }

    public void setPath(Stack<Cell> path) {
        this.path = path;
    }


    public int shortestPath(String[][] map, Cell start, Cell end,
            Stack<Cell> path) {
        
        int[][] distances = new int[map.length][];
        for (int i = 0; i < map.length; i++) {
            distances[i] = new int[map[i].length];
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        
        int distance = 0;
        List<Cell> currentCells = Arrays.asList(start);

        while (distances[end.row][end.col] == Integer.MAX_VALUE
                && !currentCells.isEmpty()) {
            List<Cell> nextCells = new ArrayList<>();


            for (Cell cell : currentCells) {
                if (distances[cell.row][cell.col] == Integer.MAX_VALUE
                        && !map[cell.row][cell.col].equals("0")) {
                    distances[cell.row][cell.col] = distance;
                    addNeighbors(cell, nextCells, map.length, map[0].length);
                }
            }

            
            currentCells = nextCells;
            distance++;
        }

        
        if (distances[end.row][end.col] < Integer.MAX_VALUE) {
            Cell cell = end;
            path.push(end);
            for (int d = distances[end.row][end.col] - 1; d >= 0; d--) {
                cell = getNeighbor(cell, d, distances);
                path.push(cell);
            }
        }

        return distances[end.row][end.col];
    }


    private static void addNeighbors(Cell cell, List<Cell> list,
            int maxRow, int maxCol) {
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : ds) {
            int row = cell.row + d[0];
            int col = cell.col + d[1];
            if (isValid(row, col, maxRow, maxCol)) {
                list.add(new Cell(row, col));
            }
        }
    }

     
    private static Cell getNeighbor(Cell cell, int distance, int[][] distances) {
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : ds) {
            int row = cell.row + d[0];
            int col = cell.col + d[1];
            if (isValid(row, col, distances.length, distances[0].length)
                    && distances[row][col] == distance) {
                return new Cell(row, col);
            }
        }
        return null;
    }


    public static boolean isValid(int row, int col, int maxRow, int maxCol) {
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }


}
