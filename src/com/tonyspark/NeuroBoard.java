package com.tonyspark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class NeuroBoard
{
    private int size, squareSize;

    private BitSet cells;

    private List<BooleanFunction> booleanFunctions;

    private List<Integer> thresholds;

    NeuroBoard(int[] thresholds) {
        double size = Math.sqrt(thresholds.length);
        if (size != (int)size) {
            throw new IllegalArgumentException("Thresholds array must have length equal to the square of an integer");
        }
        this.size = (int)size;
        this.squareSize = thresholds.length;
        this.cells = new BitSet(squareSize);
        this.booleanFunctions = new ArrayList<>(squareSize);
        this.thresholds = new ArrayList<>(squareSize);

        for (int i = 0; i < squareSize; i++) {
            this.thresholds.add(thresholds[i]);
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
    public void associate(int x1, int y1, int x2, int y2) {

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
