package org.example;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board board = new Board();
        Player player1 = new HumanPlayer(Mark.X, in);
        // Player player2 = new HumanPlayer(Mark.O, in);
        Player player2 = new RandomAIPlayer(Mark.O);

        Game game = new Game(player1, player2, board);
        game.run();
    }
}
