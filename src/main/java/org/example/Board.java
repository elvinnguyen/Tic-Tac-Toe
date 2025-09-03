package org.example;

import java.util.Optional;

public class Board {
    private final int size = 3; // Initialize size of grid to 3x3
    private final Mark[][] grid; // Initialize grid

    public Board() {
        this.grid = new Mark[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = Mark.Empty;
            }
        }
    }

    public void place (Move mv) {
        // Throws exception if no mv is null
        if (mv == null) {
            throw new IllegalArgumentException("Invalid move. Cannot be null");
        }


    }

    public Mark getCell(int r, int c) {
        if (r < 0 || c < 0) {
            throw new IllegalArgumentException("Row and Columns cannot be negative");
        }
        return grid[r][c];
    }

    public boolean isFull() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c] == Mark.Empty) {
                    return false;
                }
            }
        }
        return true;
    }

    public Optional<Mark> winner() {

        return Optional.empty();
    }

    public void reset() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = Mark.Empty;
            }
        }
    }

    public int getSize() {
        return size;
    }
}