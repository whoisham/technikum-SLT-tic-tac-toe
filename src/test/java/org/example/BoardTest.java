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

        // Positive case: 3 in a row horizontally returns true
        assertTrue(board.checkWin('X'));
        // Negative case: 'O' shouldn't be flagged as winning
        assertFalse(board.checkWin('O'));
    }

    @Test
    void testBoardIsFullCondition() {
        Board board = new Board();
        // Fill up the board mock-style
        char[][] moves = {
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                board.makeMove(i, j, moves[i][j]);
            }
        }
        // Positive case: Full grid returns true
        assertTrue(board.isFull());
    }
}