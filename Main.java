import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Human player will use "X"
        Player human = new HumanPlayer("You", Mark.X, in);

        // Computer player will use "O"
        Player computer = new ComputerPlayer("Computer", Mark.O);

        // Run the game
        Game game = new Game(human, computer);
        game.play();
    }
}


