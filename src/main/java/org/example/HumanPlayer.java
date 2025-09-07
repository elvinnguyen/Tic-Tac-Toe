package org.example;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner in;

    public HumanPlayer(Mark mark, Scanner in) {
        super(mark);
        this.in = in;
    }

    @Override
    public Move nextMove(Board board) {
        while (true) {
            System.out.println("Enter row (0-2): ");
            int row = in.nextInt();

            //  Check if row entered is out of bounds
            if (row < 0 || row >= board.getSize()) {
                System.out.println("Please try again. Number is out of bounds");
                continue;
            }

            System.out.println("Enter column (0-2): ");
            int col = in.nextInt();

            // Check column entered is out of bounds
            if (col < 0 || col >= board.getSize()) {
                System.out.println("Please try again. Number is out of bounds");
                continue;
            }

            // Check if the cell is empty
            if (board.getCell(row, col) != Mark.Empty) {
                System.out.println("Please try again. Cell is not empty");
                continue;
            }

            return new Move(row, col, mark);
        }
    }
}
