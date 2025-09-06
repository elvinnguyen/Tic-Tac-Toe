/**
 *Handles the game loop and switching between players.
 */
public class Game {
    private final Board board = new Board();
    private final Player p1;
    private final Player p2;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    //Runs the game until it ends
    public void play() {
        Player current = p1;
        while (true) {
            board.displayBoard();
            int[] move = current.makeMove(board);
            board.markCell(move[0], move[1], current.getSymbol());

            //Checks for win
            if (board.checkWin(current.getSymbol())) {
                board.displayBoard();
                System.out.println("Winner: " + current.getName());
                break;
            }
            //Checks for draw
            if (board.isFull()) {
                board.displayBoard();
                System.out.println("Draw!");
                break;
            }
            current = (current == p1) ? p2 : p1; //Switches current player
        }
    }
}
