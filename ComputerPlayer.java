/**
 * Represents the computer player.
 * randomly selects available move
 */

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Random;

    public class ComputerPlayer extends Player {
        private final Random rng = new Random();

        public ComputerPlayer(String name, Mark mark) {
            super(name, mark);
        }

        @Override
        public int[] makeMove(Board board) {
            // Find all available moves
            List<int[]> moves = new ArrayList<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board.isCellEmpty(r, c)) {
                    moves.add(new int[]{r, c});
                }
            }
        }

        // Pick random move
        int[] move = moves.get(rng.nextInt(moves.size()));
        System.out.println(getName() + " chooses: " + (move[0] + 1) + " " + (move[1] + 1));
        return move;
    }
}

