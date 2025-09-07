package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomAIPlayer extends Player{
    public RandomAIPlayer(Mark mark) {
        super(mark);
    }

    @Override
    public Move nextMove(Board board) {
        List<int[]> moves = new ArrayList<>();
        final int size = board.getSize();

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board.getCell(r, c) == Mark.Empty) {
                    moves.add(new int[]{r, c});
                }
            }
        }

        int pick = ThreadLocalRandom.current().nextInt(moves.size());
        int[] rc = moves.get(pick);
        return new Move(rc[0], rc[1], mark);
    }
}
