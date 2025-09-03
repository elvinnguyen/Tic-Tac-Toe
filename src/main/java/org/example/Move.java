package org.example;

public class Move {
    // Initialize row, column and mark
    private final int row;
    private final int col;
    private final Mark mark;

    public Move(int row, int col, Mark mark) {
        // Throws exception if row or column entered is negative
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Rows and Columns cannot be negative");
        }

        // Throws exception if mark is null or placing empty mark
        if (mark == null || mark == Mark.Empty) {
            throw new IllegalArgumentException("Must choose X or 0. Cannot be EMPTY");
        }

        this.row = row;
        this.col = col;
        this.mark = mark;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Mark getMark() {
        return mark;
    }
}
