package org.example;

import java.util.Optional;

public class Game {
    private final Player p1;
    private final Player p2;
    private final Board board;

    public Game(Player p1, Player p2, Board board) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
    }

    public void run() {
        Player current = p1;
        board.print();

        while (true) {
            System.out.println("Player " + current.getMark() + "'s turn"); // Print whichever player's turn it is

            Move mv = current.nextMove(board);
            board.place(mv);
            board.print();
            board.winner();

            Optional<Mark> winner = board.winner();
            if (winner.isPresent()) {
                board.print();
                System.out.println("Winner: " + winner.get());
                break;
            }

            if (board.isFull()) {
                System.out.print("Draw");
                break;
            }

            current = (current == p1) ? p2 : p1;
        }
    }

}
