package com.tonyspark;

public class Cell
{
    private boolean filled = false;

    public Cell() {
    }

    public Cell(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void fill() {
        this.filled = true;
    }

    public void clear() {
        this.filled = false;
    }
}
