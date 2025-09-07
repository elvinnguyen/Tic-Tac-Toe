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

        int row = mv.getRow();
        int col = mv.getCol();

        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Move out of bounds");
        }

        if (grid[row][col] != Mark.Empty) {
            throw new IllegalArgumentException("Cell is occupied");
        }

        grid[row][col] = mv.getMark();
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
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (line(grid[i][0], grid[i][1], grid[i][2])) {
                return Optional.of(grid[i][0]);
            }
            if (line(grid[0][i], grid[1][i], grid[2][i])) {
                return Optional.of(grid[0][i]);
            }
        }

        // Check diagonals
        if (line(grid[0][0], grid[1][1], grid[2][2])) {
            return Optional.of(grid[0][0]);
        }

        if (line(grid[0][2], grid[1][1], grid[2][0])) {
            return Optional.of(grid[0][2]);
        }

        return Optional.empty();
    }

    private boolean line(Mark a, Mark b, Mark c) {
        return a != Mark.Empty && a == b && b == c;
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

    public void print() {
        for (int r = 0; r < size; r++) {
            System.out.printf(" %s | %s | %s %n", grid[r][0], grid[r][1], grid[r][2]);
            if (r < 2) {
                System.out.println("---+---+---");
            }
        }
    }
}