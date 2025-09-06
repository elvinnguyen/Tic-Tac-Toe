/**
 * Creates the 3x3 Tic Tac Toe board.
 * marks cells, outlines win conditions, and displays the game
 */

import java.util.Arrays;
public class Board {
    private final Mark[][] grid = new Mark[3][3];
    private int moves = 0;

    public Board() {
        for (Mark[] row : grid) Arrays.fill(row, Mark.EMPTY); // make all of the rows empty
    }

    //Checks if the location is empty
    public boolean isCellEmpty(int r, int c) {
        return grid[r][c] == Mark.EMPTY;
    }

    // Places a mark if the cell is empty
    public boolean markCell(int r, int c, Mark mark) {
        if (!isCellEmpty(r, c)) return false; //Prevents a mark from being overwritten
        grid[r][c] = mark;
        moves++;
        return true;
    }

    //Checks if the board is full
    public boolean isFull() {
        return moves == 9;
    }

    //Checks for a winner and outlines win conditions
    public boolean checkWin(Mark mark) {
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == mark && grid[i][1] == mark && grid[i][2] == mark)) return true;//row
            if ((grid[0][i] == mark && grid[1][i] == mark && grid[2][i] == mark)) return true;//column
        }
        //Diagonals
        if (grid[0][0] == mark && grid[1][1] == mark && grid[2][2] == mark) return true;
        if (grid[0][2] == mark && grid[1][1] == mark && grid[2][0] == mark) return true;
        return false;
    }

    //Displays the board
    public void displayBoard() {
        for (int r = 0; r < 3; r++) {
            System.out.printf(" %s | %s | %s %n", grid[r][0], grid[r][1], grid[r][2]);
            if (r < 2) System.out.println("---+---+---");
        }
    }
}



