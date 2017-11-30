package com.tonyspark;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Board
{
    private int size, squareSize;

    private BitSet cells;

    private List<BooleanFunction> booleanFunctions;

    Board(int size) {
        this.size = size;
        this.squareSize = size * size;
        this.cells = new BitSet(squareSize);
        this.booleanFunctions = new ArrayList<>(squareSize);

        for (int i = 0; i < squareSize; i++) {
            booleanFunctions.add(new BooleanFunction(squareSize));
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isBlack(int x, int y) {
        return cells.get(x * size + y);
    }

    public boolean isWhite(int x, int y) {
        return !isBlack(x, y);
    }

    public int getValueAt(int x, int y) {
        return isBlack(x, y) ? 1 : 0;
    }

    public int[] getValues() {
        int[] result = new int[squareSize];

        cells.stream().forEach(index -> result[index] = 1);

        return result;
    }

    public void paintBlack(int x, int y) {
        cells.set(x * size + y);
    }

    public void clear(int x, int y) {
        cells.clear(x * size + y);
    }

    // TODO: Consider using List<Integer> instead of int[] everywhere
    public void associate(int x, int y, int... configuration) {
        assertConfigurationValid(configuration);

        booleanFunctions.get(x * size + y).setTrue(configuration);
    }

    public void associateConfigurations(int[] from, int[] to) {
        assertConfigurationValid(from);
        assertConfigurationValid(to);

        for (int i = 0; i < from.length; i++) {
            if (to[i] == 1) {
                booleanFunctions.get(i).setTrue(from);
            }
        }
    }

    private void assertConfigurationValid(int[] configuration) {
        if (configuration.length != squareSize) {
            throw new IllegalArgumentException("Int array length should be equal to the board's square size.");
        }
    }

    public void step() {
        BitSet nextCells = new BitSet(squareSize);

        for (int i = 0; i < squareSize; i++) {
            if (booleanFunctions.get(i).call(cells)) {
                nextCells.set(i);
            }
        }

        this.cells = nextCells;
    }

    @Override
    public String toString() {
        // TODO: Fancy board
        return cells.toString();
    }
}
