package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    public void testValidPlacementOnEmptyCell() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testInvalidPlacementOnOccupiedCell() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    public void testIsCellEmptyOutOfBoundsEdgeCases() {
        Board board = new Board();
        assertFalse(board.isCellEmpty(-1, 0));
        assertFalse(board.isCellEmpty(0, 3));
        assertFalse(board.isCellEmpty(3, 3));
        assertFalse(board.isCellEmpty(-5, 12));
    }

    @Test
    public void testPlaceOutOfBoundsEdgeCases() {
        Board board = new Board();
        board.place(-1, 0, 'X');
        board.place(0, 3, 'O');
        board.place(4, 4, 'X');

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    @Test
    void testInitialBoardClearState() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    @Test
    void testIsFullCondition() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testIsFullAlmostFullEdgeCase() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 2 && j == 2)) {
                    board.place(i, j, 'X');
                }
            }
        }
        assertFalse(board.isFull());
    }

    @Test
    void testClearResetsAllCells() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(2, 2, 'O');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(2, 2));
    }
}