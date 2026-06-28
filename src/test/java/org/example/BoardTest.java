package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    public void testValidMoveOnEmptySquare() {
        Board board = new Board();
        boolean result = board.makeMove(0, 0, 'X');
        assertTrue(result);
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testInvalidMoveOnOccupiedSquare() {
        Board board = new Board();
        board.makeMove(1, 1, 'X');
        boolean result = board.makeMove(1, 1, 'O');
        assertFalse(result);
        assertEquals('X', board.getCell(1, 1));
    }

    @Test
    void testInitialBoardIsEmpty() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCell(i, j));
            }
        }
    }

    @Test
    void testBoardTracksMultipleMoves() {
        Board board = new Board();
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'O');
        assertEquals('X', board.getCell(0, 0));
        assertEquals('O', board.getCell(1, 1));
        assertEquals(' ', board.getCell(2, 2));
    }

    @Test
    void testHorizontalWinCondition() {
        Board board = new Board();
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertTrue(board.checkWin('X'));
        assertFalse(board.checkWin('O'));
    }

    @Test
    void testBoardIsFullCondition() {
        Board board = new Board();
        char[][] moves = {
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.makeMove(i, j, moves[i][j]);
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testResetBoardClearsAllSymbols() {
        Board board = new Board();
        board.makeMove(0, 0, 'X');
        board.makeMove(2, 2, 'O');
        board.resetBoard();
        assertEquals(' ', board.getCell(0, 0));
        assertEquals(' ', board.getCell(2, 2));
    }

    @Test
    void testResetBoardAllowsNewMovesOnOldSquares() {
        Board board = new Board();
        board.makeMove(1, 1, 'X');
        board.resetBoard();
        boolean result = board.makeMove(1, 1, 'O');
        assertTrue(result);
        assertEquals('O', board.getCell(1, 1));
    }
}