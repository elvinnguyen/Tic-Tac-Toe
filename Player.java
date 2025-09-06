/**
 * Abstract class for the Tic Tac Toe player.
 * applies to HumanPlayer and ComputerPlayer.
 */

public abstract class Player {
    protected final String name;
    protected final Mark mark;

    protected Player(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public Mark getSymbol() {
        return mark;
    }

    //The player chooses their move
    public abstract int[] makeMove(Board board);
}
