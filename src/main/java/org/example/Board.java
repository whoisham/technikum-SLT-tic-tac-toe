package org.example;
import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Character>> grid;

    public Board() {
        grid = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(' ');
            }
            grid.add(row);
        }
    }

    public boolean makeMove(int row, int column, char symbol) {
        if (row < 0 || row > 2 || column < 0 || column > 2) {
            return false;
        }
        if (grid.get(row).get(column) == ' ') {
            grid.get(row).set(column, symbol);
            return true;
        }
        return false;
    }

    public char getCell(int row, int column) {
        return grid.get(row).get(column);
    }

    public void printBoard() {
        System.out.println("▁▁▁▁▁▁");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid.get(i).get(j) + "|");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔");
    }

    public boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((grid.get(i).get(0) == symbol && grid.get(i).get(1) == symbol && grid.get(i).get(2) == symbol) ||
                    (grid.get(0).get(i) == symbol && grid.get(1).get(i) == symbol && grid.get(2).get(i) == symbol)) {
                return true;
            }
        }
        if ((grid.get(0).get(0) == symbol && grid.get(1).get(1) == symbol && grid.get(2).get(2) == symbol) ||
                (grid.get(0).get(2) == symbol && grid.get(1).get(1) == symbol && grid.get(2).get(0) == symbol)) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.get(i).get(j) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid.get(i).set(j, ' ');
            }
        }
    }
}