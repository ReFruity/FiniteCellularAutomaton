package com.tonyspark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest
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
        Board board = new Board(2);

        board.paintBlack(0, 0);
        board.paintBlack(1, 1);

        board.associate(0,0, 0,0,0,0);
        board.associate(0,0, 0,0,0,1);
        board.associate(0,0, 0,0,1,0);
        board.associate(0,0, 0,0,1,1);
        board.associate(0,0, 1,0,0,0);
        board.associate(0,0, 1,0,0,1);
        board.associate(0,0, 1,0,1,0);
        board.associate(0,0, 1,0,1,1);

        board.associate(0,1, 1,0,0,0);
        board.associate(0,1, 1,0,0,1);
        board.associate(0,1, 1,0,1,0);
        board.associate(0,1, 1,0,1,1);
        board.associate(0,1, 1,1,0,0);
        board.associate(0,1, 1,1,0,1);
        board.associate(0,1, 1,1,1,0);
        board.associate(0,1, 1,1,1,1);

        board.associate(1,0, 0,0,0,0);
        board.associate(1,0, 0,0,0,1);
        board.associate(1,0, 0,1,0,0);
        board.associate(1,0, 0,1,0,1);
        board.associate(1,0, 1,0,0,0);
        board.associate(1,0, 1,0,0,1);
        board.associate(1,0, 1,1,0,0);
        board.associate(1,0, 1,1,0,1);

        board.associate(1,1, 0,0,0,0);
        board.associate(1,1, 0,0,0,1);
        board.associate(1,1, 0,1,0,0);
        board.associate(1,1, 0,1,0,1);
        board.associate(1,1, 1,0,0,0);
        board.associate(1,1, 1,0,0,1);
        board.associate(1,1, 1,1,0,0);
        board.associate(1,1, 1,1,0,1);

        /*
          cell 0 0    | cell 0 1    | cell 1 0    | cell 1 1

          0 0 0 0 = 1 | 0 0 0 0 = 0 | 0 0 0 0 = 1 | 0 0 0 0 = 1
          0 0 0 1 = 1 | 0 0 0 1 = 0 | 0 0 0 1 = 1 | 0 0 0 1 = 1
          0 0 1 0 = 1 | 0 0 1 0 = 0 | 0 0 1 0 = 0 | 0 0 1 0 = 0
          0 0 1 1 = 1 | 0 0 1 1 = 0 | 0 0 1 1 = 0 | 0 0 1 1 = 0

          0 1 0 0 = 0 | 0 1 0 0 = 0 | 0 1 0 0 = 1 | 0 1 0 0 = 1
          0 1 0 1 = 0 | 0 1 0 1 = 0 | 0 1 0 1 = 1 | 0 1 0 1 = 1
          0 1 1 0 = 0 | 0 1 1 0 = 0 | 0 1 1 0 = 0 | 0 1 1 0 = 0
          0 1 1 1 = 0 | 0 1 1 1 = 0 | 0 1 1 1 = 0 | 0 1 1 1 = 0

          1 0 0 0 = 1 | 1 0 0 0 = 1 | 1 0 0 0 = 1 | 1 0 0 0 = 1
          1 0 0 1 = 1 | 1 0 0 1 = 1 | 1 0 0 1 = 1 | 1 0 0 1 = 1
          1 0 1 0 = 1 | 1 0 1 0 = 1 | 1 0 1 0 = 0 | 1 0 1 0 = 0
          1 0 1 1 = 1 | 1 0 1 1 = 1 | 1 0 1 1 = 0 | 1 0 1 1 = 0

          1 1 0 0 = 0 | 1 1 0 0 = 1 | 1 1 0 0 = 1 | 1 1 0 0 = 1
          1 1 0 1 = 0 | 1 1 0 1 = 1 | 1 1 0 1 = 1 | 1 1 0 1 = 1
          1 1 1 0 = 0 | 1 1 1 0 = 1 | 1 1 1 0 = 0 | 1 1 1 0 = 0
          1 1 1 1 = 0 | 1 1 1 1 = 1 | 1 1 1 1 = 0 | 1 1 1 1 = 0
         */

        board.step();

        assertArrayEquals(new int[]{1,1,1,1}, board.getValues());

        board.step();

        assertArrayEquals(new int[]{0,1,0,0}, board.getValues());

        board.step();

        assertArrayEquals(new int[]{0,0,1,1}, board.getValues());

        board.step();

        assertArrayEquals(new int[]{1,0,0,0}, board.getValues());

        board.step();

        assertArrayEquals(new int[]{1,1,1,1}, board.getValues());
    }

    @Test
    void associateConfigurations() {
        Board board = new Board(2);

        board.paintBlack(0, 0);
        board.paintBlack(1, 1);

        board.associateConfigurations(new int[]{1,0,0,1}, new int[]{1,1,1,1});
        board.associateConfigurations(new int[]{1,1,1,1}, new int[]{0,1,0,0});
        board.associateConfigurations(new int[]{0,1,0,0}, new int[]{0,0,1,1});
        board.associateConfigurations(new int[]{0,0,1,1}, new int[]{1,0,0,0});
        board.associateConfigurations(new int[]{1,0,0,0}, new int[]{1,1,1,1});

        board.step();

        assertArrayEquals(new int[]{1,1,1,1}, board.getValues());

        board.step();

        assertArrayEquals(new int[]{0,1,0,0}, board.getValues());

        board.step();

        assertArrayEquals(new int[]{0,0,1,1}, board.getValues());

        board.step();

        assertArrayEquals(new int[]{1,0,0,0}, board.getValues());

        board.step();

        assertArrayEquals(new int[]{1,1,1,1}, board.getValues());
    }
}