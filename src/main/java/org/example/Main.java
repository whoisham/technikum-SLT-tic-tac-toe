package org.example;

import java.util.Scanner;


public class Main {
    static void main(String[] sender) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';

        for (int turn = 0; turn < 3; turn++) {
            System.out.println("Current Player: " + currentPlayer);
            board.printBoard();

            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            if (board.makeMove(row, col, currentPlayer)) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
                turn--;
            }
        }
    }
}
