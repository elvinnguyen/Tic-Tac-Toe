/**
 * Enum for the symbols in Tic Tac Toe.
 */
public enum Mark {
    X, O, EMPTY;

    @Override
    public String toString() {
        return switch (this) {
            case X -> "X";
            case O -> "O";
            case EMPTY -> " ";
        };
    }
}