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

    public boolean checkWin(char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) ||
                    (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol)) {
                return true;
            }
        }
        // Check diagonals
        if ((grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
                (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    return false; // Found an empty space
                }
            }
        }
        return true; // No empty spaces left
    }

}
