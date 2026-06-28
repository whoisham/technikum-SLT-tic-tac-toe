package org.example;

import java.util.Scanner;


public class Main {
    static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            char currentPlayer = 'X';
            boolean gameOver = false;
            board.resetBoard();

            while (!gameOver) {
                System.out.println("Current Player: " + currentPlayer);
                board.printBoard();

                System.out.print("row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("column (0-2): ");
                int col = scanner.nextInt();

                if (board.makeMove(row, col, currentPlayer)) {
                    if (board.checkWin(currentPlayer)) {
                        board.printBoard();
                        System.out.println("Player " + currentPlayer + " wins the game!");
                        gameOver = true;
                    } else if (board.isFull()) {
                        board.printBoard();
                        System.out.println("The game ended in a draw!");
                        gameOver = true;
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String choice = scanner.next().trim().toLowerCase();
            if (!choice.equals("y")) {
                keepPlaying = false;
                System.out.println("Thank you for playing Tic-Tac-Toe!");
            }
        }
        scanner.close();
    }
}
