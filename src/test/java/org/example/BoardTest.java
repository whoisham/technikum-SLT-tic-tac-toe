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
}