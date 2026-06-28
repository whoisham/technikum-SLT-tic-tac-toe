package org.example;

public class Board {
    private char[][] grid;

    public Board() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int column, char symbol) {
        if (row < 0 || row > 2 || column < 0 || column > 2) {
            return false;
        }
        if (grid[row][column] == ' ') {
            grid[row][column] = symbol;
            return true;
        }
        return false;
    }

    public void printBoard() {
        System.out.println("▁▁▁▁▁▁");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔");
    }

    public char getCell(int row, int column) {
        return grid[row][column];
    }
}
