package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            board.clear();
            currentPlayer = player1;
            boolean gameOver = false;

            while (!gameOver) {
                System.out.println("Current Player: " + currentPlayer.getMarker());
                board.print();

                System.out.print("row (0-2): ");
                int x = scanner.nextInt();
                System.out.print("column (0-2): ");
                int y = scanner.nextInt();

                if (board.isCellEmpty(x, y)) {
                    board.place(x, y, currentPlayer.getMarker());

                    if (hasWinner()) {
                        board.print();
                        System.out.println("Player " + currentPlayer.getMarker() + " wins the game!");
                        gameOver = true;
                    } else if (board.isFull()) {
                        board.print();
                        System.out.println("The game ended in a draw!");
                        gameOver = true;
                    } else {
                        switchCurrentPlayer();
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

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean hasWinner() {
        char m = currentPlayer.getMarker();
        for (int i = 0; i < 3; i++) {
            if ((board.getCell(i, 0) == m && board.getCell(i, 1) == m && board.getCell(i, 2) == m) ||
                    (board.getCell(0, i) == m && board.getCell(1, i) == m && board.getCell(2, i) == m)) {
                return true;
            }
        }
        if ((board.getCell(0, 0) == m && board.getCell(1, 1) == m && board.getCell(2, 2) == m) ||
                (board.getCell(0, 2) == m && board.getCell(1, 1) == m && board.getCell(2, 0) == m)) {
            return true;
        }
        return false;
    }
}
