package com.tonyspark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NeuroBoardTest
{
    @Test
    void fill() {
        Board board = new Board(2);

        board.paintBlack(0, 0);
        board.paintBlack(1, 1);

        assertArrayEquals(new int[]{1,0,0,1}, board.getValues());
    }

    @Test
    void clear() {
        Board board = new Board(2);

        board.paintBlack(0, 0);
        board.paintBlack(0, 1);
        board.paintBlack(1, 0);
        board.paintBlack(1, 1);

        board.clear(0, 1);
        board.clear(1, 0);

        assertArrayEquals(new int[]{1,0,0,1}, board.getValues());
    }

    @Test
    void associate() {
        NeuroBoard board = new NeuroBoard(new int[]{1,1,1,1});

        board.paintBlack(0, 0);

        board.associate(0, 0, 0, 1);
        board.associate(0, 1, 1, 1);
        board.associate(1, 1, 1, 0);
        board.associate(1, 0, 0, 0);
    }

    @Test
    void associateConfigurations() {

    }
}